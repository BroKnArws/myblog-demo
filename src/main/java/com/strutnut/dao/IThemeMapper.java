package com.strutnut.dao;

import com.strutnut.model.pojo.Theme;
import com.strutnut.model.pojo.Title;


import java.util.List;

public interface IThemeMapper {

    /**
     * 获得所有的文章
     *
     * @return
     */
    List<Theme> getAllThemes();


    /**
     * 获取所有标题
     *
     * @return
     */
    List<Title> getAllTitles();

    /**
     * 根据tid获取文章
     *
     * @param tid
     * @return
     */
    Theme getArticleById(String tid);
}
