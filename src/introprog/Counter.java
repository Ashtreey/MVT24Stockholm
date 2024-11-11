package introprog; // Speci

public class Counter {
    private int totalChars; // Totala tecken utan mellanslag
    private int lineCount;  // Antal rader
    private int wordCount;  // Antal giltiga ord
    private String longestWord; // Längsta  giltiga ordet
    private boolean stopEntered; // Flagga för att kolla om "stop" har skrivits
    private boolean allWordsEqual; // Flagga för att kolla om alla ord är lika långa
    private int firstWordLength; // Längd på det första ordet som jämförelse


    // Konstruktor som initialiserar räknarna
    public Counter() {
        this.totalChars = 0; // Initialisera total antal tecken till 0
        this.lineCount = 0; // Initialisera total antal rader till 0
        this.wordCount = 0; // Initialisera total antal giltiga ord till 0
        this.longestWord = "Inga giltiga ord";
        this.stopEntered = false;
        this.allWordsEqual = true; // Startar ifall att alla ord är lika långa
        this.firstWordLength = -1; // Initial längd på första ordet är satt till ett ogiltigt värde
    }

    // Metod för att lägga till tecken från en ny rad
    public void addLine(String line) {
        if (line.equalsIgnoreCase("stop")) {
            stopEntered = true; // Sätt flaggan om "stop" har skrivits
            return; // Avsluta metoden
        }
        // Öka antalet rader
        lineCount++;

        // Dela upp raden i ord
        String[] words = line.trim().split("\\s+"); // Dela upp raden i ord
        int localWordCount = 0; // Räkna giltiga ord för denna rad
        String currentLongestWord = ""; // Temporär lagring för längsta ord

        // Kontrollera och uppdatera det längsta ordet
        for (String word : words) {
            // Räkna alla tecken
            totalChars += word.length();

            // Extrahera bokstäver från ordet
            String onlyLetters = word.replaceAll("[^a-zA-ZåäöÅÄÖ]", "");

            if (!onlyLetters.isEmpty()) {
                localWordCount++;
                wordCount++; // Öka antalet giltiga ord

                // Kontrollera och uppdatera första ordets längd
                if (firstWordLength == -1) {
                    firstWordLength = onlyLetters.length();
                } else if (onlyLetters.length() != firstWordLength) {
                    allWordsEqual = false; // Om längderna inte matchar sätts flaggan till false
                }
                // Kontrollera och uppdatera det längsta ordet
                if (onlyLetters.length() > currentLongestWord.length()) {
                    currentLongestWord = onlyLetters;
                }
            }
        }

        if (localWordCount > 0) {

            // Kontrollera om alla ord är lika långa och uppdatera längsta ordet
            if (allWordsEqual && wordCount > 1) {
                longestWord = "Alla ord är lika långa";
            } else {
                longestWord = currentLongestWord;
            }
        }
        // Om inga giltiga ord finns, skrivs "Inga giltiga ord" ut.
        if (wordCount == 0) {
            longestWord = "Inga giltiga ord";
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
