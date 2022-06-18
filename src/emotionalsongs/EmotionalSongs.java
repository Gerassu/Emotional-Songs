package emotionalsongs;

import java.io.IOException;

public class EmotionalSongs {
	
	//Metodo Main
	public static void main(String[] args) throws IOException{
		System.out.println(Ricerca.RiceraNome("Don't Pan Me"));
		System.out.println(Ricerca.RiceraNome("Don't Pan123"));
		System.out.println(Ricerca.RiceraNome("Don't Pan"));
		System.out.println(Ricerca.RiceraAnno_Autore("Joe Venuti_ Eddie Lang", 1926));
		System.out.println(Ricerca.RiceraAnno_Autore("Barrington Levy", 1922));
	}

}

