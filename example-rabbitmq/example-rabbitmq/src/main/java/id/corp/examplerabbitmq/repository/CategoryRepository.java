package id.corp.examplerabbitmq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.corp.examplerabbitmq.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
