import com.keyin.SuggestionEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine;

    @BeforeEach
    public void setUp() {
        suggestionEngine = new SuggestionEngine();
    }

    @Test
    public void testGenerateSuggestionsForExistingWord() {
        String suggestions = suggestionEngine.generateSuggestions("hello");
        assertEquals("", suggestions);
    }

    @Test
    public void testGenerateSuggestionsForNonExistingWord() {
        String suggestions = suggestionEngine.generateSuggestions("helo");
        assertNotNull(suggestions);
    }

    @Test
    public void testLoadDictionaryData() {
        assertDoesNotThrow(() -> suggestionEngine.loadDictionaryData(Paths.get("src/main/words.txt")));
    }

    @Test
    public void testWordSuggestionDBInitialization() {
        assertNotNull(suggestionEngine.getWordSuggestionDB());
    }

    @Test
    public void testWordSuggestionDBPopulation() throws IOException {
        suggestionEngine.loadDictionaryData(Paths.get("src/main/words.txt"));
        assertTrue(suggestionEngine.getWordSuggestionDB().size() > 0);
    }
}

//test comment