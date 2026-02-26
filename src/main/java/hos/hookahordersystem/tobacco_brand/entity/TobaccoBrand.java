package hos.hookahordersystem.tobacco_brand.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tobacco_brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TobaccoBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(nullable = false)
    private String tobaccoBrand;
    private String imageUrl;

    @Column(nullable = false)
    private Double price;

    @OneToMany(
            mappedBy = "tobaccoBrand",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Tobacco> tobaccos;

}
