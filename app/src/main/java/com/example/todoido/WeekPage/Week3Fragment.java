package com.example.todoido.WeekPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.todoido.Adapter.WeekAdapter;
import com.example.todoido.R;
import com.example.todoido.ViewModel.WeekViewModel;

public class Week3Fragment extends BaseWeekFragment {
    private RecyclerView weekRecyclerView;
    private WeekAdapter weekAdapter;
    private WeekViewModel weekViewModel;

    ViewPager viewPager;
    ImageButton buttonPrev, buttonNext;
    ImageView mainImageView;

    @Override
    protected String getWeekId() {
        return "week3";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week3, container, false);

        weekViewModel = new ViewModelProvider(requireActivity()).get(WeekViewModel.class);

        weekRecyclerView = view.findViewById(R.id.weekrecyclerView);
        weekAdapter = new WeekAdapter(weekViewModel, "week3");
        weekRecyclerView.setAdapter(weekAdapter);
        weekRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewPager = getActivity().findViewById(R.id.week_viewPager);
        buttonPrev = view.findViewById(R.id.week3_prev);
        buttonNext = view.findViewById(R.id.week3_next);
        mainImageView = view.findViewById(R.id.mainImageView);

        setupDialog(mainImageView);

        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weekViewModel.getWeekDataList().observe(getViewLifecycleOwner(), weekDataList -> {
            for (WeekViewModel.WeekData weekData : weekDataList) {
                if (weekData.getId().equals( "week3")) {
                    weekAdapter.setSelectedEmoji(weekData.getSelectedEmoji());
                    weekAdapter.setGoals(weekData.getGoals());

                    String selectedEmoji = weekData.getSelectedEmoji();
                    if (selectedEmoji != null) {
                        switch (selectedEmoji) {
                            case "happy":
                                mainImageView.setImageResource(R.drawable.happy2);
                                break;
                            case "smile":
                                mainImageView.setImageResource(R.drawable.smile);
                                break;
                            case "soso":
                                mainImageView.setImageResource(R.drawable.soso);
                                break;
                            case "bad":
                                mainImageView.setImageResource(R.drawable.bad);
                                break;
                            case "angry":
                                mainImageView.setImageResource(R.drawable.angry);
                                break;
                        }
                    }

                }
            }
        });
    }
}
