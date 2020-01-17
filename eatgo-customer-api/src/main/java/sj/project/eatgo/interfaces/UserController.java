package sj.project.eatgo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sj.project.eatgo.application.UserService;
import sj.project.eatgo.domain.User;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {
        String email = resource.getEmail();
        String name = resource.getName();
        String password = resource.getPassword();

        User user = userService.registerUser(email, name, password);

        String url = "/users/" + user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }


}
