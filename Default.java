import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD}) // Применяется к классам и полям
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения программы
@interface Default {
    Class<?> value();
}
