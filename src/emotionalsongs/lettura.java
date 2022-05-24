package emotionalsongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class lettura {
	
	//variabili da utilizzare in più di un metodo
	private static int n_righe;
	private static String[] lines;

	//Metodo lettura canzoni da file
	public static String[] leggi() throws IOException{
		
		//acquisizione path file
		File fileCanzoni = new File("Canzoni.dati.txt");
		String path = fileCanzoni.getAbsolutePath();
		
		//creazione file e reader
		File c_d = new File(path);
		FileReader fr = new FileReader(c_d);
		BufferedReader br = new BufferedReader(fr);
		
		//lettura numero di righe
		n_righe = 0;
		while (!(br.readLine().equals("_"))) n_righe++;
		
		//creazione array e scanner
		lines = new String[n_righe];
		Scanner scan = new Scanner(c_d);
		
		//isnerimento ogni riga del file nell'array
		for (int i = 0; i < lines.length; i++) {
			lines[i] = scan.nextLine();
		}
		
		scan.close();
		br.close();
		
		//return del metodo (array di stringhe)
		return lines;

	}
	
	//Metodo ricerca con parola chiave
	public static String ricerca(String parola_chiave){
		int cont = 0;
		for(int i = 0; i<n_righe; i++) {
			if(lines[i].contains(parola_chiave)) {
				System.out.println(lines[i]);
				cont++;
			}
		}
		return "Ricerca completata con " + cont + " risultati.";
	}
}

