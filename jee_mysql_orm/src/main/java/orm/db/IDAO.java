
package orm.db;

import java.util.List;

/**
 * Interface for ORM persistence
 * 
 * *** NOTHING TO DO HERE ***
 *
 * @author hajo
 * @param <T> The type
 * @param <K> key type
 */
public interface IDAO<T, K> {

    void add(T data);

    void delete(K id);

    void update(T data);

    T getById(K id);

    List<T> get();

    List<T> get(int maxResults, int firstResult);

    int size();

}
