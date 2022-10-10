public class Principal {

    public static void main(String[] args) {

        Carro calhambeque = new Carro();
        Bicicleta minhaBike = new Bicicleta("Pinarello", false);

        calhambeque.abastecer();


//        System.out.println(minhaBike.toString());
//
        Garagem garagem = new Garagem();
//
//        System.out.println(minhaBike.getNumeroDeRodas());
//
        garagem.estacionarVeiculo(calhambeque);
        garagem.estacionarVeiculo(minhaBike);
//
//        System.out.println(minhaBike.getNumeroDeRodas());

    }
}
