package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addRayon(Rayon r);

    boolean removeRayon(Rayon r);
    Rayon updateRayon(Rayon r);

    Rayon readRayon(int idRayon);

    List<Rayon> getRayons();
}
