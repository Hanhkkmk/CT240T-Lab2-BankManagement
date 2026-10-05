import java.util.List;
import java.util.Scanner;

public class BankManagerAccount {
    public static int main(String args[]){
        BankerManager accounts = new BankerManager();
        while(true){
            System.out.println("MENU BANK\n" +
                    "1. Tao Tai Khoan cho khack\n" +
                    "2. Nap tien cho khach\n" +
                    "3. Rut tien cho khach\n" +
                    "4. Liet ke danh sach tai khoan\n" +
                    "5. Tim tai khoan khach hang\n" +
                    "6. Thuc hien chuyen tien" +
                    "7. OUT!");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Thuc hien tao tai khoan!!");
                    System.out.println("Hay nhap account number, name, so du ban dau:");
                    String numberAcc = sc.nextLine();
                    String name = sc.nextLine();
                    double soDu = sc.nextDouble();
                    try {
                       SavingAccount acc = new SavingAccount(numberAcc,name,soDu,0.0);
                        accounts.addAccount(acc);
                    }
                    catch (InvalidAmountException e){
                        System.err.println("Loi So Lieu: " + e.getMessage());
                    }
                    catch (InsufficientBalanceException e){
                        System.err.println("Loi So Du: " + e.getMessage());
                    }

                    break;
                case 2:
                    System.out.print("Nhap so tai khoan: ");
                    String numAccDe = sc.nextLine();
                    System.out.print("Nhap so tien can nap: ");
                    double moneyDe = sc.nextDouble();
                    try {
                        accounts.Deposit(numAccDe, moneyDe);
                    }
                    catch (InvalidAmountException e){
                        System.err.println("Loi so lieu: "+ e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Nhap so tai khoan: ");
                    String numAccWi = sc.nextLine();
                    System.out.print("Nhap sp tien can rut: ");
                    double moneyWi = sc.nextDouble();
                    try{
                        accounts.Withdraw(numAccWi,moneyWi);
                    }catch (InsufficientBalanceException e){
                        System.err.print("Loi So Du: "+ e.getMessage());
                    }
                    break;
                case 7:
                    return 0;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}
