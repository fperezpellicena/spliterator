package unit.com.fperezpellicena.wordcounter;

import com.fperezpellicena.wordcounter.FunctionalWordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionalWordCounterTest {

    @Test
    public void simplePhrase() {
        String text = "Hello I am Frank";
        assertEquals(4, FunctionalWordCounter.countWords(text));
    }

    @Test
    public void phraseWithExtraWhitespaces() {
        String text = " Hello   I'm  Frank ";
        assertEquals(3, FunctionalWordCounter.countWords(text));
    }

}