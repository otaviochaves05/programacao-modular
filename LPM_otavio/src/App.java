import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner teclado = new Scanner(System.in);
        int numero;
        int unidade;
        int dezena;
        int meio;

        numero = lerNumero(teclado);

        unidade = numero % 10;
        dezena = numero / 10;
        meio = unidade + dezena;

        teclado.close();

    }

    public static int lerNumero(Scanner teclado){
        System.out.println("Digite um numero: ");
        return Integer.parseInt(teclado.nextLine());
    }
}
