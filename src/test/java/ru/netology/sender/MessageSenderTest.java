package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void send_Rus() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Mockito.when(localService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        String result = messageSender.send(headers);
        Assertions.assertEquals( "Добро пожаловать", result);
    }
    @Test
    void send_USA() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        Mockito.when(localService.locale(Country.USA))
                .thenReturn("Welcome");

        String result = messageSender.send(headers);
        Assertions.assertEquals( "Welcome", result);
    }
}