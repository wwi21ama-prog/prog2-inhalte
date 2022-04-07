import java.util.ArrayList;
import java.util.List;

// Klasse zum Ausprobieren
public class Application {
    public static void main(String[] args) {
        // Zwei Menschen zum Testen
        Mensch mensch1 = new Mensch();
        mensch1.name = "Karl Kapitän";
        System.out.println(mensch1);

        Mensch mensch2 = new Mensch();
        mensch2.name = "Clemens Crew";

        // Wir erzeugen ein Container-Schiff
        ContainerSchiff containerSchiff = new ContainerSchiff();
        containerSchiff.kapitaen = mensch1;
        containerSchiff.crew.add(mensch2);
        containerSchiff.maxAnzahlContainer = 2500;
        containerSchiff.maxLadegewicht = 1500.5;

        // gibt den spezifischen Text aus der überschriebenen Methode in ContainerSchiff.java zurück
        containerSchiff.auslaufen();
        // containerSchiff.containerSchiffLaeuftAus();

        PassagierSchiff passagierSchiff = new PassagierSchiff();
        passagierSchiff.kapitaen = mensch2;
        passagierSchiff.crew.add(mensch1);
        passagierSchiff.maxAnzahlPersonen = 1250;

        // gibt den spezifischen Text aus der überschriebenen Methode in PassagierSchiff.java zurück
        passagierSchiff.auslaufen();

        // Da Transportmittel und Schiff abstratc sind, können wir aus ihnen keine Objekte erzeugen
        // Transportmittel irgendeinTransportmittel = new Transportmittel();
        // Schiff schiff = new Schiff();

        // Objekte konkreteren Typs können in Variablen eines allgemeineren Typs gespeichert werden...
        Schiff passagierSchiff2 = new PassagierSchiff();
        // ... allerdings besitzen sie dann nur noch die Attribute und Methoden der allgemeineren Klasse...
        passagierSchiff2.kapitaen = mensch1;
        // ... bis man sie wieder zu dem konkreten Typ umwandelt:
        PassagierSchiff umgewandeltesSchiff = (PassagierSchiff) passagierSchiff2;
        umgewandeltesSchiff.maxAnzahlPersonen = 100;

        // Das ist nützlich, wenn wir bspw. alle Transportmittel (unabhängig des Typs) in einer Liste speichern wollen.
        List<Transportmittel> alleSchiffe = new ArrayList<>();
        alleSchiffe.add(passagierSchiff);
        alleSchiffe.add(containerSchiff);
        alleSchiffe.add(new Elektroauto());
    }
}
