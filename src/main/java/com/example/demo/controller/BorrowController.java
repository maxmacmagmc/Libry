package com.example.demo.controller;

import com.example.demo.model.BorrowRecord;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public BorrowRecord borrow(@RequestParam Long userId,@RequestParam Long bookId){
        return borrowService.borrowBook(userId,bookId);
    }
    @PutMapping("/return/{borrowId}")
    public BorrowRecord returnBook(@PathVariable Long borrowId) {
        return borrowService.returnBook(borrowId);
    }
}