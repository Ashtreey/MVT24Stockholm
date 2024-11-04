package introprog; // Specifierar paketet som klassen tillhör

// Klass för att räkna antalet tecken och rader
public class Räknare {
    private int totalChars; // Totala tecken utan mellanslag
    private int lineCount;  // Antal rader
    private int wordCount;  // Antal giltiga ord
    private String longestWord; // Längsta ordet eller meddelande
    private boolean stopEntered; // Flagga för att kolla om "stop" har skrivits

    // Konstruktor som initialiserar räknarna
    public Räknare() {
        this.totalChars = 0;
        this.lineCount = 0;
        this.wordCount = 0;
        this.longestWord = "Inga giltiga ord"; // Sätter till standardmeddelande
        this.stopEntered = false;
    }

    // Metod för att lägga till tecken från en ny rad
    public void addLine(String line) {
        if (line.equalsIgnoreCase("stop")) {
            stopEntered = true;
            return;
        }

        lineCount++; // Öka antalet rader

        // Dela upp raden i ord
        String[] words = line.trim().split("\\s+"); // Dela upp raden i ord
        int localWordCount = 0; // Räkna giltiga ord för denna rad
        String currentLongestWord = ""; // Temporär lagring för längsta ord

        // Kontrollera och uppdatera det längsta ordet
        for (String word : words) {
            // Hoppa över ogiltiga ord
            if (word.isEmpty() || word.matches("^[0-9]+$") || !word.matches("^[a-zA-ZåäöÅÄÖ]+$")) {
                continue; // Hoppa över ogiltiga ord
            }

            localWordCount++; // Räkna giltigt ord

            // Kolla om det längsta ordet ska uppdateras
            if (word.length() > currentLongestWord.length()) {
                currentLongestWord = word; // Sätt aktuellt längsta ord
            }
        }

        // Räkna tecken utan mellanslag
        totalChars += line.replace(" ", "").length();

        wordCount += localWordCount; // Lägg till den lokala ordräkningen till den totala

        // Om programmet har funnit giltiga ord, uppdatera det längsta ordet
        if (localWordCount > 0) {
            longestWord = currentLongestWord; // Sätt längsta ordet till aktuellt längsta
        }

        // Om inga giltiga ord finns och man inte har registrerat något, sätt längsta ordet till "Inga giltiga ord"
        if (wordCount == 0) {
            longestWord = "Inga giltiga ord"; // Sätt längsta ordet till meddelandet
        }
    }

    // Getters för att hämta resultat
    public int getTotalChars() {
        return totalChars;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public boolean isStopEntered() {
        return stopEntered;
    }
}
