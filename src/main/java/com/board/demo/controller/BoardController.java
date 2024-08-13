package com.board.demo.controller;

import com.board.demo.dto.CategoryResult;
import com.board.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;


    @GetMapping("/api/category/{id}")
    public ResponseEntity<CategoryResult> getSearchById(@PathVariable long id){
        return ResponseEntity.ok().body(boardService.findById(id));
    }

    @GetMapping("/api/category/search")
    public ResponseEntity<List<CategoryResult>> getSearchByName(@RequestParam String name){
        return ResponseEntity.ok().body( boardService.findByName(name));
    }

    @GetMapping("/api/category/list")
    public ResponseEntity<List<CategoryResult>> getCategoryList(){
        return ResponseEntity.ok().body(boardService.getCategoryList());
    }

}
