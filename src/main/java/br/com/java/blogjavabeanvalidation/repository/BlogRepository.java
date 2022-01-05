package br.com.java.blogjavabeanvalidation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.java.blogjavabeanvalidation.model.Blog;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long>{
    
}
