package hos.hookahordersystem.hookah_device.entity;

import hos.hookahordersystem.orders.entity.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hookah_model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HookahModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="device_id")
    private HookahDevice hookahDevice;

    private String model;

    @Column(name="model_count")
    private Integer modelCount;

    @Column(name = "model_image_url")
    private String deviceImageUrl;

    @OneToMany(mappedBy = "hookahModel")
    private List<Orders> orders=new ArrayList<>();
}
