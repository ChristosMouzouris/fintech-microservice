import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;

    private final LinkedHashMap<K, V> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cacheMap.get(key);
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public void remove(K key) {
        cacheMap.remove(key);
    }

    public List<V> getAll() {
        return new ArrayList<>(cacheMap.values());
    }
}
