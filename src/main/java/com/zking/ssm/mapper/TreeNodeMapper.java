package com.zking.ssm.mapper;

import com.zking.ssm.model.TreeNode;

import java.util.List;

public interface TreeNodeMapper {
    List<TreeNode> list(TreeNode record);

    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);
}