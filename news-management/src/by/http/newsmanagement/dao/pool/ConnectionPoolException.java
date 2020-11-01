package by.http.newsmanagement.dao.pool;

public class ConnectionPoolException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ConnectionPoolException() {
	}
	public ConnectionPoolException(String message, Exception e) {
		super (message, e);
	}
	public ConnectionPoolException(String message) {
        super(message);
    }
}
