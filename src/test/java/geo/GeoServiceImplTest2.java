package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest2 {
    @Test
    public void testByCoordinates() {
        // Given
        GeoService geoService = new GeoServiceImpl();

        // Then
        Assertions.assertThrowsExactly(RuntimeException.class, () -> geoService.byCoordinates(100, 100));
    }
}