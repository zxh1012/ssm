package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.NewsMapper;
import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public int add(News news) {
        return newsMapper.insert(news);
    }

    @Override
    public int del(Integer newsId) {
        newsMapper.deleteNewsKey(newsId);
        return newsMapper.deleteByPrimaryKey(newsId);
    }

    @Override
    public int edit(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }

    @Override
    public News load(News news) {
        return newsMapper.selectByPrimaryKey(news.getNewsId());
    }

    @Override
    public News loadNews(News news) {
        return newsMapper.loadNews(news.getNewsId());
    }

    @Override
    public List<News> list(News news, PageBean pageBean) {
        return newsMapper.list(news);
    }
}
