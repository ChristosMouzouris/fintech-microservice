import java.util.List;

public interface CacheStrategy<K, V> {
    V get(K key);
    void put(K key, V Value);
    List<V> getAll();
    void clear();
}
