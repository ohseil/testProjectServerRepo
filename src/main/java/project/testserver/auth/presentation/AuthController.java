package project.testserver.auth.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @GetMapping
    ResponseEntity<String> login(@RequestParam final String code) {
        return ResponseEntity.ok("hello " + code);
    }

    @GetMapping(value = "/redirect")
    ResponseEntity<String> redirect() {
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "http://127.0.0.1:8080/auth/end").body("redirect");
    }

    @GetMapping(value = "/end")
    ResponseEntity<String> end() {
        System.out.println("1");
        return ResponseEntity.ok("end");
    }
}
