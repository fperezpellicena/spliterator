package com.fperezpellicena.wordcounter;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorWordCounter {

    public static int countWords(String text) {
        WordCounterSpliterator spliterator = new WordCounterSpliterator(text);
        Stream<Character> characterStream = StreamSupport.stream(spliterator, true);
        WordCounter identity = new WordCounter(0, true);
        WordCounter wordCounter = characterStream.parallel().reduce(identity, WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }

}
