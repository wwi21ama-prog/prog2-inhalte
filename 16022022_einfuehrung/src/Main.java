// Generelle Konvention: Camel-Case-Schreibweise (bspw. "thisIsAVeryLongVariableName")

class Main { // Klasse "Main" (Konvention: Klassen beginnen mit einem Großbuchstaben

    // Von anderen Klassen sichtbare (public) Methode ohne Rückgabewert (void), die ein String-Array mit übergebenen
    // Argumenten aus der Konsole (args) erwartet und initial beim Aufruf der Anwendung ausgeführt wird
    public static void main(String[] args) {
        // Zwei Variablen vm Typ "Fließkomma mit doppelter Genauigkeit" (double) deklarieren und initialisieren
        double number1 = 24.0;
        double number2 = 32.0;

        // Ergebnis der Division muss wieder ein "double" sein (da Division Bruchteile ergeben kann)
        double result = number1 / number2;
        System.out.println("Das Ergebnis ist: " + result); // Ergebnis von number1 / number2

        // Zwei Zeichenketten (Typ ist die Klasse "String") deklarieren und initialisieren
        String vorname = "Max";
        String nachname = "Mustermann";

        // Konkatenierten (d. h. "zusammengefügten") String an der Konsole ausgeben
        System.out.println("Mein Name ist: " + vorname + " " + nachname);

        String password = "java"; // Benutzereingabe
        String actualPassword = "javakurs";
        // Wichtig: bei Vergleich von Strings immer ".equals()" nutzen
        // (https://github.com/DieProgrammierDozenten/java-intro/blob/master/Exkurse/Strings%20vs.%20Basistypen.md)
        if (password.equals(actualPassword)) {
            // Passwort ist korrekt
            System.out.println("Login erfolgreich");
        } else {
            // Passwort ist falsch
            System.out.println("Login fehlgeschlagen, bitte erneut versuchen.");
        }

        int passcode = 12346;
        int realPasscode = 12346;
        // Vergleich bei primitiven Datentypen wie "int" immer über "==" möglich)
        if (passcode == realPasscode) {
            // Passcode ist korrekt
            System.out.println("Login mit Passcode erfolgreich");
        } else {
            // Passcode ist falsch
            System.out.println("Login mit Passcode fehlgeschlagen, bitte erneut versuchen.");
        }
    }
}