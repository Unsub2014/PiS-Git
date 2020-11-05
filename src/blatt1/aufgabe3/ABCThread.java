package blatt1.aufgabe3;

public class ABCThread extends Thread {
    static boolean turnBig = false;
    boolean printBig;

    public ABCThread(boolean printBig) {
        this.printBig = printBig;
    }

    @Override
    public void run() {
        if (this.printBig) {
            for (char c = 'a'; c <= 'z'; c++) {
                System.out.print(c);
                turnBig = false;
                if(c=='z') break;
                while (!turnBig) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print(c);
                turnBig = true;
                if(c=='Z') break;
                while (turnBig) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ABCThread big = new ABCThread(true);
        ABCThread small = new ABCThread(false);
        big.start();
        small.start();
    }
}