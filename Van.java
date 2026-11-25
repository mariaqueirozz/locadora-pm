public class Van extends Veiculo implements Avaliavel, Inspecionavel {
    private int maxPassageiros;
    private int somaNotas;
    private int qtdAvaliacoes;
    private int inspecoes;

    public Van(String placa, String modelo, int ano, double valorDiaria,
               double quilometragem, int maxPassageiros) {
        super(placa, modelo, ano, valorDiaria, quilometragem);
        this.maxPassageiros = maxPassageiros;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota inválida (use de 1 a 5).");
            return;
        }
        somaNotas += nota;
        qtdAvaliacoes++;
        System.out.println("Van " + getModelo() + " avaliada com nota " + nota + ".");
    }

    @Override
    public void realizarInspecao() {
        inspecoes++;
        System.out.println("Inspeção realizada na van " + getModelo() + " (total: " + inspecoes + ").");
    }

    public double getMedia() { return qtdAvaliacoes == 0 ? 0 : (double) somaNotas / qtdAvaliacoes; }

    @Override
    public String toString() {
        return "[Van] " + super.toString() + " | passageiros: " + maxPassageiros
                + " | média: " + String.format("%.1f", getMedia()) + " | inspeções: " + inspecoes;
    }
}