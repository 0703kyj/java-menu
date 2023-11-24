package menu.exception.argument;

import menu.exception.RecommendException;

public class RecommendArgumentException extends IllegalArgumentException implements RecommendException {
    private final String message;

    public RecommendArgumentException(String message) {
        this.message = PREFIX + message + '\n';
    }

    @Override
    public String toString() {
        return this.message;
    }
}
