package emotionalsongs;

import java.io.IOException;
import java.util.Arrays;

public class EmotionalSongs {
	
	//Metodo Main
	public static void main(String[] args) throws IOException{
		//Test
		//Metodo lettura file
		System.out.println(Arrays.toString(lettura.leggi()));
		//Metodo ricerca con parola chiave
		System.out.println(lettura.ricerca("Ariana"));
	}

}
