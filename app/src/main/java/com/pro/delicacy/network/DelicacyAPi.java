package com.pro.delicacy.network;

import com.pro.delicacy.models.CategoriesResponse;
import com.pro.delicacy.models.Meal;
import com.pro.delicacy.models.RandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DelicacyAPi {

    @GET("random.php")
    Call<RandomResponse> randomMeals();

    @GET("categories.php")
    Call<CategoriesResponse> categoryMeals();
}
