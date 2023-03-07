package io.github.handharbeni.epbb.apis;

import io.github.handharbeni.epbb.apis.responses.DataResponse;
import io.github.handharbeni.epbb.apis.responses.ListResponse;
import io.github.handharbeni.epbb.apis.responses.data.DataBphtb;
import io.github.handharbeni.epbb.apis.responses.data.DataDendaPayment;
import io.github.handharbeni.epbb.apis.responses.data.DataLogin;
import io.github.handharbeni.epbb.apis.responses.data.DataObjekPbb;
import io.github.handharbeni.epbb.apis.responses.data.DataPbbBayar;
import io.github.handharbeni.epbb.apis.responses.data.DataStatusPayment;
import io.github.handharbeni.epbb.utils.Constant;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientInterface {
    @FormUrlEncoded
    @POST("loginJWT.php")
    Call<DataResponse<DataLogin>> login(
            @Field(Constant.CI_USERNAME) String username,
            @Field(Constant.CI_PASSWORD) String password
    );

    @GET("getDataBphtb.php")
    Call<ListResponse<DataBphtb>> getDataBphtb();


    @FormUrlEncoded
    @POST("getDataPbb.php")
    Call<ListResponse<DataObjekPbb>> getDataPbb(
            @Field(Constant.CI_NOP) String nop
    );

    @FormUrlEncoded
    @POST("getDataPbbBayar.php")
    Call<ListResponse<DataPbbBayar>> getDataPbbBayar(
            @Field(Constant.CI_NOP) String nop
    );

    @FormUrlEncoded
    @POST("getDendaPayment.php")
    Call<ListResponse<DataDendaPayment>> getDendaPayment(
            @Field(Constant.CI_NOP) String nop,
            @Field(Constant.CI_TAHUN) String tahun
    );

    @FormUrlEncoded
    @POST("getStatusPayment.php")
    Call<ListResponse<DataStatusPayment>> getStatusPayment(
            @Field(Constant.CI_NOP) String nop,
            @Field(Constant.CI_TAHUN) String tahun
    );

    @FormUrlEncoded
    @POST("createQR.php")
    Call<DataResponse<String>> generateQr(
            @Field(Constant.CI_INTITUTION) String institution,
            @Field(Constant.CI_AMOUNT) String amount,
            @Field(Constant.CI_KDTAGIHAN) String kdTagihan,
            @Field(Constant.CI_NOP) String nop,
            @Field(Constant.CI_TAHUN) String tahun,
            @Field(Constant.CI_DESC) String desc,
            @Field(Constant.CI_ISPBB) String isPbb
    );

    @FormUrlEncoded
    @POST("statusQR.php")
    Call<ListResponse<Object>> statusQr(
            @Field(Constant.CI_INTITUTION) String institution
    );
}
