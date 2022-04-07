import java.util.ArrayList;
import java.util.List;

public abstract class Schiff extends Transportmittel implements Treibhausgasemittent {
    Mensch kapitaen;
    List<Mensch> crew = new ArrayList<>();

    void auslaufen() {
        System.out.println("Das Schiff mit dem Kapitän " + kapitaen.name + " verlässt den Hafen.");
    }

    public double ausgestoßeneTreibhausgase() {
        return 0.0;
    }
}
