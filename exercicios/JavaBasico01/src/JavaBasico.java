import java.util.Arrays;
import java.util.Scanner;

public class JavaBasico {
    public static void main(String[] args) throws Exception {
        int exercicio;
        System.out.println("EXERCICIO INVERTE VETOR: 1");
        System.out.println("EXERCICIO MULTIPLICA POR 11: 2");
        System.out.println("EXERCICIO PREVE DIA DA SEMANA: 3");
        Scanner scanner = new Scanner(System.in);
        exercicio = Integer.parseInt(scanner.nextLine());
        switch (exercicio) {
            case 1: inverteVetor();
            case 2: multiplicaPor11();
            case 3: diasDaSemana();
            default: break;
        }
        scanner.close();
    }


    /*EXERCICIO DIAS DA SEMANA */


    public static void diasDaSemana(){
        String[] infoInicial = lerData();
        int[] data = converteStringParaInteiro(infoInicial);
        String diaDaSemana = calculaData(data[0], data[1]);
        System.out.println(diaDaSemana);
    }

    /**
     * MÉTODO DO EXERCICIO DIAS DA SEMANA
     * Lê uma data fornecida pelo usuário no formato "dd/mm/aaaa".
     * @return retorna um array de strings onde o primeiro elemento é o dia, o segundo é o mês e o terceiro é o ano.
     */
    public static String[] lerData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a data no seguinte formato: dd/mm/aaaa. ");
        String[] data = (scanner.nextLine().split("/"));
        scanner.close();
        return data;
    }

    /**
     * MÉTODO DO EXERCICIO DIAS DA SEMANA
     * Converte um array de strings para um array de inteiros.
     * @param infoInicial array de Strings que será convertido para uma array de inteiros.
     * @return retorna um array de inteiros convertidos do array de Strings
     */
    public static int[] converteStringParaInteiro(String[] infoInicial){
        int[] dataConvertida = new int[infoInicial.length];
        for (int i = 0; i < infoInicial.length; i++) {
            dataConvertida[i] = Integer.parseInt(infoInicial[i]);
        }
        return dataConvertida;
    }

    /**
     * MÉTODO DO EXERCICIO DIAS DA SEMANA
    * Calcula o dia da semana para uma data em 2024;.
     * @param diaInfo dia do mês que foi fornecido pelo usuário.
     * @param mes o mês que foi fornecido pelo usuário.
     * @return
     */
    public static String calculaData(int diaInfo, int mes) {
        int[] diasMeses2024 = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        int dia = diaInfo - 1;
        for (int i = 0; i < mes; i++) {
            dia += diasMeses2024[i];
        }
        int resultadoDiaSemana = dia % 7;
        return diasSemana[resultadoDiaSemana];
    }   


    /*EXERCICIO MULTIPLICAÇÃO POR 11 */


    public static void multiplicaPor11(){
        int numero = lerNumero();
        int[] numeroTratado = trataNumero(numero);
        int[] resultado = calculaResultado(numeroTratado);
        System.out.printf("%d%d%d",resultado[0], resultado[1], resultado[2]);
    }

    /**
     * METODO DO EXERCICIO MULTIPLICAÇÃO POR 11
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
     * METODO DO EXERCICIO MULTIPLICAÇÃO POR 11
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
     * METODO DO EXERCICIO MULTIPLICAÇÃO POR 11
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


    /*EXERCICIO INVERTE VETOR */


    public static void inverteVetor(){
        int tamanhoVetor = 6;
        int[] vetorLido = lerVetor(tamanhoVetor);
        int[] vetorInvertido = inverteVetor(vetorLido);
        System.out.println(Arrays.toString(vetorInvertido));
    }

    /**
     * METODO DO EXERCICIO INVERTE VETOR
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
     * METODO DO EXERCICIO INVERTE VETOR
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
