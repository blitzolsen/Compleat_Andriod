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

        addIngredientBtn = (Button)findViewById(R.id.addAnotherIngredient);
        ingredientContainer = (LinearLayout) findViewById(R.id.ingredientsContainer);

        addIngredientBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.ingredient_enter_layout, null);

                EditText ingredientEditText = (EditText) findViewById(R.id.ingredientName);
                String _ingredientName = ingredientEditText.getText().toString();
                EditText ingredientQuantity = (EditText) findViewById(R.id.ingredientQuantity);
                String _ingredientQuantity = ingredientQuantity.getText().toString();
                Spinner quantityFraction = (Spinner) findViewById(R.id.quantityFraction);
                String _quantityFraction = quantityFraction.getSelectedItem().toString();
                Spinner quantityType = (Spinner) findViewById(R.id.quantityType);
                String _quantityType = quantityType.getSelectedItem().toString();
                Spinner ingredientFoodGroup = (Spinner) findViewById(R.id.ingredientFoodGroup);
                String _ingredientFoodGroup = ingredientFoodGroup.getSelectedItem().toString();

                EditText IngredientNameOut = (EditText)addView.findViewById(R.id.ingredientNameOut);
                IngredientNameOut.setText(_ingredientName);
                EditText quantity = (EditText)addView.findViewById(R.id.quantity);
                quantity.setText(_ingredientQuantity);
                EditText amountType = (EditText)addView.findViewById(R.id.amountType);
                amountType.setText(_quantityType);
                EditText foodType = (EditText)addView.findViewById(R.id.foodType);
                foodType.setText(_ingredientFoodGroup);


                Button buttonRemove = (Button)addView.findViewById(R.id.remove);

                final View.OnClickListener thisListener = new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);

                        listAllAddView();
                    }
                };

                buttonRemove.setOnClickListener(thisListener);
                ingredientContainer.addView(addView);

                listAllAddView();
            }
        });
    }
    private void listAllAddView(){
        reList.setText("");

        int childCount = container.getChildCount();
        for(int i=0; i<childCount; i++){
            View thisChild = container.getChildAt(i);
            reList.append(thisChild + "\n");

            AutoCompleteTextView childTextView = (AutoCompleteTextView) thisChild.findViewById(R.id.textout);
            String childTextViewValue = childTextView.getText().toString();
            reList.append("= " + childTextViewValue + "\n");
        }
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
