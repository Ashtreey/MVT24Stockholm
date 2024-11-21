package introprog; // Specifierar paketet som klassen tillhör

public class Counter {
    // Räknar antalet rader som har lästs in
    private int lineCount = 0;

    // Räknar antalet ord som har lästs in
    private int wordCount = 0;

    // Räknar totala antalet tecken i alla ord
    private int totalChars = 0;

    // Det längsta ordet hittills
    private String longestWord = "";

    // Flagga för att spåra om "stop" har angetts
    private boolean stopEntered = false;

    // Flagga för att kontrollera om alla ord är lika långa
    private boolean allWordsEqual = true;

    // Längd på det första ordet som jämförelse
    private int firstWordLength = -1;

    public void addLine(String line) {
        // Kontrollera om "stop" har angetts, om ja, sätt stopEntered till true och avsluta metoden
        if (line.equalsIgnoreCase("stop")) {
            stopEntered = true;
            return;
        }

        // Öka räknaren för antalet rader
        lineCount++;

        // Dela upp raden i ord
        String[] words = line.trim().split("\\s+");
        String currentLongestWord = "";
        boolean hasValidWord = false;
        boolean currentAllWordsEqual = true;

        // Loopar genom varje ord i raden
        for (String word : words) {
            // Lägg till ordets längd till totalChars
            totalChars += word.length();

            // Ta bort alla tecken som inte är bokstäver
            String onlyLetters = word.replaceAll("[^a-zA-ZåäöÅÄÖ]", "");

            // Kontrollera om ordet innehåller giltiga bokstäver
            if (!onlyLetters.isEmpty()) {
                // Öka räknaren för antalet ord
                wordCount++;
                hasValidWord = true;

                // Om det är första ordet, sätt dess längd till firstWordLength
                if (firstWordLength == -1) {
                    firstWordLength = onlyLetters.length();
                } else if (onlyLetters.length() != firstWordLength) {
                    // Om ett ord inte har samma längd som det första ordet, sätt currentAllWordsEqual till false
                    currentAllWordsEqual = false;
                }

                // Om ordet är längre än nuvarande längsta ordet, sätt det som nuvarande längsta ordet
                if (onlyLetters.length() > currentLongestWord.length()) {
                    currentLongestWord = onlyLetters;
                }
            }
        }

        // Om det inte finns några giltiga ord, sätt currentLongestWord till en tom sträng
        if (!hasValidWord) {
            currentLongestWord = "";
        }

        // Kontrollera och sätt längsta ordet
        if (currentAllWordsEqual && wordCount > 1) {
            // Om alla ord är lika långa, sätt längsta ordet till "Alla ord är lika långa"
            longestWord = "Alla ord är lika långa";
        } else if (!currentLongestWord.isEmpty() && (longestWord.equals("Alla ord är lika långa") || currentLongestWord.length() > longestWord.length())) {
            // Om det nuvarande längsta ordet är längre än det längsta ordet hittills, sätt det som längsta ordet
            longestWord = currentLongestWord;
        }

        // Om det inte finns några ord alls, sätt längsta ordet till "Inga giltiga ord"
        if (wordCount == 0) {
            longestWord = "Inga giltiga ord";
        }

        // Om orden inte är lika långa, sätt allWordsEqual till false
        if (!currentAllWordsEqual) {
            allWordsEqual = false;
        }

        // Logga status för felsökning
      //  System.out.println("Longest Word: " + longestWord + ", All Words Equal: " + allWordsEqual + ", Current Longest Word: " + currentLongestWord);
    }

    // Returnera det längsta ordet
    public String getLongestWord() {
        return longestWord;
    }

    // Returnera antalet rader
    public int getLineCount() {
        return lineCount;
    }

    // Returnera antalet ord
    public int getWordCount() {
        return wordCount;
    }

    // Returnera totala antalet tecken
    public int getTotalChars() {
        return totalChars;
    }

    // Returnera om "stop" har angetts
    public boolean isStopEntered() {
        return stopEntered;
    }

    // Återställ alla räknare och flaggor
    public void reset() {
        lineCount = 0;
        wordCount = 0;
        totalChars = 0;
        longestWord = "";
        stopEntered = false;
        allWordsEqual = true;
        firstWordLength = -1;
    }
}
