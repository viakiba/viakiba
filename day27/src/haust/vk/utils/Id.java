package haust.vk.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
/**
 * @author vk
 *
 * 2016年5月13日
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {

}
