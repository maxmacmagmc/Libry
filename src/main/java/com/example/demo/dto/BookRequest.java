package com.example.demo.dto;

import com.example.demo.model.Book.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequest {
    @NotBlank(message = "ใส่ชื่อหนังสือด้วยจ้า")
    private String title ;

    @NotBlank(message = "เล่นนี้ใครเขียนคะ")
    private String author ;

    @Size(min = 10, max = 13, message = "ISBN มันมี 13 ตัวค่ะน้องดูดีๆเนาะ")
    private String isbn;
}