package ba.unsa.etf.rpr;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Student {
    private String imeStudenta = null;
    private String prezimeStudenta = null;
    private Integer brojIndeksa = null;

    public Student(String imeStudenta, String prezimeStudenta, Integer brojIndeksa) {
        this.setImeStudenta(imeStudenta);
        this.setPrezimeStudenta(prezimeStudenta);
        this.setBrojIndeksa(brojIndeksa);
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public String getPrezimeStudenta() {
        return prezimeStudenta;
    }

    public void setPrezimeStudenta(String prezimeStudenta) {
        this.prezimeStudenta = prezimeStudenta;
    }

    public Integer getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(Integer brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    @Override
    public String toString() {
        return this.getPrezimeStudenta() + " " + this.getImeStudenta() + " (" + Integer.toString(this.getBrojIndeksa()) + ")\n";
    }
}
