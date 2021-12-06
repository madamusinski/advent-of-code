package com.advent.of.code.daysix.service;

import com.advent.of.code.daysix.model.Fish;
import com.advent.of.code.shared.TextData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FishService {

    private final TextData data;
    private List<Fish> schoolOfFish;
    private List<Fish> awaitingFish;
    private int currentDay = 0;
    private final int maxDay;

    public FishService(TextData data, int maxDay) {
        this.data = data;
        this.maxDay = maxDay;
        schoolOfFish = new ArrayList<>();
        awaitingFish = new ArrayList<>();
    }

    public void runService() {
        populateSchool();
        while (currentDay <= maxDay) {
            addNewBornFishToSchool();
            trySpawningFish();
            print();
            dayForward();
        }
        System.out.printf("After %d there is total of %d%n", maxDay, schoolOfFish.size());
    }

    private void populateSchool() {
        if (data.getData().size() == 1) {
            String[] fishInternals = data.getData().get(0).split(",");
            for (String fishInternal : fishInternals) {
                Fish newFish = new Fish(Integer.parseInt(fishInternal));
                schoolOfFish.add(newFish);
            }
        }
    }

    private void trySpawningFish() {
        awaitingFish = schoolOfFish.stream()
                .filter(fish -> fish.getInternalTimer() == 0)
                .map(Fish::reproduce).collect(Collectors.toList());
    }

    private void dayForward() {
        currentDay++;
        schoolOfFish.forEach(Fish::updateFishInternal);
    }

    private void print() {
        String fishString = schoolOfFish.stream().map(fish -> String.valueOf(fish.getInternalTimer())).collect(Collectors.joining(","));
        System.out.printf("After %d day: %s %n", currentDay, fishString);
    }

    private void addNewBornFishToSchool() {
        if (awaitingFish.size() > 0) {
            schoolOfFish.addAll(awaitingFish);
            awaitingFish.clear();
        }
    }
}
