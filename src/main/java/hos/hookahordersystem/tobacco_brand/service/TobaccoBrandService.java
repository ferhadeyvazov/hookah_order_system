package hos.hookahordersystem.tobacco_brand.service;

import hos.hookahordersystem.common.enums.ErrorCode;
import hos.hookahordersystem.common.exceptions.SystemException;
import hos.hookahordersystem.tobacco_brand.entity.TobaccoBrand;
import hos.hookahordersystem.tobacco_brand.repository.TobaccoBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TobaccoBrandService {
    private final TobaccoBrandRepository tobaccoBrandRepository;

    public TobaccoBrand createTobaccoBrand(TobaccoBrand tobaccoBrand) {
        return tobaccoBrandRepository.save(tobaccoBrand);
    }

    public List<TobaccoBrand> findAllTobaccoBrands() {
        return tobaccoBrandRepository.findAll();
    }

    public Optional<TobaccoBrand> getTobaccoBrandById(Byte id) {
        return tobaccoBrandRepository.findById(id);
    }

    public void deleteTobaccoBrand(Byte id) {
        tobaccoBrandRepository.deleteById(id);
    }

    public TobaccoBrand updateBrand(Byte id, TobaccoBrand tobaccoBrand) {
        TobaccoBrand existingBrand = tobaccoBrandRepository.findById(id)
                .orElseThrow(() -> new SystemException(ErrorCode.TOBACCO_BRAND_NOT_FOUND)
                        .addDetail("id", id)
                        .addDetail("tobacco_brand", tobaccoBrand));

        existingBrand.setTobaccoBrand(tobaccoBrand.getTobaccoBrand());
        existingBrand.setImageUrl(tobaccoBrand.getImageUrl());
        existingBrand.setPrice(tobaccoBrand.getPrice());

        return tobaccoBrandRepository.save(existingBrand);
    }
}
