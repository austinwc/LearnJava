package com.austinwc.StringAlgo;

import java.util.ArrayList;
import java.util.List;

/**
 * KMP search defines provides O(n) search time where n is the length of the
 * search text.
 *
 * A pi function is defined that provides the longest prefix of the search pattern
 * that is a proper suffix of the search pattern. This function provides information
 * about already matched characters in the search so that previous text does not need to be
 * reexamined when considering a new possible match
 */
public class KMPStringSearch implements StringSearch{
    private int[] lps;
    @Override
    public List<Integer> search(String text, String match) {
        List<Integer> result = new ArrayList<>();
        if (text.length() == 0 || match.length() == 0) return result;

        // Create LPS function where lps[k] is the longest prefix of match
        // that is a proper suffix of match {0..k}
        lps = new int[match.length()];
        calculateLPS(match);

        int i = 0, k = 0;
        while (i < text.length()) {
            if (text.charAt(i) == match.charAt(k)) {
                i++;
                k++;
            }
            if (k == match.length()) {
                result.add(i - k); // Found match at match length back from current position
                k = lps[k - 1]; // Continue search with next longest prefix
            } else if (i < text.length() && text.charAt(i) != match.charAt(k)) {
                if (k != 0) {
                    // Consider next longest prefix
                    k = lps[k - 1];
                } else {
                    // Only trivial empty prefix matches, so continue
                    i++;
                }
            }
        }

        return result;
    }

    private void calculateLPS(String match) {
        int i = 1, k = 0;

        while (i < match.length()) {
            if (match.charAt(i) == match.charAt(k)) {
                // Character matches so extend prefix at this point
                k++;
                lps[i++] = k;
            } else {
                if (k != 0) {
                    // Reconsider match at next longest prefix
                    k = lps[k - 1];
                } else {
                    // only the trivial "" prefix matches
                    lps[i++] = k;
                }
            }
        }
    }
}
