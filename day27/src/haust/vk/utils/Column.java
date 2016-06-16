package haust.vk.utils;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author vk
 *
 * 2016年5月13日
 */


@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String columnName();
}
