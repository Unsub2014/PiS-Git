package blatt1.aufgabe1;

public class ABCThread extends Thread{

    boolean printBig;

    public ABCThread(boolean printBig){
        this.printBig = printBig;
    }
    @Override
    public void run() {
        if(this.printBig){
            for(char c = 'a'; c<'z'; c++){
                System.out.print(c);
            }
        }
        else {
            for(char c = 'A'; c<'Z'; c++){
                System.out.print(c);
            }
        }
    }

    public static void main(String [] args){
        ABCThread big = new ABCThread(true);
        ABCThread small = new ABCThread(false);

        big.start();
        small.start();
    }
}
