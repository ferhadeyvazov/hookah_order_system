package hos.hookahordersystem.tobacco_brand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tobacco_brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TobaccoBrand {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String tobaccoBrand;
    private String imageUrl;
    private Double price;

    @OneToMany(mappedBy = "tobaccoBrand")
    List<Product> products;

}
