package com.example.plantguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PlantDetailActivity extends AppCompatActivity {
    private TextView plantName;
    private TextView plantDescription;
    private ImageView plantImage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        // Initialize views
        plantName = findViewById(R.id.plantName);
        plantDescription = findViewById(R.id.plantDescription);
        plantImage = findViewById(R.id.plantImage);
        backButton = findViewById(R.id.backButton);

        // Get the plant detail from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("plantName");
        String description = intent.getStringExtra("plantDescription");
        int imageResource = intent.getIntExtra("plantImage", R.drawable.plant_placeholder); // Default image if not found

        // Set the plant details to the TextViews and ImageView
        plantName.setText(name);
        plantDescription.setText(description);
        plantImage.setImageResource(imageResource); // Set the plant image

        // Back button click listener
        backButton.setOnClickListener(view -> {
            finish(); // Finish this activity and return to the previous one
        });
    }
}
