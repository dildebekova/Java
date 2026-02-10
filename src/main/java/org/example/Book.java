package org.example;

import java.util.Scanner;

public class Book {
    private final String title;
    private final String author;
    private final int year;
    private boolean isAvailable;

    // Параметризированный конструктор
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    // Конструктор копирования
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.year = other.year;
        this.isAvailable = other.isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("📕 Book borrowed successfully.");
        } else {
            System.out.println("❌ Book is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("📗 Book returned successfully.");
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author +
                ", Year: " + year +
                ", Available: " + isAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return title.equals(other.title)
                && author.equals(other.author)
                && year == other.year;
    }
}

class EBook extends Book {
    private double fileSize; // MB

    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "[E-Book] " + super.toString() +
                ", File Size: " + fileSize + "MB";
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            System.out.println("✅ Book added to library.");
        } else {
            System.out.println("❌ Library is full.");
        }
    }

    public void displayBooks() {
        if (count == 0) {
            System.out.println("📭 Library is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    public Book searchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void borrowBook(String title) {
        Book book = searchByTitle(title);
        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("❌ Book not found.");
        }
    }

    public void returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("❌ Book not found.");
        }
    }
}


class MainBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10);

        while (true) {
            System.out.println("\n📚 Library Management System");
            System.out.println("1. Add book");
            System.out.println("2. Add e-book");
            System.out.println("3. Display all books");
            System.out.println("4. Search book by title");
            System.out.println("5. Borrow book");
            System.out.println("6. Return book");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();

                    library.addBook(new Book(title, author, year));
                }

                case 2 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("File size (MB): ");
                    double size = scanner.nextDouble();

                    library.addBook(new EBook(title, author, year, size));
                }

                case 3 -> library.displayBooks();

                case 4 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Book book = library.searchByTitle(title);
                    System.out.println(book != null ? book : "❌ Book not found.");
                }

                case 5 -> {
                    System.out.print("Enter title: ");
                    library.borrowBook(scanner.nextLine());
                }

                case 6 -> {
                    System.out.print("Enter title: ");
                    library.returnBook(scanner.nextLine());
                }

                case 7 -> {
                    System.out.println("👋 Goodbye!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
