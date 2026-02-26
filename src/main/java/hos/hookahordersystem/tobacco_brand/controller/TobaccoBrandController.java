package hos.hookahordersystem.tobacco_brand.controller;

import hos.hookahordersystem.tobacco_brand.entity.TobaccoBrand;
import hos.hookahordersystem.tobacco_brand.service.TobaccoBrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tobacco-brand")
@AllArgsConstructor
public class TobaccoBrandController {
    private final TobaccoBrandService tobaccoBrandService;

    @PostMapping
    public TobaccoBrand createTobaccoBrand(@RequestBody TobaccoBrand tobaccoBrand) {
        return tobaccoBrandService.createTobaccoBrand(tobaccoBrand);
    }

    @GetMapping
    public List<TobaccoBrand> getAllTobaccoBrands() {
        return tobaccoBrandService.findAllTobaccoBrands();
    }

    @GetMapping("/{id}")
    public TobaccoBrand findTobaccoBrandById(@PathVariable Byte id) {
        return tobaccoBrandService.getTobaccoBrandById(id)
                .orElseThrow(() -> new RuntimeException("Tobacco Brand Not Found"));
    }

    @DeleteMapping("/{id}")
    public String deleteTobaccoBrandById(@PathVariable Byte id) {
        tobaccoBrandService.deleteTobaccoBrand(id);
        return id + " ID Tobacco-Brand was deleted";
    }

    @PutMapping("/{id}")
    public TobaccoBrand uptadeTobaccoBrand(@PathVariable Byte id, @RequestBody TobaccoBrand tobaccoBrand) {
        return tobaccoBrandService.updateBrand(id, tobaccoBrand);
    }

}
