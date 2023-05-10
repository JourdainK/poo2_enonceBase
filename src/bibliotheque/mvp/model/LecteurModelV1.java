package bibliotheque.mvp.model;


import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LecteurModelV1 implements DAOLecteur,SpecialLecteur {
    private int numcli = 0;
    private List<Lecteur> lecteurs = new ArrayList<>();

    public LecteurModelV1(){

        try {
            populate();
        } catch (Exception e) {
            System.out.println("erreur : "+e);
        }
    }
    @Override
    public Lecteur addLecteur(Lecteur lec) {
        boolean present = lecteurs.contains(lec);
        if (!present) {
            numcli++;
            lec.setNumlecteur(numcli);
            lecteurs.add(lec);
            return lec;
        } else return null;
    }

    @Override
    public boolean removeLecteur(Lecteur lec) {
        return lecteurs.remove(lec);
    }

    @Override
    public Lecteur updateLecteur(Lecteur lecteur) {
        //int idLecteur = lecteur.getNumlecteur();
        int p = lecteurs.indexOf(lecteur);
        if (p < 0) return null;
        lecteurs.set(p, lecteur);//remplacement du lecteur à la même position
        return lecteur;
    }

    @Override
    public Lecteur readLecteur(int idLecteur) {
        for (Lecteur l : lecteurs) {
            if (l.getNumlecteur() == idLecteur) return l;
        }
        return null;
    }

    @Override
    public List<Lecteur> getLecteurs() {
        return lecteurs;
    }

    private void populate() throws Exception {
        Lecteur lec = new Lecteur(0,"Dupont","Jean", LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        addLecteur(lec);
        lec = new Lecteur(0,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        addLecteur(lec);
    }

    @Override
    public List<Exemplaire> exemplairesEnLocation(Lecteur l) {
        return l.listerExemplairesEnLocation();
    }

    @Override
    public List<Exemplaire> exemplairesLoues(Lecteur l) {
        return new ArrayList<>(l.listerExemplairesLoues());
    }

    @Override
    public Lecteur lecParMail(String mail) {
        return null;
    }
}