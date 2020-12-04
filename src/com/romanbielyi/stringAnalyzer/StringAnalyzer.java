package com.romanbielyi.stringAnalyzer;

import java.util.*;

public class StringAnalyzer {
    private final String str;
    private int letterCount;
    private int wsCount;
    private int digitCount;
    private int punctuationCount;
    private final LinkedHashMap<Character, Integer> charMap;


    public StringAnalyzer(String str) {
        this.str = str.toLowerCase();
        this.charMap = new LinkedHashMap<>();
        analyse();
    }

    public int getLetterCount() {
        return letterCount;
    }

    public int getWsCount() {
        return wsCount;
    }

    public int getPunctuationCount() {
        return punctuationCount;
    }

    public int getDigitCount() {
        return digitCount;
    }

    public LinkedHashMap<Character, Integer> getLettersOccurrencesMap() {
        return  charMap;
    }

    private void analyse() {
        char[] strArray = str.toCharArray();

        for (char c : strArray) {

            if (Character.isLetter(c)) {
                letterCount++;
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else {
                    charMap.put(c, 1);
                }
            } else {
                if (Character.isSpaceChar(c)) {
                    wsCount++;
                }
                if (Character.isDigit(c)) {
                    digitCount++;
                }
                if (c == '.' || c == ',' || c == ';' || c == ':' || c == '?' || c == '!' || c == '-') {
                    punctuationCount++;
                }
            }
        }
    }

    public void printAnalyzedString() {
        System.out.printf("letters: %d\nwhitespaces: %d\ndigits: %d\npunctuation marks [.,;:?!-]: %d\n",
                getLetterCount(), getWsCount(), getDigitCount(), getPunctuationCount());
        System.out.println("-- letters occurrences --");

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.printf("letter \"%s\", occurrence %d\n", entry.getKey(), entry.getValue());
        }
    }
}


