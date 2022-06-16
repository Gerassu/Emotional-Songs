import java.io.DataOutputStream;
import java.util.Scanner;
import java.io.FileWriter;

//Utilizzo di fliewriter al posto do dataoutputstream (per compatibilita')

/*todo metodo da implementare inserisciEmozioniBrano(); 
implementare un metodo inserisciEmozioniBrano che permette all'utente 
di inserire emozioni provate durante l'ascolto di un brano. L'utente che utilizza
il metodo inserisciEmozioniBrano(); deve essere registrato, aver eseguito l'autenticazione, ricercare la canzone 
a cui assegnare l'emozione che prova.



*/

public class ClasseFantoccioDaRimpiazzare {

    static void InserisciEmozioniBrano(Boolean U_Reg, Boolean U_Play, int UID, String Song_In) {

        // Controllare inoltre con flag se l'utente è loggato nel sistema e se è nella
        // playlist giusta

        Boolean Flag1 = U_Reg;
        Boolean Flag2 = U_Play;
        int UserId = UID;
        String canzonein = Song_In;
        String newLine = System.getProperty("line.separator");

        /*
         * Update / Scrittura di campo Emozioni nel file di testo
         * Emozioni.Dati, contentente La canzone, l'user id e l'emozione provata
         */

        if (Flag1 && Flag2) {
            // dovrei aggiungere un modo per mettere piu' emozioni a mo' di tag

            Scanner in = new Scanner(System.in);
            FileWriter fw = new FileWriter("Emozioni.Dati.txt");

            fw.write(UserId + " " + canzonein);

            System.out.println("Quante emozioni vuoi inserire?");

            int QTY = in.nextInt();

            for (int i = 0; i < QTY; i++) {
                System.out.println("che tipo di emozione/i hai provato?");
                String Emozione = in.nextLine();
                fw.write(" " + Emozione + " ");
            }

            fw.write(newLine);

            fw.close();

        } else {
            System.out.println("controlla di essere nella Playlist giusta o che la sessione non sia scaduta.");
        }

    }

}