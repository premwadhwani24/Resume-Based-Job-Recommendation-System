package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Validated User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     * Get all users.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    /**
     * Get user by name.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    /**
     * Get user by email.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    /**
     * Get user by skills (this implies some relation or search logic).
     */
    @GetMapping("/skills/{skills}")
    public ResponseEntity<User> getUserBySkills(@PathVariable String skills) {
        return ResponseEntity.ok(userService.getUserBySkills(skills));
    }

    /**
     * Get user by education (same assumption as skills).
     */
    @GetMapping("/education/{education}")
    public ResponseEntity<User> getUserByEducation(@PathVariable String education) {
        return ResponseEntity.ok(userService.getUserByEducation(education));
    }
}
