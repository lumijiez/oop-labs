package org.lumijiez;

public class Main {
    public static void main(String[] args) {
        // First Challenge
        User.printInitials(new User("Dominic", "Toretto"));

        // Second Challenge
        MathUtils.printSumMultiples(10);

        // Third Challenge
        Diamond.draw(7);

        // Fourth Challenge
        Member member1 = new Member("Don", 56, 9);
        member1.printCategory();

        // Fifth Challenge
        MathUtils.printNextPerfectSqr(64);

        // Sixth Challenge
        MathUtils.printIsNarcissistic(153);
    }
}