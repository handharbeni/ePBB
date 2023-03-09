package io.github.handharbeni.epbb.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import io.github.handharbeni.epbb.apis.responses.data.DataPbb;
import io.github.handharbeni.epbb.cores.BaseFragment;
import io.github.handharbeni.epbb.databinding.FragmentQrisBinding;

public class QrisFragment extends BaseFragment {
	public static final String KEY_PBB = "KeyDataPbb";
	FragmentQrisBinding binding;

	DataPbb dataPbb;


	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState
	) {
		binding = FragmentQrisBinding.inflate(inflater, container, false);
		navController = NavHostFragment.findNavController(this);

		return binding.getRoot();
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initDataPbb();
		bindData();
	}

	void initDataPbb() {
		if (getArguments() != null) {
			dataPbb = (DataPbb) getArguments().getSerializable(KEY_PBB);
		}
	}

	void bindData() {
		if (dataPbb != null) {
			binding.txtTahun.setText(String.format("Tahun : %s", dataPbb.getThnPajakSppt()));
			binding.txtKetetapan.setText(String.format("Ketetapan : Rp %s", dataPbb.getPbbYgHarusDibayarSppt()));
			binding.txtStatus.setText(String.format("Status : %s", dataPbb.getStatusPembayaranSppt()));
		}
	}
}
