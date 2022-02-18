import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        /* Wir verwenden statt Arrays Listen (ArrayList), da wir eine dynamische Länge z. B. für die zur Kompilierzeit
            noch nicht bekannte Anzahl an Spielern benötigen */

        // Fragekatalog inkl. Antworten (Freitext) generieren
        // Wir nehmen hier vorerst einen (fehleranfälligeren) Ansatz mit zwei Listen für Fragen und Antworten
        List<String> questions = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            // Fragen generieren
            questions.add("Frage " + (i + 1));
        }
        System.out.println(questions.size()); // Erwartete Ausgabe: 40
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            // Antworten generieren
            answers.add("Antwort " + (i + 1));
        }
        System.out.println(answers.size()); // Erwartete Ausgabe: 40

        // "Sichtprüfung": Stehen die richtigen Antworten am gleichen Index wie die jeweilige Frage?
        System.out.println("Frage: " + questions.get(20) + ", " + "Antwort: " + answers.get(20));

        // Benutzer soll Namen eingeben
        List<String> playerNames = new ArrayList<>();
        Scanner consoleScanner = new Scanner(System.in); // liest von der Konsole

        // Unterschiede: do {} while(), for {}, while{}

        /*
         Schleifenabbruchlogik:
            1. userInput == ":" --> Schleife soll abbrechen
            2. userInput != ":" --> Schleife soll weiterlaufen
         */
        String userInput = "";
        while (!userInput.equals("weiter")) {
            System.out.println("Bitte gib deinen Spielernamen ein (oder 'weiter' zum Abbruch):");
            userInput = consoleScanner.nextLine();
            playerNames.add(userInput);
            System.out.println("Willkommen im Spiel, " + userInput);
        }
        /* Nicht sehr elegante Lösung, aber wir wollen den Abbruchbefehl "weiter" nicht in unserer Spielerliste haben
            Alternativ könnte man bspw. über if(!userInput.equals("weiter")) {} in der Schleife prüfen, ob wir den
            Benutzer hinzufügen möchten oder nicht. Darüber lassen sich z. B. auch Mindestlängen für Benutzernamen ausgeben.
        */
        playerNames.remove("weiter");

        System.out.println("Das Spiel kann beginnen!");

        String inGameInput = "";
        // Ermitteln, ob Ende des Spiels erreicht ist (über Anzahl der beantworteten Fragen)
        final int MAX_NUMBER_OF_ROUNDS = 10;
        int roundCounter = 0;
        /* Solange Fragen stellen und auf Antworten warten, bis der Benutzer entweder "beenden" eingibt oder die
            maximale Anzahl an Runden erreicht ist */

        while (!inGameInput.equals("beenden") && roundCounter < MAX_NUMBER_OF_ROUNDS) {
            // Herausfinden, welcher Benutzer am Zug ist (Loop/Schleife)
            // TODO: Hier seid ihr gefragt!
            // Benutzer soll seine Antwort eingeben
            // TODO: Hier seid ihr gefragt!
            // Anzeigen, ob Antwort richtig oder falsch war
            // TODO: Hier seid ihr gefragt!
            // Punktzahl erhöhen oder 0 Punkte vergeben
            // TODO: Hier seid ihr gefragt!
            roundCounter++;
        }

        // Gewinner soll ausgegeben werden
        // TODO: Hier seid ihr gefragt!
    }
}
