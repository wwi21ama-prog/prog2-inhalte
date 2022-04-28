public class BankAccount {
    private final String iban;
    private double balance;
    private boolean allowOverdraft;

    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
        this.allowOverdraft = false;
    }

    public BankAccount(String iban, double balance, boolean allowOverdraft) {
        this(iban, balance);
        this.allowOverdraft = allowOverdraft;
    }

    public String getIban() {
        return this.iban;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean isInDebt() {
        return this.balance < 0;
    }

    public boolean allowsOverdraft() {
        return this.allowOverdraft;
    }

    public void setOverdraft(boolean allowOverdraft) {
        this.allowOverdraft = allowOverdraft;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean debit(double amount) {
        if (this.balance - amount < 0 && !this.allowOverdraft) {
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public void printDetails() {
        System.out.printf("IBAN: %s, Kontostand: %.2f €, negativ: %s, Überziehungskredit: %s\n",
                this.getIban(), this.getBalance(), this.isInDebt() ? "ja" : "nein", this.allowsOverdraft() ? "ja" : "nein");
    }
}
