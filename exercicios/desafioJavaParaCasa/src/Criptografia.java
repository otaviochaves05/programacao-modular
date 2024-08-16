import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/*Não consegui gerar o arquivo através do programa, mas se caso forem criados os arquivos manualmente na pasta raiz do projeto, o programa funcionará corretamente*/
public class Criptografia {
    public static void main(String[] args) throws Exception{
        final String NOME_ARQUIVO = "mensagem.txt";
        final String ARQUIVO_CRIPTOGRAFADO = "criptografado.txt";
        char[] respostaArquivo = lerArquivo(NOME_ARQUIVO);
        int[] respostaASCII = converteParaASCII(respostaArquivo);
        int[] ASCIIAdicionado = adicionaASCII(respostaASCII);
        char[] criptografiaFinal = converteParaChar(ASCIIAdicionado);
        String mensagemFinal = new String(criptografiaFinal); 
        escreveArquivo(ARQUIVO_CRIPTOGRAFADO, mensagemFinal);
    }  

    /**
     * Lê a primeira linha de um arquivo e a converte em um array de caracteres.
     * @param NOME_ARQUIVO  o nome do arquivo a ser lido.
     * @return retorna um array de caracteres contendo os caracteres da primeira linha lida do arquivo.
     * @throws Exception se ocorrer um erro ao abrir, ler ou fechar o arquivo, como se o arquivo não existir.
     */
    public static char[] lerArquivo(String NOME_ARQUIVO) throws Exception { 
        Scanner arquivo = new Scanner(new File(NOME_ARQUIVO));
        String linha = arquivo.nextLine();
        char[] caracteres = linha.toCharArray();
        arquivo.close();
        return caracteres;
    }

    /**
     * Converte um array de caracteres em um array de códigos ASCII correspondentes.
     * @param respostaArquivo um array de caracteres que será convertido para códigos ASCII.
     * @return retorna um array de inteiros onde cada elemento representa o código ASCII do caractere correspondente no array de entrada.
     */
    public static int[] converteParaASCII(char[] respostaArquivo){
        int[] codigoASCII = new int[respostaArquivo.length];
        for (int i = 0; i < respostaArquivo.length; i++) {
            codigoASCII[i] = (int)respostaArquivo[i];
        }
        return codigoASCII;
    }

    /**
     * Adiciona uma unidade (1) a cada valor no array de códigos ASCII.
     * @param respostaASCII um array de inteiros representando códigos ASCII que serão incrementados.
     * @return retorna um novo array de inteiros onde cada valor é o código ASCII original incrementado em 1.
     */
    public static int[] adicionaASCII(int[] respostaASCII) {
        int[] novoASCII = new int[respostaASCII.length];
        for (int i = 0; i < novoASCII.length; i++) {
            novoASCII[i] = respostaASCII[i] + 1;
        }
        return novoASCII;
    }

    /**
     * Converte um array de códigos ASCII em um array de caracteres.
     * @param ASCIIAdicionado um array de inteiros representando códigos ASCII que serão convertidos em caracteres.
     * @return retorna um array de caracteres onde cada caractere corresponde ao código ASCII convertido do array de entrada.
     */
    public static char[] converteParaChar(int[] ASCIIAdicionado) {
        char[] MensagemCriptografada = new char[ASCIIAdicionado.length];
        for (int i = 0; i < MensagemCriptografada.length; i++) {
            MensagemCriptografada[i] = (char)ASCIIAdicionado[i];
        }
        return MensagemCriptografada;
    }

    /**
     * Escreve uma mensagem em um arquivo.
     * @param ARQUIVO_CRIPTOGRAFADO o nome do arquivo onde a mensagem será escrita.
     * @param mensagemFinal  a mensagem que será escrita no arquivo.
     * @throws Exception se ocorrer um erro ao abrir, ler ou fechar o arquivo, como se o arquivo não existir.
     */
    public static void escreveArquivo(String ARQUIVO_CRIPTOGRAFADO, String mensagemFinal) throws Exception{
        File novoArquivo = new File(ARQUIVO_CRIPTOGRAFADO);
        FileWriter writer = new FileWriter(novoArquivo);
        writer.write(mensagemFinal);
        writer.close();
    }
}
