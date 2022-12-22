package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context myContext;
    String[] products;
    String[] prices;
    TypedArray images;
    ItemClickListener itemClickListener;

    public RecyclerAdapter(Context context){
        myContext = context;
        products = myContext.getResources().getStringArray(R.array.products);
        prices = myContext.getResources().getStringArray(R.array.prices);
        images = myContext.getResources().obtainTypedArray(R.array.images);
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.products,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.ivProduct.setImageDrawable(images.getDrawable(position));
        holder.tvName.setText(products[position]);
        holder.tvPrice.setText(prices[position]);

    }

    @Override
    public int getItemCount() {
        if(products==null){
            return 0;
        }else{
            return products.length;
        }
    }
    public void setOnClickListener(ItemClickListener itemClickListener1){
        itemClickListener = itemClickListener1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        TextView tvName;
        TextView tvPrice;
        public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                ivProduct = itemView.findViewById(R.id.imageView);
                tvName = itemView.findViewById(R.id.textName);
                tvPrice = itemView.findViewById(R.id.textPrice);
                itemView.setOnClickListener(this::Onclick);
            }

        private void Onclick(View view) {
            if(itemClickListener!=null){
                itemClickListener.Onclick(view,getAdapterPosition());
            }
        }
    }
}
