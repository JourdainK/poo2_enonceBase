package bibliotheque.mvp.model;

import bibliotheque.metier.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuteurModel implements DAOAuteur, SpecialAuteur {

    //set to check if it's contained
    private Set<Auteur> sAuthor = new HashSet<>();
    private List<Auteur> lAuthor = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(AuteurModel.class);

    @Override
    public Auteur addAuteur(Auteur aut) {
        boolean check = sAuthor.contains(aut);

        if (!check) {
            sAuthor.add(aut);
            lAuthor.add(aut);
            return aut;
        } else {
            logger.error("Erreur lors de l'ajout de l'auteur");
            return null;
        }
    }

    @Override
    public boolean removeAuteur(Auteur aut) {
        lAuthor.remove(aut);
        return sAuthor.remove(aut);
    }

    @Override
    public Auteur updateAuteur(Auteur aut) {
        boolean isIn = sAuthor.contains(aut);

        if (isIn) {
            int pos = lAuthor.indexOf(aut);
            sAuthor.remove(aut);
            sAuthor.add(aut);
            lAuthor.set(pos, aut);

            return lAuthor.get(pos);
        } else {
            return null;
        }
    }

    @Override
    public Auteur readAuteur(Auteur aut) {
        boolean check = sAuthor.contains(aut);

        if (check) {
            int pos = lAuthor.indexOf(aut);
            return lAuthor.get(pos);
        } else {
            return null;
        }
    }

    @Override
    public List<Auteur> getAuteurs() {
        return lAuthor;
    }

    public Set<Auteur> getSetAuthor() {
        return sAuthor;
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur aut) {
        return aut.getLouvrage();
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur aut, TypeOuvrage to, TypeLivre tl) {
        List<Ouvrage> lOuvr = listerOuvrages(aut);
        List<Ouvrage> lOuvrageSorted = new ArrayList<>();
        for(Ouvrage o : lOuvr){
            if(o.getTo().equals(to)){
                o = (Livre) o;
                if(((Livre) o).getTl().equals(tl)){
                    lOuvrageSorted.add(o);
                }
            }
        }

        return lOuvrageSorted;
    }

    @Override
    public List<Ouvrage> listerOuvrages(String genre) {
        Set<Ouvrage> sOuvr = new HashSet<>();
        List<Ouvrage> lOuvr = new ArrayList<>();
        for(Auteur a : lAuthor){
            sOuvr.addAll(a.getLouvrage());
        }

        for(Ouvrage a : sOuvr){
            if(a.getGenre().equals(genre)){
                lOuvr.add(a);
            }
        }

        return lOuvr;
    }
}
