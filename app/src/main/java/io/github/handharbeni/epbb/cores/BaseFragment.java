package io.github.handharbeni.epbb.cores;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

import java.util.HashMap;
import java.util.Objects;

import io.github.handharbeni.epbb.apis.Client;
import io.github.handharbeni.epbb.apis.ClientInterface;
import io.github.handharbeni.epbb.database.AppDb;
import io.github.handharbeni.epbb.services.TrackingServices;
import io.github.handharbeni.epbb.utils.UtilDb;

public class BaseFragment extends Fragment {
    public final String TAG = BaseFragment.class.getSimpleName();
    public NavController navController;
    public AppDb appDb;
    public UtilDb utilDb;
    public Balloon balloon;
    public Resources resources;
    public RequestManager glideManager;
    public ProgressDialog progressDialog;
    public Gson gson;

    public ClientInterface clientInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clientInterface = Client.getInstance(requireContext(), ClientInterface.class);
        appDb = AppDb.getInstance(requireContext());
        utilDb = new UtilDb(requireContext());
        resources = requireContext().getResources();
        glideManager = Glide.with(this);
        gson = new Gson();


        Intent intent = new Intent(requireActivity(), TrackingServices.class);
        requireActivity().startService(intent);

//        UtilFirebase.setOnline(getMe(), task -> {});
    }

    @Override
    public void onStart() {
        super.onStart();
//        UtilFirebase.setOnline(getMe(), task -> {});
    }

    @Override
    public void onResume() {
        super.onResume();
//        UtilFirebase.setOnline(getMe(), task -> {});
    }

    @Override
    public void onDestroy() {
//        UtilFirebase.setOffline(getMe(), task -> {});
        super.onDestroy();
    }

    public <T> void observe(String key, Observer<T> observer) {
        Objects.requireNonNull(
                navController
                        .getCurrentBackStackEntry()
        ).getSavedStateHandle().getLiveData(key).observe(
                getViewLifecycleOwner(),
                (Observer<? super Object>) t -> observer.onChanged((T) t)
        );
    }

    public <T> void setState(String key, T value) {
        Objects.requireNonNull(
                navController
                        .getCurrentBackStackEntry()
        ).getSavedStateHandle().set(key, value);
    }

    public void navigate(int id) {
        try {
            navController.navigate(id);
        } catch (Exception ignored) {}
    }

    public void navigate(int id, HashMap<View, String> hashMapShared) {
        try {
            FragmentNavigator.Extras
                    nExtras = new FragmentNavigator.Extras.Builder().addSharedElements(hashMapShared).build();
            FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                    .addSharedElements(hashMapShared).build();
            navController.navigate(id, null, null, extras);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void navigate(int id, Bundle bundle, HashMap<View, String> hashMapShared) {
        try {
            FragmentNavigator.Extras
                    nExtras = new FragmentNavigator.Extras.Builder().addSharedElements(hashMapShared).build();
            FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                    .addSharedElements(hashMapShared).build();
            navController.navigate(id, bundle, null, extras);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void navigate(int id, Bundle bundle) {
        try {
            navController.navigate(id, bundle);
        } catch (Exception ignored) {}
    }

    public void showLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new ProgressDialog(requireActivity());
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Tunggu Sebentar");
        progressDialog.show();
    }

    public void doneLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void showError(View view, String message) {
        if (balloon != null) {
            balloon.dismiss();
            balloon = null;
        }
        balloon = new Balloon.Builder(requireContext())
                .setArrowSize(10)
                .setArrowOrientation(ArrowOrientation.TOP)
                .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                .setArrowPosition(0.5f)
                .setIsVisibleArrow(true)
                .setText(message)
                .setPadding(9)
                .setWidth(BalloonSizeSpec.WRAP)
                .setHeight(BalloonSizeSpec.WRAP)
                .setTextSize(15f)
                .setCornerRadius(4f)
                .setAlpha(0.9f)
                .setBalloonAnimation(BalloonAnimation.ELASTIC)
                .setLifecycleOwner(getViewLifecycleOwner())
                .build();
        balloon.showAlignBottom(view);
        balloon.setOnBalloonClickListener(view1 -> balloon.dismiss());
        balloon.setOnBalloonOverlayClickListener(balloon::dismiss);
    }

    public void showDialogOneButton(String title, String message, String button) {
        new MaterialAlertDialogBuilder(requireActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(button, (dialogInterface, i) -> {

                })
                .show();
    }
}
