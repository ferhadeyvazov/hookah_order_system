package hos.hookahordersystem.tobacco_brand.service;

import hos.hookahordersystem.tobacco_brand.entity.Tobacco;
import hos.hookahordersystem.tobacco_brand.entity.TobaccoBrand;
import hos.hookahordersystem.tobacco_brand.repository.TobaccoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TobaccoService {
    private final TobaccoRepository tobaccoRepository;

    //    1. Bütün aktiv tütünləri gətir
    public List<Tobacco> getAllActiveTobaccos() {
        return tobaccoRepository.findByIsActiveTrue();
    }

    //    2. ID ilé tap
    public Tobacco getTobaccoById(Long id) {
        return tobaccoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tobacco not found with id: " + id)
        );
    }

    //    3. Yeni tütün əlavə et
    @Transactional
    public Tobacco createTobacco(String name, TobaccoBrand brand) {
        // BIZNES MƏNTIQ: Eyni adda aktiv tütün varmı yoxla
        tobaccoRepository.findByTobaccoNameAndTobaccoBrand(name, brand)
                .ifPresent(existingTobacco -> {
                    throw new RuntimeException("Bu adda tütün artıq mövcuddur!");
                });
//        Yeni tutun yarat
        Tobacco newTobacco = new Tobacco();
        newTobacco.setTobaccoName(name);
        newTobacco.setTobaccoBrand(brand);
        newTobacco.setIsActive(true);

//        Yeni tobacco-nu gonder database-e, TobaccoRepository vasitesi ile
        return tobaccoRepository.save(newTobacco);
    }

//    4. Tütünü deaktiv et(silmək əvəzinə)
    @Transactional
    public void deactivateTobacco(Long id){
//        Repodan tutunu tap
//        Artiq deaktivdirse xeta ver
//        Aktivdirse Deaktiv Et
//        Yadda saxla
        Tobacco tobacco = tobaccoRepository.findById(id).orElseThrow();
        if(!tobacco.getIsActive()){
            throw new RuntimeException("Bu tütün artıq deaktivdir!");
        }
        tobacco.setIsActive(false);
        tobaccoRepository.save(tobacco);
    }

//    5. Brend uzre aktiv tutunleri tap
    @Transactional
    public List<Tobacco> getActiveTobaccosByBrand(TobaccoBrand brand) {
        return tobaccoRepository.findByIsActiveTrueAndTobaccoBrand(brand);
    }
}
