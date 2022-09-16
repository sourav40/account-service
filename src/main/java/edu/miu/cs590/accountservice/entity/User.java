package edu.miu.cs590.accountservice.entity;

import edu.miu.cs590.accountservice.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private boolean active;

    @Column
    private String roles;

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "address",
            referencedColumnName = "id"
    )
    private Address address;
}

