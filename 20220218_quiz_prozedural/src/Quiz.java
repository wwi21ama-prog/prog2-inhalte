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
        List<Player> players = new ArrayList<>();
        Scanner consoleScanner = new Scanner(System.in); // liest von der Konsole

        // Unterschiede: do {} while(), for {}, while{}

        /*
         Schleifenabbruchlogik:
            1. userInput == ":" --> Schleife soll abbrechen
            2. userInput != ":" --> Schleife soll weiterlaufen
         */
        String userInput = "";
        while (true) {
            System.out.println("Bitte gib deinen Spielernamen ein (oder 'weiter' zum Abbruch):");
            userInput = consoleScanner.nextLine();
            if(userInput.equals("weiter")) {
                break;
            }

            Player newPlayer = new Player();
            players.add(newPlayer);
            newPlayer.name = userInput;
            System.out.println("Willkommen im Spiel, " + newPlayer.name);
        }
        /* Nicht sehr elegante Lösung, aber wir wollen den Abbruchbefehl "weiter" nicht in unserer Spielerliste haben
            Alternativ könnte man bspw. über if(!userInput.equals("weiter")) {} in der Schleife prüfen, ob wir den
            Benutzer hinzufügen möchten oder nicht. Darüber lassen sich z. B. auch Mindestlängen für Benutzernamen ausgeben.
        */
        System.out.println("Das Spiel kann beginnen!");

        String inGameInput = "";
        // Ermitteln, ob Ende des Spiels erreicht ist (über Anzahl der beantworteten Fragen)
        final int MAX_NUMBER_OF_ROUNDS = 10;
        int roundCounter = 0;
        int currentPlayerIndex = 0;
        /* Solange Fragen stellen und auf Antworten warten, bis der Benutzer entweder "beenden" eingibt oder die
            maximale Anzahl an Runden erreicht ist */
        while (/*!inGameInput.equals("beenden") &&*/ roundCounter < MAX_NUMBER_OF_ROUNDS) {
            // Herausfinden, welcher Benutzer am Zug ist (Loop/Schleife)
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.name + " ist an der Reihe!");

            // Frage stellen
            int currentQuestionIndex = (int) (Math.random() * questions.size());
            String currentQuestionText = questions.get(currentQuestionIndex);
            System.out.println("Frage: " + currentQuestionText);

            // Benutzer soll seine Antwort eingeben
            System.out.println("Was ist deine Antwort?");
            inGameInput = consoleScanner.nextLine();
            if(inGameInput.equals("beenden")) {
                System.out.println("Das Spiel wurde durch Spieler " + currentPlayer.name + " abgebrochen");
                break;
            }

            // Anzeigen, ob Antwort richtig oder falsch war
            String correctAnswerInLowerCaps = answers.get(currentQuestionIndex).toLowerCase();
            if(correctAnswerInLowerCaps.equals(inGameInput.toLowerCase())) {
                // Punktzahl erhöhen
                System.out.println("Diese Antwort war richtig!");
                currentPlayer.score++;
            } else {
                // 0 Punkte vergeben
                System.out.println("Diese Antwort war leider falsch. :(");
            }

            if(currentPlayerIndex == players.size() - 1) {
                System.out.println("Runde " + (roundCounter + 1) + " ist zu Ende.");
                roundCounter++;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); // size = 3
            // 1. Durchlauf: cPI = 0 -> (0 + 1 = 1) % 3 = 1
            // 2. Durchlauf: cPI = 1 -> (1 + 1 = 2) % 3 = 2
            // 3. Durchlauf: cPI = 2 -> (2 + 1 = 3) % 3 = 0
        }

        // Gewinner soll ausgegeben werden
        for(int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println("Spieler " + player.name + " hat " + player.score + " Punkte");
        }
    }
}
