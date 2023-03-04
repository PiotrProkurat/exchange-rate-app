package pl.kurs.exchangerateapp.services;

import pl.kurs.exchangerateapp.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;

public interface ICurrencyService {
    BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException, IOException;
}
