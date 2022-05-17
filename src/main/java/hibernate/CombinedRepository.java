package hibernate;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("repository")
public class CombinedRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public double getAmountOfAllOutgoingPaymentsByAccountNumber(long accountNumber) {
        String queryStr = "select sum (p.amount) " +
                "from Payment p " +
                "where p.payerAccount.accountNumber = : accountNumber ";

        Query query = entityManager.createQuery(queryStr).setParameter("accountNumber", accountNumber);
        return (double) query.getSingleResult();
    }

    public List<Account> findAllPayerAccountsWithALargerAmountOfPayments(double amount) {
        String queryStr = "select a " +
                "from Account a, Payment p " +
                "where p.payerAccount = a " +
                "and a.currency.name = 'rouble' " +
                "group by a.id " +
                "having sum (p.amount) > :amount";

        Query query = entityManager.createQuery(queryStr).setParameter("amount", amount);
        return query.getResultList();
    }

    public List<Payment> findAllRublePaymentsForCustomersWhoseNameStartsWithA(char startLetter) {
        String queryStr = "select p " +
                "from Payment p " +
                "where p.receiverAccount.currency.name = 'rouble' and p.receiverAccount.client.name like :letter " +
                "or p.payerAccount.currency.name = 'rouble' and p.payerAccount.client.name like :letter ";

        Query query = entityManager.createQuery(queryStr).setParameter("letter", startLetter + "%");
        return query.getResultList();
    }

    public List<Payment> findAllPaymentsWhereThePayerAccountHasType(String accountType) {
        String queryStr = "select p " +
                "from Payment p " +
                "where p.payerAccount.accountType.name = :accountTypeName";

        Query query = entityManager.createQuery(queryStr).setParameter("accountTypeName", accountType);
        return query.getResultList();
    }

    public List<Client> findAllClientsOfTheBank(Long bankId) {
        String queryStr = "select c " +
                "from Client c, Account a " +
                "where a.client = c " +
                "and a.bank.id = :bankId";

        Query query = entityManager.createQuery(queryStr).setParameter("bankId", bankId);
        return query.getResultList();
    }

}
