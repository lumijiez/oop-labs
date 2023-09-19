package org.lumijiez;

public class Member {
    private final int age;
    private final int handicap;
    private final String category;

    public int getAge() {
        return age;
    }

    public int getHandicap() {
        return handicap;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    private String name;
    public Member(String name, int age, int handicap) {
        this.age = age;
        this.handicap = handicap;
        this.name = name;
        this.category = (age > 55 && handicap > 7) ? "SENIOR" : "OPEN";
    }


    public void printCategory() {
        System.out.println(this.category);
    }
}