public abstract class BankAccount {
    private String  accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(){
        this("NULL","NULL",0.0);
    }

    public  BankAccount(String acc, String name, double balance){

        if(balance >= 0 ) {
            this.balance = balance;
            this.accountNumber = acc;
            this.holderName = name;
        }
        else throw new InvalidAmountException("So du khong hop le!!");
    }

    public BankAccount(String acc, String name) {
        this(acc,name,0.0);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        if (balance < 0) throw new InvalidAmountException("So du khong duoc la so am!!");
        this.balance = balance;
    }
    public void setHolderName(String name){
        this.holderName = name;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getHolderName(){
        return this.holderName;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount) throws InvalidAmountException, InsufficientBalanceException{
        if (amount <= 0) throw new InvalidAmountException("So tien nap vao phai lon hon 0!!");
        this.setBalance(this.getBalance()+amount);
    }
    /**
     * Rút tiền khỏi tài khoản ngân hàng.
     * @param amount Số tiền ma khach hang nhap
     * @throws InvalidAmountException Tiền điều kiện: amount <= 0,
     * @post-condition balance_new == balance_old - amount
     * @invariant balance_new >= 0 (Luoon xet so du hien tai cua tai khoan)
     */

    public abstract void withdraw(double amount) throws InvalidAmountException;
}
