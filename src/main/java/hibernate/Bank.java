package hibernate;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long bic;
}
