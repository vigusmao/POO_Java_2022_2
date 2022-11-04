public class Guitarra extends Instrumento {

    public static final long MAX_IDADE_CORDAS = 4*30*24*60*60*1000;  // 4 meses
    private static final int MAX_VOLUME = 80;
    private long ultimaTroca;

    public Guitarra(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public int getVolumeMaximo() {
        return MAX_VOLUME;
    }

    public boolean precisaTrocarAsCordas() {
        return System.currentTimeMillis() - ultimaTroca > MAX_IDADE_CORDAS;
    }

    public void trocarAsCordas() {
        ultimaTroca = System.currentTimeMillis();
    }

    @Override
    public void testar() {
        System.out.println("Vou testar com volume " + getVolume());
        getAudioPlayer().start("som_de_guitarra.wav"); }
}
