package introprog; // Specifierar paketet som klassen tillhör

// Klass för att räkna antalet tecken och rader
public class Räknare {
    // Variabel för att hålla antalet tecken som användaren skrivit
    private int totalChars;

    // Variabel för att hålla antalet rader som användaren skrivit
    private int lineCount;

    // Variabel för att hålla antalet ord som användaren skrivit
    private int wordCount;

    // Variabel för att hålla det längsta ordet
    private String longestWord;

    // Flagga för att kolla om "stop" har skrivits
    private boolean stopEntered;

    // Konstruktor som initialiserar tecken, rad och ordräknaren
    public Räknare() {
        this.totalChars = 0; // Sätter det totala antalet tecken till 0
        this.lineCount = 0;  // Sätter antalet rader till 0
        this.wordCount = 0;  // Sätter antalet ord till 0
        this.longestWord = ""; // Längsta ordet är tomt
        this.stopEntered = false; // Initialt är stop inte skrivet
    }

    // Metod för att lägga till tecken från en ny rad
    public void addLine(String line) {
        // Kontrollera om användaren har skrivit "stop"
        if (line.equalsIgnoreCase("stop")) {
            stopEntered = true; // Sätt flaggan till true
            return; // Avsluta metoden om "stop" skrivs
        }

        totalChars += line.length();  // Ökar det totala antalet tecken med längden av den nya raden
        lineCount++;  // Ökar räknaren för antalet rader med 1

        // Räkna ord
        String[] words = line.trim().split("\\s+"); // Dela upp raden i ord
        wordCount += words.length; // Lägg till antalet ord

        // Kontrollera och uppdatera det längsta ordet
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word; // Uppdatera längsta ordet
            }
        }
    }

    // Getter för att hämta det totala antalet tecken
    public int getTotalChars() {
        return totalChars; // Returnerar det totala antalet tecken
    }

    // Getter för att hämta det totala antalet rader
    public int getLineCount() {
        return lineCount; // Returnerar det totala antalet rader
    }

    // Getter för totalt antal ord
    public int getWordCount() {
        return wordCount; // Returnerar totalt antal ord
    }

    // Getter för längsta ordet
    public String getLongestWord() {
        return longestWord; // Returnerar det längsta ordet
    }

    // Getter för att kolla om "stop" har skrivits
    public boolean isStopEntered() {
        return stopEntered; // Returnerar true om "stop" har skrivits
    }
}