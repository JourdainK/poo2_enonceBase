package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon {
    private List<Rayon> lRayons = new ArrayList<>();

    public RayonModel() {
        populate();
    }

    @Override
    public Rayon addrayon(Rayon rayon) {
        boolean check = lRayons.contains(rayon);
        if (!check) {
            lRayons.add(rayon);
            return rayon;
        } else return null;
    }

    @Override
    public boolean removeRayon(Rayon rayon) {
        return lRayons.remove(rayon);
    }

    @Override
    public Rayon updateRayon(Rayon rayon) {
        int pos = lRayons.indexOf(rayon);
        if(pos < 0) {
            return null;
        }else {
            lRayons.set(pos,rayon);
            return rayon;
        }
    }

    @Override
    public Rayon readRayon(String codeRayon) {
        for(Rayon r:lRayons){
            if(r.getCodeRayon().equalsIgnoreCase(codeRayon)){
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Rayon> getRayons() {
        return lRayons;
    }


    public void populate(){
        Rayon r1 = new Rayon("1CR","Rock");
        Rayon r2 = new Rayon("1LC","Comédies");
        Rayon r3 = new Rayon("1LE","Essais");
        Rayon r4 = new Rayon("1DC","Comédies");
        lRayons.add(r1);
        lRayons.add(r2);
        lRayons.add(r3);
        lRayons.add(r4);
    }
}
