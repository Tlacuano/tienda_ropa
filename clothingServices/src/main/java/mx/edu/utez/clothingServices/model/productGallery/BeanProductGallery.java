package mx.edu.utez.clothingServices.model.productGallery;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product_gallery")
public class BeanProductGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Long idImage;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;


}
