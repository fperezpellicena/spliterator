package unit.com.fperezpellicena.wordcounter;

import com.fperezpellicena.wordcounter.IterativeWordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IterativeWordCounterTest {

    @Test
    public void simplePhrase() {
        String text = "Hello I am Frank";
        assertEquals(4, IterativeWordCounter.countWords(text));
    }

    @Test
    public void phraseWithExtraWhitespaces() {
        String text = " Hello   I'm  Frank ";
        assertEquals(3, IterativeWordCounter.countWords(text));
    }
}