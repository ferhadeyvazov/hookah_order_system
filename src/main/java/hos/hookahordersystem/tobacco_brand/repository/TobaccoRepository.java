package hos.hookahordersystem.tobacco_brand.repository;

import hos.hookahordersystem.tobacco_brand.entity.Tobacco;
import hos.hookahordersystem.tobacco_brand.entity.TobaccoBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TobaccoRepository extends JpaRepository<Tobacco, Long> {
    // JpaRepository bizə hazır verir:
    // - save(tobacco)
    // - findById(id)
    // - findAll()
    // - deleteById(id)
    // - count()

    // Özümüz əlavə metodlar yaza bilərik
    // Aktiv tütünləri tap
    List<Tobacco> findByIsActiveTrue();

    // Ad və Brend ilə database-dən sorğula
    Optional<Tobacco> findByTobaccoNameAndTobaccoBrand(String name, TobaccoBrand tobaccoBrand);

//    Brend uzre tap
    List<Tobacco> findByTobaccoBrand(TobaccoBrand brand);

    // Aktiv və brend üzrə
    List<Tobacco> findByIsActiveTrueAndTobaccoBrand(TobaccoBrand brand);
}
