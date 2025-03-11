package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @EnumSource(Country.class)
    public void testLocale(Country country) {
        // Given
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = country == Country.RUSSIA ? "Добро пожаловать" : "Welcome";

        // When
        String actual = localizationService.locale(country);

        // Then
        Assertions.assertEquals(expected, actual);
    }
}
