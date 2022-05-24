package com.luv2codestudent.Ecommerce.dao;

import com.luv2codestudent.Ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200") // passing the Angular address
// Especificando o tipo do dado e o caminho, para fugir do padrão.
// O Collection recebe o nome do arquivo Json.
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
