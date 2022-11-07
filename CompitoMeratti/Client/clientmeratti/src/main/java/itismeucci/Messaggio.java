package itismeucci;

import java.util.ArrayList;
import java.util.Objects;

public class Messaggio {
    private ArrayList<Biglietti> messaggio;

    public Messaggio() {
    }

    public Messaggio(ArrayList<Biglietti> messaggio) {
        this.messaggio = messaggio;
    }

    public ArrayList<Biglietti> getMessaggio() {
        return this.messaggio;
    }

    public void setMessaggio(ArrayList<Biglietti> messaggio) {
        this.messaggio = messaggio;
    }

    public Messaggio messaggio(ArrayList<Biglietti> messaggio) {
        setMessaggio(messaggio);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Messaggio)) {
            return false;
        }
        Messaggio messaggio = (Messaggio) o;
        return Objects.equals(messaggio, messaggio.messaggio);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(messaggio);
    }

    @Override
    public String toString() {
        return "{" +
            " messaggio='" + getMessaggio() + "'" +
            "}";
    }
}
