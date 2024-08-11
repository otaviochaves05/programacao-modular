import java.util.Scanner;

public class Imposto {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double valor, valorImposto;
        valor = lerNumero(scanner);
        valorImposto = calculaImposto(valor);
        mostraImposto(valorImposto);
        scanner.close();
    }

    public static double lerNumero(Scanner scanner){
        System.out.print("Digite o valor: ");
        return Float.valueOf(scanner.nextLine());
    }

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

    public static void mostraImposto(double valorImposto){
        System.out.printf("O imposto a pagar é: R$ %.2f",valorImposto);
    }

}
