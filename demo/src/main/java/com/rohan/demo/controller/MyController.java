package com.rohan.demo.controller;

import com.rohan.demo.dto.Student;
import com.rohan.demo.dto.StudentInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my")

public class MyController {
    @GetMapping("/hello")
    public ResponseEntity<String> printHello() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/get/{id}")

    public ResponseEntity<String> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok("Hello" + id);
    }

    @GetMapping("/myget")
    public ResponseEntity<String> myget(@RequestParam Integer id) {

        return ResponseEntity.ok("Hello" + id);
    }

    @PostMapping("/mypost")

    public ResponseEntity<String> post(@RequestBody Student std) {
        return ResponseEntity.ok("Hello " + std.getName());
    }

    @PostMapping("/mypostwithfile")
    public ResponseEntity<String> post(@ModelAttribute StudentInfo std) {
        return ResponseEntity.ok(String.valueOf(std.getFile().getSize()));
    }


}
