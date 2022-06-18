package emotionalsongs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class RegistraPlaylist {

	public static void main(String[] args) throws IOException {
		//list con canzoni aggiunte
		LinkedList<String> playlist = new LinkedList<String>();
		//list con risultati della ricerca
		LinkedList<String> canzoni = new LinkedList<String>();
		
		//Creazione File playlist
		File f_playlist = new File("Playlist.dati.txt");
		String path = f_playlist.getAbsolutePath();
		
		//Creazione oggetto scanner
		Scanner scanner = new Scanner(System.in);
		//Creazione oggetto FileWriter
		FileWriter fw = new FileWriter(path, true);

		System.out.println("Inserire le canzoni da registrare nella playlist");
		System.out.println("Per concludere, lasciare vuoto e premere invio");

		int scelta = 0; //metodo di ricerca canzoni

		String nome = ""; //variabile con il nome usato come criterio di ricerca
		String autore = ""; //variabile con l'autore usato come criterio di ricerca 
		int anno = 0; //variabile con l'anno usato come criterio di ricerca

		boolean continuare = true;

		System.out.println("1- Ricerca per nome");
		System.out.println("2- Ricerca per autore e anno");
		scelta = scanner.nextInt();
		scanner.nextLine(); // reset dello scanner
		
		while (continuare) {
			if (scelta == 1) {
				System.out.println("Inserisci il nome della canzone: ");
				nome = scanner.nextLine();
				Ricerca.RiceraNome(nome);
				canzoni = Ricerca.Stringhe;
				if(canzoni.isEmpty()) {
					System.out.println("Nessun Risultato trovato.");
					break;
				}
				for (int i = 0; i < canzoni.size(); i++) {
					System.out.print(i + "- ");
					System.out.print(canzoni.get(i).replace("<SEP>", " - ") + "\n");
				}
				System.out.println("Selezionare la canzone che si vuole aggiungere alla playlist: ");
				int n_canzone = scanner.nextInt();
				playlist.add(canzoni.get(n_canzone).replace("<SEP>", " - "));
				System.out.println("Vuoi aggiungere un'altra canzone? (s/n): ");
				scanner.nextLine(); //reset dello scanner
				String si_no = scanner.nextLine();
				if (si_no.equals("s"))
					continuare = true;
				else
					continuare = false;
			}
			if (scelta == 2) {
				System.out.println("Inserisci l'autore della canzone : ");
				autore = scanner.nextLine();
				System.out.println("Inserisci l'anno della canzone : ");
				anno = scanner.nextInt();
				Ricerca.RiceraAnno_Autore(autore, anno);
				scanner.nextLine(); //reset scanner
				canzoni = Ricerca.StringheAA;
				if(canzoni.isEmpty()) {
					System.out.println("Nessun Risultato trovato.");
					break;
				}
				for (int i = 0; i < canzoni.size(); i++) {
					System.out.print(i + "- ");
					System.out.print(canzoni.get(i).replace("<SEP>", " - ") + "\n");
				}
				System.out.println("Selezionare la canzone che si vuole aggiungere alla playlist: ");
				int n_canzone = scanner.nextInt();
				playlist.add(canzoni.get(n_canzone).replace("<SEP>", " - "));
				System.out.println("Vuoi aggiungere un'altra canzone? (s/n): ");
				scanner.nextLine(); //reset dello scanner
				String si_no = scanner.nextLine();
				if (si_no.equals("s"))
					continuare = true;
				else
					continuare = false;
				
			}
		}
		System.out.println("Dai un nome alla tua playlist: ");
		String nome_playlist = scanner.nextLine();
		fw.write("\n" + nome_playlist + ": ");
		for(int i = 0; i < playlist.size(); i++) {
			fw.write("\n" + playlist.get(i) + "\n");
		}
		fw.close();
		scanner.close();
	}

}
