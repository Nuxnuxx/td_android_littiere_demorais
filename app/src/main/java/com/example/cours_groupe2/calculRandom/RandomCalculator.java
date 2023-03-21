package com.example.cours_groupe2.calculRandom;

import java.util.Random;

public class RandomCalculator {

    private Random random;

    public RandomCalculator() {
        random = new Random();
    }

    public String getRandomCalculation() {

        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int operator = random.nextInt(4);

        String operatorSymbol = "";

        switch (operator) {
            case 0:
                operatorSymbol = "+";
                break;
            case 1:
                operatorSymbol = "-";
                break;
            case 2:
                operatorSymbol = "*";
                break;
            case 3:
                operatorSymbol = "/";
                break;
        }

        String calculation = num1 + " " + operatorSymbol + " " + num2;
        return calculation;

    }
}
