package tc.task01.service.exception;

public class CriteriaGroupSearchNameException extends Exception {
    private static final long serialVersionUID = 1L;

    public CriteriaGroupSearchNameException() {
        super();
    }

    public CriteriaGroupSearchNameException(String message) {
        super(message);
    }

    public CriteriaGroupSearchNameException(Exception exception) {
        super(exception);
    }

    public CriteriaGroupSearchNameException(String message, Exception exception) {
        super(message, exception);
    }
}
