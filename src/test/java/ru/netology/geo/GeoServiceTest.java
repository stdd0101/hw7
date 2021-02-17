package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceTest {

    private GeoService geo;

    @BeforeEach
    void setUp() throws Exception{
        this.geo = new GeoServiceImpl();
    }

    @Test
    void byIp_Should_Return_Rus_Location() {
        Location location = geo.byIp("172.0.32.11");
        Assertions.assertEquals("Moscow", location.getCity());
    }
    @Test
    void byIp_Should_Return_USA_Location() {
        Location location = geo.byIp("96.44.183.149");
        Assertions.assertEquals("New York", location.getCity());
    }
}