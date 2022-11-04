import java.util.Objects;

public abstract class Instrumento {
    private final String marca;
    private final String modelo;
    private int volume = 10;  // volume default
    private final AePlayWave player = new AePlayWave();  // tocador de .wav

    public Instrumento(String marca, String modelo) {
        this.marca = marca;  this.modelo = modelo;
    }

    protected AePlayWave getAudioPlayer() { return player; }

    public abstract int getVolumeMaximo();

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volumeDesejado) {
        if (volumeDesejado >= 0 && volumeDesejado <= getVolumeMaximo()) {
            this.volume = volumeDesejado;
        }
    }

    public void testar() {
        System.out.println("Vou testar com volume " + volume);
        player.start("som_padrao.wav"); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrumento that = (Instrumento) o;
        return volume == that.volume &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(modelo, that.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, volume);
    }
}
