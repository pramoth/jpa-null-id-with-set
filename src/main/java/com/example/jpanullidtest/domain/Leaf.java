package com.example.jpanullidtest.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LEAF")
public class Leaf implements Serializable {
    @Id
    @SequenceGenerator(name = "LEAF", sequenceName = "LEAF_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LEAF", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    private Integer id;
    private String name;

    public Leaf() {
    }

    public Leaf(String name) {
        this.name = name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(id, leaf.id);
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }
        return Objects.hash(id);
    }
}
