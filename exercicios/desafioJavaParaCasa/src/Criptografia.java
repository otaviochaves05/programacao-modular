import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Criptografia {
    public static void main(String[] args) throws Exception{
        final String NOME_ARQUIVO = "mensagem.txt";
        char[] respostaArquivo;
    
            respostaArquivo = lerArquivo(NOME_ARQUIVO);

        int[] respostaASCII = converteParaASCII(respostaArquivo);
        int[] ASCIIAdicionado = adicionaASCII(respostaASCII);
        char[] criptografiaFinal = converteParaChar(ASCIIAdicionado);
        
        final String ARQUIVO_CRIPTOGRAFADO = "criptografado.txt";

        String mensagemFinal = new String(criptografiaFinal); 
        File novoArquivo = new File(ARQUIVO_CRIPTOGRAFADO);
        
            FileWriter writer = new FileWriter(novoArquivo);
            writer.write(mensagemFinal);
            writer.close();
        
    }  


    public static char[] lerArquivo(String NOME_ARQUIVO) throws FileNotFoundException { 
        Scanner arquivo = new Scanner(new File(NOME_ARQUIVO));
        String linha = arquivo.nextLine();
        char[] caracteres = linha.toCharArray();
        arquivo.close();
        return caracteres;
    }

    public static int[] converteParaASCII(char[] respostaArquivo){
        int[] codigoASCII = new int[respostaArquivo.length];
        for (int i = 0; i < respostaArquivo.length; i++) {
            codigoASCII[i] = (int)respostaArquivo[i];
        }
        return codigoASCII;
    }

    public static int[] adicionaASCII(int[] respostaASCII) {
        int[] novoASCII = new int[respostaASCII.length];
        for (int i = 0; i < novoASCII.length; i++) {
            novoASCII[i] = respostaASCII[i] + 1;
        }
        return novoASCII;
    }

    public static char[] converteParaChar(int[] ASCIIAdicionado) {
        char[] MensagemCriptografada = new char[ASCIIAdicionado.length];
        for (int i = 0; i < MensagemCriptografada.length; i++) {
            MensagemCriptografada[i] = (char)ASCIIAdicionado[i];
        }
        return MensagemCriptografada;
    }
}
