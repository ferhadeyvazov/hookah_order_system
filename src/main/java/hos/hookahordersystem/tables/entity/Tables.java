package hos.hookahordersystem.tables.entity;

import hos.hookahordersystem.orders.entity.Orders;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableNumber;

    @OneToMany(mappedBy = "table")
    private List<Orders> orders =  new ArrayList<>();
}
