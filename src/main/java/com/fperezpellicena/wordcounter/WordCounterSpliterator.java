package com.fperezpellicena.wordcounter;

import lombok.RequiredArgsConstructor;

import java.util.Spliterator;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class WordCounterSpliterator implements Spliterator<Character> {

    private static final int MIN_CHARACTERS_THRESHOLD = 10;

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
        int remainingCharacters = text.length() - currentPosition;
        // Do not split the stream if there are fewer than MIN_CHARACTERS_THRESHOLD characters
        if (remainingCharacters < MIN_CHARACTERS_THRESHOLD) {
            return null;
        }
        // Divide and conquer: Split the remaining text to the half and find the next non-whitespace character to split the text properly
        for(int splitPosition = currentPosition + remainingCharacters / 2; splitPosition < text.length(); splitPosition++) {
            if (Character.isWhitespace(text.charAt(splitPosition))) {
                WordCounterSpliterator spliterator = new WordCounterSpliterator(text.substring(currentPosition, splitPosition));
                currentPosition = splitPosition;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return  text.length() - currentPosition;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }

}
