package pl.wsb.kms.trainee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class BodyMetrics {

    @Column(name = "height_cm", nullable = false)
    private Integer heightCm;

    @Column(name = "weight_kg", nullable = false, precision = 5, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "body_fat_percentage", precision = 4, scale = 1)
    private BigDecimal bodyFatPercentage;

    protected BodyMetrics() {}

    public BodyMetrics(Integer heightCm, BigDecimal weightKg, BigDecimal bodyFatPercentage) {
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public Integer getHeightCm() {
        return heightCm;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public BigDecimal getBodyFatPercentage() {
        return bodyFatPercentage;
    }
}
