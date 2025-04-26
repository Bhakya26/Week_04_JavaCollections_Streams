package java8;
import java.util.*;
import java.util.stream.*;

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.8),
            new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.6),
            new Book("Ender\'s Game", "Orson Scott Card", "Science Fiction", 4.3),
            new Book("The Martian", "Andy Weir", "Science Fiction", 4.4),
            new Book("Ready Player One", "Ernest Cline", "Science Fiction", 4.0),
            new Book("Children of Time", "Adrian Tchaikovsky", "Science Fiction", 4.7),
            new Book("Leviathan Wakes", "James S. A. Corey", "Science Fiction", 4.2),
            new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.3),
            new Book("Ringworld", "Larry Niven", "Science Fiction", 4.1)
        );
        List<List<BookRecommendation>> pages = recommend(books, "Science Fiction", 4.0, 5);

      
        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            pages.get(i).forEach(br -> System.out.println(br.getTitle() + " (" + br.getRating() + ")"));
            System.out.println();
        }
    }

    public static List<List<BookRecommendation>> recommend(
            List<Book> books,
            String genre,
            double minRating,
            int pageSize) {
        List<BookRecommendation> top10 = books.stream()
            .filter(b -> genre.equals(b.getGenre()) && b.getRating() > minRating)
            .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
            .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
            .limit(10)
            .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < top10.size(); i += pageSize) {
            pages.add(top10.subList(i, Math.min(i + pageSize, top10.size())));
        }
        return pages;
    }

    static class Book {
        private final String title;
        private final String author;
        private final String genre;
        private final double rating;
        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getGenre() { return genre; }
        public double getRating() { return rating; }
    }

    static class BookRecommendation {
        private final String title;
        private final double rating;
        public BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }
        public String getTitle() { return title; }
        public double getRating() { return rating; }
    }
}
