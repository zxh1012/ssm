package com.zking.ssm.mapper;

import com.zking.ssm.model.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int deleteNewsKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    News loadNews(Integer newsId);

    List<News> list(News news);
}