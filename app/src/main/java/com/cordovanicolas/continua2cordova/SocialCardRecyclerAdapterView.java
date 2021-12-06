package com.cordovanicolas.continua2cordova;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cordovanicolas.continua2cordova.network.RequestImage;
import com.cordovanicolas.continua2cordova.network.SocialEntry;

import java.util.List;

public class SocialCardRecyclerAdapterView extends RecyclerView.Adapter<SocialCardViewHolder> {

    private List<SocialEntry> socialList;
    private RequestImage imageRequester;

    SocialCardRecyclerAdapterView(List<SocialEntry> socialList) {
        this.socialList = socialList;
        imageRequester = imageRequester.getInstance();
    }

    @NonNull
    @Override
    public SocialCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.social_card, parent, false);
        return new SocialCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialCardViewHolder holder, int position) {
        if (socialList != null && position < socialList.size()) {
            SocialEntry social = socialList.get(position);
            holder.socialName.setText(social.name);

            imageRequester.setImageFromUrl(holder.socialImage, social.url);
        }
    }

    @Override
    public int getItemCount() {
        return socialList.size();
    }
}
