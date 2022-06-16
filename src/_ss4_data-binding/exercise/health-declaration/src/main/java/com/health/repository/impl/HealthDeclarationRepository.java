package com.health.repository.impl;

import com.health.model.Health;
import com.health.repository.IHealthDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HealthDeclarationRepository implements IHealthDeclarationRepository {


    private Health health = new Health();

    @Override
    public void save(Health health) {
        this.health = health;
    }

    @Override
    public Health getHealth() {
        return this.health;
    }

    private static final List<Integer> years = new ArrayList<>();
    private static final List<String> nations = new ArrayList<>();
    private static final List<String> genders = new ArrayList<>();
    private static final List<String> vehicles = new ArrayList<>();

    static {
        for (int i = 1950; i < 2000; i++) {
            years.add(i);
        }
        vehicles.add("Tàu bay");
        vehicles.add("Tàu thuyền");
        vehicles.add("Ô tô");
        vehicles.add("Khác");
        genders.add("Chọn");
        genders.add("Nam");
        genders.add("Nữ");
        genders.add("Khác");
        nations.add("India");
        nations.add("Saudi Arabia");
        nations.add("Singapore");
        nations.add("South Korea");
        nations.add("Sri Lanka");
        nations.add("Syria");
        nations.add("Tajikistan");
        nations.add("Thailand");
        nations.add("Timor-Leste");
        nations.add("Turkey");
        nations.add("Turkmenistan");
        nations.add("United Arab Emirates");
        nations.add("Uzbekistan");
        nations.add("Vietnam");
        nations.add("Yemen");
    }

    @Override
    public List<Integer> getYearList() {
        return years;
    }

    @Override
    public List<String> getNations() {
        return nations;
    }

    @Override
    public List<String> getGenders() {
        return genders;
    }

    @Override
    public List<String> getVehicles() {
        return vehicles;
    }

}
