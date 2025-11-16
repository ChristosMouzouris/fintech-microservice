import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

    public List<Person> topKBalances(int k) throws IOException {
        PriorityQueue<Person> minHeap = new PriorityQueue<>(Comparator.comparing(Person::getBalance));

        for (Person p : repository.getAll()) {
            minHeap.offer(p);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Person> topK = new ArrayList<>(minHeap);
        topK.sort(Comparator.comparing(Person::getBalance).reversed());

        return topK;
    }
}
