package sj.project.eatgo.application;

import org.springframework.stereotype.Service;
import sj.project.eatgo.domain.User;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {


    public User registerUser(String email, String name, String password) {
        // TODO : 제대로 된 구현
        return null;
    }
}
