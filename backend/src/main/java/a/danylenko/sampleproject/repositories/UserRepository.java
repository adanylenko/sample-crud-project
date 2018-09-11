package a.danylenko.sampleproject.repositories;

import a.danylenko.sampleproject.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}