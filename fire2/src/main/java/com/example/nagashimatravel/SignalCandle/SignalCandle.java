package com.example.nagashimatravel.SignalCandle;

public class SignalCandle {
    private final double close;
    private final double volume;

    public SignalCandle(double close, double volume) {
        this.close = close;
        this.volume = volume;
    }

    public double getClose() {
        return close;
    }

    public double getVolume() {
        return volume;
    }
}