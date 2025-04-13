package io.github.premwadhwani24.resumeanalyzer.resumeanalyzer.User;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserByName(String name);

    User getUserByEmail(String email);

    User getUserBySkills(String skills );

    User getUserByEducation(String education);
}