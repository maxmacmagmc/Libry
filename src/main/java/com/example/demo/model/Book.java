package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data // Lombok: สร้าง Getter/Setter/ToString ให้เอง
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private BookStatus status; // สร้าง Enum: AVAILABLE, BORROWED
    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        LOST
    }
}