package org.lumijiez;
public class Diamond {
    public static void draw(int size) {
        if (size % 2 == 0) {
            System.out.println("Please give an odd number");
            return;
        }
        int count = 1;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y <= size; y++) System.out.print((y >= (size - count) / 2 && y <= (size / 2 + count / 2)) ? '*' : ' ');
            System.out.println();
            count += (x < size / 2) ? 2 : -2;
        }

    }
}



