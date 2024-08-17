import java.util.Scanner;

public class MultiplicaPor11 {
    public static void main(String[] args) throws Exception{
        int numero = lerNumero();
        int[] numeroTratado = trataNumero(numero);
        int[] resultado = calculaResultado(numeroTratado);
        System.out.printf("%d%d%d",resultado[0], resultado[1], resultado[2]);
    }
    
    /**
     * Lê um número inteiro fornecido pelo usuário.
     * @return o número inteiro lido.
     */
    public static int lerNumero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número a ser multiplicado por 11: ");
        int entrada = Integer.parseInt(scanner.nextLine());
        scanner.close();
        return entrada;
    }

    /**
     * Decompõe um número de dois dígitos em dezena e unidade, calcula a soma deles e armazena na variavel "meio".
     * @param numero o numero inteiro lido no método "lerNumero"
     * @return retorna um array de inteiros contendo a dezena, a soma da dezena com a unidade (meio), e a unidade.
     */
    public static int[] trataNumero(int numero) {
        int unidade, dezena, meio;
        unidade = numero % 10;
        dezena = numero / 10;
        meio = unidade + dezena;
        return new int[] {dezena, meio, unidade};
    }
 
    /**
     * Calcula o resultado do número multiplicado por 11 com as regras especificadas. 
     * @param numeroTratado um array de inteiros contendo a dezena, a soma da dezena com a unidade (meio), e a unidade.
     * @return retoena um array com os números conforme as regras descritas, para formar o resultado da multiplicação.
     */
    public static int[] calculaResultado(int[] numeroTratado) {
        if (numeroTratado[1] > 9) {
            numeroTratado[1] = 1;
            numeroTratado[0]++;
            return numeroTratado;
        } else {
            return numeroTratado;
        }
    }
}
