package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Rayon;

import java.util.List;

public class ExemplaireModel extends AbstractModel<Exemplaire> implements SpecialExemplaire {
    @Override
    public void modifierEtat(Exemplaire ex, String etat) {

    }

    @Override
    public Lecteur LecteurActuel(Exemplaire ex) {
        return ex.lecteurActuel();
    }

    @Override
    public List<Lecteur> lecteurs(Exemplaire ex) {
        return ex.lecteurs();
    }

    @Override
    public void envoiMailLecteurActuel(Exemplaire ex) {
     //TODO envoi mail lecteur
    }

    @Override
    public void envoiMailLecteurs(Exemplaire ex) {
     //TODO envoi mail lecteurs
    }

    @Override
    public boolean enRetard(Exemplaire ex) {
        return ex.enRetard();
    }

    @Override
    public int joursRetard(Exemplaire ex) {
        return ex.joursRetard();
    }

    @Override
    public boolean enLocation(Exemplaire ex) {
        return ex.enLocation();
    }
}
