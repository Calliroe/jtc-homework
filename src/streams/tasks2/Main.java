package streams.tasks2;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("1", "001");
        Account account2 = new Account("2", "002");
        Account account3 = new Account("3", "003");
        Account account4 = new Account("4", "004");
        Account account5 = new Account("5", "005");
        Account account6 = new Account("6", "006");

        Payment a = new Payment(account4, account1, 300.0, LocalDateTime.of(2021, 2, 5, 13, 0, 21), ProductCategory.FOOD);
        Payment b = new Payment(account4, account2, 300.0, LocalDateTime.of(2021, 2, 5, 13, 0, 21), ProductCategory.EDUCATION);
        Payment c = new Payment(account4, account3, 300.0, LocalDateTime.of(2021, 3, 6, 13, 0, 21), ProductCategory.MEDICINE);
        Payment d = new Payment(account5, account1, 300.0, LocalDateTime.of(2021, 5, 5, 13, 0, 21), ProductCategory.FOOD);
        Payment e = new Payment(account5, account2, 300.0, LocalDateTime.of(2021, 5, 25, 13, 0, 21), ProductCategory.EDUCATION);
        Payment f = new Payment(account5, account3, 300.0, LocalDateTime.of(2021, 7, 25, 13, 0, 21), ProductCategory.MEDICINE);
        Payment g = new Payment(account6, account5, 400.0, LocalDateTime.of(2021, 7, 4, 13, 0, 21), ProductCategory.FOOD);
        Payment h = new Payment(account6, account2, 300.0, LocalDateTime.of(2021, 8, 17, 13, 0, 21), ProductCategory.EDUCATION);
        Payment i = new Payment(account6, account5, 400.0, LocalDateTime.of(2021, 9, 20, 13, 0, 21), ProductCategory.FOOD);
        Payment j = new Payment(account6, account3, 300.0, LocalDateTime.of(2021, 10, 31, 13, 0, 21), ProductCategory.MEDICINE);

        PaymentRepository paymentRepository = new PaymentRepository() {
            @Override
            public Stream<Payment> findAll() {
                return Stream.of(a, b, c, d, e, f, g, h, i, j);
            }
        };

        for (Payment payment: paymentRepository.findAllInPeriod(LocalDateTime.of(2021, 2, 5, 13, 0, 21), LocalDateTime.of(2021, 5, 25, 13, 0, 21))){
            System.out.println(payment.toString());
        }
        System.out.println(paymentRepository.spentOnFood(LocalDateTime.of(2021, 2, 5, 13, 0, 21), LocalDateTime.of(2021, 8, 17, 13, 0, 21)));
        System.out.println(paymentRepository.spentMoreThanPlanned(900.0));
        System.out.println(paymentRepository.groupedByCategory("6", "006").toString());
        for (Payment payment: paymentRepository.paymentsBetweenDifferentAccounts()){
            System.out.println(payment.toString());
        }
        System.out.println(paymentRepository.paymentSumInPeriod(LocalDateTime.of(2021, 2, 5, 13, 0, 21), LocalDateTime.of(2021, 5, 25, 13, 0, 21)));
        System.out.println(paymentRepository.findDaysWithBiggestPayment());
        System.out.println(paymentRepository.findFirstDayWithBiggestPayment());
        for (AccountInfo accountInfo: paymentRepository.findPaymentsCountForAccount()){
            System.out.println(accountInfo);
        }
        System.out.println(paymentRepository.paymentsCount("4", "004"));
    }
}
