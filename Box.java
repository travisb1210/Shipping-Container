package com.company;

import java.util.Random;

public class Box {

    // static factory method called to create Box instance objects
    // with random values for weight, value and contents
    public static Box randomBox() {
        String[] contents = {"apples", "oranges", "lemons", "bread", "sugar"};
        Random r = new Random();
        return new Box(r.nextDouble()*100, r.nextDouble() * 50, contents[r.nextInt(contents.length)]);
    }

    private double weight = 1;
    private double value = 1;
    private String contents = "nothing";

    public Box() { }

    public Box(double weight, double value, String contents) {
        if (weight > 1)
            this.weight = weight;
        if (value > 1)
            this.value = value;
        this.contents = contents;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public String getContents() {
        return contents;
    }
}