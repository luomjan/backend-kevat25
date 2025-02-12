package kevat25.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 2, max = 250)
    private String title;

    @NotEmpty(message = "Author cannot be empty")
    @Size(min = 3, max = 250)
    private String author;

    private String isbn;

    @Min(value = 1001, message = "Publication year must be after 1000")
    @Max(value = 2025, message = "Publication year can't be in future")
    private int publicationYear;

    @Min(value = 0, message = "Price can't be negative")
    private double price;

    @JsonIgnoreProperties("books")
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
    }

    public Book(String title, String author, String isbn, int publicationYear, double price, Category category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publicationYear="
                + publicationYear + ", price=" + price + ", category=" + category + "]";
    }

}
