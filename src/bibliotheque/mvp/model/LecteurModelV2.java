package bibliotheque.mvp.model;


import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecteurModelV2 implements DAO<Lecteur>,SpecialLecteur {
    private int numcli = 0;
    private List<Lecteur> ldatas = new ArrayList<>();
    private int numLecteur = 0;

    private Map<String,Lecteur> mdatas = new HashMap<>();

    @Override
    public boolean remove(Lecteur elt) {
        return ldatas.remove(elt);
    }

    @Override
    public Lecteur update(Lecteur elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        return elt;
    }

    @Override
    public Lecteur read(Lecteur rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Lecteur> getAll() {
        return ldatas;
    }

    @Override
    public Map<String, Lecteur> getMapAll() {
        return mdatas;
    }

    public Lecteur add(Lecteur nl){
        if(ldatas.contains(nl)) return null;
        ldatas.add(nl);
        mdatas.put(nl.getMail(), nl);
        nl.setNumlecteur(++numLecteur);
        return  nl;
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