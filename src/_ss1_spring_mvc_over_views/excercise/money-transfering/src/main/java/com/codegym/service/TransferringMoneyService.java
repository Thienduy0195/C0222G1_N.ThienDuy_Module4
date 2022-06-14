package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class TransferringMoneyService implements ITransferringService {
    @Override
    public double transferring(double usd) {
        double vnd = usd * 23000;
        return vnd;
    }
}
