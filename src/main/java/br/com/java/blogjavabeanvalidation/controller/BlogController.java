package br.com.java.blogjavabeanvalidation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.java.blogjavabeanvalidation.model.Blog;
import br.com.java.blogjavabeanvalidation.repository.BlogRepository;

@RestController
@RequestMapping("api/v1")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog salvarBlog(@Valid @RequestBody Blog blog) {

        return blogRepository.save(blog);
    }
    
}
