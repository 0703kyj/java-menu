package menu.exception.state;

import menu.exception.RecommendException;

public class RecommendStateException extends IllegalStateException implements RecommendException {
    private final String message;

    public RecommendStateException(String message) {
        this.message = PREFIX + message + '\n';
    }

    @Override
    public String toString() {
        return this.message;
    }
}
