package com.github.jperucca;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * since <spring-core 4.3>
     * @Autowired is no more needed when constructor has only one injectable dependency
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
