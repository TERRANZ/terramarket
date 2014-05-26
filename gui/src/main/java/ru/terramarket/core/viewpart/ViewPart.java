package ru.terramarket.core.viewpart;

import java.lang.annotation.*;

/**
 * Date: 26.05.14
 * Time: 15:41
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ViewPart {
    String value() default "";
}
