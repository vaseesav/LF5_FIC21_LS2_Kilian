import java.util.Scanner;

class FahrkartenAutomatv2 {
    public static void main(String[] args) {

        begruessung();

        Scanner tastatur = new Scanner(System.in);
        double zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
        double eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);

        rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);
        fahrkartenAusgeben(zuZahlenderBetrag);

        tastatur.close();
    }

    /**
     * ist eine Methode, die den Benutzer begrüßt und keine Eingaben oder Rückgabewerte hat.
     **/
    public static void begruessung() {
        System.out.println("Herzlich Willkommen! \n");
    }

    /**
     * ist eine Methode, die den Benutzer nach der gewünschten Fahrkarte und der Anzahl der Fahrkarten fragt,
     * die er kaufen möchte. Sie nimmt einen Scanner als Eingabeparameter und
     * gibt den Gesamtbetrag der bestellten Fahrkarten als double zurück.
     **/
    public static double fahrkartenbestellungErfassen(Scanner tastatur) {
        int zuZahlenderBetrag = 0;
        double zuZahlenBetrag = 0;
        double AnzahlDerTickets = 0;
        double ticketsMalBetrag = 0;

        while (zuZahlenderBetrag != 9) {
            // Eingabe des Geldbetreages
            System.out.print("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:\n");
            System.out.print("	Kurzeste Strecke AB [2,00 EUR] (1)\n");
            System.out.print("	Einzelfahrschein AB [3,00 EUR] (2)\n");
            System.out.print("	Tageskarte AB [8,80 EUR] (3)\n");
            System.out.print("	4-Fahrten-Karte AB [9,40 EUR] (4)\n");
            System.out.print("	Bezahlen (9)\n\n");

            zuZahlenderBetrag = 0;
            zuZahlenBetrag = 0;

            while (zuZahlenderBetrag > 4 || zuZahlenderBetrag < 1) {
                System.out.print("Ihre Wahl: ");
                zuZahlenderBetrag = tastatur.nextInt();
                if (zuZahlenderBetrag != 9) {
                    switch (zuZahlenderBetrag) {
                        case 1:
                            zuZahlenBetrag = 2;
                            break;
                        case 2:
                            zuZahlenBetrag = 3;
                            break;
                        case 3:
                            zuZahlenBetrag = 8.8;
                            break;
                        case 4:
                            zuZahlenBetrag = 9.4;
                            break;
                        default:
                            System.out.print("	>>falsche Eingabe<<\n");
                    }
                    AnzahlDerTickets = 0;
                    while (AnzahlDerTickets > 10 || AnzahlDerTickets < 1) {
                        System.out.print("Anzahl der Tickets: ");
                        AnzahlDerTickets = tastatur.nextDouble();
                        if (AnzahlDerTickets > 10 || AnzahlDerTickets < 1) {
                            System.out.println(">> Wählen sie bite eine Anzahl von 1 bis 10 Tickets aus. \n");
                        }
                    }
                    ticketsMalBetrag = zuZahlenBetrag * AnzahlDerTickets;
                } else if (zuZahlenderBetrag == 9) {
                    break;
                }
            }
        }

        return ticketsMalBetrag;
    }

    /**
     * ist eine Methode, die den Fahrschein ausgibt, indem sie eine Animationsnachricht ausgibt.
     **/
    public static void fahrkartenAusgeben(double ticketPrice) {
        // Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n" + "Wir wünschen Ihnen eine gute Fahrt.");
    }

    /**
     * ist eine Methode, die den Benutzer nach dem eingezahlten Betrag fragt und den eingezahlten Gesamtbetrag zurückgibt
     **/
    public static double fahrkartenBezahlen(Scanner tastatur, double totalAmount) {
        double eingezahlterGesamtbetrag = 0.0;
        double nochZuZahlen = 0.0;

        while (eingezahlterGesamtbetrag < totalAmount) {
            nochZuZahlen = totalAmount - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
            double eingeworfeneMuenze = tastatur.nextDouble();
            if (!(eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 || eingeworfeneMuenze == 0.2 || eingeworfeneMuenze == 0.5 || eingeworfeneMuenze == 1 || eingeworfeneMuenze == 2)) {
                System.out.print("	>>falsche Eingabe<<\n");
            } else {
                eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
            }
        }

        return eingezahlterGesamtbetrag;
    }

    /**
     * ist eine Methode, die das Rückgeld berechnet
     **/
    public static void rueckgeldAusgeben(double totalAmount, double paidAmount) {
        double returnAmount = paidAmount - totalAmount;
        System.out.printf("Rückgabe: %.2f Euro\n", returnAmount);
    }
}