import java.io.DataOutputStream;

/*todo metodo da implementare inserisciEmozioniBrano(); 
implementare un metodo inserisciEmozioniBrano che permette all'utente 
di inserire emozioni provate durante l'ascolto di un brano. L'utente che utilizza
il metodo inserisciEmozioniBrano(); deve essere registrato, aver eseguito l'autenticazione, ricercare la canzone 
a cui assegnare l'emozione che prova.



*/

public class ClasseFantoccioDaRimpiazzare {

    static void InserisciEmozioniBrano(Boolean U_Reg, Boolean U_Play) {

        // Controllare inoltre con flag se l'utente è loggato nel sistema e se è nella
        // playlist giusta

        Boolean Flag1 = U_Reg;
        Boolean Flag2 = U_Play;

        /*
         * Update / Scrittura di campo Emozioni nel file di testo
         * Emozioni.Dati, contentente La canzone, l'user id e l'emozione provata
         */

        if (Flag1 && Flag2) {
            Scanner In = new Scanner(System.in);
            // dovrei aggiungere un modo per mettere piu' emozioni a mo' di tag
            DataOutputStream dataupdate = new DataOutputStream("Emozioni.Dati.txt");

            System.println("che tipo di emozione/i hai provato?");
            String Emozione = In.nextLine();

            dataupdate.writeChars(Emozione);
            dataupdate.close();
        } else {
            System.out
                    .println("Perfavore controlla di essere nella Playlist giusta o che la sessione non sia scaduta.");
        }

    }

}