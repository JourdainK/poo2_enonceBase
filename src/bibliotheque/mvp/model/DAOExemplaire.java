package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;

import java.util.List;

public interface DAOExemplaire {

    Exemplaire addExemplaire(Exemplaire exemp);

    boolean removeExemplaire(Exemplaire exemp);

    Exemplaire updateExemplaire(Exemplaire exemp);

    Exemplaire readExemplaire(Exemplaire exemp);

    List<Exemplaire> getExemplaires();

}
