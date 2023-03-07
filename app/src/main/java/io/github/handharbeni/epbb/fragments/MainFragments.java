package io.github.handharbeni.epbb.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import io.github.handharbeni.epbb.R;
import io.github.handharbeni.epbb.cores.BaseFragment;
import io.github.handharbeni.epbb.databinding.FragmentMainBinding;

public class MainFragments extends BaseFragment {
	FragmentMainBinding binding;

	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState
	) {
		binding = FragmentMainBinding.inflate(inflater, container, false);
		navController = NavHostFragment.findNavController(this);
		initClick();
		return binding.getRoot();
	}

	void initClick() {
		binding.cvPbb.setOnClickListener(this::goToPbb);
		binding.cvPajak.setOnClickListener(this::goToPajak);
		binding.cvBphtb.setOnClickListener(this::goToBphtb);
		binding.cvRetribution.setOnClickListener(this::goToRetribution);
	}

	void goToPbb(View view) {
		navController.navigate(R.id.action_mainFragment_to_pbbFragment);
	}

	void goToPajak(View view) {

	}

	void goToBphtb(View view) {

	}

	void goToRetribution(View view) {

	}

	public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}
