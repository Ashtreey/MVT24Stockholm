package introprog; // Specifierar paketet som klassen tillhör

import org.junit.Test; // Importerar JUnit Test-annotering för att markera testmetoder
import static org.junit.Assert.*; // Importerar assert-metoder för att göra påståenden i tester

// Testklass för att testa funktionaliteten i Del2Räknare
public class InläsningTest {

    // Testar att metoden addLine korrekt uppdaterar tecken- och radräknaren
    @Test
    public void testAddLineUpdatesCounts() {
        // Arrange: Skapa en instans av Del2Räknare för att hålla statistiken
        Räknare stats = new Räknare();

        // Act: Lägg till en rad text
        stats.addLine("Hello World!");

        // Assert: Kontrollera att antalet tecken och rader har uppdaterats korrekt
        assertEquals(11, stats.getTotalChars()); // Förväntat antal tecken
        assertEquals(1, stats.getLineCount()); // Förväntat antal rader
    }

    // Testar att flera rader uppdaterar tecken- och radräknaren korrekt
    @Test
    public void testMultipleLines() {
        // Arrange: Skapa en ny instans av Del2Räknare
        Räknare stats = new Räknare();

        // Act: Lägg till flera rader text
        stats.addLine("First line.");
        stats.addLine("Second line.");

        // Assert: Kontrollera att totalsumman av tecken och antal rader stämmer
        assertEquals(21, stats.getTotalChars()); // Förväntat totalt antal tecken
        assertEquals(2, stats.getLineCount()); // Förväntat antal rader
    }

    // Testar att lägga till en tom rad hanteras korrekt
    @Test
    public void testEmptyLine() {
        // Arrange: Skapa en ny instans av Del2Räknare
        Räknare stats = new Räknare();

        // Act: Lägg till en tom rad
        stats.addLine("");

        // Assert: Kontrollera att statistiken för tecken och rader uppdateras som förväntat
        assertEquals(0, stats.getTotalChars()); // Förväntat antal tecken
        assertEquals(1, stats.getLineCount()); // Förväntat antal rader
    }
        // Test för att räkna antalet ord
    @Test
    public void testWordCount() {
        // Arrange
        Räknare stats = new Räknare();

        // Act
        stats.addLine("First line.");
        stats.addLine("Second line with more words.");

        // Assert
        assertEquals(5
                , stats.getWordCount()); // Förväntat antal ord
        assertEquals("Second", stats.getLongestWord()); // Förväntat längsta ord
    }


}