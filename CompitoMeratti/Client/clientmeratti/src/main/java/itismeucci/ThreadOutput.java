package itismeucci;

public class ThreadOutput extends Thread{
    Compra c;
    public ThreadOutput(Compra c){
        this.c = c;
    }

    public void run(){
        try {
            c.output();
        } catch (Exception e) {}
    }
}
