package src;
public abstract class Veiculo {
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double valorDiaria;
    private double quilometragem;
    private StatusVeiculo status;

    public Veiculo(String placa, String modelo, int anoFabricacao,
                   double valorDiaria, double quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
        this.quilometragem = quilometragem;
        this.status = StatusVeiculo.DISPONIVEL;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getAnoFabricacao() { return anoFabricacao; }
    public double getValorDiaria() { return valorDiaria; }
    public double getQuilometragem() { return quilometragem; }
    public StatusVeiculo getStatus() { return status; }
    public void setStatus(StatusVeiculo status) { this.status = status; }

    @Override
    public String toString() {
        return placa + " | " + modelo + " | " + anoFabricacao + " | R$ "
                + String.format("%.2f", valorDiaria) + "/dia | " + quilometragem + " km | " + status;
    }
}