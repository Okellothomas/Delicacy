package com.pro.delicacy.network;

import com.pro.delicacy.models.CategoriesResponse;
import com.pro.delicacy.models.Meal;
import com.pro.delicacy.models.NameResponse;
import com.pro.delicacy.models.RandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DelicacyAPi {

    @GET("random.php")
    Call<RandomResponse> randomMeals(

    );

    @GET("categories.php")
    Call<CategoriesResponse> categoryMeals(
//            @Query("api_Key") int api_Key
    );

    @GET("search.php")
    Call<NameResponse> mealNames(
//            @Query("api_Key") int api_Key
            @Query("s") String name
    );
}
