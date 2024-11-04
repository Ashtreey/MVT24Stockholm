package introprog; // Specifierar paketet som klassen tillhör

import org.junit.Test; // Importerar JUnit Test-annotering för att markera testmetoder
import static org.junit.Assert.*; // Importerar assert-metoder för att göra påståenden i tester

// Testklass för att testa funktionaliteten i Del2Räknare
public class InläsningTest {

    // Testar att metoden addLine korrekt uppdaterar tecken- och radräknaren
    @Test
    public void testAddLineUpdatesCounts() {
        // Skapar en instans av Räknare för att hålla statistiken
        Räknare stats = new Räknare();

        // Lägg till en rad och kontrollera att statistiken uppdateras korrekt
        stats.addLine("Hello World!");
        assertEquals(11, stats.getTotalChars()); // Förväntat antal tecken
        assertEquals(1, stats.getLineCount()); // Förväntat antal rader
    }

    // Testar att flera rader uppdaterar tecken- och radräknaren korrekt
    @Test
    public void testMultipleLines() {
        // Skapar en ny instans av Räknare
        Räknare stats = new Räknare();

        //Lägg till flera rader text
        stats.addLine("First line.");
        stats.addLine("Second line.");

        //Kontrollera att totalsumman av tecken och antal rader stämmer
        assertEquals(21, stats.getTotalChars()); // Förväntat totalt antal tecken
        assertEquals(2, stats.getLineCount()); // Förväntat antal rader
    }

    // Testar att lägga till en tom rad hanteras korrekt
    @Test
    public void testEmptyLine() {
        // Skapar en ny instans av Räknare
        Räknare stats = new Räknare();

        // Lägg till en tom rad
        stats.addLine("");

        // Kontrollera att statistiken för tecken och rader uppdateras som förväntat
        assertEquals(0, stats.getTotalChars()); // Förväntat antal tecken
        assertEquals(1, stats.getLineCount()); // Förväntat antal rader
    }
        // Test för att räkna antalet ord
    @Test
    public void testWordCount() {
        // Skapar ny instans av Räknare
        Räknare stats = new Räknare();

        // Lägg till rader med text för att testa funktionaliteten
        stats.addLine("First line.");
        stats.addLine("Second line with more words.");

        // Kontrollerar att antalet ord och det längsta ordet är korrekt
        assertEquals(5,stats.getWordCount()); // Förväntat antal ord
        assertEquals("Second", stats.getLongestWord()); // Förväntat längsta ord
    }


}