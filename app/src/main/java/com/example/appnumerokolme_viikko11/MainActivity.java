package com.example.appnumerokolme_viikko11;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText popupSetName, popupSetReminder;
    private Button btnSavePurchase, btnCancel;

    private RecyclerView recyclerView;

    private ImageView btnCalender,btnSortByName;
    ArrayList<Purchase> purchases = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalender = findViewById(R.id.imgDateSort);
        btnSortByName = findViewById(R.id.imgLetterSort);

        btnCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortByDate();
            }
        });

        btnSortByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortByABC();
            }
        });

    }


    public void setRecyclerView() {
        recyclerView = findViewById(R.id.rvOstokset);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PurchaseViewAdapter(getApplicationContext(), purchases));
    }
    public void createNewPurchaseDialog(View view){
        dialogBuilder = new AlertDialog.Builder(this);
        final View purchasePopupView = getLayoutInflater().inflate(R.layout.popup,null);
        popupSetName = (EditText) purchasePopupView.findViewById(R.id.EditTextName);
        popupSetReminder = (EditText) purchasePopupView.findViewById(R.id.EditTextReminder);

        btnSavePurchase = (Button) purchasePopupView.findViewById(R.id.btnAddPurchase);
        btnCancel = (Button) purchasePopupView.findViewById(R.id.btnCancel);
        dialogBuilder.setView(purchasePopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        btnSavePurchase.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Purchase purchase = new Purchase(popupSetName.getText().toString(),popupSetReminder.getText().toString());
                purchases.add(purchase);
                setRecyclerView();
                Toast.makeText(getApplicationContext(),purchase.getName() + " lisätty ostoskoriin.",Toast.LENGTH_LONG).show();


            }
        });




        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void sortByDate(){
        Comparator<Purchase> purchaseComparator = new Comparator<Purchase>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Purchase p1, Purchase p2) {
                return p1.getTime().compareTo(p2.getTime());
            }
        };

        purchases.sort(purchaseComparator);
        setRecyclerView();
    }

    public void sortByABC(){
        Comparator<Purchase> purchaseComparator = new Comparator<Purchase>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public int compare(Purchase p1, Purchase p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };

        purchases.sort(purchaseComparator);
        setRecyclerView();
    }

}