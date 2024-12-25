import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface ToString {
    enum Value {YES, NO} // Возможные значения свойства value

    Value value() default Value.YES; // Свойство по умолчанию: YES
}
