package com.example.info.presentation;

import com.example.info.domain.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealView {
    private boolean success;
    private List<Meal> data;

    public MealView(boolean success, List<Meal> data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Meal> getMeals() {
        return data;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.data = meals;
    }
}
