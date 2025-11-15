import java.io.IOException;
import java.util.List;

public class JsonPersonRepository implements PersonRepository{
    @Override
    public Person getById(int id) throws IOException {
        return getAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Person> getAll() throws IOException {
        return PersonMapper.loadPeople();
    }

    @Override
    public void addPerson(Person p) throws IOException {
        List<Person> people = PersonMapper.loadPeople();

        people.add(p);
        PersonMapper.savePeople(people);
    }

    @Override
    public void updatePerson(Person p) throws IOException {
        List<Person> people = PersonMapper.loadPeople();

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == p.getId()) {
                people.set(i, p);
                break;
            }
        }

        PersonMapper.savePeople(people);
    }
}
