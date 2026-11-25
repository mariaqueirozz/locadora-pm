package src;

public class Moto extends Veiculo implements Inspecionavel {
    private int cilindrada;
    private int inspecoes;

    public Moto(String placa, String modelo, int ano, double valorDiaria,
                double quilometragem, int cilindrada) {
        super(placa, modelo, ano, valorDiaria, quilometragem);
        this.cilindrada = cilindrada;
    }

    @Override
    public void realizarInspecao() {
        inspecoes++;
        System.out.println("Inspeção realizada na moto " + getModelo() + " (total: " + inspecoes + ").");
    }

    @Override
    public String toString() {
        return "[Moto] " + super.toString() + " | " + cilindrada + " cc | inspeções: " + inspecoes;
    }
}