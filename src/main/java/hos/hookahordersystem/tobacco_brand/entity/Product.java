package hos.hookahordersystem.tobacco_brand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tobaccoName;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private TobaccoBrand tobaccoBrand;

    private Boolean isActive;
}
