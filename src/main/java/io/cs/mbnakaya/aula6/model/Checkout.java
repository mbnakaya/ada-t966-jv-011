package io.cs.mbnakaya.aula6.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Checkout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long total;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod method;
}
