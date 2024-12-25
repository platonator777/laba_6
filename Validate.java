import java.lang.annotation.*;
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Validate {
    Class<?>[] value();
}

