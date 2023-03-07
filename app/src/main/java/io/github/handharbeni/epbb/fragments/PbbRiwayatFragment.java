package io.github.handharbeni.epbb.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import io.github.handharbeni.epbb.adapters.PbbRiwayatAdapter;
import io.github.handharbeni.epbb.apis.responses.data.DataPbb;
import io.github.handharbeni.epbb.cores.BaseFragment;
import io.github.handharbeni.epbb.databinding.FragmentPbbRiwayatBinding;

public class PbbRiwayatFragment extends BaseFragment implements PbbRiwayatAdapter.PbbAdapterCallback {
	FragmentPbbRiwayatBinding binding;
	NavController navController;

	PbbRiwayatAdapter pbbRiwayatAdapter;
	List<DataPbb> listData = new ArrayList<>();

	@Nullable
	@Override
	public View onCreateView(
			@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState
	) {
		binding = FragmentPbbRiwayatBinding.inflate(inflater, container, false);
		navController = NavHostFragment.findNavController(this);

		setupAdapter();
		dummyData();
		return binding.getRoot();
	}

	void setupAdapter() {
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
		pbbRiwayatAdapter = new PbbRiwayatAdapter(requireContext(), this.listData, this);

		binding.rvPbb.setLayoutManager(linearLayoutManager);
		binding.rvPbb.setAdapter(pbbRiwayatAdapter);
	}

	void dummyData() {
		for (int i = 0; i < 3; i++) {
			DataPbb dataPbb = new DataPbb();
			dataPbb.setPbbYgHarusDibayarSppt("100000");
			switch (i) {
				case 0 :
					dataPbb.setThnPajakSppt("2021");
					dataPbb.setTglJatuhTempoSppt("2021");
					dataPbb.setStatusPembayaranSppt("Belum Lunas");
					break;
				case 1 :
					dataPbb.setThnPajakSppt("2022");
					dataPbb.setTglJatuhTempoSppt("2022");
					dataPbb.setStatusPembayaranSppt("Lunas");
					break;
				case 2 :
					dataPbb.setThnPajakSppt("2023");
					dataPbb.setTglJatuhTempoSppt("2023");
					dataPbb.setStatusPembayaranSppt("Lunas");
					break;
			}
			listData.add(dataPbb);
		}

		pbbRiwayatAdapter.updateData(listData);
	}

	public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	@Override
	public void onQrisClick(DataPbb dataPbb) {

	}

	@Override
	public void onVaClick(DataPbb dataPbb) {

	}
}
