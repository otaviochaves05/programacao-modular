import java.util.Scanner;

public class Eleicao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] votosRegistrados = recebeDados(scanner);
        int vencedor = calculaVencedor(votosRegistrados[0], votosRegistrados[1], votosRegistrados[2]);
        System.out.printf("Vencedor: %d \nVotos nulos: %d \nVotos brancos: %d \nTotal de eleitores: %d", vencedor, votosRegistrados[4], votosRegistrados[3], votosRegistrados[5]);
        scanner.close();
    }

    /**
     * Solicita ao usuário que insira o número de um candidato ou a opção para sair, e retorna o valor inserido.
     * @param scanner objeto utilizado para ler a entrada de dados.
     * @return retorna o valor fornecido pelo usuário convertido para o tipo Integer.
     */
    public static int lerVoto(Scanner scanner) {
        System.out.print("Digite o número do candidato ou 9 para sair: ");
        return Integer.parseInt(scanner.nextLine());
    }

   /**
    * Coleta e conta os votos para diferentes candidatos, votos nulos e brancos, até que o usuário decida sair.
    * @param scanner objeto utilizado para ler a entrada de dados.
    * @return retorna um vetor de inteiros com a quantidade de votos de cada opção e o total de votos.
    */
    public static int[] recebeDados(Scanner scanner) {
        int c1 = 0, c2 = 0, c3 = 0, branco = 0, nulo = 0, total = 0;
        int voto;
        do {
            voto = lerVoto(scanner);
            switch (voto) {
                case 1: c1++;                 
                case 2: c2++;                
                case 3: c3++;                   
                case 4: nulo++;                  
                case 0: branco++;           
                case 9: continue;
                default: nulo++;
            }
            total++;
        } while (voto != 9);
        return new int[] { c1, c2, c3, branco, nulo, total };
    }

    /**
     * Determina o vencedor de uma eleição com base na contagem de votos para três candidatos.
     * @param c1 número de votos recebidos pelo candidato 1
     * @param c2 número de votos recebidos pelo candidato 2
     * @param c3 número de votos recebidos pelo candidato 3
     * @return retorna um valor inteiro representando o vencedor da eleição
     */
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
}
