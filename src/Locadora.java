package src;
import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo v) { veiculos.add(v); }
    public void cadastrarAluguel(Aluguel a) { alugueis.add(a); }

    public boolean associarVeiculoAoAluguel(int idxAluguel, int idxVeiculo) {
        if (!aluguelValido(idxAluguel) || !veiculoValido(idxVeiculo)) return false;
        Veiculo v = veiculos.get(idxVeiculo);
        if (v.getStatus() != StatusVeiculo.DISPONIVEL) return false;
        if (alugueis.get(idxAluguel).associarVeiculo(v)) {
            v.setStatus(StatusVeiculo.ALUGADO);
            return true;
        }
        return false;
    }

    public void exibirVeiculos(boolean apenasDisponiveis) {
        boolean achou = false;
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            if (!apenasDisponiveis || v.getStatus() == StatusVeiculo.DISPONIVEL) {
                System.out.println(i + " - " + v);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum veículo encontrado.");
    }

    public void exibirAlugueis() {
        if (alugueis.isEmpty()) System.out.println("Nenhum aluguel cadastrado.");
        for (int i = 0; i < alugueis.size(); i++) {
            System.out.println(i + " - " + alugueis.get(i));
        }
    }

    public void avaliarVeiculo(int idx, int nota) {
        if (!veiculoValido(idx)) { System.out.println("Veículo inválido."); return; }
        Veiculo v = veiculos.get(idx);
        if (v instanceof Avaliavel) {
            ((Avaliavel) v).avaliar(nota);
        } else {
            System.out.println("Este veículo não pode ser avaliado.");
        }
    }

    public void avaliarAluguel(int idx, int nota) {
        if (!aluguelValido(idx)) { System.out.println("Aluguel inválido."); return; }
        Aluguel a = alugueis.get(idx);
        if (a instanceof Avaliavel) {
            ((Avaliavel) a).avaliar(nota);
        } else {
            System.out.println("Este tipo de aluguel não pode ser avaliado.");
        }
    }

    public void realizarInspecao(int idx) {
        if (!veiculoValido(idx)) { System.out.println("Veículo inválido."); return; }
        Veiculo v = veiculos.get(idx);
        if (v instanceof Inspecionavel) {
            ((Inspecionavel) v).realizarInspecao();
        } else {
            System.out.println("Este veículo não precisa de inspeção.");
        }
    }

    public void removerVeiculosEmManutencao() {
        List<Veiculo> emManutencao = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) emManutencao.add(v);
        }
        for (Aluguel a : alugueis) {
            for (Veiculo v : emManutencao) a.removerVeiculo(v);
        }
        veiculos.removeAll(emManutencao);
        System.out.println(emManutencao.size() + " veículo(s) em manutenção removido(s).");
    }

    private boolean veiculoValido(int i) { return i >= 0 && i < veiculos.size(); }
    private boolean aluguelValido(int i) { return i >= 0 && i < alugueis.size(); }
}