package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OuvrageModel implements DAOOuvrage {

    private List<Ouvrage> lOuv = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(OuvrageModel.class);

    @Override
    public Ouvrage addOuvrage(Ouvrage ouv) {
        boolean check = lOuv.contains(ouv);
        if (!check) {
            lOuv.add(ouv);
            return ouv;
        } else {
            logger.error("Erreur d'ajout d'ouvrage");
            return null;
        }
    }

    @Override
    public boolean removeOuvrage(Ouvrage ouv) {
        return lOuv.remove(ouv);
    }

    @Override
    public Ouvrage updateOuvrage(Ouvrage ouv) {
        int posOuv = lOuv.indexOf(ouv);

        if(posOuv >= 0){
            lOuv.set(posOuv,ouv);
            return lOuv.get(posOuv);
        }
        else{
            logger.error("Erreur lors de la mise à jour de l'ouvrage");
            return null;
        }
    }

    @Override
    public Ouvrage readOuvrage(String title) {
        Ouvrage tmp = null;
        for(Ouvrage o : lOuv){
            if(o.getTitre().equals(title)){
                tmp = o;
            }
        }

        if(tmp!=null){
            return  tmp;
        }
        else return null;
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return lOuv;
    }


}
