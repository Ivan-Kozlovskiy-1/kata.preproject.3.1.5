package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
public class UserController {

    @GetMapping()
    public String pageForUser() {
        return "user";
    }
}