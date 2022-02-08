package hibernate;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "payer_account_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Account payerAccount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_account_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Account receiverAccount;

    private double amount;
    private String name;
}
