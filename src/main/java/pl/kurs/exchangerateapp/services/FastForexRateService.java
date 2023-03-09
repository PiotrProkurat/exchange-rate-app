package pl.kurs.exchangerateapp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.exchangerateapp.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public class FastForexRateService implements IRateService {

    private final IUrlStringBuilder urlStringBuilder;
    private final ObjectMapper objectMapper;

    public FastForexRateService(IUrlStringBuilder urlStringBuilder, ObjectMapper objectMapper) {
        this.urlStringBuilder = urlStringBuilder;
        this.objectMapper = objectMapper;
    }

    @Override
    public BigDecimal getRate(String currencyFrom, String CurrencyTo) throws InvalidInputDataException {
        String preparedUrl = urlStringBuilder.buildURL(currencyFrom);
        JsonNode currencies;
        String rate;

        try {
            currencies = objectMapper.readTree(new URL(preparedUrl));
        } catch (IOException e) {
            throw new InvalidInputDataException("Wpisana waluta, ktora chcesz wymienic jest niepoprawna!");
        }

        if (currencies.get("results").get(CurrencyTo) != null &&
                !currencies.get("results").get(CurrencyTo).isMissingNode()) {
            rate = currencies.get("results").get(CurrencyTo).asText();
        } else {
            throw new InvalidInputDataException("Wpisana waluta, na ktora chcesz wymienic jest niepoprawna!");
        }

        return new BigDecimal(rate);
    }
}
