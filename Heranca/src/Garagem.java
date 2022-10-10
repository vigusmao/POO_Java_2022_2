import java.util.ArrayList;

public class Garagem {

    ArrayList<Veiculo> veiculosEstacionados;

    public Garagem() {
        veiculosEstacionados = new ArrayList<>();
    }

    public void estacionarVeiculo(Veiculo veiculo) {
        veiculo.andar(15);
//        veiculo.desligar();
        veiculosEstacionados.add(veiculo);

    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Garagem com ")
          .append(veiculosEstacionados.size())
          .append(" veículos: \n");

//        for (int i = 0; i < veiculosEstacionados.size(); i++) {
//            Veiculo v = veiculosEstacionados.get(i);
//            sb.append(v.toString()).append("\n");
//        }

        for (Veiculo v : veiculosEstacionados) {
            sb.append(v.toString()).append("\n");
        }

        return sb.toString();
    }
}
