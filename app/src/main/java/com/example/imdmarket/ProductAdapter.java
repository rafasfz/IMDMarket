package com.example.imdmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.imdmarket.ProductEntity;
import com.example.imdmarket.R;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductEntity> {

    private final Context context;
    private final List<ProductEntity> products;

    public ProductAdapter(Context context, List<ProductEntity> products) {
        super(context, R.layout.list_item_layout, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
            holder = new ViewHolder();
            holder.titleTextView = convertView.findViewById(R.id.item_title);
            holder.subtitleTextView = convertView.findViewById(R.id.item_subtitle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductEntity currentProduct = products.get(position);
        holder.titleTextView.setText(currentProduct.id + ": " + currentProduct.name);
        holder.subtitleTextView.setText(currentProduct.description);

        return convertView;
    }

    static class ViewHolder {
        TextView titleTextView;
        TextView subtitleTextView;
    }
}