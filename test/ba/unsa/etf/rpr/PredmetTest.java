package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void getStudenti() {  // ujedno testiramo i metode upisi i ispisi
        Predmet p = new Predmet("RPR", 1, 33);
        Student[] studenten = new Student[3];
        Student s1 = new Student("Rizzo","Ruža",999);
        Student s2 = new Student("Nino", "Pršeš", 812);
        Student s3 = new Student("Fuad", "Backović", 17);
        studenten[0] = s1;
        studenten[1] = s2;
        studenten[2] = s3;
        p.upisi(s1); p.upisi(s2); p.upisi(s3);
        assertArrayEquals(studenten, p.getStudenti());
        p.ispisi(s2);
        studenten = new Student[2];
        studenten[0] = s1;
        studenten[1] = s3;
        assertArrayEquals(studenten, p.getStudenti());
    }

    @Test
    void getNazivPredmeta() {
        assertEquals("RPR", (new Predmet("RPR", 1, 120)).getNazivPredmeta());
    }

    @Test
    void getSifraPredmeta() {
        assertEquals((Integer)1, (Integer)((new Predmet("RPR", 1, 120)).getSifraPredmeta()));
    }

    @Test
    void daLiJeStudentUpisan() {
        Student s = new Student("Edin", "Dzeko", 1);
        Predmet p = new Predmet("RPR", 1,1);
        p.upisi(s);
        boolean rezultat = p.daLiJeStudentUpisan(s);
        Predmet p2 = new Predmet("Priroda i drustvo", 2, 16);
        assertTrue(rezultat);
        rezultat = p2.daLiJeStudentUpisan(s);
        assertFalse(rezultat);
    }
}