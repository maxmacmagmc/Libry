package com.example.demo.dto;

import java.time.LocalDate;

public class BorrowResponse {
    private Long id;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private Long userId;
    private String userName;
    private String userEmail;

    private Long bookId;
    private String title;
    private String author;
    private String isbn;


    public BorrowResponse(Long id, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate,
                          Long userId, String userName, String userEmail,
                          Long bookId, String title, String author, String isbn) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Long getId() { return id; }

    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public Long getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }

    public Long getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

}