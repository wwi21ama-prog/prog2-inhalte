public class PluginHybridAuto extends Transportmittel implements Treibhausgasemittent, Stromverbraucher {
    @Override
    public double verbrauchterStrom() {
        return 0;
    }

    @Override
    public double ausgestoßeneTreibhausgase() {
        return 0;
    }
}
