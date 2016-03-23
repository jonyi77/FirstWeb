package ua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("select u from User u where u.login = :login")
	User findByLogin(@Param("login")String login);
	
	@Query("select u from User u where u.email = :email")
	User findByEmail(@Param("email")String email);

}
