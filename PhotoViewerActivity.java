package com.example.photoviewergallery;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class PhotoViewerActivity extends AppCompatActivity {
    private final int[] photos = {
        R.drawable.photo_1, R.drawable.photo_2,
        R.drawable.photo_3, R.drawable.photo_4,
        R.drawable.photo_5, R.drawable.photo_6
    };
    private int position;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);

        image = findViewById(R.id.viewerImage);
        position = getIntent().getIntExtra("position", 0);
        showPhoto();

        findViewById(R.id.previousButton).setOnClickListener(v -> {
            if (position > 0) { position--; showPhoto(); }
        });
        findViewById(R.id.nextButton).setOnClickListener(v -> {
            if (position < photos.length - 1) { position++; showPhoto(); }
        });
    }

    private void showPhoto() {
        image.setImageResource(photos[position]);
    }
}
