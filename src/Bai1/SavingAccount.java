public class SavingAccount extends BankAccount{
    private  double interestRate;
    public SavingAccount(){

    }
    public SavingAccount(String acc, String name, double balance, double interestRate){
        super(acc,name);
        if(balance < 50000) throw new InsufficientBalanceException("Tai khoan chu du dieu kien! (so du >= 50.000)");
        this.setBalance(balance);
        this.interestRate = interestRate;
    }
    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if(this.getBalance() < 50000) throw new InsufficientBalanceException("So du con lai trong tai khoan toi thieu 50000 ");

    }
}
