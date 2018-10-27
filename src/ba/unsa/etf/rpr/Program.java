package ba.unsa.etf.rpr;
import java.io.PrintStream;
public class Program {
    private Student[] studenti;
    private Predmet[] predmeti;
// potrebno: kreiranje novog predmeta, novog studenta, upis studenata na predmet, ispis
    // studenata sa predmeta, brisanje studenta, brisanje predmeta, ispis spiska studenata
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
    public void obrisiStudenta(int brojIndeksa) {
        int pronadjen = 0;
        Student[] temp = new Student[this.studenti.length - 1];
        for (int i = 0; i < studenti.length; i++)
            if (this.studenti[i].getBrojIndeksa() != brojIndeksa) temp[i-pronadjen] = this.studenti[i];
            else pronadjen = 1;
        this.studenti = temp;
    }
    public void obrisiPredmet(int sifraPredmeta) {
        int pronadjen = 0;
        Predmet[] temp = new Predmet[this.predmeti.length - 1];
        for (int i = 0; i < predmeti.length; i++)
            if (this.predmeti[i].getSifraPredmeta() != sifraPredmeta) temp[i-pronadjen] = this.predmeti[i];
            else pronadjen = 1;
        this.predmeti = temp;
    }
    public void ispisiStudenteNaPredmetu(String nazivPredmeta) {
        for (int i = 0; i < predmeti.length; i++)
            if (nazivPredmeta.equals(predmeti[i].getNazivPredmeta()))
                for (int j = 0; j < predmeti[i].getStudenti().length; j++)
                    System.out.println((predmeti[i].getStudenti())[i]);
    }
    public static void main(String[] args) {
	// write your code here

    }
}
