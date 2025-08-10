package notepad.org;

import java.util.List;
import java.util.Scanner;

public class ForTesting {
    public static void main(String[] args) {
        NoteDAO dao = new NoteDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Digital Note Keeper =====");
            System.out.println("1. Add Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter content: ");
                    String content = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter tags (comma-separated): ");
                    String tags = sc.nextLine();

                    Note newNote = new Note(title, content, category, tags);
                    if (dao.addNote(newNote)) {
                        System.out.println(" Note added successfully!");
                    } else {
                        System.out.println(" Failed to add note.");
                    }
                    break;

                case 2:
                    List<Note> notes = dao.getAllNotes();
                    if (notes.isEmpty()) {
                        System.out.println(" No notes found.");
                    } else {
                        for (Note n : notes) {
                            System.out.println("\n-----------------------------");
                            System.out.println("ID: " + n.getId());
                            System.out.println("Title: " + n.getTitle());
                            System.out.println("Content: " + n.getContent());
                            System.out.println("Category: " + n.getCategory());
                            System.out.println("Tags: " + n.getTags());
                            System.out.println("Created At: " + n.getCreatedAt());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter note ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Note updateNote = dao.getNoteById(updateId);
                    if (updateNote == null) {
                        System.out.println(" Note not found.");
                        break;
                    }

                    System.out.print("New title: ");
                    updateNote.setTitle(sc.nextLine());
                    System.out.print("New content: ");
                    updateNote.setContent(sc.nextLine());
                    System.out.print("New category: ");
                    updateNote.setCategory(sc.nextLine());
                    System.out.print("New tags: ");
                    updateNote.setTags(sc.nextLine());

                    if (dao.updateNote(updateNote)) {
                        System.out.println(" Note updated successfully.");
                    } else {
                        System.out.println(" Failed to update note.");
                    }
                    break;

                case 4:
                    System.out.print("Enter note ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    if (dao.deleteNote(deleteId)) {
                        System.out.println(" Note deleted.");
                    } else {
                        System.out.println(" Could not delete note.");
                    }
                    break;
                    
                case 5:
                    System.out.println(" Exiting. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}