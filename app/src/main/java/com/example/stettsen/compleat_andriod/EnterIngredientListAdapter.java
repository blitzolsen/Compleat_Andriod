package com.example.stettsen.compleat_andriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class EnterIngredientListAdapter extends BaseAdapter {
    private List<Food> ingredients;
    private LayoutInflater inflater = null;

    public EnterIngredientListAdapter(Context context, List<Food> food){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.ingredients = food;
    }
    @Override
    public int getCount() {
        return ingredients.size();
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
    public View getView(final int position, View convertView, ViewGroup parent){

        final ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.ingredient_enter_layout,null,false);
            holder = new ViewHolder();
            holder.ingredientName = (EditText) convertView.findViewById(R.id.ingredientName);
            holder.quantity = (EditText) convertView.findViewById(R.id.quantity);
            holder.fraction = (Spinner)convertView.findViewById(R.id.fraction);
            holder.amountType = (Spinner)convertView.findViewById(R.id.amountType);
            holder.foodType = (Spinner)convertView.findViewById(R.id.foodType);
            holder.remove = (Button)convertView.findViewById(R.id.remove);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredients.remove(position);
                notifyDataSetChanged();
                }
        });

        return convertView;
    }
    static class ViewHolder {
        EditText ingredientName;
        EditText quantity;
        Spinner fraction;
        Spinner amountType;
        Spinner foodType;
        Button remove;
    }
}
