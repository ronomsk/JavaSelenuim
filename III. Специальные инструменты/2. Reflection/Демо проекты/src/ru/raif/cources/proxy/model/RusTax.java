package ru.raif.cources.proxy.model;

public class RusTax implements TaxCalculator {
    @Override
    public double getTax(double summ) {
        return summ * 0.13;
    }
}
