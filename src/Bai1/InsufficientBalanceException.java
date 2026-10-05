public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(){
        super("So tien khong du");
    }
    public InsufficientBalanceException(String mes){
        super(mes);
    }
}
