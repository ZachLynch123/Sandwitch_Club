package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject swData = new JSONObject(json);
        JSONObject swName = swData.getJSONObject("name");
        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(swName.getString("mainName"));
        Log.v(TAG, "From JSON " + sandwich.getMainName());
        sandwich.setPlaceOfOrigin(swData.getString("placeOfOrigin"));
        sandwich.setDescription(swData.getString("description"));
        sandwich.setImage(swData.getString("image"));
        sandwich.setIngredients(getIngredients(json));
       Log.v(TAG, "From JSON " + sandwich.getDescription());
       return sandwich;
    }

    private static List<String> getIngredients(String json) throws JSONException {
        ArrayList<String> ingredientsData = new ArrayList<>();
        JSONObject ingObj = new JSONObject(json);
        JSONArray ingredients = ingObj.getJSONArray("ingredients");
        for (int i = 0; i < ingredients.length(); i++){
            ingredientsData.add(ingredients.getString(i));
        }
        return ingredientsData;

    }


}
