package com.board.demo.service;

import com.board.demo.domain.Category;
import com.board.demo.dto.CategoryResult;
import com.board.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final CategoryRepository categoryRepository;
    private final Long ROOT_DEPTH = 1L;
    public CategoryResult findById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        return CategoryResult.of(category);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public List<CategoryResult> findByName(String name) {
        return categoryRepository.findByName(name).stream().map(CategoryResult::of).collect(Collectors.toList());
    }

    public List<CategoryResult> getCategoryList() {
        return categoryRepository.findByDepth(ROOT_DEPTH).stream().map(CategoryResult::of).collect(Collectors.toList());
    }
}
