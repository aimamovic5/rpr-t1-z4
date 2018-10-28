package ba.unsa.etf.rpr;

import java.io.PrintStream;
import java.util.Scanner;

public class Program {
    private Student[] studenti;
    private Predmet[] predmeti;
    public Integer getBrojStudenata() {
        return this.studenti.length;
    }
    public Integer getBrojPredmeta() {
        return this.predmeti.length;
    }
    public void dodajPredmet(String nazivPredmeta, Integer sifraPredmeta, Integer maksimalanBrojStudenata) {
        if (this.predmeti == null || this.predmeti.length == 0) {
            predmeti = new Predmet[1];
            predmeti[0] = new Predmet(nazivPredmeta, sifraPredmeta, maksimalanBrojStudenata);
            return;
        }
        for (int i = 0; i < this.getBrojPredmeta(); i++)
            if (predmeti[i].getSifraPredmeta() == sifraPredmeta) {
                System.out.println("Navedena šifra predmeta je već zauzeta!");
                return;
            }
        for (int i = 0; i < this.getBrojPredmeta(); i++)
            if (predmeti[i].getNazivPredmeta().equals(nazivPredmeta)) {
                System.out.println("Već postoji predmet sa navedenim imenom!");
                return;
            }
        Predmet[] pomocni = new Predmet[this.predmeti.length + 1];
        for (int i = 0; i < predmeti.length; i++) pomocni[i] = predmeti[i];
        pomocni[this.predmeti.length] = new Predmet(nazivPredmeta, sifraPredmeta, maksimalanBrojStudenata);
        this.predmeti = pomocni;
    }
    public void dodajStudenta(Student s) {
        if (this.studenti == null || this.studenti.length == 0) {
            studenti = new Student[1];
            studenti[0] = s;
            return;
        }
        for (int i = 0; i < this.getBrojStudenata(); i++)
            if (studenti[i].getBrojIndeksa().equals(s.getBrojIndeksa())) {
                System.out.println("Navedeni broj indeksa je već zauzet!");
                return;
            }
        Student[] pomocni = new Student[this.studenti.length + 1];
        for (int i = 0; i < studenti.length; i++) pomocni[i] = studenti[i];
        pomocni[this.studenti.length] = s;
        this.studenti = pomocni;
    }
    public void obrisiStudenta(int brojIndeksa) {
        int pronadjen = 0;
        Student[] temp = new Student[this.studenti.length - 1];
        for (int i = 0; i < studenti.length; i++)
            if (this.studenti[i].getBrojIndeksa() != brojIndeksa) temp[i-pronadjen] = this.studenti[i];
            else {
                pronadjen = 1;
                for (int k = 0; k < predmeti.length; k++) predmeti[k].ispisi(studenti[i]);
            }
        this.studenti = temp;
            if (pronadjen == 0) System.out.println("Student s navedenim brojem indeksa nije pronađen!");
    }
    public void obrisiPredmet(String nazivPredmeta) {
        int pronadjen = 0;
        Predmet[] temp = new Predmet[this.predmeti.length - 1];
        for (int i = 0; i < predmeti.length; i++)
            if (!this.predmeti[i].getNazivPredmeta().equals(nazivPredmeta)) temp[i-pronadjen] = this.predmeti[i];
            else pronadjen = 1;
        if (pronadjen == 1) this.predmeti = temp;
        else System.out.println("Nije pronađen predmet pod traženim nazivom!");
    }
    public void ispisiStudenteNaPredmetu(String nazivPredmeta) {
        for (int i = 0; i < predmeti.length; i++)
            if (nazivPredmeta.equals(predmeti[i].getNazivPredmeta())) {
                for (int j = 0; j < predmeti[i].getStudenti().length; j++)
                    System.out.print((predmeti[i].getStudenti())[j]);
                return;
            }
        System.out.println("Nije pronađen predmet pod traženim nazivom!");
    }
    public void upisiStudentaNaPredmet(Integer brojIndeksa, String nazivPredmeta) {
        for (int i = 0; i < predmeti.length; i++)
            if (nazivPredmeta.equals(predmeti[i].getNazivPredmeta())) {
                for (int j = 0; j < this.studenti.length; j++)
                    if (brojIndeksa.equals(this.studenti[j].getBrojIndeksa())) {
                    predmeti[i].upisi(studenti[j]);
                    return;
                    }
                System.out.println("Student s traženim brojem indeksa nije evidentiran na fakultetu!");
                return;
            }
        System.out.println("Predmet pod traženim nazivom ne postoji!");
    }
    public void ispisiStudentaSaPredmeta(Integer brojIndeksa, String nazivPredmeta) {
        for (int i = 0; i < predmeti.length; i++) if (nazivPredmeta.equals(predmeti[i].getNazivPredmeta())) {
            for (int j = 0; j < this.studenti.length; j++)
                if (brojIndeksa.equals(this.studenti[j].getBrojIndeksa())) {
                    predmeti[i].ispisi(studenti[j]);
                    return;
                }
            System.out.println("Student s traženim brojem indeksa nije prijavljen na predmet!");
            return;
        }
        System.out.println("Predmet pod traženim nazivom ne postoji!");
    }
    public static void main(String[] args) {
	    Program program = new Program();
        int odabir = -1;
        while (odabir != 0) {
            System.out.println("Odaberite željenu naredbu:");
            System.out.println("    1 - Dodavanje novog predmeta");
            System.out.println("    2 - Dodavanje novog studenta");
            System.out.println("    3 - Upis studenta na predmet");
            System.out.println("    4 - Ispis studenta sa predmeta");
            System.out.println("    5 - Brisanje predmeta");
            System.out.println("    6 - Brisanje studenta iz evidencije");
            System.out.println("    7 - Ispis spiska studenata na predmetu");
            System.out.println("    0 - Izlaz");
            Scanner scanner = new Scanner(System.in);
            odabir = scanner.nextInt();
            switch (odabir) {

                case 0:
                {
                    return;
                }
                case 1: {
                    Scanner unos = new Scanner(System.in);
                    System.out.println("Unesite, redom, naziv predmeta, šifru predmeta i maksimalan broj studenata:");
                    String nazivPredmeta = unos.nextLine();
                    unos = new Scanner(System.in);
                    int sifraPredmeta = unos.nextInt();
                    unos = new Scanner(System.in);
                    int maxBrojStudenata = unos.nextInt();
                    program.dodajPredmet(nazivPredmeta,sifraPredmeta,maxBrojStudenata);
                    break;
                }
                case 2: {
                    Scanner unos = new Scanner(System.in);
                    System.out.println("Unesite, redom, ime studenta, prezime studenta i broj indeksa");
                    String ime = unos.nextLine();
                    unos = new Scanner(System.in);
                    String prezime = unos.nextLine();
                    unos = new Scanner(System.in);
                    int brojIndeksa = unos.nextInt();
                    program.dodajStudenta(new Student(ime, prezime, brojIndeksa));
                    break;
                }
                case 3: {
                    System.out.println("Unesite, redom, broj indeksa studenta i naziv predmeta");
                    Scanner unos = new Scanner(System.in);
                    int brojIndeksa = unos.nextInt();
                    unos = new Scanner(System.in);
                    String nazivPredmeta = unos.nextLine();
                    program.upisiStudentaNaPredmet(brojIndeksa,nazivPredmeta);
                    break;
                }
                case 4: {
                    System.out.println("Unesite, redom, broj indeksa studenta i naziv predmeta");
                    Scanner unos = new Scanner(System.in);
                    int brojIndeksa = unos.nextInt();
                    unos = new Scanner(System.in);
                    String nazivPredmeta = unos.nextLine();
                    program.ispisiStudentaSaPredmeta(brojIndeksa,nazivPredmeta);
                    break;
                }
                case 5: {
                    System.out.println("Upišite ime predmeta kojeg želite obrisati");
                    Scanner unos = new Scanner(System.in);
                    String nazivPredmeta = unos.nextLine();
                    program.obrisiPredmet(nazivPredmeta);
                    break;
                }
                case 6: {
                    System.out.println("Unesite indeks studenta kojeg želite obrisati iz evidencije");
                    Scanner unos = new Scanner(System.in);
                    Integer brojIndeksa = unos.nextInt();
                    program.obrisiStudenta(brojIndeksa);
                    break;
                }
                case 7: {
                    Scanner unos = new Scanner(System.in);
                    System.out.println("Unesite naziv predmeta");
                    String nazivPredmeta = unos.nextLine();
                    program.ispisiStudenteNaPredmetu(nazivPredmeta);
                    break;
                }
            }
        }
    }
}
