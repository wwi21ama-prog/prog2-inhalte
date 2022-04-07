public class ContainerSchiff extends Schiff {
    int maxAnzahlContainer;
    double maxLadegewicht;

    // Eine separate Methode wäre möglich, dann müssten wir diese aber für jede erbende Klasse kennen,
    // anstatt einfach auslaufen() aufzurufen. Dann kümmert sich die JVM um die Zuordnung zur richtigen Klasse.
    /*void containerSchiffLaeuftAus() {
        System.out.println("Das Schiff mit dem Kapitän " + kapitaen.name + " verlässt den Hafen mit der maximalen Anzahl von " + maxAnzahlContainer + " Containern.");
    }*/

    @Override // optional, aber hilfreich zum Erkennen überschriebener Methoden
    void auslaufen() {
        System.out.println("Das Schiff mit dem Kapitän " + kapitaen.name + " verlässt den Hafen mit der maximalen Anzahl von " + maxAnzahlContainer + " Containern.");
    }
}
