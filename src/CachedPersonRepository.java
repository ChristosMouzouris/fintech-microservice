import java.io.IOException;
import java.util.List;

public class CachedPersonRepository implements PersonRepository {

    private final PersonRepository delegate;
    private final CacheStrategy<Integer, Person> cache;

    public CachedPersonRepository(PersonRepository delegate, CacheStrategy<Integer, Person> cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    @Override
    public Person getById(int id) throws IOException {
        Person p = cache.get(id);
        if (p == null) {
            p = delegate.getById(id);
            if (p != null) {
                cache.put(id, p);
            }
        }
        return p;
    }

    @Override
    public List<Person> getAll() throws IOException {
        if (cache.getAll().isEmpty()) {
            List<Person> allPeople = delegate.getAll();
            for (Person p : allPeople) {
                cache.put(p.getId(), p);
            }
        }
        return cache.getAll();
    }

    @Override
    public void addPerson(Person p) throws IOException {
        delegate.addPerson(p);
        cache.put(p.getId(), p);
    }

    @Override
    public void updatePerson(Person p) throws IOException {
        delegate.updatePerson(p);
        cache.put(p.getId(), p);
    }
}
