package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class LocalizationServiceTest {

    private LocalizationService local;

    @BeforeEach
    void setUp() throws Exception{
        this.local = new LocalizationServiceImpl();
    }

    @Test
    void locale_isRussia() {
        Country country = RUSSIA;
        String result = local.locale(country);
        Assertions.assertEquals("Добро пожаловать", result);
    }
    @Test
    void locale_isUSA() {
        Country country = USA;
        String result = local.locale(country);
        Assertions.assertEquals("Welcome", result);
    }
}