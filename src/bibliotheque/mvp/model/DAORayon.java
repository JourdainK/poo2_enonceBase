package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addrayon(Rayon rayon);
    boolean removeRayon(Rayon rayon);
    Rayon updateRayon(Rayon rayon);
    Rayon readRayon(String codeRayon);
    List<Rayon> getRayons();
}
