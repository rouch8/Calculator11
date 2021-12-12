package com.company;

public class Arabic {

    public static boolean isArabic(String a) {
        String[] arabics = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String arabic : arabics) {
            if (arabic.equals(a)) {
                return true;
            }
        }
        return false;
    }


    public static int toInt(String a) throws Exception {
        int n = Integer.parseInt(a);
        if (n > 0 && n < 11) {
            return n;
        }
        throw new Exception("Число больше 10.");
    }
}
