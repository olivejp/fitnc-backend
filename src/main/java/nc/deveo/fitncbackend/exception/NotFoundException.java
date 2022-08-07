package nc.deveo.fitncbackend.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
