import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Arquivo {

    public static void main(String[] args) {
        String nomeArquivo = "arquivo.txt";
        int[] valores;
        valores = lerArquivo(nomeArquivo);


    }

    public static int[] lerArquivo(String nomeArquivo) throws FileNotFoundException{
        Scanner arquivo = new Scanner(new File(nomeArquivo));
        int[] valores;
        String[] detalhes = arquivo.nextLine().split(";");

        valores = new int[detalhes.length];

        for(int i = 0; i < detalhes.length; i++){
            valores[i] = Integer.parseInt(detalhes[i]);
        }
        arquivo.close();
        return valores;
    }
    //throw FileNotFoundException


    // public static void main(String[] args) throws Exception {
    //     // Scanner entrada = new Scanner(System.in);
    //     // int[] numeros = lerArquivo(entrada, arquivo);
    //     // System.out.printf("Existem %f valores acima da media.", calculaValores(numeros));
    //     // entrada.close();



    // }


}
