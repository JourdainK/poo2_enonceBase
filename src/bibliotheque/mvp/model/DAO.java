package bibliotheque.mvp.model;

import java.util.List;
import java.util.Map;

public interface DAO<T> {

    T add(T t);

    boolean remove(T t);
    T update(T t);

    T read(T rech);

    List<T> getAll();

    Map<String, T> getMapAll();
}
