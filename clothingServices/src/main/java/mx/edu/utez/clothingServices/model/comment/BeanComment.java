package mx.edu.utez.clothingServices.model.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.edu.utez.clothingServices.model.product.BeanProduct;
import mx.edu.utez.clothingServices.model.user.BeanUser;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "comments")
public class BeanComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long idComment;

    //relacion muchos a uno con la tabla products
    @ManyToOne
    @JoinColumn(name = "fk_id_product")
    private BeanProduct product;

    //relacion muchos a uno con la tabla users
    @ManyToOne
    @JoinColumn(name = "fk_id_user")
    private BeanUser user;


}
