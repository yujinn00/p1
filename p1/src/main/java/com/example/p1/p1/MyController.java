package com.example.p1.p1;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 클래스 위의 @Controller 필수
public class MyController {
    @GetMapping("/") // 서버 접속 첫 화면을 의미 // YourController.java도 연동
    public String home() {
        return "home"; // static 폴더의 index.html보다 Controller 코딩이 우선순위
    }
    
    @GetMapping("/ex01") // 주소창이 /ex01일 때
    public String ex01() {
        return "ex01"; // templates 안에 있는 ex01.html 파일을 의미
    }

    @PostMapping("/ex01/answer") // 주소창이 /ex01/answer일 때
    public String ex01Answer(String id, String pw, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "ex01Answer"; // templates 안에 있는 ex01Answer.html 파일을 의미
    }

    @GetMapping("/ex02") // 주소창이 /ex02일 때
    public String ex02() {
        return "ex02"; // templates 안에 있는 ex02.html 파일을
    }

    @PostMapping("/ex02/answer") // 주소창이 /ex01/answer일 때
    public String ex02Answer(String name, String po, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("po", po);
        int salary = 0;
        switch(po) {
            case "사원" -> salary = 3500;
            case "대리" -> salary = 5000;
            case "팀장" -> salary = 7000;
            case "임원" -> salary = 9900;
        }
        model.addAttribute("salary", salary);
        return "ex02Answer";
    }

    @GetMapping("/wise") // 주소창이 /wise일 때
    public String wise() {
        return "wise"; // templates 안에 있는 wise.html 파일을 의미
    }

    @PostMapping("/wise/answer") // 주소창이 /wise/answer일 때
    public String wiseAnswer(String name, String saying, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("saying", saying);
        return "wiseAnswer"; // templates 안에 있는 wiseAnswer.html 파일을 의미
    }

    @GetMapping("/bread") // 주소창이 /bread일 때
    public String bread() {
        return "bread"; // templates 안에 있는 bread.html 파일을 의미
    }

    @PostMapping("/bread/answer") // 주소창이 /bread/answer일 때
    public String breadAnswer(String bread, int price, String buy, Model model) {
        model.addAttribute("bread", bread);
        model.addAttribute("price", price);
        model.addAttribute("buy", buy);
        int money = 0;
        switch(buy) {
            case "1개" -> money = price * 1;
            case "2개" -> money = price * 2;
            case "3개" -> money = price * 3;
            case "4개" -> money = price * 4;
            case "5개" -> money = price * 5;
        }
        model.addAttribute("money", money);
        return "breadAnswer"; // templates 안에 있는 breadAnswer.html 파일을 의미
    }

    @GetMapping("/ex03")
    public String ex03() {
        return "ex03";
    }
    
    @PostMapping("/ex03/answer")
    public String ex03Answer(String name, String color, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("color", color);
        return "ex03Answer";
    }

    @GetMapping("/ex04")
    public String ex04Answer(Model model) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("고흐");
        list.add("james");
        list.add("dooli");
        list.add("bread");
        model.addAttribute("list", list);
        return "ex04";
    }

    @GetMapping("/q06")
    public String q06() {
        return "q06";
    }
    
    @GetMapping("/q06/a")
    public String q06a() {
        return "q06a";
    }

    @GetMapping("/q06/b")
    public String q06b() {
        return "q06b";
    }

    @PostMapping("/q06/aa")
    public String q06aa(String first, String second, Model model) {
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        return "q06aa";
    }

    @PostMapping("/q06/bb")
    public String q06bb(String position, Model model) {
        model.addAttribute("position", position);
        return "q06bb";
    }
}