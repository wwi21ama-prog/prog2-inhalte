# Unternehmensstruktur
## Vorbereitung
Lege für die entworfene Unternehmensstruktur die Struktur der Java-Klassen inkl. der Vererbungshierarchie an.

## Anforderungen
1. Jeder Mitarbeitende soll sich zur Arbeit melden können (`checkIn()`), was zu folgender Ausgabe führt: `Der Mitarbeitende <Vorname> <Nachname> ist verfügbar`
2. Der Sachbearbeiter (`Clerk`) soll Aufgaben verwalten können (`tasks`).
3. Meldet sich ein Manager zur Arbeit, soll die Mitteilung `Der Manager <Vorname> <Nachname> ist verfügbar` ausgegeben werden.
4. Der Manager managed verschiedene Mitarbeitende (`managedEmpl`).
5. Jeder Mitarbeitende erhält eine eindeutige und automatisch generierte `id`.
6. Ein Sachbearbeiter besitzt eine Liste von `tasks`, die er mithilfe der Methode `processDocuments()` abarbeiten kann (`Der Sachbearbeiter bearbeitet Aufgabe <Aufgabenname>`).
 