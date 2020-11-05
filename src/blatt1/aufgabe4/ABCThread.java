package blatt1.aufgabe4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABCThread extends Thread{
    private static List <ABCThread> allABCThreads = new ArrayList();
    boolean printBig;
    public ABCThread(boolean printBig){
        this.printBig = printBig;
        allABCThreads.add(this);
    }
    @Override
    public void run() {
        if(this.printBig){
            boolean stop = false;
            while (stop == false){
                for(char c = 'A'; c<='Z'; c++){
                    System.out.print(c);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        stop = true;
                        break;
                    }
                }
            }
        }
        else {
            boolean stop = false;
            while (stop == false){
                for(char c = 'a'; c<='z'; c++){
                    System.out.print(c);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        stop = true;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String [] args) throws InterruptedException {
        ABCThread big = new ABCThread(true);
        ABCThread small = new ABCThread(false);
        Thread killer = new Thread(new Runnable() {
            @Override
            public void run() {
                new Scanner(System.in).nextLine();
                for(ABCThread abcThread : allABCThreads){
                    abcThread.interrupt();
                }
            }
        });
        big.start();
        small.start();
        killer.start();
    }
}