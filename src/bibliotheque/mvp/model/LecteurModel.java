package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;

public class LecteurModel extends AbstractModel<Lecteur> implements SpecialLecteur {
    private int numLecteur = 0;
    private List<Lecteur> lecteurs = new ArrayList<>();

    public Lecteur add(Lecteur nl){
        Lecteur l = super.add(nl);
        if(l!=null) l.setNumlecteur(++numLecteur);
        return  l;
    }

    @Override
    public List<Exemplaire> exemplairesEnLocation(Lecteur l) {
        return l.listerExemplairesEnLocation();
    }

    @Override
    public List<Exemplaire> exemplairesLoues(Lecteur l) {
        return new ArrayList<>(l.listerExemplairesLoues());
    }
}