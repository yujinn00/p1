package com.example.p1.p1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
    @GetMapping("/ex01") // 주소창이 /ex01일 때
    public String ex01() {
        return "ex01"; // templates 안에 있는 ex01.html 파일을 의미
    }

    @PostMapping("/ex01/answer") // 주소창이 /ex01/answer일 때
    public String ex01Answer(String id, String pw, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "ex01Answer"; // templates 안에 있는 exAnswer.html 파일을 의미
    }
}