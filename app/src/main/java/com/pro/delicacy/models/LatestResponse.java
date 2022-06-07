package com.pro.delicacy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class LatestResponse {

    @SerializedName("meals")
    @Expose
    private Meals meals;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LatestResponse() {
    }

    /**
     * 
     * @param meals
     */
    public LatestResponse(Meals meals) {
        super();
        this.meals = meals;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

}
