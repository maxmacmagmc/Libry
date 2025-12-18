package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
public class BorrowService {
    @Autowired private BookRepository bookRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private BorrowRecordRepository borrowRecordRepository;

    @Transactional
    public BorrowRecord borrowBook(Long userId,Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("หาไม่เจอหรือเธอไม่มีจริง"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("หล่อนพิมพ์ถูกรึเปล่า"));

        if (book.getStatus() != Book.BookStatus.AVAILABLE) {
            throw new RuntimeException("มีคนมายืมไปก่อนแล้วข่าา ไว้มาใหม่น้าา");
        }

        BorrowRecord Record = new BorrowRecord();
        Record.setUser(user);
        Record.setBook(book);
        Record.setBorrowDate(LocalDate.now());
        Record.setDueDate(LocalDate.now().plusDays(7));

        book.setStatus(Book.BookStatus.BORROWED);
        bookRepository.save(book);

        return borrowRecordRepository.save(Record);

        }

    @Transactional
    public BorrowRecord returnBook(Long borrowId) {
        BorrowRecord record = borrowRecordRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("ไม่เจอรายการยืมนี้"));
        Book book = record.getBook();
        book.setStatus(Book.BookStatus.AVAILABLE);
        bookRepository.save(book);
        record.setReturnDate(LocalDate.now());
        return borrowRecordRepository.save(record);
        }
    }
