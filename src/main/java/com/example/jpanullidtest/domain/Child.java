package com.example.jpanullidtest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CHILD")
public class Child implements Serializable {
    @Id
    @SequenceGenerator(name = "CHILD", sequenceName = "CHILD_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CHILD", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Leaf> leafs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Leaf> getLeafs() {
        if (leafs == null) {
            leafs = new LinkedHashSet<>();
        }
        return leafs;
    }

    public void setLeafs(Set<Leaf> leafs) {
        this.leafs = leafs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id);
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }
        return Objects.hash(id);
    }
}
