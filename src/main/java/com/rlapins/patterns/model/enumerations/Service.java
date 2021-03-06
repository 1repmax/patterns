package com.rlapins.patterns.model.enumerations;

public enum Service {

    COFFEE(3),
    WIFI(5);

    final int price;

    private Service(int price) {
        this.price = price;
    }
}
