package id.corp.examplerabbitmqconsumer.repository;

import id.corp.examplerabbitmqconsumer.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    Products findProductByCategoryId(String categoryId);

}
