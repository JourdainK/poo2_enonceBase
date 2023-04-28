package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;

import java.util.List;

public interface SpecialExemplaire {
  public void modifierEtat(Exemplaire ex,String etat);
  public Lecteur lecteurActuel(Exemplaire ex);

  public List<Lecteur> lecteurs(Exemplaire ex);

  public void envoiMailLecteurActuel(Exemplaire ex);

  public void envoiMailLecteurs(Exemplaire ex);

  public boolean enRetard(Exemplaire ex);

  public int joursRetard(Exemplaire ex);

  public boolean enLocation(Exemplaire ex);
}
