package hos.hookahordersystem.controller;

import hos.hookahordersystem.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping
    public String createUser(@RequestParam String name) {
//        Biznes mentiqi Buradadir
        if (name == null || name.isBlank()) {
            return "Ad boş ola bilməz";
        }

        if (name.length() < 3) {
            return "Ad ən azı 3 simvol olmalıdır";
        }
        // Business mentiqi bitdi 👆

        userRepository.save(name);
        return "User yaradıldı: " + name;
    }
}
