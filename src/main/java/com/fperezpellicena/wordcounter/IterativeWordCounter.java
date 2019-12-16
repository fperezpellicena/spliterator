package com.fperezpellicena.wordcounter;

public class IterativeWordCounter {

    public static int countWords(String text) {
        int wordCount = 0;
        String[] splitText = text.split("\\s");
        for (int index = 0; index < splitText.length; index++) {
            String currentWord = splitText[index];
            if (currentWord.isEmpty()) {
                continue;
            }
            wordCount++;
        }
        return wordCount;
    }

}
