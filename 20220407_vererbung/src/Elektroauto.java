public class Elektroauto extends Transportmittel implements Stromverbraucher { // emittiert (lokal) keine Treibhausgase
    @Override
    public double verbrauchterStrom() {
        return 0;
    }
}
