package streams.tasks2;

import java.util.Objects;

//@Data
class Account {
    private String accountNumber;
    private String bic;

    public Account() {
    }

    public Account(String accountNumber, String bic) {
        this.accountNumber = accountNumber;
        this.bic = bic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getAccountNumber(), account.getAccountNumber()) && Objects.equals(getBic(), account.getBic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getBic());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", bic='" + bic + '\'' +
                '}';
    }
}
