package com.austinwc.stringalgo;

import java.util.ArrayList;
import java.util.List;

public class NaiveStringSearch implements StringSearch {
    @Override
    public List<Integer> search(String text, String match) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            boolean stringsMatch = true;
            for (int j = 0; j < match.length(); j++) {
                if (i + j == text.length()) break;
                if (text.charAt(i + j) != match.charAt(j)) {
                    stringsMatch = false;
                    break;
                }
            }
            if (stringsMatch) result.add(i);
        }
        return result;
    }
}
