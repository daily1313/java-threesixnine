package com.example.model;

public class Player {

    private final Name name;
    private final Count count = Count.initZeroCount();

    private Player(Name name) {
        this.name = name;
    }

    public static Player from(Name name) {
        return new Player(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getCount() {
        return count.getCount();
    }

    public void incrementPlayCount() {
        count.increase();
    }
}
