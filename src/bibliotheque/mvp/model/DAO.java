package bibliotheque.mvp.model;

import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {

    T add(T t);

    boolean remove(T t);
    T update(T t);

    T read(T rech);

    List<T> getAll();
}
