package emotionalsongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Ricerca {
	// VARIABILI PRIVATE
	private static File canzoni = new File("canzoni.txt");
	private static String path = canzoni.getAbsolutePath();
	private static StringBuilder sb = new StringBuilder();
	private static int n_ris = 0;

	// METODO RICERCA PER NOME
	public static String RiceraNome(String chiave) throws IOException {
		// CREAZIONE OGGETTI
		BufferedReader br = new BufferedReader(new FileReader(path));
		LinkedList<String> Stringhe = new LinkedList<String>();

		// CREAZIONE VARIABILI
		int cont = 0;
		String Nome = "";

		// LETTURA RIGA DAL FILE "canzoni.txt"
		String riga = br.readLine();
		while (riga != null) {
			sb.append(riga);
			sb.append(System.lineSeparator());
			// CONTROLLO PRESENZA PAROLA CHIAVE NELLA RIGA
			if (riga.contains(chiave)) {
				String temp = riga;
				for (int i = 0; i < temp.length(); i++) {
					// RILEVAZIONE CAMPO DEL NOME CANZONE
					if (temp.charAt(i) == '>')
						cont++;
					if (cont >= 3)
						// ESTRAZIONE NOME CANZONE
						Nome = riga.substring(i, riga.length());
					// CONTROLLO PRESENZA PAROLA CHIAVE NEL NOME
					if (Nome.contains(chiave))
						// INSERIMENTO RIGA NELLA LISTA
						Stringhe.add(riga);
				}
				// RESET CONTATORE PER IL CAMPO DEL NOME
				cont = 0;
			}
			// LETTURA NUOVA RIGA
			riga = br.readLine();
		}
		// CONTROLLO DOPPIONI TRAMITE METODO "Doppioni"
		Stringhe = Ricerca.Doppioni(Stringhe);

		String risultato = "";
		// INSERIMENTO RISULTATI IN STRINGA "risultato"
		for (int i = 0; i < Stringhe.size(); i++) {
			risultato += Stringhe.get(i) + "\n";
		}
		br.close();

		// STAMPA ECONTROLLO NUMERO RISULTATI
		if (risultato == "")
			return "La ricerca per nome non ha prodotto risultati.\n";
		else 
			if (n_ris == 1)
				return "Ricerca per nome:\n" + risultato.replace("<SEP>", " - ") + "\n� stato trovato " + n_ris + " risultato.\n";
			else
				return "Ricerca per nome:\n" + risultato.replace("<SEP>", " - ") + "\nSono stati trovati " + n_ris + " risultati.\n";

	}

	// METODO RICERCA PER ANNO E AUTORE
	public static String RiceraAnno_Autore(String autore, int anno) throws IOException {
		// CREAZIONE OGGETTI
		BufferedReader br = new BufferedReader(new FileReader(path));
		LinkedList<String> Stringhe = new LinkedList<String>();

		// SUBSTRING CONTENENTI ANNO E AUTORE
		String subAnno = "";
		String subAutore = "";

		// VARIABILE ANNO IN NUMERO
		int numero = 0;

		// CONTATORE CAMPO AUTORE
		int cont2 = 0;

		// LETTURA RIGA DAL FILE "canzoni.txt"
		String riga = br.readLine();
		while (riga != null) {
			sb.append(riga);
			sb.append(System.lineSeparator());
			// ESTRAZIONE ANNO CANZONE
			subAnno = riga.substring(0, 4);
			// TRASFORMO DA STRING A INT
			numero = Integer.valueOf(subAnno);
			// CONTROLLO PRESENZA AUTORE RICHIESTO
			if (riga.contains(autore)) {
				for (int i = 0; i < riga.length(); i++) {
					// RILEVAZIONE CAMPO AUTORE
					if (riga.charAt(i) == '>')
						cont2++;
					// ESTRAZIONE DEL NOME AUTORE
					if (cont2 >= 2 && cont2 <= 2) {
						subAutore += riga.charAt(i);
						subAutore = subAutore.replace("<SEP", "");
						subAutore = subAutore.replace(">", "");
					}
				}

				// CONTROLLO COINCIDENZA AUTORE E ANNO
				if (subAutore.equals(autore) && numero == anno)
					Stringhe.add(riga);
			}

			// LETTURA PROSSIMA RIGA
			riga = br.readLine();
		}

		// CONTROLLO DOPPIONI TRAMITE METODO "Doppioni"
		Stringhe = Ricerca.Doppioni(Stringhe);
		String risultato = "";
		
		// INSERIMENTO RISULTATI IN STRINGA "risultato"
		for (int i = 0; i < Stringhe.size(); i++) {
			risultato += Stringhe.get(i) + "\n";
		}

		br.close();

		// STAMPA ECONTROLLO NUMERO RISULTATI
		if (risultato == "")
			return "La ricerca per autore e anno non ha prodotto risultati.\n";
		else 
			if (n_ris == 1)
				return "Ricerca per autore e anno:\n" + risultato.replace("<SEP>", " - ") + "\n� stato trovato " + n_ris + " risultato.\n";
			else
				return "Ricerca per autore e anno:\n" + risultato.replace("<SEP>", " - ") + "\nSono stati trovati " + n_ris + " risultati.\n";
		
	}

	// METODO CONTROLLO DOPPIONI
	public static LinkedList<String> Doppioni(LinkedList<String> originale) {
		// CREAZIONE OGGETTI
		LinkedList<String> copia = new LinkedList<String>();
		LinkedList<String> medio = new LinkedList<String>();

		String sub = "";

		// INSERIMENTO RISULTATI IN UNA LISTA SENZA L'ID PER EVITARE FALSI POSITIVI
		for (int i = 0; i < originale.size(); i++) {
			sub = originale.get(i).substring(0, 4);
			sub += originale.get(i).substring(27, originale.get(i).length());
			medio.add(sub);
			sub = "";
		}

		// CONTROLLO DOPPIONI
		for (int i = 0; i < medio.size(); i++) {
			if (!(copia.contains(medio.get(i)))) {
				copia.add(medio.get(i));
				n_ris++;
			}
		}

		return copia;
	}

}
