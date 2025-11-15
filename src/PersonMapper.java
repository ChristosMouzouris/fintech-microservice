import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper {
    private static final String FILE_PATH = "resources/people.json";

    public static List<Person> loadPeople() throws IOException {
        List<Person> people = new ArrayList<>();
        File file = new File(FILE_PATH);
        ObjectMapper mapper = new ObjectMapper();

        try (MappingIterator<Person> iterator = mapper.readerFor(Person.class).readValues(file)) {
            while (iterator.hasNext()) {
                Person person = iterator.next();
                people.add(person);
            }
        }

        return people;
    }

    public static void savePeople(List<Person> people) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), people);
    }
}
