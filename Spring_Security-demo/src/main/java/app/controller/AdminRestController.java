package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> userList(){
        List<User> users = userService.listUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> showUser(@PathVariable long id) {
        User user = userService.findUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<List<User>> addUser(@RequestBody User user){
        userService.add(user, user.getRoles());
        List<User> users = userService.listUsers();
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user){
        userService.change(user, user.getRoles());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable long id) {
        userService.delete(id);
        List<User> users = userService.listUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}