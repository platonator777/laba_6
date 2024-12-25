import java.lang.reflect.*;

class Main {
    public static void main(String[] args) throws Exception{

        //ЗАДАНИЕ 1

        B b = new B();
        System.out.println(b);

        // ЗАДАНИЕ 2.1

        ExampleInvoke test = new ExampleInvoke();

        Method[] methods = ExampleInvoke.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                System.out.println("Метод " + method.getName() + " аннотирован @Invoke. Вызываем его...");
                method.invoke(test); // Вызываем метод
            }
        }

        //ЗАДАНИЕ 2.2

//        Class<ExampleDefault> clazz = ExampleDefault.class;
//
//        // Проверяем аннотацию на классе
//        if (clazz.isAnnotationPresent(Default.class)) {
//            Default classAnnotation = clazz.getAnnotation(Default.class);
//            System.out.println("Класс " + clazz.getSimpleName() + " имеет аннотацию @Default с значением: " + classAnnotation.value().getSimpleName());
//        } else {
//            System.out.println("Класс " + clazz.getSimpleName() + " не имеет аннотации @Default.");
//        }
//
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(Default.class)) {
//                Default fieldAnnotation = field.getAnnotation(Default.class);
//                System.out.println("Поле " + field.getName() + " имеет аннотацию @Default с значением: " + fieldAnnotation.value().getSimpleName());
//            } else {
//                System.out.println("Поле " + field.getName() + " не имеет аннотации @Default.");
//            }
//        }

        //ЗАДАНИЕ 3.3

//        Class<ExampleToString> clazz = ExampleToString.class;
//
//        // Проверяем аннотацию на классе
//        if (clazz.isAnnotationPresent(ToString.class)) {
//            System.out.println("Класс " + clazz.getSimpleName() + " имеет аннотацию @ToString.");
//        } else {
//            System.out.println("Класс " + clazz.getSimpleName() + " не имеет аннотации @ToString.");
//        }
//
//        // Проверяем аннотацию на полях
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(ToString.class)) {
//                ToString fieldAnnotation = field.getAnnotation(ToString.class);
//                if (fieldAnnotation.value() == ToString.Value.YES) {
//                    System.out.println("Поле " + field.getName() + " имеет аннотацию @ToString с значением: YES");
//                } else {
//                    System.out.println("Поле " + field.getName() + " имеет аннотацию @ToString с значением: NO");
//                }
//            } else {
//                System.out.println("Поле " + field.getName() + " не имеет аннотации @ToString.");
//            }
//        }

        //ЗАДАНИЕ 2.4

//        Class<?> myCustomAnnotationClass = MyCustomAnnotation.class;
//        if (myCustomAnnotationClass.isAnnotationPresent(Validate.class)) {
//            Validate validate = myCustomAnnotationClass.getAnnotation(Validate.class);
//            System.out.println("Объект MyCustomAnnotation имеет аннотацию @Validate с типами:");
//            for (Class<?> type : validate.value()) {
//                System.out.println(" - " + type.getSimpleName());
//            }
//        } else {
//            System.out.println("Объект MyCustomAnnotation не имеет аннотации @Validate.");
//        }
//
//        // Проверка класса ExampleValidate
//        Class<?> exampleValidateClass = ExampleValidate.class;
//        if (exampleValidateClass.isAnnotationPresent(Validate.class)) {
//            Validate validate = exampleValidateClass.getAnnotation(Validate.class);
//            System.out.println("Объект ExampleValidate имеет аннотацию @Validate с типами:");
//            for (Class<?> type : validate.value()) {
//                System.out.println(" - " + type.getSimpleName());
//            }
//        } else {
//            System.out.println("Объект ExampleValidate не имеет аннотации @Validate.");
//        }

        //ЗАДАНИЕ 2.5

//        Class<?> clazz = ExampleTwo.class;
//
//        // Проверяем наличие аннотации @Two
//        if (clazz.isAnnotationPresent(Two.class)) {
//            // Извлекаем аннотацию
//            Two twoAnnotation = clazz.getAnnotation(Two.class);
//
//            // Выводим значения параметров аннотации
//            System.out.println("Класс " + clazz.getSimpleName() + " имеет аннотацию @Two:");
//            System.out.println(" - first: " + twoAnnotation.first());
//            System.out.println(" - second: " + twoAnnotation.second());
//        } else {
//            System.out.println("Класс " + clazz.getSimpleName() + " не имеет аннотации @Two.");
//        }

        //ЗАДАНИЕ 2.6

//        Class<?> clazz = ExampleCache.class;
//
//        // Проверяем наличие аннотации @Cache
//        if (clazz.isAnnotationPresent(Cache.class)) {
//            // Извлекаем аннотацию
//            Cache cacheAnnotation = clazz.getAnnotation(Cache.class);
//
//            // Выводим значения параметров аннотации
//            System.out.println("Класс " + clazz.getSimpleName() + " имеет аннотацию @Cache с значениями:");
//            for (String value : cacheAnnotation.value()) {
//                System.out.println(" - " + value);
//            }
//        } else {
//            System.out.println("Класс " + clazz.getSimpleName() + " не имеет аннотации @Cache.");
//        }
    }
}