package hos.hookahordersystem.orders.entity;

import hos.hookahordersystem.hookah_device.entity.HookahModel;
import hos.hookahordersystem.tables.entity.Tables;
import hos.hookahordersystem.tobacco_brand.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name="table_id", nullable = false)
    private Tables table;

    @ManyToOne
    @JoinColumn(name="hookah_model_id", nullable=false)
    private HookahModel hookahModel;

    private byte tobaccoCount;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;
}
