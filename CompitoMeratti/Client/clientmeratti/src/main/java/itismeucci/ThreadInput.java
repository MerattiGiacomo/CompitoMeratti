package itismeucci;

public class ThreadInput extends Thread{
    Compra c;
    public ThreadInput(Compra c){
        this.c = c;
    }

    public void run(){
        try {
            c.input();
        } catch (Exception e) {}
    }
}
