package streams.tasks2;

import java.time.LocalDateTime;
import java.util.Objects;

//@Data
class Payment {
    private Account from;
    private Account to;
    private Double amount;
    private LocalDateTime dateTime;
    private ProductCategory productCategory;

    public Payment() {
    }

    public Payment(Account from, Account to, Double amount, LocalDateTime dateTime, ProductCategory productCategory) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.dateTime = dateTime;
        this.productCategory = productCategory;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getFrom(), payment.getFrom()) && Objects.equals(getTo(), payment.getTo()) && Objects.equals(getAmount(), payment.getAmount()) && Objects.equals(getDateTime(), payment.getDateTime()) && getProductCategory() == payment.getProductCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo(), getAmount(), getDateTime(), getProductCategory());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", productCategory=" + productCategory +
                '}';
    }
}
