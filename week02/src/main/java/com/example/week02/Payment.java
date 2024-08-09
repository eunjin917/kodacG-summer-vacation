package com.example.week02;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long cardId;

    @Column(nullable = false)
    private int pointUsed;

    @Builder
    public Payment(Long id, Long cardId, int pointUsed) {
        this.id = id;
        this.cardId = cardId;
        this.pointUsed = pointUsed;
    }
}
