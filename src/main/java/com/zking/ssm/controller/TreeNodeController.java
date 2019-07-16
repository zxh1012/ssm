package com.zking.ssm.controller;

import com.zking.ssm.model.TreeNode;
import com.zking.ssm.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shu")
public class TreeNodeController {

    @Autowired
    private ITreeNodeService iTreeNodeService;


    @ResponseBody
    @RequestMapping("/treeNode1")
    public List<TreeNode> treeNode1(TreeNode treeNode, HttpSession session){
//        User user  = (User) session.getAttribute("treeNode");
        List<TreeNode> treeNodeList = iTreeNodeService.list(treeNode);
        for (TreeNode treeNode1:treeNodeList){
            if (treeNode1.getTreeNodeType()==1){
                treeNode1.setTreeNodes(iTreeNodeService.list(treeNode1));
            }
        }
        return treeNodeList;
    }


}
