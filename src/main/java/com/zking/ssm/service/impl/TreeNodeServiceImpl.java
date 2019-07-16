package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.TreeNodeMapper;
import com.zking.ssm.model.TreeNode;
import com.zking.ssm.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreeNodeServiceImpl implements ITreeNodeService {
    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public List<TreeNode> list(TreeNode treeNode) {
        return treeNodeMapper.list(treeNode);
    }

    @Override
    public int deleteByPrimaryKey(Integer treeNodeId) {
        return 0;
    }

    @Override
    public int insert(TreeNode record) {
        return 0;
    }

    @Override
    public int insertSelective(TreeNode record) {
        return 0;
    }

    @Override
    public TreeNode selectByPrimaryKey(Integer treeNodeId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TreeNode record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TreeNode record) {
        return 0;
    }
}
