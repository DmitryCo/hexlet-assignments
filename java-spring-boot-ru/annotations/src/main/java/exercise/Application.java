package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                var methodName = method.getName();
                var returnedType = method.getReturnType().getSimpleName();
                System.out.println("Method " + methodName + " returns a value of type " + returnedType);
            }
            // END
        }
    }
}
