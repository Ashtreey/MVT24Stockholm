package introprog; // Specifierar paketet som klassen tillhör

// Klass för att räkna antalet tecken och rader
public class Del2Räknare {
    // Variabel för att hålla antalet tecken som användaren skrivit
    private int totalChars;

    // Variabel för att hålla antalet rader som användaren skrivit
    private int lineCount;

    // Konstruktor som initialiserar tecken- och radräknaren
    public Del2Räknare() {
        this.totalChars = 0; // Sätter det totala antalet tecken till 0
        this.lineCount = 0;  // Sätter antalet rader till 0
    }

    // Metod för att lägga till tecken från en ny rad
    public void addLine(String line) {
        totalChars += line.length();  // Ökar det totala antalet tecken med längden av den nya raden
        lineCount++;  // Ökar räknaren för antalet rader med 1
    }

    // Getter för att hämta det totala antalet tecken
    public int getTotalChars() {
        return totalChars; // Returnerar det totala antalet tecken
    }

    // Getter för att hämta det totala antalet rader
    public int getLineCount() {
        return lineCount; // Returnerar det totala antalet rader
    }
}