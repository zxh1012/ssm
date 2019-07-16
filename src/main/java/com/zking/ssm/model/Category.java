package com.zking.ssm.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Category {
    private Integer categoryId;

    private String categoryName;

    private List<News> news = new ArrayList<>();

    public Category(Integer categoryId, String categoryName,List<News> news) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.news = news;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}