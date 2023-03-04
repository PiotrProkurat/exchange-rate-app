package pl.kurs.exchangerateapp.services;

import pl.kurs.exchangerateapp.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;

public interface IRateService {

    BigDecimal getRate(String currencyFrom, String CurrencyTo) throws IOException, InvalidInputDataException;
}
