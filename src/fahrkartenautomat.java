import java.util.Scanner;

class Fahrkartenautomat {

    public static void main(String[] args) {
        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        zuZahlenderBetrag = fahrkartenbestellungErfassen();
        eingezahlterGesamtbetrag = fahrkartenBezahlen(zuZahlenderBetrag);
        fahrkartenAusgeben();
        double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        rueckgeldAusgeben(rueckgabebetrag);
    }
    public static double fahrkartenbestellungErfassen() {
        double zuZahlenderBetrag;
        double ticketPreis;
        int anzahlTickets;
        Scanner tastatur = new Scanner(System.in);
        System.out.print("Ticketpreis");
        ticketPreis = tastatur.nextDouble();
        System.out.print("Anzahl der Tickets");
        anzahlTickets = tastatur.nextInt();
        while (anzahlTickets <= 0 || anzahlTickets > 10) {
            System.out.println("ngültige Anzahl");
            anzahlTickets = tastatur.nextInt();
        }
        zuZahlenderBetrag = ticketPreis * anzahlTickets;
        return zuZahlenderBetrag;
    }
    public static double fahrkartenBezahlen(double zuZahlenderBetrag) {
        Scanner tastatur = new Scanner(System.in);
        double eingezahlterGesamtbetrag = 0.0;
        double eingeworfeneMuenze;

        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            System.out.format("Noch zu zahlen: %4.2f €%n", (zuZahlenderBetrag - eingezahlterGesamtbetrag));
            System.out.print("Eingabe (mind. 5Ct, höchstens 2 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (eingeworfeneMuenze == 0.05){
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            } else if (eingeworfeneMuenze == 0.1){
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            }  else if (eingeworfeneMuenze == 0.2){
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            }  else if (eingeworfeneMuenze == 0.5){
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            }  else if (eingeworfeneMuenze == 1){
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            } else if (eingeworfeneMuenze == 2){
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            } else {
                System.out.println("Dies ist kein akzeptiertes Zahlungsmittel.");
            }

        }
        return eingezahlterGesamtbetrag;
    }
    public static void fahrkartenAusgeben() {
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
    }

    public static void rueckgeldAusgeben(double rueckgabebetrag) {
        if (rueckgabebetrag > 0.0) {
            System.out.format("Der Rückgabebetrag in Höhe von %4.2f € %n", rueckgabebetrag);
            System.out.println("wird in folgenden Münzen ausgezahlt");
            while (rueckgabebetrag >= 2.0)
            {
                System.out.println("2euro");
                rueckgabebetrag -= 2.0;
                rueckgabebetrag = Math.round(rueckgabebetrag*100.0)/100.0;
            }
            while (rueckgabebetrag >= 1.0)
            {
                System.out.println("1 EURO");
                rueckgabebetrag -= 1.0;
                rueckgabebetrag = Math.round(rueckgabebetrag*100.0)/100.0;
            }
            while (rueckgabebetrag >= 0.5)
            {
                System.out.println("50 CENT");
                rueckgabebetrag -= 0.5;
                rueckgabebetrag = Math.round(rueckgabebetrag*100.0)/100.0;
            }
            while (rueckgabebetrag >= 0.2)
            {
                System.out.println("20 CENT");
                rueckgabebetrag -= 0.2;
                rueckgabebetrag = Math.round(rueckgabebetrag*100.0)/100.0;
            }
            while (rueckgabebetrag >= 0.1)
            {
                System.out.println("10 CENT");
                rueckgabebetrag -= 0.1;
                rueckgabebetrag = Math.round(rueckgabebetrag*100.0)/100.0;
            }
            while (rueckgabebetrag >= 0.05)
            {
                System.out.println("5 CENT");
                rueckgabebetrag -= 0.05;
                rueckgabebetrag = Math.round(rueckgabebetrag*100.0)/100.0;
            }
        }
    }
}