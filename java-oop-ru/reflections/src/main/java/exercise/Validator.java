package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();

        Field[] fields = Address.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    notValidFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return notValidFields;
    }
    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> errors = new HashMap<>();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            // Проверка на аннотацию @MinLength
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength annotation = field.getAnnotation(MinLength.class);
                try {
                    String value = (String) field.get(obj);
                    if (value != null && value.length() < annotation.minLength()) {
                        errors.computeIfAbsent(field.getName(), k -> new ArrayList<>())
                                .add("Length of " + field.getName() + " is less than " + annotation.minLength());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Проверка на аннотацию @NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        errors.computeIfAbsent(field.getName(), k -> new ArrayList<>())
                                .add(field.getName() + " must not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return errors;
    }
}
// END
