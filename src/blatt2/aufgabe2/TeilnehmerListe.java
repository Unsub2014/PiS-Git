package blatt2.aufgabe2;

import java.util.ArrayList;

public class TeilnehmerListe implements TNListe{

    public static ArrayList<Teilnehmer> liste = new ArrayList<Teilnehmer>();

    public synchronized boolean einfugen(Teilnehmer tn) {
        for(Teilnehmer t : liste){
            if(t.getName().equals(tn.getName())) {
                return false;
            }
        }
        liste.add(tn);
        return true;
    }

    @Override
    public synchronized boolean entfernen(Teilnehmer tn) {
        for(Teilnehmer t : liste){
            if(t.getName().equals(tn.getName())) {
                liste.remove(tn);
                return true;
            }
        }
        return false;
    }

    Thread anmelder1 = new Thread(new Runnable() {
        @Override
        public void run() {
            int counter = 0;
            for(char c = 'A'; c <= 'Z'; c++){
                Teilnehmer t = new Teilnehmer(Character.toString(c), (int)Math.random());
                if (einfugen(t)){
                    System.out.println("Anmelder 1 : Anmeldung " + t.getName() + ", " + t.getTelefon() );
                    counter++;
                }
                else{
                    System.out.println("Fehler 1: " + t.getName() + ", " + t.getTelefon());
                }
            }
            System.out.println("Anmelder 1 : " + counter);
        }
    });

    Thread anmelder2 = new Thread(new Runnable() {
        @Override
        public void run() {
            int counter = 0;
            for(char c = 'Z'; c >= 'A'; c--){
                Teilnehmer t = new Teilnehmer(Character.toString(c), (int)Math.random() * 1000 + 10);
                if (einfugen(t)){
                    System.out.println("Anmelder 2 : Anmeldung " + t.getName() + ", " + t.getTelefon() );
                    counter++;
                }
                else{
                    System.out.println("Fehler 2: " + t.getName() + ", " + t.getTelefon());
                }
            }
            System.out.println("Anmelder 2 : " + counter);
        }
    });

    public static void main(String [] args){
        TeilnehmerListe tnL = new TeilnehmerListe();
        tnL.anmelder1.start();
        tnL.anmelder2.start();
    }
}

