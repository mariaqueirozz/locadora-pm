package src;

public class Carro extends Veiculo implements Avaliavel {
    private int quantidadePortas;
    private int somaNotas;
    private int qtdAvaliacoes;

    public Carro(String placa, String modelo, int ano, double valorDiaria,
                 double quilometragem, int quantidadePortas) {
        super(placa, modelo, ano, valorDiaria, quilometragem);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota inválida (use de 1 a 5).");
            return;
        }
        somaNotas += nota;
        qtdAvaliacoes++;
        System.out.println("Carro " + getModelo() + " avaliado com nota " + nota + ".");
    }

    public double getMedia() { return qtdAvaliacoes == 0 ? 0 : (double) somaNotas / qtdAvaliacoes; }

    @Override
    public String toString() {
        return "[Carro] " + super.toString() + " | portas: " + quantidadePortas
                + " | média: " + String.format("%.1f", getMedia());
    }
}