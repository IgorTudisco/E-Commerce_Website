package com.luv2codestudent.Ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_category")
// Dessa vez não usaremos a anotação @Data, vamos usar a seguinte anotação
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    // Informa que vai ser ligado de um para muitos do lado do 1, e diz como vai ser mapeado.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> product;

}
