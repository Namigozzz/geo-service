package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest1 {
    @ParameterizedTest
    @CsvSource({
            "127.0.0.1,,,,0",
            "172.0.32.11,Moscow,RUSSIA,Lenina,15",
            "96.44.183.149,New York,USA,10th Avenue,32",
            "172.5.5.5,Moscow,RUSSIA,,0",
            "96.207.132.170,New York,USA,,0"
    })
    public void testByIp(String ip, String city, Country country, String street, int building) {
        // Given
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location(city, country, street, building);

        // When
        Location actual = geoService.byIp(ip);

        // Then
        Assertions.assertEquals(expected.getCity(), actual.getCity());
        Assertions.assertEquals(expected.getCountry(), actual.getCountry());
        Assertions.assertEquals(expected.getStreet(), actual.getStreet());
        Assertions.assertEquals(expected.getBuiling(), actual.getBuiling());
    }
}