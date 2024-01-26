import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private final List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public boolean removeContact(String name) {
        return contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public Contact getContact(String name) {
        return contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("\nNo contacts available.");
        } else {
            contacts.forEach(System.out::println);
        }
    }
}