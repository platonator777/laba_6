import java.lang.reflect.Field;

public class Entity {

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Class<?> clazz = this.getClass();

        result.append(clazz.getSimpleName()).append("{");

        while (clazz != null) {
            // Проверяем аннотацию @ToString для текущего класса
            boolean classHasToStringAnnotation = clazz.isAnnotationPresent(ToString.class);
            ToString.Value classToStringValue = classHasToStringAnnotation
                    ? clazz.getAnnotation(ToString.class).value()
                    : ToString.Value.YES;

            if (classToStringValue == ToString.Value.NO) {
                // Если класс или суперкласс помечен @ToString(NO), включаем только поля с @ToString(YES)
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    ToString fieldAnnotation = field.getAnnotation(ToString.class);
                    if (fieldAnnotation != null && fieldAnnotation.value() == ToString.Value.YES) {
                        try {
                            result.append(field.getName()).append("=")
                                    .append(field.get(this)).append(", ");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                // Если класс не помечен @ToString(NO), включаем все поля, кроме @ToString(NO)
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    ToString fieldAnnotation = field.getAnnotation(ToString.class);
                    if (fieldAnnotation == null || fieldAnnotation.value() != ToString.Value.NO) {
                        try {
                            result.append(field.getName()).append("=")
                                    .append(field.get(this)).append(", ");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            clazz = clazz.getSuperclass();
        }

        if (result.length() > 2 && result.charAt(result.length() - 2) == ',') {
            result.setLength(result.length() - 2);
        }
        result.append("}");
        return result.toString();
    }

}