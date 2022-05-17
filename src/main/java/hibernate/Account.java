package hibernate;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_number")
    private long accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Currency currency;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bank_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Bank bank;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AccountType accountType;
}
