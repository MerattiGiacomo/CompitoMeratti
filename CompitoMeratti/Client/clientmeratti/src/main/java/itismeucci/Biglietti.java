package itismeucci;

import java.util.Objects;

public class Biglietti {
    private int id;
    private String posto;

    public Biglietti() {
    }

    public Biglietti(int id, String posto) {
        this.id = id;
        this.posto = posto;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosto() {
        return this.posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public Biglietti id(int id) {
        setId(id);
        return this;
    }

    public Biglietti posto(String posto) {
        setPosto(posto);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Biglietti)) {
            return false;
        }
        Biglietti biglietti = (Biglietti) o;
        return id == biglietti.id && Objects.equals(posto, biglietti.posto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, posto);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", posto='" + getPosto() + "'" +
            "}";
    }

}
