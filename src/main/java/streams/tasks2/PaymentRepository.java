package streams.tasks2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class PaymentRepository {


    public abstract Stream<Payment> findAll();

    // найти все платежи за указанный интервал
    public List<Payment> findAllInPeriod(LocalDateTime start, LocalDateTime end) {
        return findAll().filter(payment -> payment.getDateTime().isAfter(start) && payment.getDateTime().isBefore(end))
                .collect(Collectors.toList());
    }

    // найти общее количество денег, потраченных на еду за указанный интервал
    public Double spentOnFood(LocalDateTime start, LocalDateTime end) {
        return findAll().filter(payment -> payment.getDateTime().isAfter(start) && payment.getDateTime().isBefore(end) && payment.getProductCategory().equals(ProductCategory.FOOD))
                .map(Payment::getAmount)
                .reduce(0.0, Double::sum);
    }

    // найти категории продуктов, на которые было потрачено больше чем планировалось
    public List<ProductCategory> spentMoreThanPlanned(Double planned) {
        Map<ProductCategory, Double> map = findAll().collect(Collectors.groupingBy(Payment::getProductCategory, Collectors.summingDouble(Payment::getAmount)));
        return map.entrySet().stream()
                .filter(category -> category.getValue() > planned)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // найти все платежи со счета, сгруппированные по категориям
    public Map<ProductCategory, List<Payment>> groupedByCategory(String accountNumber, String bic) {
        return findAll().filter(payment -> payment.getFrom().getBic().equals(bic) && payment.getFrom().getAccountNumber().equals(accountNumber))
                .collect(Collectors.groupingBy(Payment::getProductCategory));
    }

    // найти все платежи между разными счетами
    public List<Payment> paymentsBetweenDifferentAccounts() {
        return findAll().filter(payment -> !payment.getFrom().equals(payment.getTo()))
                .collect(Collectors.toList());
    }

    // найти сумму платежей за период
    public Double paymentSumInPeriod(LocalDateTime start, LocalDateTime end) {
        return findAll().filter(p -> (p.getDateTime().isAfter(start) && p.getDateTime().isBefore(end)))
                .map(Payment::getAmount)
                .reduce(0.0, Double::sum);
    }

    // получить дни с самым большим платежом
    public List<LocalDate> findDaysWithBiggestPayment() {
        Optional<Double> maxPayment = findAll().max(Comparator.comparing(Payment::getAmount))
                .map(Payment::getAmount);
        return maxPayment.map(aDouble -> findAll().filter(payment -> payment.getAmount().equals(aDouble))
                .map(payment -> payment.getDateTime().toLocalDate())
                .collect(Collectors.toList())).orElse(null);
    }

    // получить первый попавшийся день с самым большим платежом
    public LocalDate findFirstDayWithBiggestPayment() {
        return findAll().max(Comparator.comparing(Payment::getAmount))
                .map(payment -> payment.getDateTime().toLocalDate()).orElse(null);
    }

    // получить информацию по количеству переводов на счета получателя
    public List<AccountInfo> findPaymentsCountForAccount() {
        Map<Account, Long> map = findAll().collect(Collectors.groupingBy(Payment::getTo, Collectors.counting()));
        return map.entrySet().stream()
                .map(account -> new AccountInfo(account.getKey(), account.getValue().intValue()))
                .collect(Collectors.toList());
    }

    // получить количество переводов на заданный счет
    public Integer paymentsCount(String accountNumber, String bic) {
        long l = findAll()
                .filter(payment -> payment.getTo().getAccountNumber().equals(accountNumber) && payment.getTo().getBic().equals(bic))
                .count();
        return (int) l;
    }

}
