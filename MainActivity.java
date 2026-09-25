package com.example.photoviewergallery;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private final int[] photos = {
        R.drawable.photo_1, R.drawable.photo_2,
        R.drawable.photo_3, R.drawable.photo_4,
        R.drawable.photo_5, R.drawable.photo_6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView gallery = findViewById(R.id.galleryRecyclerView);
        gallery.setLayoutManager(new GridLayoutManager(this, 2));
        gallery.setAdapter(new PhotoAdapter(this, photos, position -> {
            Intent intent = new Intent(this, PhotoViewerActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        }));
    }
}
