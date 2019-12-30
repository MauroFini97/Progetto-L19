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
 
 Parte di codice della classe ServizioDAO con i dati generali per la connessione al db:
 
 private String nomeTabella = "listaservizi";
 private String host = "jdbc:mysql://localhost:3306/ufficiopubblico-data?useTimezone=true&serverTimezone=UTC";
 private String user = ""; // username della propria workbench
 private String password = ""; // password della propria workbench
 
 Quando tutto è pronto e funzionante aprire il progetto UfficioPubblicoVF, e avviare tramite la classe StartApplication
 tutto quanto. UfficioPubblicoVF è il sistema principale che fa girare tutto quanto.
 In seguito aprire progetto ClientUtenteVF, nella classe StartApplication scrivere l'indirizzo IP della macchina che ospita
 il server principale (UfficioPubblicoVF) e avviare.
 Eseguire gli stessi passi per ClientSportelloVF e ClientUfficioVF.
