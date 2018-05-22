package com.austinwc.stringalgo;

import com.austinwc.testutils.ApproxTimeElapsed;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// TODO Add file access to search very large strings. Current test case input too small to see difference
public class StringAlgoTest {
    // Text file resources
    private static String worstCasePath = "res/WorstCaseText";
    private static String worstCaseText;
    private static String worstCasePattern = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    private static String averagePath = "res/AverageText";
    private static String averageText;
    private static String averageTextPattern = "Ash will be the search word.";

    private static void readFiles() throws IOException {
        // Worst Case Text
        byte[] encoded = Files.readAllBytes(Paths.get(worstCasePath));
        worstCaseText = new String(encoded, Charset.defaultCharset());

        encoded = Files.readAllBytes(Paths.get(averagePath));
        averageText = new String(encoded, Charset.defaultCharset());
    }

    private static void runTest(String searchAlgoName, StringSearch searchAlgo) {
        long elapsedTime;
        ApproxTimeElapsed timer = new ApproxTimeElapsed();
        List<Integer> result;

        // Setup
        try {
            readFiles();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Could not open files: " + ex.getLocalizedMessage());
            return;
        }

        timer.setStartTime();
        result = searchAlgo.search(averageText, averageTextPattern);
        elapsedTime = timer.getElapsedTime();
        System.out.println(searchAlgoName + " search on normal string took " + elapsedTime + " milliseconds");
        System.out.println("Number of locations found: " + result.size());

        timer.setStartTime();
        result = searchAlgo.search(worstCaseText, worstCasePattern);
        elapsedTime = timer.getElapsedTime();
        System.out.println(searchAlgoName + " search on worst-case string took " + elapsedTime + " milliseconds");
        System.out.println("Number of locations found: " + result.size());
    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        // Naive Search -> O(n^2)
        runTest("Naive", new NaiveStringSearch());

        // KMP Search -> O(n)
        runTest("KMP", new KMPStringSearch());
    }
}
