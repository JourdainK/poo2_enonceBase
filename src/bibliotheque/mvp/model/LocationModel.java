package bibliotheque.mvp.model;

import bibliotheque.metier.Location;

public class LocationModel extends AbstractModel<Location> implements Speciallocation{
    @Override
    public double calculerAmende(Location l) {
        return l.calculerAmende();
    }

    @Override
    public void enregistrerRetour(Location l) {
        l.enregistrerRetour();
    }
}
