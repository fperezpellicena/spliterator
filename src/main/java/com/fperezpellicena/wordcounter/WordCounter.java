package com.fperezpellicena.wordcounter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.lang.Character.isWhitespace;

@Getter
@RequiredArgsConstructor
class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter accumulate(Character character) {
        if (isWhitespace(character)) {
            if (lastSpace) {
                return this;
            } else {
                return new WordCounter(counter, true);
            }
        } else {
            if (lastSpace) {
                return new WordCounter(counter + 1, false);
            } else {
                return this;
            }
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.getCounter(), wordCounter.isLastSpace());
    }

}