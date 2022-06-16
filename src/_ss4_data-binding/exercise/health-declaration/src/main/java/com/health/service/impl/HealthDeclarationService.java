package com.health.service.impl;

import com.health.model.Health;
import com.health.repository.IHealthDeclarationRepository;
import com.health.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthDeclarationService implements IHealthDeclarationService {
    @Autowired
    IHealthDeclarationRepository healthDeclarationRepository;

    @Override
    public void save(Health health) {
        this.healthDeclarationRepository.save(health);
    }

    @Override
    public Health getHealth() {
        return this.healthDeclarationRepository.getHealth();
    }

    @Override
    public List<Integer> getYearList() {
        return this.healthDeclarationRepository.getYearList();
    }

    @Override
    public List<String> getNations() {
        return this.healthDeclarationRepository.getNations();
    }

    @Override
    public List<String> getGenders() {
        return this.healthDeclarationRepository.getGenders();
    }

    @Override
    public List<String> getVehicles() {
        return this.healthDeclarationRepository.getVehicles();
    }
}
