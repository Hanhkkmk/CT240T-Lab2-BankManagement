import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BankerManager{
    private Map<String, BankAccount> accountNumber;

    public BankerManager(Map<String, BankAccount> accountNumber) {
        this.accountNumber = accountNumber;
    }
    public BankerManager(){
        this(null);
    }
    public double calculateTotalBalance(List<? extends BankAccount> accounts) {

        double total = 0.0;

        for (BankAccount acc : accounts) {
            total += acc.getBalance(); // Producer Extends
        }

        return total;
    }
    public <T extends BankAccount> void addAccount(  T acc ){
        String id = acc.getAccountNumber();
        this.accountNumber.put(id,acc);
    }

    public <T extends BankAccount>void findAccount(T acc){
    if(this.accountNumber.containsValue(acc)) System.out.println("Da tim thay");
    else System.out.println("Khong tim thay");
    }
    public void Deposit(String  numAcc, double amount){
        if(amount <= 0) throw new InvalidAmountException("So nhap vao khong hop le!!");
        accountNumber.get(numAcc).deposit(amount);
    }
    public void Withdraw(String numAcc, double amount){
        if(amount > accountNumber.get(numAcc).getBalance()) throw new InsufficientBalanceException("So du khong du");
        accountNumber.get(numAcc).withdraw(amount);
    }
    public <T extends BankAccount>void transferMoney(T from, T end, double amount){
        if(amount <= 0) throw new InvalidAmountException("So tien khong hop le");
        if(amount > from.getBalance()) throw new InsufficientBalanceException("So du khong du de thuc hien");
        from.setBalance(from.getBalance()-amount);
        end.setBalance(end.getBalance()+amount);
    }
}
