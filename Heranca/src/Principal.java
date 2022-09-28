public class Principal {

    public static void main(String[] args) {

        Veiculo calhambeque = new Veiculo("Calhambeque");
        Bicicleta minhaBike = new Bicicleta("Pinarello", false);

        System.out.println(minhaBike.toString());

        Garagem garagem = new Garagem();

        System.out.println(minhaBike.getNumeroDeRodas());

        garagem.estacionarVeiculo(minhaBike);

        System.out.println(minhaBike.getNumeroDeRodas());


    }
}
