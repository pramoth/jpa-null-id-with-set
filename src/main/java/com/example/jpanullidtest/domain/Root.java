package com.example.jpanullidtest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ROOT")
public class Root implements Serializable {
    @Id
    @SequenceGenerator(name = "ROOT", sequenceName = "ROOT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ROOT", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Child> children;

    public Root() {
    }

    public Root(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Child> getChildren() {
        if(children==null){
            children = new LinkedHashSet<>();
        }
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return Objects.equals(id, root.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
