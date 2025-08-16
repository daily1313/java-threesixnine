package com.example.model;

public class Name {

    private String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }
    }
}
