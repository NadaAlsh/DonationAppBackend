package com.nada.DonationApp.util.enums;

public enum BloodType {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    O_NEGATIVE("O-"),
    O_POSITIVE("O+"),
    AB_NEGATIVE("AB-"),
    AB_POSITIVE("AB+");

    private final String label;

    private BloodType(String label) { this.label = label; }

    @Override
    public String toString() { return label; }
}
