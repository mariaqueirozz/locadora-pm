public class AluguelExecutivo extends Aluguel implements Avaliavel {
    private int somaNotas;
    private int qtdAvaliacoes;

    public AluguelExecutivo(String cliente, int dias) { super(cliente, dias); }

    @Override
    public int getLimiteKmPorDia() { return -1; }

    @Override
    public boolean temSeguro() { return false; }

    public boolean temMotoristaParticular() { return true; }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) {
            System.out.println("Nota inválida (use de 1 a 5).");
            return;
        }
        somaNotas += nota;
        qtdAvaliacoes++;
        System.out.println("Aluguel executivo de " + getCliente() + " avaliado com nota " + nota + ".");
    }

    public double getMedia() { return qtdAvaliacoes == 0 ? 0 : (double) somaNotas / qtdAvaliacoes; }

    @Override
    public String toString() {
        return "[Executivo] " + super.toString() + " | motorista particular | média: "
                + String.format("%.1f", getMedia());
    }
}