package com.fperezpellicena.wordcounter;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalWordCounter {

    public static int countWords(String text) {
        Stream<Character> characterStream = IntStream.range(0, text.length()).mapToObj(text::charAt);
        WordCounter identity = new WordCounter(0, true);
        WordCounter wordCounter = characterStream.reduce(identity, WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static int countWordsParallel(String text) {
        Stream<Character> characterStream = IntStream.range(0, text.length()).mapToObj(text::charAt);
        WordCounter identity = new WordCounter(0, true);
        WordCounter wordCounter = characterStream.parallel().reduce(identity, WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }

}
