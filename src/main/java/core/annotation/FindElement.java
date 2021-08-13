package core.annotation;

import core.element.LocatorType;
import core.element.ExpectedCondition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindElement {
    LocatorType type(); // locator type: id, xpath, css...

    String value(); // locator value

    ExpectedCondition condition() default ExpectedCondition.VISIBILITY;
}
