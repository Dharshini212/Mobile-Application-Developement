package com.example.plantguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {
    ListView plantListView;
    Button logoutBtn;

    String[] plantNames = {"Rose", "Tulip", "Sunflower", "Lily", "Orchid"};
    String[] plantDetails = {
            "Rose: A beautiful red flower.",
            "Tulip: A bright colorful spring flower.",
            "Sunflower: A large yellow flower that follows the sun.",
            "Lily: A delicate white flower.",
            "Orchid: A rare and exotic flower."
    };

    int[] plantImages = {
            R.drawable.rose_image,       // Add your plant images in drawable folder
            R.drawable.tuple_image,
            R.drawable.sunflower_image,
            R.drawable.fern_image,
            R.drawable.cactus_image
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        plantListView = findViewById(R.id.plantListView);
        logoutBtn = findViewById(R.id.logoutBtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, plantNames);
        plantListView.setAdapter(adapter);

        plantListView.setOnItemClickListener((adapterView, view, position, l) -> {
            Intent intent = new Intent(HomePageActivity.this, PlantDetailActivity.class);
            intent.putExtra("plantName", plantNames[position]); // Pass the plant name
            intent.putExtra("plantDescription", plantDetails[position]); // Pass the plant description
            intent.putExtra("plantImage", plantImages[position]); // Pass the plant image resource
            startActivity(intent);
        });

        logoutBtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
