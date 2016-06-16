package haust.vk.d_anno;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author vk
 *自定义注解  描述一个作者
 * 2016年5月13日
 */
//元注解 定义注解的使用对象
@Target({TYPE,FIELD , METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
//@Target({METHOD,FIELD,TYPE})   指定只能在方法、字段、类上用；

//元注解 - 2. 指定注解的声明周期
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
	String authorName() default "vk";
	int age() default 18;
	String remark();
}
