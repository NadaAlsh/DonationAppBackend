package com.nada.DonationApp.util.enums;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String label;

    private Gender(String label) { this.label = label; }

    @Override
    public String toString() { return label; }
}
