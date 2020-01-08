# Progetto-L19

## Suddivisione ruoli
- _Documentazione dei requisiti_: Andrea Secchi <br>
- _Documentazione del progetto_: Luca Goretti <br>
- _Documentazione del codice_: Davide Previte <br>
- _Verifica e convalida_: Giulio Lunghi <br>
- _Qualità del codice_: Mauro Finiguerra <br>
- _Progettazione dell’interfaccia_: Alessandro Zuccolo <br>

## Requirements
 - Ambiente di sviluppo Java
 - MySQL Workbench

 - Java jdk versione 12.0.1
 - mysql-connector-java-8.0.16

## Come avviare il programma
 Per avviare il programma è necessario prima di tutto avere il database a disposizione e funzionante.
 Per evitare di dover modificare parametri all'interno del codice creare il db tramite la workbench con gli stessi parametri
 presenti all'interno della classe "ServizioDAO" del progetto UfficioPubblicoVF. Creare quindi un nuovo schema in localhost
 e chiamarlo "ufficiopubblico-data"; all'interno dello schema creare una tabella e chiamarla "listaservizi".
 Per creare la tabella copiare ed eseguire il codice contenuto nel file "Cod-MySQL-DB".
 
 Parte di codice della classe ServizioDAO con i dati generali per la connessione al db:
 
 ******************************************************************************************************************
 * private String nomeTabella = "listaservizi";                                                                   *
 * private String host = "jdbc:mysql://localhost:3306/ufficiopubblico-data?useTimezone=true&serverTimezone=UTC";  *
 * private String user = ""; // username della propria workbench                                                  *
 * private String password = ""; // password della propria workbench                                              *
 ******************************************************************************************************************
 
 Quando tutto è pronto eseguire i seguenti passi:
 - Avviare la workbech e il database.
 - Aprire UfficioPubblicoVF e avviare il programma tramite StartApplication.
 - Aprire ClientUtenteVF su un altro dispositivo oppure sullo stesso, nella classe StartApplication immettere l'indirizzo IP
   della macchina che esegue UfficioPubblicoVF e avviare.
 - Aprire ClientSportelloVF su un altro dispositivo oppure sullo stesso, nella classe StartApplication immettere l'indirizzo IP
   della macchina che esegue UfficioPubblicoVF e avviare.
 - Aprire ClientUfficioVF su un altro dispositivo oppure sullo stesso, nella classe StartApplication immettere l'indirizzo IP
   della macchina che esegue UfficioPubblicoVF e avviare.

Tutto il sistema può essere eseguito tramite un numero diverso di dispositivi oppure sullo stesso dispositivo in caso ci siano
problemi di rete che impediscono lo scambio di dati tra i dispositivi.
