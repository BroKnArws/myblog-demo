package com.strutnut.service.impl;

import com.strutnut.dao.IThemeMapper;
import com.strutnut.model.pojo.Theme;
import com.strutnut.model.pojo.Title;
import com.strutnut.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ThemeService")
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private final IThemeMapper themeMapper;

    public ThemeServiceImpl(IThemeMapper themeMapper) {
        this.themeMapper = themeMapper;
    }


    @Override
    public List<Theme> getAllThemes() {
        return themeMapper.getAllThemes();
    }

    @Override
    public List<Title> getAllTitles() {
        return themeMapper.getAllTitles();
    }

    @Override
    public Theme getArticleById(String tid) {
        return themeMapper.getArticleById(tid);
    }


}
