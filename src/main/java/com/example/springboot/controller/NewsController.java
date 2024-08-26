package com.example.springboot.controller;

import com.example.springboot.model.Comment;
import com.example.springboot.model.News;
import com.example.springboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/category/{categoryId}")
    public List<News> getNewsByCategory(@PathVariable Long categoryId) {
        return newsService.getNewsByCategory(categoryId);
    }

    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable Long newsId) throws Exception {
        return newsService.getNewsById(newsId);
    }

    @PostMapping("/{newsId}/comments")
    public ResponseEntity<?> addComment(@PathVariable Long newsId, @RequestBody Comment comment) throws Exception {
        newsService.addComment(newsId, comment);
        return ResponseEntity.ok("Comment added successfully");
    }
}

