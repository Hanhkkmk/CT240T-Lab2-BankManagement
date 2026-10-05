// Định nghĩa một Unchecked Exception bằng cách kế thừa RuntimeException
public class InvalidAmountException extends RuntimeException {

    // Constructor không tham số
    public InvalidAmountException() {
        super("Số tiền không hợp lệ!");
    }

    // Constructor nhận thông báo lỗi tùy biến
    public InvalidAmountException(String message) {
        super(message);
    }
}
