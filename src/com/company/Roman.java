package com.company;

public class Roman {

    public static boolean isRoman(String r)  {
        String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String roman : romans) {
            if (roman.equals(r)) {
                return true;
            }
        }
        return false;
    }

    public static int toInt(String r) throws Exception {
        String[] romans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < romans.length; i++) {
            if (r.equals(romans[i])) {
                return i + 1;
            }
        }
        throw new Exception("Число больше 10.");
    }

    public static String toRoman(int n) throws Exception {
        if (n < 0) {
            throw new Exception("в римской системе нет отрицательных чисел");
        }
        if (n == 100) {
            return "C";
        }
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int t = n / 10;
        int u = n % 10;
        return tens[t] + units[u];
    }
}