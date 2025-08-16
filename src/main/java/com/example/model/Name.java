package com.example.model;

import com.example.exception.NameNotBlankException;

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
            throw new NameNotBlankException();
        }
    }
}
