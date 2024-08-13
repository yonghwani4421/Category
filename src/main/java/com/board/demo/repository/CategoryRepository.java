package com.board.demo.repository;

import com.board.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public List<Category> findByName(String name);
    public List<Category> findByDepth(Long depth);
//    public List<Category> findByParentIsNull();

}
