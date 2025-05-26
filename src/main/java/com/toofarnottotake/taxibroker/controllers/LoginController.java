package com.toofarnottotake.taxibroker.controllers;

import com.toofarnottotake.taxibroker.dtos.LoginRequest;
import com.toofarnottotake.taxibroker.dtos.RegisterUserRequest;
import com.toofarnottotake.taxibroker.entities.User;
import com.toofarnottotake.taxibroker.mappers.UserMapper;
import com.toofarnottotake.taxibroker.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @GetMapping
    public String login(Model model){
        model.addAttribute("user", new LoginRequest());
        return "login";
    }

    @PostMapping
    public String login(LoginRequest request,
                        HttpServletResponse response){
        if(userRepository.findByEmail(request.getEmail()) == null){
            return "redirect:/login?error";
        }
        var users = userRepository.findByEmail(request.getEmail());
        for (User user : users) {
            if(user.getPassword().equals(request.getPassword())){
                Cookie cookie = new Cookie("userId", user.getId().toString());
                cookie.setDomain("localhost");
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
                return "redirect:/";
            }
        }
        return "redirect:/login?error";
    }
}
