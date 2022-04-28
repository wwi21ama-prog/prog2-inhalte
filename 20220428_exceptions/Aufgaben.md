# Aufgaben
## Hintergrund
Die Applikation `JavaBankAG` ermöglicht das Einlesen von Kontoinformationen aus einer Textdatei sowie die Anzeige von und Interaktion mit Bankkonten.
Allerdings ist diese noch nicht funktionsfähig, da einige Fehlerfälle nicht korrekt behandelt werden.

## Basisaufgabe
Im Programmcode fehlt an verschiedenen Stellen eine entsprechende Ausnahmenbehandlung, aufgrund derer sich das Programm nicht kompilieren lässt (`checked exceptions`) oder in bestimmten Fällen abstürzen würde (`unchecked exceptions`).
Die Aufgabe ist es, diese Stellen zu identifizieren und mit einer entsprechenden Ausnahmenbehandlung (`try {} catch() {} finally {}` oder `throws`) zu versehen.
Vor der Implementierung der Änderung ist zu überlegen, welche Art von Exception (bspw. `IOException`) an welcher Position Sinn macht.

## Fortgeschrittene Aufgaben
1. Für den Fall, dass die Textdatei `accountdetails.txt` nicht das vorgesehene Format (siehe unten) hat, soll eine `AccountFormatException` geworfen und entsprechend behandelt werden.
2. Die selbst erstellte Exception soll eine individuelle Fehlermeldung ausgeben können, die einen Hinweis auf die Nummer der ersten Zeile mit fehlerhaftem Format gibt.
3. Wählt der Benutzer im Hauptmenü eine ungültige Option, soll eine `InvalidMenuOptionException` geworfen und entsprechend behandelt werden.
