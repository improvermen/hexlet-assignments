package exercise;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> invalidFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
                if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return invalidFields;
    }
    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> validationErrors = new HashMap<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            List<String> errors = new ArrayList<>();
            field.setAccessible(true);

            try {
                Object value = field.get(obj);
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    errors.add("Поле не должно быть null.");
                }

                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minimLength = field.getAnnotation(MinLength.class);
                    int minLen = minimLength.minLength();

                    if (value instanceof String) {
                        String strValue = (String) value;
                        if (strValue.length() < minLen) {
                            errors.add("Длина строки должна быть не менее " + minLen + " символов.");
                        }
                    } else {
                        errors.add("Поле должно быть строкой.");
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (!errors.isEmpty()) {
                validationErrors.put(field.getName(), errors);
            }
        }

        return validationErrors;
    }
}
// END
