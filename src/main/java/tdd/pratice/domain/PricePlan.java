package tdd.pratice.domain;

//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

public class PricePlan {

    private final String energySupplier;
    private final String planName;
    private final BigDecimal unitRate; // unit price per kWh
    private final List<PeakTimeMultiplier> peakTimeMultipliers;

    public PricePlan(String planName, String energySupplier, BigDecimal unitRate, List<PeakTimeMultiplier> peakTimeMultipliers) {
        this.planName = planName;
        this.energySupplier = energySupplier;
        this.unitRate = unitRate;
        if (peakTimeMultipliers == null || peakTimeMultipliers.isEmpty()) {
            this.peakTimeMultipliers = generatePeakTimeMultipliers();
        } else {
            this.peakTimeMultipliers = peakTimeMultipliers;
        }
    }

    public String getEnergySupplier() {
        return energySupplier;
    }

    public String getPlanName() {
        return planName;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public BigDecimal getPrice(LocalDateTime dateTime) {
        return peakTimeMultipliers.stream()
                .filter(multiplier -> multiplier.dayOfWeek.equals(dateTime.getDayOfWeek()))
                .findFirst()
                .map(multiplier -> unitRate.multiply(multiplier.multiplier))
                .orElse(unitRate);
    }


    static class PeakTimeMultiplier {

        DayOfWeek dayOfWeek;
        BigDecimal multiplier;


        public PeakTimeMultiplier(DayOfWeek dayOfWeek, BigDecimal multiplier) {
            this.dayOfWeek = dayOfWeek;
            this.multiplier = multiplier;
        }
    }

    private List<PeakTimeMultiplier> generatePeakTimeMultipliers() {
        List<PeakTimeMultiplier> peakTimeMultipliers = new LinkedList<>();
        Random peakRandomiser = new Random();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            double positiveRandomValue = Math.abs(peakRandomiser.nextGaussian());
            BigDecimal randomReading = BigDecimal.valueOf(positiveRandomValue).setScale(4, RoundingMode.CEILING);
            peakTimeMultipliers.add(new PeakTimeMultiplier(dayOfWeek, randomReading));
        }
        return peakTimeMultipliers;
    }
}
