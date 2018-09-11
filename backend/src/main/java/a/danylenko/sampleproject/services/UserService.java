package a.danylenko.sampleproject.services;

import java.util.List;

import a.danylenko.sampleproject.dto.User;
import a.danylenko.sampleproject.exceptions.NoSuchUserException;

public interface UserService {
  void addUser(final User user);

  void updateUser(final User user) throws NoSuchUserException;

  void deleteUser(final Long userId) throws NoSuchUserException;

  User getUserById(final Long userId) throws NoSuchUserException;

  List<User> getAllUsers();
}
