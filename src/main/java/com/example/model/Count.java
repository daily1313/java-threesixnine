package com.example.model;

public class Count {

    private int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count initZeroCount() {
        return new Count(0);
    }

    public void increase() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
