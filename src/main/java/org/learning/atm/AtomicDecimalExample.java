package org.learning.atm;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDecimalExample {
    public static void main(String[] args) {
        AtomicReference<BigDecimal> atomicDecimal = new AtomicReference<>(BigDecimal.ZERO);

        atomicDecimal.updateAndGet(currentValue -> currentValue.add(BigDecimal.valueOf(10.5)));
        atomicDecimal.updateAndGet(currentValue -> currentValue.subtract(BigDecimal.valueOf(2.3)));

        BigDecimal currentValue = atomicDecimal.get();
        System.out.println("Current value: " + currentValue);
    }
}