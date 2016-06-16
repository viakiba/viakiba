package haust.vk.utils;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author vk
 *
 * 2016年5月13日
 */

/*
 * 注解描述表名称
 */
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String tableName();
}
