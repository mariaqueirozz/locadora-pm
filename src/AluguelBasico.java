package src;
public class AluguelBasico extends Aluguel {
    public AluguelBasico(String cliente, int dias) { super(cliente, dias); }

    @Override
    public int getLimiteKmPorDia() { return 100; }

    @Override
    public boolean temSeguro() { return false; }

    @Override
    public String toString() { return "[Básico] " + super.toString(); }
}