package com.example.FirstProject.controller;

import com.example.FirstProject.dto.ArticleForm;
import com.example.FirstProject.entity.Article;
import com.example.FirstProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ArticleController{

    @Autowired //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    // 게시판 생성
    @GetMapping("/articles/new")
    public String newArticleFrom(){
        return "articles/new";
    }


    // form 받는 함수
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());

        // 1. Dto 변환! Entity !
        Article article = form.toEntity();

        System.out.println(article.toString());

        // 2. Repositiory에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
