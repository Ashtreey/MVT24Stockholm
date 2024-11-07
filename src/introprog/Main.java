package introprog; // Specifierar paketet som klassen tillhör

// Huvudklass för programmet
public class Main {
    // Huvudmetoden som körs när programmet startar
    public static void main(String[] args) {
        // Skapar ett objekt av Inläsnings-klassen för att hantera användarinmatning
        Reader reader = new Reader();

        // Anropar metoden readInput(); för att starta inläsning av text
        reader.readInput();
    }
}
