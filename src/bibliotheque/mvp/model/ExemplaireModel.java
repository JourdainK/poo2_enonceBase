package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class ExemplaireModel implements DAOExemplaire{
    private List<Exemplaire> lExemplaires = new ArrayList<>();

    private ExemplaireModel(){

    }

    @Override
    public Exemplaire addExemplaire(Exemplaire exemp) {
        boolean check = lExemplaires.contains(exemp);
        if(!check){
            lExemplaires.add(exemp);
            return exemp;
        }
        else return null;
    }

    @Override
    public boolean removeExemplaire(Exemplaire exemp) {
        return lExemplaires.remove(exemp);
    }

    @Override
    public Exemplaire updateExemplaire(Exemplaire exemp) {
        int pos = lExemplaires.indexOf(exemp);

        if(pos < 0){
            return null;
        } else{
            lExemplaires.set(pos,exemp);
            return exemp;
        }
    }

    @Override
    public Exemplaire readExemplaire(String matricule) {
        for(Exemplaire e : lExemplaires){
            if(e.getMatricule().equals(matricule)){
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Exemplaire> getExemplaires() {
        return lExemplaires;
    }


    //TODO specials
}
