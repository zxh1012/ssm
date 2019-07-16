package com.zking.ssm.controller;

import com.zking.ssm.annotation.MyLog;
import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerMapperService;
import com.zking.ssm.util.JsonData;
import com.zking.ssm.util.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cu")
public class CustomerController {

    @Autowired
    private ICustomerMapperService customerMapperService;
    private Customer customer;
    private String resturantName = null;


    @ModelAttribute
    public void init(Model model, ModelAndView modelAndView){
        model.addAttribute("name","dd");
    }

    @MyLog(desc = "bb")
    @RequiresPermissions("system:cusa:add")
    @RequestMapping("/add")
    public String add( ){
        return  "add";
    }

    @ResponseBody
    @RequestMapping("/doadd")
    public Map<String, Object> doadd(Customer customer){
        Map<String,Object> map = new HashMap<>();
        if(null == customer.getCustomerId()) {
            this.customerMapperService.add(customer);
            map.put("code",0);
            map.put("message","新增成功");
        }else {
            this.customerMapperService.edit(customer);
            map.put("code",0);
            map.put("message","修改成功");
        }

//        customerMapperService.add(customer);
//        return  "redirect:list";
        return map;
    }


    @MyLog(desc = "aa")
    @RequiresPermissions("system:cusa:edit")
    @RequestMapping("/edit")
    public String edit(Customer customer,Model model){
        Customer cus = customerMapperService.load(customer);
        model.addAttribute("customer",cus);
        return  "edit";
    }


    @RequestMapping("/doedit")
    public String doedit(Customer customer, Model model){
        customerMapperService.edit(customer);
        return  "redirect:list";
    }

    @MyLog(desc = "cc")
//    @RequiresPermissions("system:cusa:del")
    @RequestMapping("/del")
    @ResponseBody
    public  Map<String,Object>  del(Customer customer){
        System.out.println(customer);
        Map<String,Object> map = new HashMap<>();
        customerMapperService.del(customer);
        map.put("message","删除成功");
        map.put("code",0);
//        return "redirect:list";
        return map;
    }

    @ResponseBody
    @MyLog(desc = "dd")
//    @RequiresPermissions("system:cusa:view")
    @RequestMapping("/list")
    public Map<String,Object> list(Model model, PageBean pageBean, HttpServletRequest request,Customer customer){
        Map<String,Object> map = new HashMap<>();
        pageBean.setRequest(request);
        System.out.println(customer.getCustomerName());
        List<Customer> customerList = customerMapperService.list(customer,pageBean);

        model.addAttribute("list",customerList);
        model.addAttribute("pageBean",pageBean);
        map.put("mas",customerList);
        map.put("page",pageBean);
        return map;
    }

    @ResponseBody
    @RequestMapping("/editDate")
    public Map<String,Object> editDate(){
        System.out.println("editDate");
        Map<String,Object> map = new HashMap<>();
        Date d  = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SS");
        String s = sdf.format(d);
        try {
            System.out.println("模拟异步情况，休眠6秒，bun超过10秒,axios超时时间设置的是3秒");
            Thread.sleep(6000);
            System.out.println("睡醒了，继续...");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        JsonData jsonData = new JsonData();
        jsonData.setResult(this.resturantName+"-"+s);
        map.put("msg",jsonData);
        return map;
    }

}
