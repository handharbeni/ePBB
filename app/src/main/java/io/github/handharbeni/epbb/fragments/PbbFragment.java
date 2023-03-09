package io.github.handharbeni.epbb.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import io.github.handharbeni.epbb.R;
import io.github.handharbeni.epbb.cores.BaseFragment;
import io.github.handharbeni.epbb.databinding.FragmentPbbBinding;

public class PbbFragment extends BaseFragment {
	FragmentPbbBinding binding;

	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState
	) {
		binding = FragmentPbbBinding.inflate(inflater, container, false);
		navController = NavHostFragment.findNavController(this);
		initClick();
		return binding.getRoot();
	}

	void initClick() {
		binding.cvRiwayatPajak.setOnClickListener(this::goToRiwayat);
		binding.cvPelayanan.setOnClickListener(this::goToPelayanan);
		binding.cvTrace.setOnClickListener(this::goToTrace);
		binding.cvPengurangan.setOnClickListener(this::goToPengurangan);
		binding.cvKeberatan.setOnClickListener(this::goToKeberatan);
	}

	void goToRiwayat(View view) {

	}

	void goToPelayanan(View view) {
		navigate(R.id.action_pbbFragment_to_pbbRiwayatFragment);
	}

	void goToTrace(View view) {

	}

	void goToPengurangan(View view) {

	}

	void goToKeberatan(View view) {

	}
}
