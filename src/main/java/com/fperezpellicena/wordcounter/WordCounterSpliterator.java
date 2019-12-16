package com.fperezpellicena.wordcounter;

import lombok.RequiredArgsConstructor;

import java.util.Spliterator;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class WordCounterSpliterator implements Spliterator<Character> {

    private final String text;

    private int currentPosition = 0;

    @Override
    public boolean tryAdvance(Consumer<? super Character> consumer) {
        char nextCharacter = text.charAt(currentPosition++);
        consumer.accept(nextCharacter);
        return text.length() > currentPosition;
    }

    @Override
    public Spliterator<Character> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

}
