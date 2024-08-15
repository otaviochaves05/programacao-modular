import java.util.Scanner;

public class Imposto {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double valor, valorImposto;
        valor = lerNumero(scanner);
        valorImposto = calculaImposto(valor);
        System.out.printf("O imposto a pagar é: R$ %.2f",valorImposto);
        scanner.close();
    }

    /**
     * Solicita ao usuário que insira um valor numérico e o retorna como um valor double.
     * @param scanner objeto utilizado para ler a entrada de dados.
     * @return retorna a proxima linha lida com o valor fornecido pelo usuário no tipo double.
     */
    public static double lerNumero(Scanner scanner){
        System.out.print("Digite o valor: ");
        return Double.parseDouble(scanner.nextLine());
    }

    /**
     * Calcula o valor do imposto a ser pago com base em faixas de valores predefinidas.
     * @param valor valor fornecido pelo usuário.
     * @return retorna o valor do imposto a ser pago calculado de acordo com as faixas numéricas predefinidas.
     */
    public static double calculaImposto(double valor){
        final double valores[] = {1200.00 , 2500.00 , 5000.00};
        final double desconto[] = {0.1 , 0.15 , 0.2};
        
        if(valor <= valores[0]){
            return 0; 
        } else if(valor > valores[0] && valor <= valores[1]){
            return valor * desconto[0];
        } else if (valor > valores[1] && valor <= valores[2]){
            return valor * desconto [1];
        } else{
            return valor * desconto[2];
        }
    }
}
