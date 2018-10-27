package ba.unsa.etf.rpr;

public class Predmet {
    private Student[] studenti = null;
    private String nazivPredmeta = null;
    private Integer sifraPredmeta = null;
    private Integer maksimalanBrojStudenata = 0;

    public Predmet(Student[] studenti, String nazivPredmeta, Integer sifraPredmeta, Integer maksimalanBrojStudenata) {
        this.studenti = studenti;
        this.nazivPredmeta = nazivPredmeta;
        this.sifraPredmeta = sifraPredmeta;
        this.maksimalanBrojStudenata = maksimalanBrojStudenata;
    }

    public Student[] getStudenti() {
        return studenti;
    }

    public void setStudenti(Student[] studenti) {
        this.studenti = studenti;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public Integer getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(Integer sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }
    public boolean daLiJeStudentUpisan(Student student) {
        for (int i = 0; i < this.studenti.length; i++) if (this.studenti[i].getBrojIndeksa() == student.getBrojIndeksa()) return true;
        return false;
    }
    public void upisi(Student student) {
        if (studenti.length == 0 || studenti == null) {
            studenti = new Student[1];
            studenti[0] = student;
        }
        else if (studenti.length == maksimalanBrojStudenata) {
            System.out.println("Broj studenata na izabranom predmetu je popunjen");
        }
        else if (this.daLiJeStudentUpisan(student)) System.out.println("Taj student je već upisan na ovaj predmet");
        else {
            Student[] pomocni = new Student[studenti.length + 1];
            for (int i = 0; i < studenti.length; i++) pomocni[i] = studenti[i];
            pomocni[studenti.length] = student;
            studenti = pomocni;
            System.out.println("Student je uspješno upisan na predmet!");
        }
    }
    public void ispisi(Student student) {
        if (this.studenti.length == 0) {
            System.out.println("Spisak studenata je već prazan");
        }
        else if (!this.daLiJeStudentUpisan(student)) System.out.println("Taj student nije upisan na ovaj predmet");
        else {
            Student[] pomocni = new Student[studenti.length - 1];
            int pronadjen = 0;
            for (int i = 0; i < studenti.length; i++) {
                if (student.getBrojIndeksa() != studenti[i].getBrojIndeksa()) pomocni[i-pronadjen] = studenti[i];
                else pronadjen = 1;
            }
            System.out.println("Student je uspješno obrisan sa predmeta!");
        }
    }


}
