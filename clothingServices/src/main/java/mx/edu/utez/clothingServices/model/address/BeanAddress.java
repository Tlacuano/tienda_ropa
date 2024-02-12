package mx.edu.utez.clothingServices.model.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.order.BeanOrder;
import mx.edu.utez.clothingServices.model.people.BeanPeople;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "address")
@Entity
public class BeanAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long idAddress;

    //relacion muchos a uno con la tabla people
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanPeople person;

    //relacion uno a muchos con la tabla orders
    @OneToMany(mappedBy = "address")
    private List<BeanOrder> order;

}
