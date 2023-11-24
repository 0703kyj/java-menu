package menu.view;

import java.util.function.Supplier;

public class InputView {


    private <T> T repeat(Supplier<T> supplier) {
        while (true) {
            try {
                T result = supplier.get();
                return result;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }
}
