package blatt1.aufgabe1;

public class ABCThread implements Runnable{

    private boolean printBig;

    public ABCThread(boolean printBig){
        this.printBig = printBig;
    }

    @Override
    public void run(){
        if(printBig){
            for(char c='A'; c <= 'Z'; c++){
                System.out.print(c);
            }
        }
        else{
            for(char c='a'; c <= 'z'; c++){
                System.out.print(c);
            }
        }
    }

    public static void main(String [] args){
        Thread big = new Thread (new ABCThread(true));
        Thread small = new Thread(new ABCThread(false));
        big.start();
        small.start();
    }
}
