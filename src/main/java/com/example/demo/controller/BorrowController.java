package com.example.demo.controller;

import com.example.demo.dto.BorrowResponse;
import com.example.demo.model.BorrowRecord;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;


    @PostMapping
    public ResponseEntity<BorrowResponse> borrow(@RequestParam Long userId, @RequestParam Long bookId) {
        BorrowRecord record = borrowService.borrowBook(userId, bookId);

        return ResponseEntity.ok(convertToResponse(record));
    }

    @PutMapping("/return/{borrowId}")
    public ResponseEntity<BorrowResponse> returnBook(@PathVariable Long borrowId) {
        BorrowRecord record = borrowService.returnBook(borrowId);

        return ResponseEntity.ok(convertToResponse(record));
    }

    private BorrowResponse convertToResponse(BorrowRecord record) {
        return new BorrowResponse(
                record.getId(),
                record.getBorrowDate(),
                record.getDueDate(),
                record.getReturnDate(),
                // User info
                record.getUser().getId(),
                record.getUser().getUserName(),
                record.getUser().getEmail(),
                // Book info
                record.getBook().getId(),
                record.getBook().getTitle(),
                record.getBook().getAuthor(),
                record.getBook().getIsbn()
        );
    }
}