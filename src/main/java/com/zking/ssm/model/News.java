package com.zking.ssm.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"categoryId","category"})
public class News {
    private Integer newsId;

    private String title;

    private Integer categoryId;

    private List<Category> category = new ArrayList<>();

    public News(Integer newsId, String title,List<Category> category) {
        this.newsId = newsId;
        this.title = title;
        this.category = category;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public News() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}