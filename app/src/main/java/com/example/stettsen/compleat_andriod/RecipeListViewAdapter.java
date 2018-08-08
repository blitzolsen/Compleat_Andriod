package com.example.stettsen.compleat_andriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * The RecipeListViewAdapter class is the bridge between the data source and a list view.
 * @author Stettsen Olsen
 * @version 1.0
 */

public class RecipeListViewAdapter extends BaseAdapter {

    private List<Recipe> recipes;
    private LayoutInflater inflater;

    public RecipeListViewAdapter(Context context, List<Recipe> recipes){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(R.layout.list_view_recipe_template,null,false);

        //Adapter gives position parameter.
        //This parameter helps us to know which item view is wanted by adapter.
        ((TextView)view.findViewById(R.id.recipe_name)).setText(recipes.get(position).getName());
        ((TextView)view.findViewById(R.id.recipe_types)).setText(recipes.get(position).getType1()
                + ", " +  recipes.get(position).getType2() + "  Tags: "
                + recipes.get(position).getTag1() + ", " + recipes.get(position).getTag2());
        return view;
    }
}
