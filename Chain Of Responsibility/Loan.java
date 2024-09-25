public class Loan {
  private int amount;

  Loan(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }
}

abstract class LoanApprover {
  protected LoanApprover nextApprover;
  
  public void setNextApprover(LoanApprover nextApprover) {
    this.nextApprover = nextApprover;
  }

  public abstract void approveLoan(Loan loan);
}

class Manager extends LoanApprover {
  public void approveLoan(Loan loan) {
    if (loan.getAmount() <= 50000) {
      System.out.println("Loan amount : " + loan.getAmount() + " approved by Manager");
    } else {
      nextApprover.approveLoan(loan);
    }
  }
}

class Director extends LoanApprover {
  public void approveLoan(Loan loan) {
    if (loan.getAmount() <= 100000) {
      System.out.println("Loan amount : " + loan.getAmount() + " approved by Director");
    } else {
      nextApprover.approveLoan(loan);
    }
  }
}

class President extends LoanApprover {
  public void approveLoan(Loan loan) {
    if (loan.getAmount() <= 200000) {
      System.out.println("Loan amount : " + loan.getAmount() + " approved by President");
    } else {
      System.out.println("Loan amount : " + loan.getAmount() + " rejected by President Above 200000");
    }
  }
}

class Test {
  public static void main(String[] args) {
    Loan loan = new Loan(200000);

    LoanApprover manager = new Manager();
    LoanApprover director = new Director();
    LoanApprover president = new President();

   manager.setNextApprover(director);
   director.setNextApprover(president);

    manager.approveLoan(loan);
  }  
}