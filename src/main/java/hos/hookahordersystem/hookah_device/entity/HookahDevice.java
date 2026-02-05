package hos.hookahordersystem.hookah_device.entity;

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
public class HookahDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="device_name")
    private String deviceName;

    private String model;

    @Column(name="model_count")
    private Integer modelCount;

    @Column(name = "model_image_url")
    private String deviceImageUrl;
}
