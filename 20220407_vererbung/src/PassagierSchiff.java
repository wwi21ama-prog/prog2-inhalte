public class PassagierSchiff extends Schiff {
    int maxAnzahlPersonen;

    @Override
    void auslaufen() {
        System.out.println("Das Schiff mit dem Kapitän " + kapitaen.name + " verlässt den Hafen mit der maximalen Anzahl von " + maxAnzahlPersonen + " Passagieren.");
    }
}
