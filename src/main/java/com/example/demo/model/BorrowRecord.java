package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "borrow_records")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; // เชื่อมไปหา Book

    private LocalDate borrowDate; // วันที่ยืม
    private LocalDate dueDate;    // กำหนดคืน
    private LocalDate returnDate; // วันที่คืนจริง (ถ้าเป็น null แปลว่ายังไม่คืน)
}