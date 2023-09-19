package org.lumijiez;
public class User {
    public String firstName, lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static void printInitials(User user) {
        System.out.print(user.firstName.charAt(0) + ". " + user.lastName.charAt(0) + ". \n");
    }
}
