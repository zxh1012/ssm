package com.zking.ssm.controller;

import com.zking.ssm.model.Student;
import com.zking.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stu")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @RequestMapping("toAdd")
    public String toAdd(){
        return "addStudent";
    }

    @RequestMapping("toEdit")
    public String toEdit(){
        return "editStudent";
    }

    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> add(@Validated(value = Student.ValidateGroups.add.class) Student student, BindingResult bindingResult){
        Date date = new Date();
        student.setCreateDatetime(date);
        System.out.println("add..");
        Map<String,Object> jsonData = new HashMap<>();
        if (bindingResult.hasErrors()) {
            Map<String,Object> erros = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError:fieldErrors){
                String message = fieldError.getDefaultMessage();
                String field = fieldError.getField();
                erros.put(field,message);
            }
            jsonData.put("errors",erros);
            return jsonData ;
        }

        studentService.insert(student);

        jsonData.put("code",0);
        jsonData.put("message","用户资料新增成功");
        return jsonData;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Map<String, Object> edit(@Validated(value = Student.ValidateGroups.edit.class) Student student, BindingResult bindingResult){
        Date date = new Date();
        student.setCreateDatetime(date);
        System.out.println("edit..");
        Map<String,Object> jsonData = new HashMap<>();
        if (bindingResult.hasErrors()) {
            Map<String,Object> erros = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError:fieldErrors){
                String message = fieldError.getDefaultMessage();
                String field = fieldError.getField();
                erros.put(field,message);
            }
            jsonData.put("errors",erros);
            return jsonData ;
        }

        studentService.updateByPrimaryKey(student);

        jsonData.put("code",-1);
        jsonData.put("message","用户资料修改成功");
        return jsonData;
    }
}
