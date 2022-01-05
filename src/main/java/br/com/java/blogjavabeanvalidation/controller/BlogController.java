package br.com.java.blogjavabeanvalidation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import br.com.java.blogjavabeanvalidation.model.Blog;
import br.com.java.blogjavabeanvalidation.repository.BlogRepository;

@RestController
@RequestMapping("api/v1")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public List<Blog> findAll() {

        return (List<Blog>) blogRepository.findAll();
    }

    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog salvarBlog(@Valid @RequestBody Blog blog) {

        return blogRepository.save(blog);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException  ex) {
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> 
              erros.put(error.getField(), error.getDefaultMessage()));

              return erros;
    }
}
