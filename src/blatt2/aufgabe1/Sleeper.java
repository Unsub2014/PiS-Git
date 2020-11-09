package blatt2.aufgabe1;

import java.util.Scanner;

public class Sleeper {

    Thread sleeper = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hallo, da bin ich und heiße schläfer");
            int counter = 0;
            while(true){
                System.out.println("Jetzt bin ich aktiv und lebe seit" + counter + ", Millisekunden");
                try {
                    Thread.sleep(1000);
                    counter = counter + 10;
                } catch (InterruptedException e) {
                    System.out.println("Eben noch geschlafen, jetzt schon tot");
                }
                if(Thread.interrupted()){
                    System.out.println("Eben noch aktiv, jetzt schon tot nur nach " + counter + " Millisekunden");
                }
            }
        }
    });

    Thread terminator = new Thread(new Runnable() {
        @Override
        public void run() {
            new Scanner(System.in).nextLine();
            sleeper.interrupt();
        }
    });
}
