package br.com.java.blogjavabeanvalidation.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, message = "O título do blog deve ter pelo menos 2 caracteres")
    private String blogTitulo;

    @NotBlank(message = "O editor do blog não pode ficar em branco")
    private String blogEditor;

    @Email(message = "Email deve ser válido")
    private String blogEmail;

    public Blog() {
    }
    
    public Blog(long id,
            @NotNull @Size(min = 2, message = "O título do blog deve ter pelo menos 2 caracteres") String blogTitulo,
            @NotBlank(message = "O editor do blog não pode ficar em branco") String blogEditor,
            @Email(message = "Email deve ser válido") String blogEmail) {
        this.id = id;
        this.blogTitulo = blogTitulo;
        this.blogEditor = blogEditor;
        this.blogEmail = blogEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlogTitulo() {
        return blogTitulo;
    }

    public void setBlogTitulo(String blogTitulo) {
        this.blogTitulo = blogTitulo;
    }

    public String getBlogEditor() {
        return blogEditor;
    }

    public void setBlogEditor(String blogEditor) {
        this.blogEditor = blogEditor;
    }

    public String getBlogEmail() {
        return blogEmail;
    }

    public void setBlogEmail(String blogEmail) {
        this.blogEmail = blogEmail;
    }
}

