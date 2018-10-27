package ba.unsa.etf.rpr;
import java.io.PrintStream;
public class Program {
    private Student[] studenti;
    private Predmet[] predmeti;
// potrebno: kreiranje novog predmeta, novog studenta, upis studenata na predmet, ispis
    // studenata sa predmeta, brisanje studenta, brisanej predmeta, ispis spiska studenata
    // na predmetu
    public void dodajPredmet(String nazivPredmeta, Integer sifraPredmeta, Integer maksimalanBrojStudenata) {
        Predmet[] pomocni = new Predmet[this.predmeti.length + 1];
        pomocni[this.predmeti.length] = new Predmet(nazivPredmeta, sifraPredmeta, maksimalanBrojStudenata);
        this.predmeti = pomocni;
        System.out.println("Predmet " + nazivPredmeta + " je uspješno kreiran!");
    }
    public void dodajStudenta(String imeStudenta, String prezimeStudenta, Integer brojIndexa) {
        //bez vršenja provjere regularnosti
        Student[] pomocni = new Student[this.studenti.length + 1];
        pomocni[this.studenti.length] = new Student(imeStudenta, prezimeStudenta, brojIndexa);
        this.studenti = pomocni;
    }
    public static void main(String[] args) {
	// write your code here

    }
}
