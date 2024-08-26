package com.example.springboot.service;

import com.example.springboot.model.Comment;
import com.example.springboot.model.News;
import com.example.springboot.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

//    @Autowired
    private final NewsRepository newsRepository;

    public List<News> getNewsByCategory(Long categoryId) {
        return List.of();
    }

    public News getNewsById(Long newsId) throws Exception {
        return newsRepository.findById(newsId).orElseThrow(() -> new Exception("Not found"));
    }

    public void addComment(Long newsId, Comment comment) throws Exception {
        News news = getNewsById(newsId);
        comment.setNews(news);
        comment.setCreatedAt(LocalDateTime.now());
        news.getComments().add(comment);
        newsRepository.save(news);
    }
}

