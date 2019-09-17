package net.teamx.utils;

import java.util.Arrays;

public class StringUtils {
    // Connect two string arrays
    public String[] concat(String[] a, String b[]){
        int a_len = a.length;
        int b_len = b.length;
        a = Arrays.copyOf(a, a_len + b_len);
        System.arraycopy(b, 0, a, a_len, b_len);
        return a;
    }
}
