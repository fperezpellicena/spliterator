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
        String text = " Hello   I'm  Frank ";
        assertEquals(3, SpliteratorWordCounter.countWords(text));
    }
    
}