import java.io.IOException;
import java.util.List;

public interface PersonRepository {

    public Person getById(int id) throws IOException;

    public List<Person> getAll() throws IOException;

    void addPerson(Person p) throws IOException;

    void updatePerson(Person p) throws IOException;
}
