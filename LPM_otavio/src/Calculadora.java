import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Calculadora {
    public static void main(String[] args) throws FileNotFoundException {
        final String NOME_ARQUIVO = "operacoes.txt";
        String[] dados; 
        dados = lerArquivo(NOME_ARQUIVO);

        for (String operacao : dados) {
            System.out.printf("%s = %f \n",operacao, calcularExpressao(operacao));
        }

        // String operacao = identificarOperacao(dados);
        // // calculaExpressao(operacao);
        // System.out.println(calculaExpressao(operacao));
    }

    public static String[] lerArquivo(String NOME_ARQUIVO) throws FileNotFoundException{
        Scanner arquivo = new Scanner(new File(NOME_ARQUIVO));
        String[] operacoes;
        int quantidadeOperacoes = Integer.parseInt(arquivo.nextLine());
        operacoes = new String[quantidadeOperacoes];
        for (int i = 0; i < quantidadeOperacoes; i++) {
            operacoes[i] = arquivo.nextLine();
        }
        arquivo.close();
        return operacoes;
    }

    /**
     * show show swh
     * @param operacao
     * @return isso ai memo
     */
    public static double calcularExpressao(String operacao) {
        String[] detalhes = operacao.split(" ");
        double primeiraParcela = Double.parseDouble(detalhes[0]);
        String sinal = detalhes[1];
        double segundaParcela = Double.parseDouble(detalhes[2]);

        return calculaValor(primeiraParcela, sinal, segundaParcela);
    }

    public static double calculaValor(double primeiraParcela, String sinal, double segundaParcela){
        double resultado;
        switch (sinal) {
            case "+": resultado = primeiraParcela + segundaParcela;
            case "-": resultado = primeiraParcela - segundaParcela;
            case "/": resultado = primeiraParcela / segundaParcela;
            case "*": resultado = primeiraParcela * segundaParcela;
            default: resultado = 0;  
        }
        return resultado;
    }
}
