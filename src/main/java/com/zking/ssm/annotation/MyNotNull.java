package com.zking.ssm.annotation;


import com.github.pagehelper.Page;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MyNotNull.MyNotNullValidator.class)
public @interface MyNotNull {
    boolean value() default true;

    String message() default "值不能为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //非空验证实现类
    class MyNotNullValidator implements ConstraintValidator<MyNotNull, Object> {

        private String message;

        private boolean value;




        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (this.value && null == value) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public void initialize(MyNotNull constraintAnnotation) {
            this.message = constraintAnnotation.message();
            this.value = constraintAnnotation.value();
        }
    }
}
