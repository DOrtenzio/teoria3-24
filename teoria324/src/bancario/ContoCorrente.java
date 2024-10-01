package bancario;

public class ContoCorrente {

    private double saldo; // variabile che memorizza il saldo del conto
    private int numero; // variabile che memorizza il numero del conto
    private String tipo; //Stringa che indica la tipologia di cliente

    private static int numeroUltimoContoCreato = 1000; // variabile condivisa (inizializzata a 1000)
    private static double tassoFamily = 0.01; //un reale che rappresenta il tasso di interesse da applicare ai clienti family
    private static double tassoBusiness = 0.02; //un reale che rappresenta il tasso di interesse da applicare ai clienti business

    //Costruttori
    public ContoCorrente(double saldoIniziale, String tipo) { //il numero del conto viene inizializzato usando la variabile condivisa numeroUltimoContoCreato
        saldo=saldoIniziale;
        numeroUltimoContoCreato++;
        numero=numeroUltimoContoCreato;
        this.tipo=tipo;
    }

    //Metodi

    public void deposita(double importo) { // metodo per il versamento di somme
        saldo += importo;
        System.out.println("Versati: " + importo + " euro");
    }

    public boolean preleva(double importo) { // metodo per il prelievo di somme
        if (saldo < importo)
            return false;
        else {
            saldo -= importo;
            System.out.println("Prelevati: " +importo+ " euro");
            return true;
        }
    }

    // restituisce il saldo a chi ne ha bisogno
    public double ottieniSaldo() { return saldo; }

    // restituisce il numero di conto a chi ne ha bisogno
    public int ottieniNumero() { return numero; }

    // restituisce l’ultimo numero di conto creato
    public static int ottieniUltimoNumero() { return numeroUltimoContoCreato; }

    //Metodi get richiesti
    public static double getTassoBusiness() { return tassoBusiness; }
    public static double getTassoFamily() { return tassoFamily; }
    public String getTipo() { return tipo; }

    //Metodi set tassi
    public static void setTassoBusiness(double tassoBusiness) { ContoCorrente.tassoBusiness = tassoBusiness; }
    public static void setTassoFamily(double tassoFamily) { ContoCorrente.tassoFamily = tassoFamily; }

    //Matura-Interessi
    public void maturaInteressi(){
        if (tipo.equalsIgnoreCase("Family"))
            saldo+=saldo*getTassoFamily();
        else
            saldo+=saldo*getTassoBusiness();
    }


}