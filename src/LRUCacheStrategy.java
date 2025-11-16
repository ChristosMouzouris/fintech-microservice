import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCacheStrategy<K, V> implements CacheStrategy<K, V> {

    private final int capacity;

    private final LinkedHashMap<K, V> cacheMap;

    public LRUCacheStrategy(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCacheStrategy.this.capacity;
            }
        };
    }

    @Override
    public V get(K key) {
        return cacheMap.get(key);
    }

    @Override
    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    @Override
    public List<V> getAll() {
        return new ArrayList<>(cacheMap.values());
    }

    @Override
    public void clear() {
        cacheMap.clear();
    }

    public void remove(K key) {
        cacheMap.remove(key);
    }
}
