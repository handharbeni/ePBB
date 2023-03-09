package io.github.handharbeni.epbb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.handharbeni.epbb.apis.responses.data.DataPbb;
import io.github.handharbeni.epbb.databinding.FragmentPbbRiwayatItemBinding;

public class PbbRiwayatAdapter extends RecyclerView.Adapter<PbbRiwayatAdapter.ViewHolder>{

	Context context;
	List<DataPbb> listData;
	PbbAdapterCallback pbbAdapterCallback;

	public PbbRiwayatAdapter(
			Context context, List<DataPbb> listData, PbbAdapterCallback pbbAdapterCallback
	) {
		this.context = context;
		this.listData = listData;
		this.pbbAdapterCallback = pbbAdapterCallback;
	}

	@NonNull
	@Override
	public PbbRiwayatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		FragmentPbbRiwayatItemBinding binding = FragmentPbbRiwayatItemBinding.inflate(LayoutInflater.from(parent.getContext()));
		RecyclerView.LayoutParams
				lp =
				new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		binding.getRoot().setLayoutParams(lp);
		return new ViewHolder(binding);
	}

	@Override
	public void onBindViewHolder(@NonNull PbbRiwayatAdapter.ViewHolder holder, int position) {
		DataPbb dataPbb = listData.get(position);
		holder.bindData(dataPbb);
		holder.binding.btnQRIS.setOnClickListener(v -> pbbAdapterCallback.onQrisClick(dataPbb));
		holder.binding.btnVA.setOnClickListener(v -> pbbAdapterCallback.onVaClick(dataPbb));
	}

	@Override
	public int getItemCount() {
		return listData.size();
	}

	public void updateData(List<DataPbb> listData) {
		this.listData = listData;
		this.notifyDataSetChanged();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		FragmentPbbRiwayatItemBinding binding;
		public ViewHolder(@NonNull FragmentPbbRiwayatItemBinding itemView) {
			super(itemView.getRoot());
			binding = itemView;
		}

		public void bindData(DataPbb dataPbb) {
			binding.btnQRIS.setVisibility(View.VISIBLE);
			binding.btnVA.setVisibility(View.VISIBLE);

			binding.txtTahun.setText(String.format("Tahun : %s", dataPbb.getThnPajakSppt()));
			binding.txtKetetapan.setText(String.format("Ketetapan : Rp %s", dataPbb.getPbbYgHarusDibayarSppt()));
			binding.txtStatus.setText(String.format("Status : %s", dataPbb.getStatusPembayaranSppt()));

			if (dataPbb.getStatusPembayaranSppt().equalsIgnoreCase("lunas")) {
				binding.btnQRIS.setVisibility(View.GONE);
				binding.btnVA.setVisibility(View.GONE);
			}
		}
	}

	public interface PbbAdapterCallback{
		void onQrisClick(DataPbb dataPbb);
		void onVaClick(DataPbb dataPbb);
	}
}
