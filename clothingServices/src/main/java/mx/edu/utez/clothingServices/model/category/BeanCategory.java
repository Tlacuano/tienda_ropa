package mx.edu.utez.clothingServices.model.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "categories")
@Entity
public class BeanCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    //relacion uno a muchos con la tabla products
    @OneToMany(mappedBy = "category")
    private List<BeanProduct> products;
}
