package com.health.repository;

import com.health.model.Health;

import java.util.List;

public interface IHealthDeclarationRepository {
    void save(Health health);

    Health getHealth();

    List<Integer> getYearList();

    List<String> getNations();

    List<String> getGenders();

    List<String> getVehicles();
}
