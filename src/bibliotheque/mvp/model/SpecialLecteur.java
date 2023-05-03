package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.util.List;
import java.util.Map;

public interface SpecialLecteur {
    public List<Exemplaire> exemplairesEnLocation(Lecteur l);
    public List<Exemplaire> exemplairesLoues(Lecteur l);

}
