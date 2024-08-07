package com.example.week02;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "pay_tb")
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pay_id;

    @Column(nullable = false)
    private Timestamp pay_date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Builder
    public Pay(Long pay_id, Timestamp pay_date, BigDecimal amount) {
        this.pay_id = pay_id;
        this.pay_date = pay_date;
        this.amount = amount;
    }
}
