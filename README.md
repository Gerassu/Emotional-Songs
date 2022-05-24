# Emotional-Songs

Progetto di Laboratorio A 

Cose da fare 

-repository di canzoni

File(Canzoni.dati) .txt
-Titolo
-Autore
-Anno
Opzionali:
-Album
-Durata
-Genere

File(UtentiRegistrati.dati) .txt collegato a -Registrazione()
-nome e cognome
-codice fiscale
-Indirizzo fisico (via/piazza, numero civico, cap, comune, provincia)
-indirizzo di posta elettronica
-userid o password per accedere al sistema

File(Playlist.dati) .txt collegato a -RegistraPlaylist()

File(Emozioni.dati) .txt collegato a -inserisciEmozioniBrano()

Prima Login:
-consultare le informazioni del repository di canzoni (titolo, autore, anno)
-visualizzare le emozioni associate a ciascuna canzone selezionata
-registrarsi all'applicazione
Dopo Login:
-creare playlists (metodo)
-inserire le emozioni provate nell’ascoltare ciascuna canzone della playlist 

Metodi da implementare:
-cercaBranoMusicale()
-visualizzaEmozioneBrano()
-Registrazione()
-RegistraPlaylist()
-inserisciEmozioniBrano()

--------------------------------------------------------------------------------
-cercaBranoMusicale()
• ricerca per titolo (prende in input una stringa di caratteri e restituisce i brani nel cui nome
compare la stringa di caratteri)
• ricerca per autore e anno (prende in input un autore e un anno e restituisce il nome del/i
brano/i corrispondenti al autore e anno ricercato)

-visualizzaEmozioneBrano()
• una volta ricercato il brano, deve essere possibile selezionare il brano e visualizzare tutte le informazioni relative al brano selezionato.

• deve anche essere possibile visualizzare un prospetto riassuntivo delle emozioni associate a quel brano o l’indicazione che il brano ricercato non contiene emozioni inserite dagli utenti. 
Nel caso di presenza di tag emozionali per quel brano, si potranno visualizzare le emozioni associate dagli utenti, in forma aggregata, con il numero di utenti
per ciascuna emozione e, ad esempio, la media del punteggio per ciascuna emozione, oltre agli eventuali commenti lasciati dagli utenti.


-Registrazione()
Per registrarsi all’applicazione, tramite la funzione Registrazione(), l'utente deve inserire
o nome e cognome
o codice fiscale
o Indirizzo fisico (via/piazza, numero civico, cap, comune, provincia)
o indirizzo di posta elettronica
o userid
o password per accedere al sistema

I dati della registrazione devono essere salvati in un file denominato
UtentiRegistrati.dati (file .txt o .csv)

-RegistraPlaylist()
Per creare la playlist (può crearne più di una), l’utente registrato:
a. deve autenticarsi tramite userid e password fornite al momento della registrazione

b. tramite la funzione RegistraPlaylist() deve inserire:
• Nome della playlist
• Elenco brani della playlist (singoli brani, brani di un autore o singoli album)

I dati di ogni playlist per ciascun utente registrato sono memorizzati in un file dedicato denominato Playlist.dati (file .txt o .csv)

-inserisciEmozioniBrano()
Per inserire eventuali emozioni provate durante l’ascolto, l’utente registrato:
a. deve autenticarsi tramite userid e password fornite al momento della registrazione
b. ricercare e selezionare la canzone ascoltata all’interno della playlist
c. può ora usare la funzione inserisciEmozioniBrano()
(la canzone e le emozioni associate dall’utente sono memorizzate nel file Emozioni.dati)

--------------------------------------------------------------------------------

Documentazione di Progetto (2 documenti distinti)
• Manuale Utente
• Manuale Tecnico

*MENU INIZIALE*
All’avvio l’applicazione mostra un menu iniziale dove:
Tutti possono:
• cercare brani con titolo, autore, anno
• visualizzare le emozioni associate a ciascuna canzone selezionata
• registrarsi all'applicazione
Gli utenti registrati possono:
• creare playlist
• inserire le emozioni provate all’ascolto di determinate canzoni


