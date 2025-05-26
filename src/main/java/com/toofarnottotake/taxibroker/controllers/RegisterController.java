package com.toofarnottotake.taxibroker.controllers;

import com.toofarnottotake.taxibroker.dtos.RegisterUserRequest;
import com.toofarnottotake.taxibroker.mappers.UserMapper;
import com.toofarnottotake.taxibroker.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute("user", new RegisterUserRequest());
        return "register";
    }

    @PostMapping
    public String registerUser(RegisterUserRequest request){
        System.out.println(userRepository.findByEmail(request.getEmail()));
        if(userRepository.findByEmail(request.getEmail()).toArray().length!=0){
            return "redirect:/register?invalidemail";
        }
        userRepository.save(userMapper.toEntity(request));
        return "redirect:/login?registered";
    }
}
