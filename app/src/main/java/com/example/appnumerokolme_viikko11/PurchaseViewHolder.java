package com.example.appnumerokolme_viikko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PurchaseViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView, imageBin, imageChange;
    TextView name, reminder;

    EditText editName, editReminder;
    public PurchaseViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageViewBasket);
        name = itemView.findViewById(R.id.textViewName);
        reminder = itemView.findViewById(R.id.textViewReminder);
        imageBin = itemView.findViewById(R.id.imageViewBin);
        imageChange = itemView.findViewById(R.id.imageViewChange);
        editName = itemView.findViewById(R.id.editTextName);
        editReminder = itemView.findViewById(R.id.editTextReminder);

    }
}
