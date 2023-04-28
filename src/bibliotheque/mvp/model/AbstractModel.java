package bibliotheque.mvp.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<T> implements DAO<T>{

    private List<T> ldatas = new ArrayList<>();


    @Override
    public T add(T elt) {
        boolean present =ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(T elt) {
        return ldatas.remove(elt);
    }

    @Override
    public T update(T elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        return elt;
    }

    @Override
    public T read(T rech) {
        int p = ldatas.indexOf(rech);
        if(p<0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<T> getAll() {
        return ldatas;
    }



}