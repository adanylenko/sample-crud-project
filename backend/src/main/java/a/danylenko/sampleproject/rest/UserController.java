package a.danylenko.sampleproject.rest;

import java.util.List;

import a.danylenko.sampleproject.dto.ResponseWrapper;
import a.danylenko.sampleproject.dto.User;
import a.danylenko.sampleproject.exceptions.NoSuchUserException;
import a.danylenko.sampleproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<ResponseWrapper<List<User>>> getAllUsers() {
    return ResponseWrapper.success(userService.getAllUsers());
  }

  @GetMapping(value = "{userId}")
  public ResponseEntity<ResponseWrapper<User>> getUserById(
      @PathVariable("userId") final Long userId) throws NoSuchUserException {
    return ResponseWrapper.success(userService.getUserById(userId));
  }

  @DeleteMapping(value = "{userId}")
  public ResponseEntity<ResponseWrapper<String>> deleteUser(
      @PathVariable("userId") final Long userId) throws NoSuchUserException {
    userService.deleteUser(userId);
    return ResponseWrapper.success("Operation success");
  }

  @PostMapping
  public ResponseEntity<ResponseWrapper<String>> updateUser(@RequestBody final User user)
      throws NoSuchUserException {
    userService.updateUser(user);
    return ResponseWrapper.success("Operation success");
  }

  @PutMapping
  public ResponseEntity<ResponseWrapper<String>> addUser(@RequestBody final User user) {
    userService.addUser(user);
    return ResponseWrapper.success("Operation success");
  }
}
