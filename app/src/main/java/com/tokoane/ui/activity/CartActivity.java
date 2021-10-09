package com.tokoane.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tokoane.R;
import com.tokoane.data.local.SharedPref;
import com.tokoane.data.model.Product;
import com.tokoane.ui.adapter.ListMainAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    List<Product> data = new ArrayList<>();
    int i;
    RecyclerView recyclerView;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.recylerview_detailcart);
        backButton = findViewById(R.id.back_btn_cart);
        backButton.setOnClickListener(v -> CartActivity.super.onBackPressed());

        try {
            if (SharedPref.GetId(this) == null) {
                Toast.makeText(this, "welcome to cart page", Toast.LENGTH_SHORT).show();
            } else {
                JSONArray jsonArray = new JSONArray(SharedPref.GetId(this));
                for (i = 0 ; i < jsonArray.length(); i++){
                    JSONObject a = jsonArray.getJSONObject(i);
                    data.add(new Product(
                            Integer.parseInt(a.getString("id")),
                            Integer.parseInt(a.getString("photo")),
                            a.getString("title"),
                            a.getString("description"),
                            a.getString("price")
                    ));
                    Log.d("TAG", "onCreate: " + a.getString("title"));
                }
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
            recyclerView.setHasFixedSize(true);
            ListMainAdapter adapter = new ListMainAdapter(CartActivity.this, data, null);
            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

