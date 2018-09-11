package a.danylenko.sampleproject.config;

import a.danylenko.sampleproject.repositories.UserRepository;
import a.danylenko.sampleproject.services.UserService;
import a.danylenko.sampleproject.services.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
  @Bean
  public UserService userService(final UserRepository userRepository) {
    return new UserServiceImpl(userRepository);
  }
}
