package bibliotheque.mvp.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Rayon;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.utilitaires.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.affListe;

public class OuvrageViewConsole extends AbstractViewConsole<Ouvrage> {
    @Override
    protected void rechercher() {

    }

    @Override
    protected void modifier() {

    }

    @Override
    protected void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;
        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();
        presenter.add(o);
        //TODO attribuer auteurs, les auteur sont triés par odre de nom et prénom, empêcher doublons
    }

    @Override
    protected void special() {

    }
}
