// Specifierar paketet som klassen tillhör
package introprog;

import java.util.Scanner; // Importerar Scanner-klassen för att läsa in data från användaren

// Klass för att läsa in text från användaren
public class Inläsning {

    // Metod för att läsa text från användaren och använda Del2Räknare för att hålla koll på rader och tecken
    public void readInput() {
        Scanner scanner = new Scanner(System.in); // Skapar en scanner för att läsa in användarens input
        Räknare stats = new Räknare(); // Skapar ett Del2Räknare-objekt för att spåra rader och tecken
        String input; // Variabel för att lagra användarens inmatning

        // Informera användaren om hur man avslutar programmet
        System.out.println("Skriv in text, skriv 'stop' för att avsluta");

        // Loop för att fortsätta läsa inmatning tills användaren skriver "stop"
        while (true) {
            input = scanner.nextLine(); // Läs in en rad från användaren
            stats.addLine(input); // Uppdatera statistiken med den nya raden

            // Kontrollera om användaren har skrivit "stop"
            if (stats.isStopEntered()) {
                break; // Avsluta loopen om användaren skrivit "stop"
            }
        }

        // Skriv ut totalantal tecken och rader efter att användaren har skrivit "stop"
        System.out.println("Programmet avslutas."); // Meddelande om att programmet avslutas
        System.out.println("Du skrev totalt " + stats.getTotalChars() + " tecken."); // Visar totala tecken
        System.out.println("Du skrev totalt " + stats.getLineCount() + " rader."); // Visar totala rader
        System.out.println("Du skrev totalt " + stats.getWordCount() + " ord."); // Visar antal ord
        System.out.println("Det längsta ordet är: " + stats.getLongestWord()); // Visar det längsta ordet

        // Stäng scanner för att frigöra resurser
        scanner.close();
    }
}