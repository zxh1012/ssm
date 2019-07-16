package com.zking.ssm.service;

import com.zking.ssm.model.News;
import com.zking.ssm.util.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface INewsService {
        int add(News news);

        int del(Integer newsId);

        int edit(News news);

         @Transactional(readOnly = true)
        News load(News news);

         @Transactional(readOnly = true)
         News loadNews(News news);

         @Transactional(readOnly = true)
        List<News> list(News news, PageBean pageBean);
}
