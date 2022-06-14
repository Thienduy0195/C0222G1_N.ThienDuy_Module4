package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class TransferringMoney {
    public double transferring(double usd) {
        double vnd = usd * 23000;
        return vnd;
    }
}
