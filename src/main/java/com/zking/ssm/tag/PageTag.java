package com.zking.ssm.tag;

import com.zking.ssm.util.PageBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private PageBean pageBean;

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			JspWriter out=pageContext.getOut();
			out.println(toHTML());
			return SKIP_BODY;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	//拼接
	public String toHTML() {
		//如何pageBean为空，或者不分页
		if(null==this.pageBean||!this.pageBean.isPagination()){
			return "";
		}

		//分页
		StringBuffer sb=new StringBuffer();

		//表单
		sb.append("<form id='gotoPageForm' action='"+pageBean.getUrl()+"' method='post'>" +
				"	<input type='hidden' name='currentPage' value='' />");

		//循环:根据请求参数便利
		Set<Entry<String, String[]>> mapSet = pageBean.getParameterMap().entrySet();

		for(Map.Entry<String, String[]> paramsMap : mapSet) {
			String key = paramsMap.getKey();
			if("currentPage".equals(key)) {
				continue;
			}

			String[] values = paramsMap.getValue();
			for (String value : values) {
				sb.append("<input type='hidden' name='"+ key +"' value='"+value+"' />");
			}
		}


		sb.append("</form>");




		//链接
		sb.append("总记录数: "+pageBean.getTotal()+"&nbsp当前页["+pageBean.getPage()+"/"+pageBean.getMaxPage()+"]"+
				"<a style=\"text-decoration: none;\" href='javascript:gotoPage(1)'>首页</a>&nbsp;" +
				"<a style=\"text-decoration: none;\" href='javascript:gotoPage("+pageBean.getPreviousPage()+")'>上一页</a>&nbsp;" +
				"<a style=\"text-decoration: none;\" href='javascript:gotoPage("+pageBean.getNextPage()+")'>下一页</a>&nbsp;" +
				"<a style=\"text-decoration: none;\" href='javascript:gotoPage("+pageBean.getMaxPage()+")'>末页</a>&nbsp;"+
				"页数 <input type='text' id='pageNumber'  style='width:20px;' onblur='myfa()' />&nbsp;"+
				"<a style=\"text-decoration: none;\" href='javascript:jumpPage()'>GO</a>");


		//js脚本
		sb.append("<script type='text/javascript'>" +
				"function gotoPage(page){" +
				"	document.getElementById('gotoPageForm').currentPage.value=page;" +
				"	document.getElementById('gotoPageForm').submit();}"+
				"function myfa(){"+
				"var a=document.getElementById('pageNumber').value;"+
				"	if(a>"+pageBean.getMaxPage()+"){"+
				"	alert('您输入的页码大于最大页码数');"+
				"	document.getElementById('pageNumber').value='';}"
				+ "else if(isNaN(a)){"
				+ "alert('您输入的页码不是数字');}"+
				"	else if(a<1){"+
				"       alert('您输入的页码小于最小页码数');"+
				"		document.getElementById('pageNumber').value=1;}"+
				"	else if(a==''){"+
				"       alert('请输入您要跳转的页码');"+
				"}}"+
				"function jumpPage(){"+
				"	var a=document.getElementById('pageNumber').value;"+
				"	if(a==''){"+
				"		alert('请输入您要跳转的页码');}"+
				"	if(a!=''){"+
				"	var currentPage=document.getElementById('pageNumber').value;"+
				"	document.getElementById('gotoPageForm').currentPage.value=currentPage;" +
				"	document.getElementById('gotoPageForm').submit();}}"+
				"</script>");

		return sb.toString();
	}

}
