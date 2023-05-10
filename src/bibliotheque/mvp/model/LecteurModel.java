package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecteurModel extends AbstractModel<Lecteur> implements SpecialLecteur {
    private int numLecteur = 0;
    private List<Lecteur> lecteurs = new ArrayList<>();
    private Map<String,Lecteur> hml= new HashMap<>();
    public Lecteur add(Lecteur nl){
        Lecteur l = super.add(nl);
        if(l!=null) {
            l.setNumlecteur(++numLecteur);
            hml.put(l.getMail(),l);
        }
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

    @Override
    public Lecteur lecParMail(String mail) {
        return hml.get(mail);
    }
}