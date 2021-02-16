import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;


public class SenderTest {
    public void MessageSenderImplIsRus () {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        LocalizationServiceImpl localService = Mockito.mock(LocalizationServiceImpl.class);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localService);

        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        Mockito.when(localService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        Assertions.assertEquals( "Добро пожаловать", messageSender.send());


    }
    public void MessageSenderImplIsEng () {

    }
    public void GeoServiceImplGetLocation () {

    }
    public void GeoServiceImplGetLocale () {

    }
}
