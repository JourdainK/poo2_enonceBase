package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.util.ArrayList;
import java.util.List;

public class AuteurModelV2 implements DAO<Auteur>, SpecialAuteur {
    private int numAuteur = 0;
    private List<Auteur> ldatas = new ArrayList<>();

    @Override
    public Auteur add(Auteur auteur) {
        if(ldatas.contains(auteur)) return null;
        ldatas.add(auteur);
        return auteur;
    }

    @Override
    public boolean remove(Auteur auteur) {
        return ldatas.remove(auteur);
    }

    @Override
    public Auteur update(Auteur auteur) {
        int pos = ldatas.indexOf(auteur);
        if(pos < 0) return null;
        ldatas.set(pos,auteur);
        return auteur;
    }

    @Override
    public Auteur read(Auteur rech) {
        int pos = ldatas.indexOf(rech);
        if(pos < 0) return null;
        return ldatas.get(pos);
    }

    @Override
    public List<Auteur> getAll() {
        return ldatas;
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur a) {
        return null;
    }

    @Override
    public List<Livre> listerLivre(Auteur a, TypeLivre tl) {
        return null;
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur a, String genre) {
        int pos = ldatas.indexOf(a);
        return ldatas.get(pos).getLouvrage();
    }
}
