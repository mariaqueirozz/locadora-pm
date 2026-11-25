package src;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        popular(locadora);

        int op;
        do {
            System.out.println("\n===== LOCADORA =====");
            System.out.println("1 - Associar veículo a aluguel");
            System.out.println("2 - Exibir veículos");
            System.out.println("3 - Exibir aluguéis");
            System.out.println("4 - Exibir veículos disponíveis");
            System.out.println("5 - Avaliar (veículo ou aluguel)");
            System.out.println("6 - Realizar inspeção");
            System.out.println("7 - Remover veículos em manutenção");
            System.out.println("0 - Sair");
            op = lerInt("Escolha: ");

            switch (op) {
                case 1:
                    locadora.exibirAlugueis();
                    int a = lerInt("Índice do aluguel: ");
                    locadora.exibirVeiculos(true);
                    int v = lerInt("Índice do veículo: ");
                    if (locadora.associarVeiculoAoAluguel(a, v)) {
                        System.out.println("Veículo associado!");
                    } else {
                        System.out.println("Não foi possível associar (índice inválido, veículo indisponível ou já associado).");
                    }
                    break;
                case 2: locadora.exibirVeiculos(false); break;
                case 3: locadora.exibirAlugueis(); break;
                case 4: locadora.exibirVeiculos(true); break;
                case 5:
                    int tipo = lerInt("1 - Veículo | 2 - Aluguel: ");
                    if (tipo == 1) {
                        locadora.exibirVeiculos(false);
                        int iv = lerInt("Índice do veículo: ");
                        locadora.avaliarVeiculo(iv, lerInt("Nota (1 a 5): "));
                    } else if (tipo == 2) {
                        locadora.exibirAlugueis();
                        int ia = lerInt("Índice do aluguel: ");
                        locadora.avaliarAluguel(ia, lerInt("Nota (1 a 5): "));
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 6:
                    locadora.exibirVeiculos(false);
                    locadora.realizarInspecao(lerInt("Índice do veículo: "));
                    break;
                case 7: locadora.removerVeiculosEmManutencao(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (op != 0);
    }

    private static void popular(Locadora locadora) {
        Veiculo carro = new Carro("ABC-1234", "Onix", 2022, 150.0, 20000, 4);
        Veiculo moto = new Moto("DEF-5678", "CG 160", 2021, 90.0, 15000, 160);
        Veiculo van = new Van("GHI-9012", "Sprinter", 2020, 300.0, 50000, 15);
        van.setStatus(StatusVeiculo.MANUTENCAO); // para testar a opção 7

        locadora.cadastrarVeiculo(carro);
        locadora.cadastrarVeiculo(moto);
        locadora.cadastrarVeiculo(van);

        locadora.cadastrarAluguel(new AluguelBasico("Maria", 3));
        locadora.cadastrarAluguel(new AluguelExecutivo("João", 5));
    }

    private static int lerInt(String msg) {
        System.out.print(msg);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}