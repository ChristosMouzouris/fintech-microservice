//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PersonRepository jsonRepo = new JsonPersonRepository();
        PersonRepository cachedRepo = new CachedPersonRepository(jsonRepo, new LRUCacheStrategy<>(100));
        PersonService service = new PersonService(cachedRepo);
    }
}