package com.toofarnottotake.taxibroker.controllers;

import com.toofarnottotake.taxibroker.dtos.JoinPartyRequest;
import com.toofarnottotake.taxibroker.dtos.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index(HttpServletRequest request){
        Cookie[] list = request.getCookies();
        if(list == null){
            return "login";
        }
        for(Cookie cookie : list) {
            if(cookie.getName().equals("userId")){
                var userId = cookie.getValue();
                return "redirect:/" + userId;
            }
        }
        return "login";
    }

    @GetMapping("/{userId}")
    public String redirectToUserPage(
            @PathVariable Long userId,
            Model model){
        JoinPartyRequest party = new JoinPartyRequest();
        party.setUserId(userId);
        model.addAttribute("party", party);
        return "index";
    }
}
