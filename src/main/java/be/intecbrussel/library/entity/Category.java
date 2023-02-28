package be.intecbrussel.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true )
    private String name;

    @ManyToMany(mappedBy = "categories",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Book> Books=new HashSet<Book>();

    public Category(String name) {
        this.name = name;
    }
}
