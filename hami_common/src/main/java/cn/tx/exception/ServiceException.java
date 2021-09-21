package cn.tx.exception;
/**自定义业务异常*/
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
//UnKnownAccountException()
//LockedAccountException();
//PasswordErrorException();
//.....