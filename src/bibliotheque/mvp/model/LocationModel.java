package bibliotheque.mvp.model;

import bibliotheque.metier.Location;

import java.util.Map;

public class LocationModel extends AbstractModel<Location> implements Speciallocation{
    @Override
    public double calculerAmende(Location l) {
        return l.calculerAmende();
    }

    @Override
    public void enregistrerRetour(Location l) {
        l.enregistrerRetour();
    }

    @Override
    public Map<String, Location> getMapAll() {
        //TODO
        return null;
    }
}
