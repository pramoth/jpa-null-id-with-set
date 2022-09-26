package com.example.jpanullidtest.repo;

import com.example.jpanullidtest.domain.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RootRepo extends JpaRepository<Root,Integer> {

    @Query("select r from Root  r left join fetch r.children c left join fetch c.leafs l where r.name=:name")
    Optional<Root> findByName(String name);
}
