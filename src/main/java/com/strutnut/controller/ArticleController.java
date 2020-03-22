package com.strutnut.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.strutnut.model.pojo.Theme;
import com.strutnut.model.pojo.Title;
import com.strutnut.service.IThemeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LogManager.getLogger(ArticleController.class);

    private final IThemeService themeService;

    @Autowired
    public ArticleController(IThemeService themeService) {
        this.themeService = themeService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public String getArticlesTitle() {

        List<Title> allTitles = themeService.getAllTitles();
        System.out.println(JSON.toJSONString(allTitles));
        return JSON.toJSONString(allTitles);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{tid}")
    public String getArticle(@PathVariable String tid) {
        Theme article = themeService.getArticleById(tid);
        if (article == null) {
            logger.error("Article is not existed.");
        }
        return JSON.toJSONString(article);

    }


}
