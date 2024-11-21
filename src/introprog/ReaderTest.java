package introprog; // Specifierar paketet som klassen tillhör

import org.junit.Test;
import static org.junit.Assert.*;


// Testklasss för att testa funktionerna i Counter genom att ta ut informationen från Reader
public class ReaderTest {

    // Testar så att metoden addLine uppdaterar tecken o radräknaren korrekt
    @Test
    public void testAddLineUpdatesCounts() {

        // Skapar en ny instans av Counter
        Counter stats = new Counter();

        // Lägger till en rad och kontrollerar så att statistiken uppdateras korrekt
        stats.addLine("Tomas for President!");
        assertEquals(18, stats.getTotalChars()); // Förväntat antal tecken
        assertEquals(1, stats.getLineCount()); // Förväntat antal rader
    }

    // Testar så att flera rader, tecken och radräknare fungerar korrekt
    @Test
    public void testMultipleLines() {

        Counter stats = new Counter();

        // Lägg till flera rader text
        stats.addLine("Första raden");
        stats.addLine("Andra raden");

        // Kontrollerar att totalsumman av tecken och antal rader stämmer
        assertEquals(21, stats.getTotalChars());
        assertEquals(2, stats.getLineCount());
    }

    // Testar så tom rad fungerar korrekt och ej räknas som tecken.
    @Test
    public void testEmptyLine() {
        Counter stats = new Counter();

        // Lägg till tom rad
        stats.addLine("");

        // Kontrollerar att statistiken för tecken och rader uppdateras korrekt
        assertEquals(0, stats.getTotalChars());
        assertEquals(1, stats.getLineCount());
    }
    // Test för att kontrollera så att tom rad och ogiltiga ord ej påverkar statistiken felaktikgt.
    @Test
    public void testEmptyAndInvalidLines() {
        Counter stats = new Counter();

        stats.addLine("");
        stats.addLine("12345");

        // Kontrollerar så statistiken ej påverkas felaktigt
        assertEquals(5, stats.getTotalChars()); // Totalt antal tecken inklusive siffror
        assertEquals(0, stats.getWordCount()); // Antalt giltiga ord
        assertEquals("Inga giltiga ord", stats.getLongestWord()); // Förväntat längsta ord
        assertEquals(2, stats.getLineCount()); // Totalt antal rader
    }

    // Test för att se så "stop" funktionen fungerar korrekt
    @Test
    public void testStopCommand() {
        Counter stats = new Counter();

        // Skriver in ett ord och sedan byter rad och
        // skriver stop för att se att stop avslutar programmet och ej räknas som ord.
        stats.addLine("Tjenis");
        stats.addLine("stop");

        // Kontrollerar så stop funktionen fungerar korrekt
        assertTrue(stats.isStopEntered()); // Stop-flaggan ska vara satt
        assertEquals(1, stats.getLineCount()); // Kontrollerar så att endast raden innan stop räknas
    }

    // Test för att kontrollera en rad med endast mellanslag
    @Test
    public void testWithSpacebarOnly() {
        Counter stats = new Counter();

        // Rad med enbart mellanslag
        stats.addLine("           ");

        // Kontrollera att enbart mellanslag ej ger utslag som ord eller tecken
        assertEquals(0, stats.getTotalChars());
        assertEquals(0, stats.getWordCount());
        assertEquals("Inga giltiga ord", stats.getLongestWord());
        assertEquals(1, stats.getLineCount());
    }

    // Test för att kontrollera att programmet hanterar stora bokstäver korrekt
    @Test
    public void testUpperCaseLetters() {
        Counter stats = new Counter();
        stats.addLine("TOMAS");
        stats.addLine("FOR PRESIDENT");
        assertEquals(17, stats.getTotalChars());
        assertEquals(3, stats.getWordCount());
        assertEquals("PRESIDENT", stats.getLongestWord());
    }

    // Test för att kontrollera antalet tomma rader så de ej räknas som ord
    @Test
    public void testLinesWithoutWords() {
        Counter stats = new Counter();
        stats.addLine(" ");
        stats.addLine(" ");
        stats.addLine(" ");
        assertEquals(0, stats.getWordCount());
        assertEquals(3, stats.getLineCount());
        assertEquals("Inga giltiga ord", stats.getLongestWord());
    }

    // Test för att kontrollera antalet ord samt längsta ord
    @Test
    public void testWordCount() {
        Counter stats = new Counter();
        stats.addLine("Hejja");
        stats.addLine("MVT Stockholm");
        assertEquals(3, stats.getWordCount());
        assertEquals("Stockholm", stats.getLongestWord());
    }

    // test för att kontrollera om alla ord är lika långa
    @Test
    public void testAllWordsEqualLength() {
        Counter stats = new Counter();

        //Lägg till rader med ord som är lika långa
        stats.addLine("Hej hoj haj");
        assertEquals("Alla ord är lika långa", stats.getLongestWord());

        //Lägg till flera rader med ord som är lika långa
        stats.addLine("Mer ber ser");
        assertEquals("Alla ord är lika långa", stats.getLongestWord());

        // Lägg till en rad med ett ord som bryter mot regeln
        stats.addLine("MVTStockholm");
        assertEquals("MVTStockholm", stats.getLongestWord());
    }
    // Test för att räkna orden korrekt samt hitta längsta ordet
    @Test
    public void testCorrectWordCountAndLongestWord() {
        Counter stats = new Counter();
        stats.addLine("HEJSAN HOPPSAN FALLERALLERA!");
        stats.addLine("Ojsan");
        stats.addLine("Stop");

        assertEquals(31, stats.getTotalChars());
        assertEquals(2, stats.getLineCount());
        assertEquals(4, stats.getWordCount());
        assertEquals("FALLERALLERA", stats.getLongestWord());
    }
}
