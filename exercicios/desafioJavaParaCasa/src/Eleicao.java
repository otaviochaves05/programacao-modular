import java.util.Scanner;

public class Eleicao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] votosRegistrados = recebeDados(scanner);
        int vencedor = calculaVencedor(votosRegistrados[0], votosRegistrados[1], votosRegistrados[2]);
        // imprimeResultado(vencedor, votosRegistrados[0], votosRegistrados[1],
        // votosRegistrados[2], votosRegistrados[3], votosRegistrados[4],
        // votosRegistrados[5]);
        // imprimeResultado(vencedor, votosRegistrados[3], votosRegistrados[4], votosRegistrados[5]);
        System.out.printf("Vencedor: %d \nVotos nulos: %d \nVotos brancos: %d \nTotal de eleitores: %d", vencedor, votosRegistrados[4], votosRegistrados[3], votosRegistrados[5]);
        scanner.close();
    }

    public static int lerVoto(Scanner scanner) {
        System.out.print("Digite o número do candidato ou 9 para sair: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] recebeDados(Scanner scanner) {
        int c1 = 0, c2 = 0, c3 = 0, branco = 0, nulo = 0, total = 0;
        int voto;
        do {
            voto = lerVoto(scanner);
            switch (voto) {
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    nulo++;
                    break;
                case 0:
                    branco++;
                    break;
                case 9:
                    continue;
            }
            total++;
        } while (voto != 9);
        return new int[] { c1, c2, c3, branco, nulo, total };
    }

    public static int calculaVencedor(int c1, int c2, int c3) {
        int resultado = 0;
        if (c1 == c2 || c1 == c3 || c2 == c3) {
            return resultado;
        } else if (c1 > c2 && c1 > c3) {
            resultado = 1;
        } else if (c2 > c1 && c2 > c3) {
            resultado = 2;
        } else if (c3 > c1 && c3 > c2) {
            resultado = 3;
        }
        return resultado;
    }

    // public static void imprimeResultado(int vencedor, int branco, int nulo, int total) {

    //     int[] resultados = { vencedor, branco, nulo, total };
    //     for (int i = 0; i < resultados.length; i++) {
    //         System.out.println(resultados[i]);
    //     }

    //     // o programa, que deve fornecer o número do vencedor da eleição (suponha que não
    //     // pode haver empates), as quantidades de votos brancos e nulos e o número de
    //     // eleitores que
    //     // compareceram às urnas.

    // }

}
