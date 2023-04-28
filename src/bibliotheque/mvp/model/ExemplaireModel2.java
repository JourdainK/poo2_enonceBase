package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Location;

import java.util.ArrayList;
import java.util.List;

public class ExemplaireModel2 implements DAO<Exemplaire>,SpecialExemplaire {
    private int numExemp = 0;
    private List<Exemplaire> ldatas = new ArrayList<>();

    @Override
    public Exemplaire add(Exemplaire exemplaire) {
        if(ldatas.contains(exemplaire)) return null;
        ldatas.add(exemplaire);
        return exemplaire;
    }

    @Override
    public boolean remove(Exemplaire exemplaire) { return ldatas.remove(exemplaire); }

    @Override
    public Exemplaire update(Exemplaire exemplaire) {
        int pos = ldatas.indexOf(exemplaire);
        if(pos < 0) return null;
        ldatas.set(pos,exemplaire);
        return exemplaire;
    }

    @Override
    public Exemplaire read(Exemplaire rech) {
        int pos = ldatas.indexOf(rech);
        if(pos < 0) return null;
        return ldatas.get(pos);
    }

    @Override
    public List<Exemplaire> getAll() {
        return ldatas;
    }

    @Override
    public void modifierEtat(Exemplaire ex, String etat) {
        int pos = ldatas.indexOf(ex);
        if(pos >= 0){
            ldatas.get(pos).setDescriptionEtat(etat);
        }
    }

    @Override
    public Lecteur LecteurActuel(Exemplaire ex) {
        int pos = ldatas.indexOf(ex);
        if(pos < 0)  return null;
        return ldatas.get(pos).lecteurActuel();
    }

    @Override
    public List<Lecteur> lecteurs(Exemplaire ex) {
        List<Lecteur> llect = new ArrayList<>();
        List<Location> lloc;

        lloc = ex.getLloc();
        for(Location l : lloc){
            llect.add(l.getLoueur());
        }
        return llect;
    }


    //TODO specials
    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {

    }

    @Override
    public void envoiMailLecteurs(Exemplaire ex) {

    }

    @Override
    public boolean enRetard(Exemplaire ex) {
        return false;
    }

    @Override
    public int joursRetard(Exemplaire ex) {
        return 0;
    }

    @Override
    public boolean enLocation(Exemplaire ex) {
        return false;
    }
}
