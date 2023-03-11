package pl.kurs.exchangerateapp.services;

import pl.kurs.exchangerateapp.config.AppConfig;

public class FastForexUrlBuilder implements IUrlStringBuilder {
    @Override
    public String buildURL(String fromCurrencyMark) {
        return AppConfig.API_PAGE + AppConfig.ENDPOINT + fromCurrencyMark + AppConfig.API_KEY;
    }
}
