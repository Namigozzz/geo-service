package sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {
    @Test
    public void testSendRussianText() {
        // Given
        GeoService geoService = Mockito.mock(GeoService.class);
        when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "172.0.32.11");

        String expected = "Добро пожаловать";

        // When
        String actual = messageSender.send(headers);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testSendEnglishText() {
        // Given
        GeoService geoService = Mockito.mock(GeoService.class);
        when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, "10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "96.44.183.149");

        String expected = "Welcome";

        // When
        String actual = messageSender.send(headers);

        // Then
        assertEquals(expected, actual);
    }
}
