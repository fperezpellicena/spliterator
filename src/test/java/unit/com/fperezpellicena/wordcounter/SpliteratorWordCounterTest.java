package unit.com.fperezpellicena.wordcounter;

import com.fperezpellicena.wordcounter.SpliteratorWordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpliteratorWordCounterTest {

    @Test
    public void simplePhrase() {
        String text = "Hello I am Frank";
        assertEquals(4, SpliteratorWordCounter.countWords(text));
    }

    @Test
    public void phraseWithExtraWhitespaces() {
        String text = " Hello   I'm  Frank and I wanted to tell you something that could be of your deepest interest";
        assertEquals(17, SpliteratorWordCounter.countWords(text));
    }
    
}