package hos.hookahordersystem.repository;

import org.springframework.stereotype.Repository;

// Data Access Layer.
@Repository
public class UserRepository {

    public void save(String name) {
        System.out.println("DB-yé yazildi: " + name);
    }
}
