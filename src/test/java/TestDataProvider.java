import org.testng.annotations.DataProvider;

public class TestDataProvider {

    String login = "fominaelena";
    String email1 = "efomina@company.ru";
    String spaceEmail = "  efomina@company.ru  ";
    String email2 = "efomina2@company.ru";
    String password = "1P73BP4Z";
    String spaceLogin = "  fominaelena  ";
    String wrongLogin = "qwe123!@#";
    String failedAuthAlertText = "Неверные данные для авторизации";

    @DataProvider
    public static Object[][] positiveAdditionData() {
        return new Object[][]{
                {"fominaelena", "1P73BP4Z"},
                {" fominaelena ", "1P73BP4Z"},
                {"fominaelena".toLowerCase(), "1P73BP4Z"},
                {"fominaelena".toUpperCase(), "1P73BP4Z"}
        };
    }

    @DataProvider
    public static Object[][] negativeAdditionData() {
        return new Object[][]{
                {"fominael", "1P73BP4Z"},
                {" fominaelena ", "1P73BP"},
                {"fominaelena", "1P73BP4Z".toLowerCase()},
                {"efomina@company.ru", "1P73BP4Z"},
                {"efomina2@company.ru", "1P73BP4Z"}
        };
    }
}
