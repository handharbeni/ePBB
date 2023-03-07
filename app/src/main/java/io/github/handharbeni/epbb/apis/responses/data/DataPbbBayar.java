package io.github.handharbeni.epbb.apis.responses.data;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataPbbBayar implements Serializable, Parcelable {
	@SerializedName("THN_PAJAK_SPPT")
	@Expose
	private String thnPajakSppt;
	@SerializedName("PBB_YG_HARUS_DIBAYAR_SPPT")
	@Expose
	private String pbbYgHarusDibayarSppt;
	@SerializedName("STATUS_PEMBAYARAN_SPPT")
	@Expose
	private String statusPembayaranSppt;
	@SerializedName("TGL_JATUH_TEMPO_SPPT")
	@Expose
	private String tglJatuhTempoSppt;
	public final static Creator<DataPbbBayar> CREATOR = new Creator<DataPbbBayar>() {


		@SuppressWarnings({
				"unchecked"
		})
		public DataPbbBayar createFromParcel(android.os.Parcel in) {
			return new DataPbbBayar(in);
		}

		public DataPbbBayar[] newArray(int size) {
			return (new DataPbbBayar[size]);
		}

	};

	protected DataPbbBayar(android.os.Parcel in) {
		this.thnPajakSppt = ((String) in.readValue((String.class.getClassLoader())));
		this.pbbYgHarusDibayarSppt = ((String) in.readValue((String.class.getClassLoader())));
		this.statusPembayaranSppt = ((String) in.readValue((String.class.getClassLoader())));
		this.tglJatuhTempoSppt = ((String) in.readValue((String.class.getClassLoader())));
	}

	public DataPbbBayar() {
	}

	public String getThnPajakSppt() {
		return thnPajakSppt;
	}

	public void setThnPajakSppt(String thnPajakSppt) {
		this.thnPajakSppt = thnPajakSppt;
	}

	public String getPbbYgHarusDibayarSppt() {
		return pbbYgHarusDibayarSppt;
	}

	public void setPbbYgHarusDibayarSppt(String pbbYgHarusDibayarSppt) {
		this.pbbYgHarusDibayarSppt = pbbYgHarusDibayarSppt;
	}

	public String getStatusPembayaranSppt() {
		return statusPembayaranSppt;
	}

	public void setStatusPembayaranSppt(String statusPembayaranSppt) {
		this.statusPembayaranSppt = statusPembayaranSppt;
	}

	public String getTglJatuhTempoSppt() {
		return tglJatuhTempoSppt;
	}

	public void setTglJatuhTempoSppt(String tglJatuhTempoSppt) {
		this.tglJatuhTempoSppt = tglJatuhTempoSppt;
	}

	public void writeToParcel(android.os.Parcel dest, int flags) {
		dest.writeValue(thnPajakSppt);
		dest.writeValue(pbbYgHarusDibayarSppt);
		dest.writeValue(statusPembayaranSppt);
		dest.writeValue(tglJatuhTempoSppt);
	}

	public int describeContents() {
		return 0;
	}
}
