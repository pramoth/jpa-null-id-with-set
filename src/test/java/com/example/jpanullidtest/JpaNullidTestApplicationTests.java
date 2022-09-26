package com.example.jpanullidtest;

import com.example.jpanullidtest.domain.Child;
import com.example.jpanullidtest.domain.Leaf;
import com.example.jpanullidtest.domain.Root;
import com.example.jpanullidtest.repo.RootRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Set;

@SpringBootTest
class JpaNullidTestApplicationTests {

    @Transactional
    @Test
    void saveChild(@Autowired RootRepo repo) {
        Child first = new Child();
        Root root = new Root();
        root.getChildren().add(first);
        root.getChildren().add(new Child());
        root = repo.save(root);
        Assertions.assertEquals(2,root.getChildren().size());
    }
    @Transactional
    @Test
    void saveLeaf(@Autowired RootRepo repo) {
        Child first = new Child();
        first.getLeafs().add(new Leaf("L1"));
        first.getLeafs().add(new Leaf("L2"));
        Root root = new Root();
        root.getChildren().add(first);
        root.getChildren().add(new Child());
        root = repo.save(root);
        Set<Leaf> leafs = new ArrayList<>(root.getChildren()).get(0).getLeafs();
        Assertions.assertEquals(2,leafs.size());
        Assertions.assertEquals("L1",leafs.stream().findFirst().get().getName());
    }

    @Transactional
    @Test
    void joinFetch(@Autowired RootRepo repo) {
        Child first = new Child();
        first.getLeafs().add(new Leaf("L1"));
        first.getLeafs().add(new Leaf("L2"));
        Root root = new Root("R1");
        root.getChildren().add(first);
        root.getChildren().add(new Child());
        repo.saveAndFlush(root);
        root = repo.findByName("R1").get();
        Set<Leaf> leafs = new ArrayList<>(root.getChildren()).get(0).getLeafs();
        Assertions.assertEquals(2,leafs.size());
        Assertions.assertEquals("L1",leafs.stream().findFirst().get().getName());
    }

}
