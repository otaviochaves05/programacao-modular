import java.util.Arrays;
import java.util.Scanner;

public class InverteVetor {
    public static void main(String[] args) {
        int tamanhoVetor = 6;
        int[] vetorLido = lerVetor(tamanhoVetor);
        int[] vetorInvertido = inverteVetor(vetorLido);
        System.out.println(Arrays.toString(vetorInvertido));
    }
     /**
     * Lê um vetor de números inteiros a partir da entrada do usuário.
     * @param tamanhoVetor o tamanho do vetor a ser lido, ou seja, o número de inteiros que o usuário deve fornecer.
     * @return retorna um vetor de inteiros contendo os valores inseridos pelo usuário.
     */
    public static int[] lerVetor(int tamanhoVetor){
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor ; i++) {
            System.out.printf("Digite o numero para posicao %d: ",i);
            vetor[i] = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();
        return vetor;
    }

    /**
     * Inverte a ordem dos elementos em um vetor de inteiros.
     * @param vetorLido o vetor de inteiros a ser invertido.
     * @return retorna um novo vetor de inteiros a posição dos elementos invertida.
     */
    public static int[] inverteVetor(int[] vetorLido){
        int[] vetorInvertido = new int[vetorLido.length];
        for (int i = 0; i < vetorLido.length; i++) {
            vetorInvertido[i] = vetorLido[vetorLido.length - 1 - i];
        }
        return vetorInvertido;
    }
}
