package introprog; // Speci

public class Counter {
    private int totalChars; // Totala tecken utan mellanslag
    private int lineCount;  // Antal rader
    private int wordCount;  // Antal giltiga ord
    private String longestWord; // Längsta  giltiga ordet
    private boolean stopEntered; // Flagga för att kolla om "stop" har skrivits

    // Konstruktor som initialiserar räknarna
    public Counter() {
        this.totalChars = 0;
        this.lineCount = 0;
        this.wordCount = 0;
        this.longestWord = "Inga giltiga ord";
        this.stopEntered = false;
    }

    // Metod för att lägga till tecken från en ny rad
    public void addLine(String line) {
        if (line.equalsIgnoreCase("stop")) {
            stopEntered = true;
            return;
        }
        // Öka antalet rader
        lineCount++; // Öka antalet rader

        // Dela upp raden i ord
        String[] words = line.trim().split("\\s+"); // Dela upp raden i ord
        int localWordCount = 0; // Räkna giltiga ord för denna rad
        String currentLongestWord = ""; // Temporär lagring för längsta ord
        boolean allWordsEqual = true;
        int firstWordLength = -1;

        // Kontrollera och uppdatera det längsta ordet
        for (String word : words) {
            // Räkna alla tecken
            totalChars += word.length();

            // Extrahera bokstäver från ordet
            String onlyLetters = word.replaceAll("[^a-zA-ZåäöÅÄÖ]", "");

            if (!onlyLetters.isEmpty()) {
                localWordCount++;

                if (firstWordLength == -1) {
                    firstWordLength = onlyLetters.length();
                } else if (onlyLetters.length() != firstWordLength) {
                    allWordsEqual = false;
                }

                if (onlyLetters.length() > currentLongestWord.length()) {
                    currentLongestWord = onlyLetters;
                }
            }
        }
        // Lägg till den lokala ordräkningen till den totala
        wordCount += localWordCount;

        if (localWordCount > 0) {
            if (allWordsEqual && localWordCount > 1) {
                longestWord = "Alla ord är lika långa";
            } else {
                longestWord = currentLongestWord;
            }
        }
        // Sätt längsta ordet till meddelandet
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
