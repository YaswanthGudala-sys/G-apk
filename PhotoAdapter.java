package com.example.photoviewergallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    public interface OnPhotoClickListener { void onClick(int position); }

    private final Context context;
    private final int[] photos;
    private final OnPhotoClickListener listener;

    public PhotoAdapter(Context context, int[] photos, OnPhotoClickListener listener) {
        this.context = context;
        this.photos = photos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.image.setImageResource(photos[position]);
        holder.itemView.setOnClickListener(v -> listener.onClick(position));
    }

    @Override public int getItemCount() { return photos.length; }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        PhotoViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.photoImage);
        }
    }
}
