import java.lang.annotation.*;

@Target(ElementType.TYPE)
// Указываем, что аннотация доступна во время выполнения
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    // Обязательное свойство first типа String
    String first();

    // Обязательное свойство second типа int
    int second();
}
