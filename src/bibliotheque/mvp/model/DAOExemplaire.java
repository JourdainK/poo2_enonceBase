package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;

public interface DAOExemplaire {

    Exemplaire addExemplaire(Exemplaire exemp);

    boolean removeExemplaire(Exemplaire exemp);

    Exemplaire updateExemplaire(Exemplaire exemp);


}
