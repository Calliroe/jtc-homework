package hibernate.test;

import hibernate.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class CombinedRepositoryTest {

    private static final String ACCOUNT_TYPE_DEBET = "debet";
    private static final Long TINKOFF_ID = 3L;

    @Autowired
    private CombinedRepository repository;

    @Test
    public void getAmountOfAllOutgoingPaymentsByAccountNumber_outgoingPaymentsExist_shouldReturnAmount() {
        double sum = repository.getAmountOfAllOutgoingPaymentsByAccountNumber(1);

        assertThat(sum).isEqualTo(200.0);
    }

    @Test
    public void findAllPayerAccountsWithALargerAmountOfPayments_payerAccountsExist_shouldReturnAccounts() {
        List<Account> accounts = repository.findAllPayerAccountsWithALargerAmountOfPayments(100.0);

        assertThat(accounts.size()).isEqualTo(2);
    }

    @Test
    public void findAllRublePaymentsForCustomersWhoseNameStartsWithA_paymentsExist_shouldReturnPayments() {
        List<Payment> payments = repository.findAllRublePaymentsForCustomersWhoseNameStartsWithA('t');

        assertThat(payments.size()).isEqualTo(2);
    }

    @Test
    public void findAllPaymentsWhereThePayerAccountHasType_paymentsExist_shouldReturnPayments() {
        List<Payment> payments = repository.findAllPaymentsWhereThePayerAccountHasType(ACCOUNT_TYPE_DEBET);

        assertThat(payments.size()).isEqualTo(4);
    }

    @Test
    public void findAllClientsOfTheBank_clientsExist_shouldReturnClients() {
        List<Client> clients = repository.findAllClientsOfTheBank(TINKOFF_ID);

        assertThat(clients.size()).isEqualTo(2);
    }
}
