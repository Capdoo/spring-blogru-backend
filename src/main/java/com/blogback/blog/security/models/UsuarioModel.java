package com.blogback.blog.security.models;

import com.blogback.blog.posts.models.PostModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    private String apellidos;

    private String nombre;

    @Column(unique = true)
    private String nombreUsuario;

    private String email;

    private String password;

    @ManyToMany(fetch=FetchType.EAGER)

    @JoinTable(name="usuario_roles", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<RolModel> roles = new HashSet<>();

    @OneToMany(mappedBy="usuario")
    private Set<PostModel> posts;

    public UsuarioModel() {
        super();
    }

    public UsuarioModel(String apellidos, String nombre, String nombreUsuario, String email, String password) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RolModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolModel> roles) {
        this.roles = roles;
    }

}
