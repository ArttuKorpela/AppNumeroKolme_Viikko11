package com.example.appnumerokolme_viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PurchaseViewAdapter extends RecyclerView.Adapter<PurchaseViewHolder> {

    private Context context;
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public PurchaseViewAdapter(Context context, ArrayList<Purchase> purchases) {
        this.context = context;
        this.purchases = purchases;
    }

    @NonNull
    @Override
    public PurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PurchaseViewHolder(LayoutInflater.from(context).inflate(R.layout.purchase_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.kori);
        holder.name.setText(purchases.get(position).getName());
        holder.reminder.setText(purchases.get(position).getReminder());
        holder.editName.setText(purchases.get(position).getName());
        holder.editReminder.setText(purchases.get(position).getReminder());
        
        holder.imageBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                for (Purchase p: purchases) {
                    if (p.getName() == purchases.get(holder.getAdapterPosition()).getName()) {
                        purchases.remove(i);
                        notifyItemRemoved(holder.getAdapterPosition());
                        break;
                    }
                    else {
                        i++;
                    }
                }
            }
        });

        holder.imageChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.editName.getVisibility() != View.GONE) {
                    purchases.get(holder.getAdapterPosition()).setName(holder.editName.getText().toString());
                    purchases.get(holder.getAdapterPosition()).setReminder(holder.editReminder.getText().toString());

                    notifyDataSetChanged();
                    holder.editName.setVisibility(View.GONE);
                    holder.editReminder.setVisibility(View.GONE);

                }
                else {
                    holder.editName.setVisibility(View.VISIBLE);
                    holder.editReminder.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return (purchases.size());
    }
}
