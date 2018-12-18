import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class criaProcesso {

	public static void main(String[] args) throws IOException {
		//verifica se a entrada possui argumentos suficientes
		if(args.length != 1) {
			System.err.println("Usage: java OSProcess <command>");
			System.exit(0);
		}
		
		// process builder é a biblioteca utilizada para o gerenciamento do processo 
		ProcessBuilder pb = new ProcessBuilder(args[0]);
		//start é o metodo responsável pela criação do processo
		Process proc = pb.start(); 
		
		//  le o input por bytes
		InputStream is = proc.getInputStream();
		// le so bytes e decodifica em caracter
		InputStreamReader isr = new InputStreamReader(is);
		// le e armazena a entrada de caracteres
		BufferedReader br = new BufferedReader(isr);
		
		// retorna o valor que foi lido
		String line;
		while( (line = br.readLine()) != null)
			System.out.println(line);
		
		br.close();
	}

}
