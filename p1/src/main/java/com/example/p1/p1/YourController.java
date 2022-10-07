package com.example.p1.p1;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 클래스 위의 @Controller 필수
public class YourController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login/check")
    public String loginCheck(HttpSession session, String id/* , Model model */) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("고흐");
        list.add("james");
        list.add("dooli");
        list.add("bread");
        if (list.contains(id)) {
            session.setAttribute("id", id);
            // model.addAttribute("id", id);
            // return "menu";
            return "redirect:/menu";
            // "/menu" 메소드와 "redirect:/menu" 반환을 없앤 뒤,
            // "menu"를 반환하면 변수 출력 X
            // "menu"를 반환하여 변수를 정상적으로 출력하려면 위의 주석을 활성화
        }
        else {
            return "popups";
        }
    }

    @GetMapping("/menu")
    public String menu(HttpSession session, Model model) {
        model.addAttribute("id", session.getAttribute("id"));
        return "menu";
    }

    // @GetMapping("/popups")
    // public String popups() {
    //     return "popups";
    // }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        model.addAttribute("id", session.getAttribute("id"));
        session.invalidate();
        return "logout";
    }

    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @PostMapping("/survey1")
    public String survey1(HttpSession session, String id) {
        session.setAttribute("id", id);
        return "survey1";
    }

    @PostMapping("/survey2")
    public String survey2(HttpSession session, String artist) {
        session.setAttribute("artist", artist);
        return "survey2";
    }

    @PostMapping("/thanks")
    public String thanks(HttpSession session, String musician) {
        session.setAttribute("musician", musician);
        return "thanks";
    }

    @GetMapping("/result")
    public String result(HttpSession session, Model model) {
    model.addAttribute("id", session.getAttribute("id"));
    model.addAttribute("artist", session.getAttribute("artist"));
    model.addAttribute("musician", session.getAttribute("musician"));
    return "result";
    }

    @GetMapping("/phone")
    public String phone() {
        return "phone";
    }

    @PostMapping("/phone/result")
    public String phoneresult(HttpSession session, String company, String model, Model modell) {
        String msg;
        if (company.equals("삼성") || company.equals("애플")) { // ==이 아닌 equals를 사용할 것
            msg = company + " " + model + "를 선택해 주셔서 감사합니다 !!";
            session.setAttribute("company", company);
            session.setAttribute("model", model);
        } else {
            msg = "해당 회사의 제품은 매진되었습니다.";
        }
        modell.addAttribute("msg", msg);
        return "phoneThanks";
    }

    @GetMapping("/phone/session")
    public String phonesession(HttpSession session, Model model) {
        model.addAttribute("company", session.getAttribute("company"));
        model.addAttribute("model", session.getAttribute("model"));
        session.invalidate();
        return "phoneSession";
    }
}