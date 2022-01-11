package streams.tasks2;

import java.util.Objects;

//@Data
class AccountInfo {
    private Account account;
    private Integer count;

    public AccountInfo(Account account, Integer count) {
        this.account = account;
        this.count = count;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountInfo)) return false;
        AccountInfo that = (AccountInfo) o;
        return Objects.equals(getAccount(), that.getAccount()) && Objects.equals(getCount(), that.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccount(), getCount());
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "account=" + account +
                ", count=" + count +
                '}';
    }
}
