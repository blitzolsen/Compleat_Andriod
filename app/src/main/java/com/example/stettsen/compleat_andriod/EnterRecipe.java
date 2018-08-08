package com.example.stettsen.compleat_andriod;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EnterRecipe extends AppCompatActivity {

    public static final String PREFS = "com.example.stettsen.compleat_andriod";
    public static final String TAG = "tag";
    Recipe recipe;
    private ListView listView;
    private EnterIngredientListAdapter adapter;
    private List<Food> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_recipe);
        Food food = new Food();
        ingredients = new ArrayList<>();
        ingredients.add(food);
    }

    @Override
    public void onResume(){

        recipe = Recipe.getCleanInstance();
        listView = (ListView)findViewById(R.id.ingredientsContainer);

        adapter = new EnterIngredientListAdapter(this, (List<Food>) ingredients);
        listView.setAdapter(adapter);
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                shoppingList.getFoodByPosition(position).toggleInCart();
                adapter.notifyDataSetChanged();
            }
        });*/
        super.onResume();
    }


    public void getRecipeInfo(View v) {


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

        Intent enterRecipe = new Intent(this, ViewCookbook.class);
        startActivity(enterRecipe);
    }
    public void addIngredient(View view){
        Food food = new Food();
        ingredients.add(food);
        adapter.notifyDataSetChanged();

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
