import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    // Attribute/Variablen, die von allen Methoden benötigt werden
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        // testInputs(); // der Code war nur zum Testen in der letzten Vorlesung gedacht
        List<User> allUsers = new ArrayList<>();
        List<Project> allProjects = new ArrayList<>();

        // 1. Schleife
        while (true) {
            System.out.println("Folgende Optionen sind möglich:");
            System.out.println("(1) Benutzer anlegen");
            System.out.println("(2) Projekt anlegen");
            System.out.println("(3) Aufgabe anlegen");
            System.out.println("(e) Programm beenden");
            // 1.1 Auf Benutzereingabe warten
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
        }*/ // das ist nicht so gut lesbar wie ein "switch"-Konstrukt

            switch (userInput) {
                // case "p":
                // case "anlegen":
                // case "projekt":
                case "1": // Benutzer anlegen
                    System.out.println("--- Neuen Benutzer anlegen ---");
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
                case "2": // Projekt anlegen und Verantwortlichen zuweisen
                    System.out.println("--- Neues Projekt anlegen ---");
                    System.out.println("Wer soll für das Projekt verantwortlich sein?");
                    User manager = askForUser(allUsers);
                    if (manager == null) { // kein valider Benutzer ausgewählt
                        System.err.println("Der angegebene Benutzer wurde nicht gefunden. Projekterstellung abgebrochen.");
                        break;
                    }
                    Project newProject = new Project();
                    newProject.manager = manager;
                    allProjects.add(newProject);
                    // wir müssen die project.tasks nicht explizit setzen, da diese bei Erzeugung eines Objekts mit
                    // einer leeren ArrayList initialisiert werden
                    System.out.println("Es wurde(n) bereits " + allProjects.size() + " Projekte registriert.");
                    break;
                case "3": // Aufgabe anlegen und zu Projekt hinzufügen
                    System.out.println("--- Neue Aufgabe anlegen ---");
                    System.out.println("Zu welchem Projekt soll die Aufgabe hinzugefügt werden?");
                    Project project = askForProject(allProjects);
                    if (project == null) { // kein valider Benutzer ausgewählt
                        System.err.println("Das angegebene Projekt wurde nicht gefunden. Aufgabenerstellung abgebrochen.");
                        break;
                    }
                    System.out.println("Welche Beschreibung soll für die Aufgabe hinterlegt werden?");
                    String taskDescription = inputScanner.nextLine();
                    System.out.println("Wer soll für die Aufgabe verantwortlich sein?");
                    User processor = askForUser(allUsers);
                    if (processor == null) { // kein valider Benutzer ausgewählt
                        System.err.println("Der angegebene Benutzer wurde nicht gefunden. Aufgabenerstellung abgebrochen.");
                        break;
                    }
                    Task newTask = new Task(processor, taskDescription);
                    // Wir benötigen keine "allTasks"-Liste, da jeder Task zu genau einem Projekt gehört.
                    // Deshalb reicht es, den Task dem jeweiligen Projekt hinzufügen.
                    project.addTask(newTask);
                    System.out.println("Das gewählte Projekt besitzt " + project.tasks.size() + " Aufgaben.");
                    break;
                case "e": // Programm beenden
                    // Alternative: System.exit(0);
                    return; // beendet auch die main()-Methode
                default: // Fehlerbehandlung
                    System.err.println("Die Eingabe ist kein gültiger Befehl, bitte versuche es nochmal!");
            }

            System.out.println("------");
            System.out.println(); // leere Zeile zur übersichtlicheren Darstellung einfügen
        }
    }

    private static User askForUser(List<User> allUsers) {
        System.out.println("Folgende Benutzer sind im System vorhanden:");

        for (int i = 0; i < allUsers.size(); i++) {
            User theUser = allUsers.get(i);
            System.out.println((i + 1) + ") " + theUser.firstname + " " + theUser.lastname + " (" + theUser.username + ")");
        }

        System.out.println("Welcher Benutzer soll ausgewählt werden (Index eingeben)?");
        // durch try {} catch {} fangen wir alle Ausnahmen (Exceptions) ab, die bei einer fehlerhaften Eingabe
        // (bspw. einem String) sonst zum Absturz des Programms führen würden
        try {
            int userIndex = inputScanner.nextInt();
            // da wir oben zur einfacheren Darstellung bei 1 anfangen (i + 1),
            // müssen wir hier (i - 1) rechnen, um den korrekten Index zu erhalten
            userIndex = userIndex - 1;
            if (userIndex < 0 || userIndex >= allUsers.size()) {
                System.err.println("Der Benutzer mit dem Index " + userIndex + "existiert nicht");
                return null;
            }
            return allUsers.get(userIndex);
        } catch (Exception e) {
            System.err.println("Ungültiger Benutzerindex!");
            return null;
        }
    }

    private static Project askForProject(List<Project> allProjects) {
        System.out.println("Folgende Projekte sind im System vorhanden:");

        for (int i = 0; i < allProjects.size(); i++) {
            Project theProject = allProjects.get(i);
            System.out.println((i + 1) + ") geleitet von " + theProject.manager.firstname + " " + theProject.manager.firstname + " (" + theProject.manager.username + ")");
        }

        System.out.println("Welches Projekt soll ausgewählt werden (Index eingeben)?");
        // durch try {} catch {} fangen wir alle Ausnahmen (Exceptions) ab, die bei einer fehlerhaften Eingabe
        // (bspw. einem String) sonst zum Absturz des Programms führen würden
        try {
            int projectIndex = inputScanner.nextInt();
            // da wir oben zur einfacheren Darstellung bei 1 anfangen (i + 1),
            // müssen wir hier (i - 1) rechnen, um den korrekten Index zu erhalten
            projectIndex = projectIndex - 1;
            if (projectIndex < 0 || projectIndex >= allProjects.size()) {
                System.err.println("Das Projekt mit dem Index " + projectIndex + "existiert nicht");
                return null;
            }
            return allProjects.get(projectIndex);
        } catch (Exception e) {
            System.err.println("Ungültiger Projektindex!");
            return null;
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
