import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // testInputs();
        List<User> allUsers = new ArrayList<>();

        // 1. Schleife
        while (true) {
            System.out.println("Folgende Optionen sind möglich:");
            System.out.println("(1) Benutzer anlegen");
            System.out.println("(2) Projekt anlegen");
            System.out.println("(3) Aufgabe anlegen");
            System.out.println("(e) Programm beenden");
            // 1.1 Auf Benutzereingabe warten
            Scanner inputScanner = new Scanner(System.in);
            String userInput = inputScanner.nextLine();
            System.out.println("Der Benutzer möchte folgende Aktion durchführen: " + userInput);
            // 1.2 Entscheidung, welche Anweisung ausgeführt werden muss
        /* if (userInput.equals("1")) {
            System.out.println("Aktion ist 1");
        } else if (userInput.equals("2")) {
            System.out.println("Aktion ist 2");
        } else if (userInput.equals("3")) {
            System.out.println("Aktion ist 3");
        } else {
            System.out.println("Andere Aktion");
        }*/

            switch (userInput) {
                // case "p":
                // case "anlegen":
                // case "projekt":
                case "1": // Benutzer anlegen
                    System.out.println("Wie heißt der Benutzer mit Vornamen?");
                    String firstname = inputScanner.nextLine();
                    System.out.println("Wie heißt der Benutzer mit Nachname?");
                    String lastname = inputScanner.nextLine();
                    System.out.println("Wie soll der Benutzername lauten?");
                    String username = inputScanner.nextLine();

                    User newUser = new User();
                    newUser.firstname = firstname;
                    newUser.lastname = lastname;
                    newUser.username = username;

                    allUsers.add(newUser);
                    System.out.println("Es wurde(n) bereits " + allUsers.size() + " Benutzer registriert.");
                    break;
                case "2": // Projekt anlegen
                    // TODO: Projekt anlegen und Verantwortlichen zuweisen
                    break;
                case "3": // Aufgabe anlegen
                    // TODO: Aufgabe anlegen und zu Projekt hinzufügen
                    break;
                case "e":
                    // TODO: Programm beenden
                    break;
                default: // Fehlerbehandlung
                    System.out.println("Die Eingabe ist kein gültiger Befehl, bitte versuche es nochmal!");
            }
            // 1.3 gewählte Anweisung ausführen
            // 1.4 Rückmeldung an den Benutzer
        }
    }

    /*
     * Dieser Code war nur zum Testen und wird im Programm nicht mehr verwendet
     */
    public static void testInputs() {
        // Ein kleines "Testprogramm"
        User u1 = new User();
        u1.username = "User 1";
        User u2 = new User();
        u2.username = "User 2";

        Project p1 = new Project();
        p1.manager = u1;

        Task t1 = new Task(u1, "Task 1");
        /*t1.description = "Task 1";
        t1.processor = u1;*/
        t1.setStatus(29);
        Task t2 = new Task(u2, "Task 2");
        /*t2.description = "Task 2";
        t2.processor = u2;*/
        t2.setStatus(100);
        Task t3 = new Task(u2, "Task 3");
        t3.setStatus(54);
        p1.addTask(t1);
        p1.addTask(t2);
        p1.addTask(t3);

        System.out.println("Der Projekstatus für Projekt 1 ist: " + p1.getProjectStatus()); // Erwartungswert: 61.0

        System.out.println(t1.getStatusAsPerc());
        System.out.println(t2.getStatusAsPerc());
    }
}
