package mx.edu.utez.clothingServices.model.orderStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.order.BeanOrder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_status")
public class BeanOrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_status")
    private Long idOrderStatus;

    //relacion uno a muchos con la tabla orders
    @OneToMany(mappedBy = "orderStatus")
    private List<BeanOrder> orders;

}
