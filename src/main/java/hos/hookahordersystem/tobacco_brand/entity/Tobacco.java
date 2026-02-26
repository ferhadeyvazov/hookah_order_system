package hos.hookahordersystem.tobacco_brand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tobacco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String tobaccoName;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private TobaccoBrand tobaccoBrand;

    private Boolean isActive;
}
