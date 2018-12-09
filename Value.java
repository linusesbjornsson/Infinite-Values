package com.linesb.value;

public class Value {

    private int value = 0;
    private final char suffix;

    public static final int THRESHOLD = 1000;

    public Value(char suffix) {
        this.suffix = suffix;
    }

    public void setValue(int value) {
        if (value >= THRESHOLD) {
            // Exception?
            return;
        }
        this.value = value;
    }

    public int addValue(int value) {
        int newValue = this.value + value;
        if (newValue >= THRESHOLD) {
            this.value = newValue - THRESHOLD;
            while (this.value >= THRESHOLD) {
                this.value -= THRESHOLD;
            }
            return newValue / THRESHOLD;
        } else {
            this.value = newValue;
        }
        return 0;
    }

    public int removeValue(int value) {
        int newValue = this.value - value;
        if (newValue < 0) {
            int rest = 1;
            this.value = 0;
            newValue = Math.abs(newValue);
            while (newValue > THRESHOLD) {
                rest++;
                newValue -= THRESHOLD;
            }
            this.value = THRESHOLD - newValue;
            return rest;
        } else {
            this.value = newValue;
        }
        return 0;
    }

    public int getValue() {
        return value;
    }

    public char getSuffix() {
        return suffix;
    }

    @Override
    public String toString() {
        return (suffix != Character.MIN_VALUE) ? Integer.toString(value) + suffix : Integer.toString(value);
    }

    @Override
    public Value clone() {
        Value newValue = new Value(suffix);
        newValue.setValue(value);
        return newValue;
    }
}
