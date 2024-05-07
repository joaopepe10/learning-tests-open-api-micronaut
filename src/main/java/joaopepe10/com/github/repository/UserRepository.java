package joaopepe10.com.github.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import joaopepe10.com.github.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
