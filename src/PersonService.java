import java.io.IOException;
import java.util.List;

public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void addPerson(Person p) throws IOException {
        repository.addPerson(p);
    }

    public void updatePerson(Person p) throws IOException {
        repository.updatePerson(p);
    }

    public Person getPersonById(int id) throws IOException {
        return repository.getById(id);
    }

    public List<Person> getAllPeople() throws IOException {
        return repository.getAll();
    }
}
