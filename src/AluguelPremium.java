package src;
public class AluguelPremium extends Aluguel {
    public AluguelPremium(String cliente, int dias) { super(cliente, dias); }

    @Override
    public int getLimiteKmPorDia() { return -1; }

    @Override
    public boolean temSeguro() { return true; }

    @Override
    public String toString() { return "[Premium] " + super.toString(); }
}