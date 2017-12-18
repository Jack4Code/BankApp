public class BankAccountInformationHolder {

    private String accountNumber;
    private double accountBalance;
    private double interestRate;

    public BankAccountInformationHolder(String accountNumber) {
        this.accountBalance = 0;
        this.interestRate = 1 + (.0001/12);
        this.accountNumber = accountNumber;
    }

    public BankAccountInformationHolder(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.interestRate = 1 + (.0001/12);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
