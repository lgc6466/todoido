package com.example.todoido.WeekPage;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;

import com.example.todoido.Adapter.WeekAdapter;
import com.example.todoido.R;

public abstract class BaseWeekFragment extends Fragment {
    protected RecyclerView recyclerView;
    protected WeekAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.weekrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WeekAdapter();
        recyclerView.setAdapter(adapter);
    }

    protected void setupDialog(final ImageView mainImageView) {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.emoiton_popup);

        ImageView happyIcon = dialog.findViewById(R.id.happy);
        happyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImageView.setImageResource(R.drawable.happy);
                dialog.dismiss();
            }
        });

        ImageView smileIcon = dialog.findViewById(R.id.smile);
        smileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImageView.setImageResource(R.drawable.smile);
                dialog.dismiss();
            }
        });

        ImageView sosoIcon = dialog.findViewById(R.id.soso);
        sosoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImageView.setImageResource(R.drawable.soso);
                dialog.dismiss();
            }
        });

        ImageView badIcon = dialog.findViewById(R.id.bad);
        badIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImageView.setImageResource(R.drawable.bad);
                dialog.dismiss();
            }
        });

        ImageView angryIcon = dialog.findViewById(R.id.angry);
        angryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainImageView.setImageResource(R.drawable.angry);
                dialog.dismiss();
            }
        });

        mainImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}