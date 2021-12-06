package com.cordovanicolas.continua2cordova;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class SocialCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView socialImage;
    public TextView socialName;


    public SocialCardViewHolder(@NonNull View itemView) {
        super(itemView);
        socialImage = itemView.findViewById(R.id.social_image);
        socialName = itemView.findViewById(R.id.social_name);

    }
}