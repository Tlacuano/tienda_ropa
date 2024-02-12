package mx.edu.utez.clothingServices.model.variant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;
import mx.edu.utez.clothingServices.model.size.BeanSizes;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "variants")
public class BeanVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variant")
    private Long idVariant;

    //relacion muchos a uno con la tabla sizes
    @ManyToOne
    @JoinColumn(name = "fk_id_size")
    private BeanSizes size;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;

}
