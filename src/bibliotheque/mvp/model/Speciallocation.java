package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.util.List;

public interface Speciallocation {
 public double calculerAmende(Location l);
 public void enregistrerRetour(Location l);
}
