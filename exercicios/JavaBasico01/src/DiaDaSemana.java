import java.util.Scanner;

public class DiaDaSemana {
    public static void main(String[] args) {
        String[] infoInicial = lerData();
        int[] data = converteStringParaInteiro(infoInicial);
        String diaDaSemana = calculaData(data[0], data[1]);
        System.out.println(diaDaSemana);
    }
    
    /**
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
}

