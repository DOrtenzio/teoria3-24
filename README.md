Esercitazione
A lezione è stata creata la classe ContoCorrente di cui si riporta il codice:
public class ContoCorrente {
// variabile che memorizza il saldo del conto
private double saldo;

// variabile che memorizza il numero del conto
private int numero;

// variabile condivisa (inizializzata a 1000)
private static int numeroUltimoContoCreato = 1000;

//il numero del conto viene inizializzato usando la variabile
//condivisa numeroUltimoContoCreato
public ContoCorrente(double saldoIniziale) {
saldo=saldoIniziale;
numeroUltimoContoCreato++;
numero=numeroUltimoContoCreato;
}

// metodo per il versamento di somme
public void deposita(double importo) {
saldo += importo;
System.out.println("Versati: " + importo + " euro");
}

// metodo per il prelievo di somme
public boolean preleva(double importo) {
if (saldo < importo)
return false;
else {
saldo -= importo;
System.out.println("Prelevati: " +importo+ " euro");
return true;
}
}

// restituisce il saldo a chi ne ha bisogno
public double ottieniSaldo() {

return saldo;

}

// restituisce il numero di conto a chi ne ha bisogno
public int ottieniNumero() {
return numero;

}

// restituisce l’ultimo numero di conto creato
public static int ottieniUltimoNumero() {
return numeroUltimoContoCreato;

}
}

A questa classe devono essere aggiunti i seguenti campi
• tipo una stringa che indica la tipologia di cliente (family o business)
• tassoFamily un reale che rappresenta il tasso di interesse da applicare ai clienti family
(inizializzato allo 0.01)
• tassoBusiness un reale che rappresenta il tasso di interesse da applicare ai clienti business
(inizializzato allo 0.02)
Inoltre devono essere previsti
• metodi get per i 2 tassi e il tipo di conto
• metodi set per i 2 tassi
• e un metodo per il calcolo degli interessi maturati, maturaInteressi( ), che aggiorna il saldo
corrente con gli interessi maturati
• il costruttore deve essere opportunamente modificato
Fai attenzione a quali variabili e metodi sono d’istanza e quali di classe

Inoltre, scrivi la classe TestContoCorrente che contiene il metodo main( ).
Nel main devi
• creare un array di 5 oggetti ContoCorrente,
• creare 5 oggetti da inserire nell’array,
• visualizzare a video le informazioni relative ai 5 oggetti (tipo, saldo e numero di conto)
• calcolare e visualizzare gli interessi maturati su tutti i conti
• modificare il tassoBusiness al nuovo valore di 0.03
• dato un numero di conto inserito in input effettuare un prelievo
• dato un numero di conto inserito in input effettuare un deposito
• dato un numero di conto inserito in input visualizzare il saldo
