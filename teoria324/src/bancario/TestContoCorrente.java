package bancario;

import java.util.Scanner;

public class TestContoCorrente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContoCorrente [] cc = new ContoCorrente[5];
        boolean isPresente;

        cc[0] = new ContoCorrente(1000.0, "family");
        cc[1] = new ContoCorrente(2000.0, "business");
        cc[2] = new ContoCorrente(1500.0, "family");
        cc[3] = new ContoCorrente(3000.0, "business");
        cc[4] = new ContoCorrente(2500.0, "family");

        for (int i = 0; i < cc.length; i++) {
            System.out.println("Conto numero: " + cc[i].ottieniNumero());
            System.out.println("Tipo: " + cc[i].getTipo());
            System.out.println("Saldo: " + cc[i].ottieniSaldo());
            System.out.println("-------------------------");
        }

        // Calcolo e visualizzazione degli interessi maturati su tutti i conti
        for (int i = 0; i < cc.length; i++) {
            cc[i].maturaInteressi();
        }

        // Modificare il tassoBusiness al nuovo valore di 0.03
        ContoCorrente.setTassoBusiness(0.03);
        System.out.println("Nuovo tasso di interesse per business: " + ContoCorrente.getTassoBusiness());


        // Eseguire un prelievo dato un numero di conto
        isPresente=false;
        System.out.print("Inserisci il numero di conto per il prelievo: ");
        int numeroConto = scanner.nextInt();
        System.out.print("Inserisci l'importo da prelevare: ");
        double importoPrelievo = scanner.nextDouble();
        for (ContoCorrente conto : cc) {
            if (conto.ottieniNumero() == numeroConto) {
                isPresente=true;
                if (conto.preleva(importoPrelievo))
                    System.out.println("Prelievo riuscito.");
                else
                    System.out.println("Saldo insufficiente.");
            }
        }
        if (!isPresente)
            System.out.println("Numero di conto inesistente");

        // Eseguire un deposito dato un numero di conto
        isPresente=false;
        System.out.print("Inserisci il numero di conto per il deposito: ");
        numeroConto = scanner.nextInt();
        System.out.print("Inserisci l'importo da depositare: ");
        double importoDeposito = scanner.nextDouble();
        for (ContoCorrente conto : cc) {
            if (conto.ottieniNumero() == numeroConto) {
                isPresente=true;
                conto.deposita(importoDeposito);
            }
        }
        if (!isPresente)
            System.out.println("Numero di conto inesistente");

        // Visualizzare il saldo dato un numero di conto
        isPresente=false;
        System.out.print("Inserisci il numero di conto per visualizzare il saldo: ");
        numeroConto = scanner.nextInt();
        for (ContoCorrente conto : cc) {
            if (conto.ottieniNumero() == numeroConto) {
                isPresente=true;
                System.out.println("Saldo corrente: " + conto.ottieniSaldo() + " euro");
            }
        }
        if (!isPresente)
            System.out.println("Numero di conto inesistente");
    }
}

