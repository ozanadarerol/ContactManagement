import java.util.Scanner;

public class ContactManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        String choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "add":
                    addContact(scanner, contactManager);
                    break;
                case "update":
                    updateContact(scanner, contactManager);
                    break;
                case "remove":
                    removeContact(scanner, contactManager);
                    break;
                case "list":
                    contactManager.listContacts();
                    break;
                case "exit":
                    System.out.println("\nExiting the Contact Management System.");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (!choice.equals("exit"));

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nContact Management System");
        System.out.println("add - Add a new contact");
        System.out.println("update - Update an existing contact");
        System.out.println("remove - Remove a contact");
        System.out.println("list - List all contacts");
        System.out.println("exit - Exit the program");
    }

    private static void addContact(Scanner scanner, ContactManager contactManager) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email);
        contactManager.addContact(newContact);
        System.out.println("\nContact added: " + newContact);
    }

    private static void updateContact(Scanner scanner, ContactManager contactManager) {
        System.out.print("Enter the name of the contact to update: ");
        String name = scanner.nextLine();
        Contact contact = contactManager.getContact(name);

        if (contact != null) {
            System.out.print("Enter new phone number (press enter to skip): ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email (press enter to skip): ");
            String email = scanner.nextLine();

            if (!phoneNumber.isEmpty()) {
                contact.setPhoneNumber(phoneNumber);
            }
            if (!email.isEmpty()) {
                contact.setEmail(email);
            }
            System.out.println("\nContact updated: " + contact);
        } else {
            System.out.println("\nContact not found.");
        }
    }

    private static void removeContact(Scanner scanner, ContactManager contactManager) {
        System.out.print("Enter the name of the contact to remove: ");
        String name = scanner.nextLine();

        if (contactManager.removeContact(name)) {
            System.out.println("\nContact removed.");
        } else {
            System.out.println("\nContact not found.");
        }
    }
}
