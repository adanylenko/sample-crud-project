package a.danylenko.sampleproject.services.impl;

import java.util.List;
import java.util.Optional;

import a.danylenko.sampleproject.dto.User;
import a.danylenko.sampleproject.exceptions.NoSuchUserException;
import a.danylenko.sampleproject.repositories.UserRepository;
import a.danylenko.sampleproject.services.UserService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
  private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

  private final UserRepository userRepository;

  public UserServiceImpl(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void addUser(final User user) {
    Preconditions.checkNotNull(user, "User can't be null");
    user.setId(null);
    userRepository.save(user);
  }

  @Override
  public void updateUser(final User user) throws NoSuchUserException {
    Preconditions.checkNotNull(user, "User can't be null");
    Preconditions.checkNotNull(user.getId(), "User id can't be null");

    getUserById(user.getId());
    userRepository.save(user);
  }

  @Override
  public void deleteUser(final Long userId) throws NoSuchUserException {
    final User user = getUserById(userId);
    userRepository.delete(user);
  }

  @Override
  public User getUserById(final Long userId) throws NoSuchUserException {
    Preconditions.checkNotNull(userId, "User id can't be null");

    final Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      LOG.warn("User with id:{} not found", userId);
      throw new NoSuchUserException(
          String.format("User with id:%s not found in our records", userId));
    }
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
