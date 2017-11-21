package cn.shi.leasplat.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.PARAMETER , ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 	记录系统日志
 * @author shiqiang
 *
 */
public @interface Auditable {

     /** 模块名称 **/  
     public String moduleName() default "";  
      
     /** 操作名称 **/  
     public String operationName() default "";
}
