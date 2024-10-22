package introprog; // Specifierar paketet som klassen tillhör

// Huvudklass för programmet
public class Main {
    // Huvudmetoden som körs när programmet startar
    public static void main(String[] args) {
        // Skapar ett nytt objekt av klassen Del2Inläsning
        // Detta objekt används för att läsa in text från användaren
        Inläsning reader = new Inläsning();

        // Anropar metoden readInput() på reader-objektet
        // Denna metod ansvarar för att hantera inläsning av text och statistik
        reader.readInput();
    }
}