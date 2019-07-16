package com.zking.ssm.annotation;


import javax.validation.*;
import java.util.Set;

public class Demo4 {

    public void print(@Valid Teacher teacher) {
        System.out.println(teacher);
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //teacher.setName("张雪");
        //teacher.setAge(20);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator  validator = factory.getValidator();
        Set<ConstraintViolation<Teacher>> constraintViolations =
                validator.validate(teacher);

        //assertEquals(0, constraintViolations.size());

        //Demo4 demo4 = new Demo4();
        //demo4.print(teacher);
        System.out.println("end");
    }
}
