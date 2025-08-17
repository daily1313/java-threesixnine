package com.example.model.vo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
