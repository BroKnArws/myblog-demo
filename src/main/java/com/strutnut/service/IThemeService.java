package com.strutnut.service;

import com.strutnut.model.pojo.Theme;
import com.strutnut.model.pojo.Title;



import java.util.List;

public interface IThemeService {

    List<Theme> getAllThemes();

    List<Title> getAllTitles();

    Theme getArticleById(String tid);
}
