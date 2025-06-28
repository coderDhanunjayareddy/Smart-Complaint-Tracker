package com.smart_complaint_tracker.Controller;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.smart_complaint_tracker.Entity.User;
import com.smart_complaint_tracker.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }

        user.setRole("USER");
        userService.saveUser(user);
        return "redirect:/login";
    }

 // Show login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Corresponds to templates/login.html
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        Optional<User> optionalUser = userService.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // (For now) Simple password check - later replace with hashed check
            if (user.getPassword().equals(password)) {
                // ✅ Store userId in session
                session.setAttribute("userId", user.getId());

                // Optionally store user name or role too
                session.setAttribute("userName", user.getName());

                return "redirect:/dashboard";
            }
        }
     // If login fails
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}


