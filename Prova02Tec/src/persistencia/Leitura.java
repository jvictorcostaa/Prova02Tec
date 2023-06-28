package persistencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

	public class Leitura {
		
		private BufferedReader leitor;
		private String diretorio;
		
		public Leitura() {
			diretorio = "src\\arquivo\\Text.txt";
			
		}
		
		public String[] lerLinhas() {
			ArrayList<String> arrayStringTemp = new ArrayList<String>();
			
			try {
				leitor = new BufferedReader(new FileReader(diretorio));
				while (leitor.ready()) {
					arrayStringTemp.add(leitor.readLine());
				}
				leitor.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String arrayString[] = new String[arrayStringTemp.size()];
			int cont =0;
			for (String str : arrayStringTemp) {
				arrayString[cont] = str;
				cont++;
			}
			
			return arrayString;
		}

		
		 protected String lerConcatString() {
			String str = "";
			try {
				leitor = new BufferedReader(new FileReader(diretorio));
				while (leitor.ready()) {
					str += (leitor.readLine()+"\n");
				}
				leitor.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return str;
		}
		
		// String[] strTemp = leitor.readLine().split(";");
		
			
		
	}
