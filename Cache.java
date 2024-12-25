import java.lang.annotation.*;

@Target(ElementType.TYPE)
// Указываем, что аннотация доступна во время выполнения
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    // Необязательное свойство value, массив строк, по умолчанию — пустой массив
    String[] value() default {};
}
