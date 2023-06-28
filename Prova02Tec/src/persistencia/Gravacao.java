package persistencia;

import java.io.FileWriter;

	public class Gravacao {
		
		private FileWriter escritor;
		private String diretorio;
		
		public Gravacao() {
			diretorio = "src\\arquivo\\Text.txt";
		}
		
		public boolean gravarConcatString(String str) {
			String strTemp = "";
			try {
				Leitura ler = new Leitura();
				strTemp = ler.lerConcatString()+(str+"\n");
				escritor = new FileWriter(diretorio);	
				escritor.write(strTemp);
				escritor.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
	}
