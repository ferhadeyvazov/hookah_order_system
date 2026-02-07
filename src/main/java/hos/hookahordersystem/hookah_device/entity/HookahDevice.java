package hos.hookahordersystem.hookah_device.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="hookah_device")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HookahDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String deviceName;

    @OneToMany(mappedBy = "hookahDevice")
    private List<HookahModel> models;
}
