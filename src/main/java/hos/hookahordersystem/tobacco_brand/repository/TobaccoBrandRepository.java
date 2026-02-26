package hos.hookahordersystem.tobacco_brand.repository;

import hos.hookahordersystem.tobacco_brand.entity.TobaccoBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TobaccoBrandRepository extends JpaRepository<TobaccoBrand, Byte> {

}
