package com.luv2codestudent.Ecommerce.config;

import com.luv2codestudent.Ecommerce.entity.Product;
import com.luv2codestudent.Ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    // Autowired JPA entity manager
    @Autowired
    public MyDataRestConfig (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    };

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST};

        // disable HTTP methods for product: Put, Post and Delete.

        // For Product
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // For ProductCategory
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // call an internal helper method
        exposeIds (config);

    }

    private  void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class> entityCalasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType tempEntityType : entities){
            entityCalasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array entity/domain types
        Class[] domainTypes = entityCalasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    };

}
