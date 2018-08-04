package com.example.stettsen.compleat_andriod;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class EnterRecipe extends AppCompatActivity {

    public static final String PREFS = "com.blogspot.team16byui.mealmaster";
    public static final String TAG = "tag";
    Recipe recipe;

    Button addIngredientBtn;
    LinearLayout ingredientContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_recipe);
    }

    public void getRecipeInfo(View v) {
        recipe = Recipe.getCleanInstance();

        EditText recipeNameEditText = (EditText) findViewById(R.id.recipeName);
        recipe.setName(recipeNameEditText.getText().toString());

        Spinner type1 = (Spinner) findViewById(R.id.recipeType1);
        recipe.setType1(type1.getSelectedItem().toString());

        Spinner type2 = (Spinner) findViewById(R.id.recipeType2);
        recipe.setType2(type2.getSelectedItem().toString());

        Spinner tag1 = (Spinner) findViewById(R.id.tag1);
        recipe.setTag1(tag1.getSelectedItem().toString());

        Spinner tag2 = (Spinner) findViewById(R.id.tag2);
        recipe.setTag2(tag2.getSelectedItem().toString());


    }

/*
    public void makeRecipeFromURL(View v){
        EditText urlEditText = (EditText) findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        recipe = Recipe.getCleanInstanceURL(url);

       DownLoadHTMLFromWeb task = new DownLoadHTMLFromWeb(recipe, getApplicationContext());
        task.execute();
    }*/
}
