package blatt2.aufgabe3;

public class ThreadLister {
    String allThreadToString(){
        Thread currentThread = Thread.currentThread();
        ThreadGroup rootG = currentThread.getThreadGroup();
        ThreadGroup parentGroup;
        while ((parentGroup =rootG.getParent())!= null){
            rootG = parentGroup;
        }
        Thread [] threadArr = new Thread[rootG.activeCount()];
        while (rootG.enumerate(threadArr, true) == threadArr.length){
            threadArr = new Thread[threadArr.length * 2];
        }
        StringBuilder outPut = new StringBuilder("");
        for(Thread thread : threadArr){
            if (thread == null) continue;
            outPut.append("ThreadName : " + thread.getName() + "\n  ThreadPriority : " + thread.getPriority() + "\n     isDaemon : " + thread.isDaemon() + "\n");
        }
        return  outPut.toString();
    }

    public static void main(String [] args){
        System.out.println(new ThreadLister().allThreadToString());
    }
}
