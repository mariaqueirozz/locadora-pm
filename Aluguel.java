import java.util.ArrayList;
import java.util.List;

public abstract class Aluguel {
    private String cliente;
    private int dias;
    private List<Veiculo> veiculos = new ArrayList<>();

    public Aluguel(String cliente, int dias) {
        this.cliente = cliente;
        this.dias = dias;
    }

    // -1 significa quilometragem ilimitada
    public abstract int getLimiteKmPorDia();
    public abstract boolean temSeguro();

    public boolean associarVeiculo(Veiculo v) {
        if (veiculos.contains(v)) return false;
        veiculos.add(v);
        return true;
    }

    public void removerVeiculo(Veiculo v) { veiculos.remove(v); }

    public String getCliente() { return cliente; }
    public int getDias() { return dias; }
    public List<Veiculo> getVeiculos() { return veiculos; }

    @Override
    public String toString() {
        String km = getLimiteKmPorDia() < 0 ? "ilimitada" : getLimiteKmPorDia() + " km/dia";
        String s = cliente + " | " + dias + " dia(s) | km: " + km
                + " | seguro: " + (temSeguro() ? "sim" : "não");
        for (Veiculo v : veiculos) {
            s += "\n      - " + v.getModelo() + " (" + v.getPlaca() + ")";
        }
        return s;
    }
}