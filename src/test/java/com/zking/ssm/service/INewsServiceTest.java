package com.zking.ssm.service;

import com.zking.ssm.model.Category;
import com.zking.ssm.model.News;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class INewsServiceTest extends BaseTestCase {
    @Autowired
    private INewsService newsService;

    private News news;

    @Override
    public void before() {
        super.before();
        news = new News();
    }

    @Test
    public void add() throws Exception{
         news = new News();
        news.setNewsId(5);
        news.setCategoryId(1);

        newsService.add(news);
        System.out.println(news);
    }

    @Test
    public void del() throws Exception{
        Integer i = 1;
        newsService.del(2);
    }

    @Test
    public void edit() throws Exception{
    }

    @Test
    public void load()throws Exception {
        news.setNewsId(3);
        News n = newsService.loadNews(news);
        System.out.println(n);

        for (Category c:n.getCategory()){
            System.out.println(c);
        }
    }

    @Test
    public void loadNews()throws Exception {
    }

    @Test
    public void list() throws Exception{
    }
}