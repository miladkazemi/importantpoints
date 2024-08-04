package com.devst0rm.importantpoints.remote.APIService;


import com.devst0rm.importantpoints.remote.APIService.point.CategoryListRes_M;
import com.devst0rm.importantpoints.remote.APIService.point.PointListRes_M;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface APIS_Point {

    @GET("getCategories")
    Observable<CategoryListRes_M> getCategories();

    @POST("getPoints")
    @FormUrlEncoded
    Observable<PointListRes_M> getPoints(
            @Field("categoryType") String categoryType
    );


}
