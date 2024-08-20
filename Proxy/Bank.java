
import java.util.ArrayList;

class Account {
    static int startingAccountNo = 1;
    String name;
    int accountNo, pin;
    double balance;

    Account(String name, double balance, int pin) {
        this.name = name;
        this.accountNo = startingAccountNo++;
        this.balance = balance;
        this.pin = pin;
    }

    public void debitBalance(int balance) {
        this.balance -= balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nname : " + name + "\naccount no : " + accountNo + "\nbalance : " + balance;
    }
}

public class Bank {
    ArrayList<Account> accounts = new ArrayList<>();
    private static Bank b = new Bank();
    private Bank() {

    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public static Bank getBankInstance() {
        return b;
    }

    public double getBalance(int accountNo) throws Exception {
        for (Account account : accounts) {
            if (account.accountNo == accountNo) {
                return account.balance;
            }
        }

        throw new Exception("Account does not exist!");
    }

    public void credit(int accountNo, int money) throws Exception {
        for (Account account : accounts) {
            if (account.accountNo == accountNo) {
                account.balance += money;

                System.out.println("Account No : " + accountNo + " successfully credited " + money);
                System.out.println("Account balance : " + account.balance);
                return;
            }
        }
        throw new Exception("Account does not exist!");
    }

    public void setBalance(int accountNo, double balance) throws Exception{
        for (Account account : accounts) {
            if(accountNo == account.accountNo) {
                account.balance = balance;
                return;
            }
        }
        throw new Exception("Account does not exist!");

    }

    public void debit(int accountNo, int money, int pin) throws Exception {
        for (Account account : accounts) {
            if (account.accountNo == accountNo) {

                if(pin != account.pin) {
                    throw new Exception("Invalid Pin");
                } 
                if(account.balance < money) {
                    throw new Exception("Account balance is very low not possible to withdraw");
                }
                account.debitBalance(money);

                System.out.println("Account No " + accountNo + " successfully debited " + money);
                System.out.println("Account balance : " + account.balance);
                return;
            }
        }

        throw new Exception("Account does not exist!");

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Account account : accounts) {
            sb.append(account.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void transeferMoney(int sourceAccountNo, int destAccountNo, int money, int pin) throws Exception {
        double originalBalance = b.getBalance(sourceAccountNo);
        b.debit(sourceAccountNo, money, pin);

        if(b.getBalance(sourceAccountNo) != (originalBalance - money)) {
            b.setBalance(sourceAccountNo, originalBalance);
            throw new Exception("something went wrong while debiting the money");
        }

        double originalBalance2 = b.getBalance(destAccountNo);

        b.credit(destAccountNo, money);

        if(b.getBalance(destAccountNo) != (originalBalance2 + money)) {
            b.setBalance(sourceAccountNo, originalBalance);
            b.setBalance(destAccountNo, originalBalance2);
            throw new Exception("something went wrong while crediting the money");
        }
        System.out.println("Account No " + sourceAccountNo + " transfered " + money + " to account No " + destAccountNo);
        System.out.println("Available balnce : " + b.getBalance(sourceAccountNo));
    }
}

class Atm {
    Bank b = Bank.getBankInstance();

    public void withdraw(int accountNo, int money, int pin) throws Exception {
        b.debit(accountNo, money, pin);
    }

    public void transeferMoney(int sourceAccountNo, int destAccountNo, int money, int pin) throws Exception {
        b.transeferMoney(sourceAccountNo, destAccountNo, money, pin);
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        Bank b = Bank.getBankInstance();
        Atm a = new Atm();
        b.addAccount(new Account("vansh potpose", 25000, 1234));
        b.addAccount(new Account("sujal nimje", 5000, 4321));
        a.withdraw(1, 1000, 1234);
        a.transeferMoney(1, 2, 20000, 1234);
        System.out.println(b);
    }
}
