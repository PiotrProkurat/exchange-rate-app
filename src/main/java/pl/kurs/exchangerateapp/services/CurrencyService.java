package pl.kurs.exchangerateapp.services;

import pl.kurs.exchangerateapp.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;

public class CurrencyService implements ICurrencyService{

    private final IRateService rateService;

    public CurrencyService(IRateService rateService) {
        this.rateService = rateService;
    }

    @Override
    public BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException, IOException {
        if (amount.doubleValue() <= 0)
            throw new InvalidInputDataException("Wartośc musi być powyżej zera!");

        BigDecimal specificRate = rateService.getRate(currencyFrom, currencyTo);

        return amount.multiply(specificRate);
    }


}
