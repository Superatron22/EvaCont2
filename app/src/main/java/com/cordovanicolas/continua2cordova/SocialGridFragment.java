package com.cordovanicolas.continua2cordova;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cordovanicolas.continua2cordova.network.SocialEntry;

public class SocialGridFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.social_grid_fragment, container, false);

        setUpToolbar(view);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false));
        SocialCardRecyclerAdapterView adapter = new SocialCardRecyclerAdapterView(
                SocialEntry.initSocialEntryList(getResources()));
        recyclerView.setAdapter(adapter);


        int largePadding = getResources().getDimensionPixelSize(R.dimen.social_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.social_grid_spacing_small);
        recyclerView.addItemDecoration(new SocialGridDecorationItem(largePadding, smallPadding));

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }



}
