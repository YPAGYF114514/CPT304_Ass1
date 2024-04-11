import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BookSearchStrategy {
    List search(String keyword);
}

class AuthorSearch implements BookSearchStrategy {
    @Override
    public List search(String keyword) {
        List<Book> matchedBooks = new ArrayList();
        List<Book> books = new ArrayList();
        //get book list
        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                books.add(new Book(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Retrieving all the books which matched the user's search query
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);

            if (b.getAuthor().equals(keyword))
                matchedBooks.add(b);

        }

        //Printing all the matched Books
        if (!matchedBooks.isEmpty()) {
            System.out.println("\nThese books are found: \n");

            for (int i = 0; i < matchedBooks.size(); i++) {
                System.out.print(i + "-" + matchedBooks.get(i).getTitle() + " " + matchedBooks.get(i).getAuthor());
            }

            return matchedBooks;
        } else {
            System.out.println("\nSorry. No Books were found related to your query.");
            return null;
        }
    }

}

class TitleSearch implements BookSearchStrategy {
    @Override
    public List search(String keyword) {
        List<Book> matchedBooks = new ArrayList();
        List<Book> books = new ArrayList();
        //get book list
        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                books.add(new Book(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Retrieving all the books which matched the user's search query
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);

            if (b.getTitle().equals(keyword))
                matchedBooks.add(b);

        }

        //Printing all the matched Books
        if (!matchedBooks.isEmpty()) {
            System.out.println("\nThese books are found: \n");

            for (int i = 0; i < matchedBooks.size(); i++) {
                System.out.print(i + "-" + matchedBooks.get(i).getTitle() + " " + matchedBooks.get(i).getAuthor());
            }

            return matchedBooks;
        } else {
            System.out.println("\nSorry. No Books were found related to your query.");
            return null;
        }

    }
}

