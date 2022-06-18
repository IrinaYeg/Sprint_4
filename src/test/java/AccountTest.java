import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AccountTest {

    // создаем поля тестового класса
    private final String name;
    private final boolean expected;

    // создаем конструктор тестового класса
    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    // передаем тестовые данные
    @Parameterized.Parameters
    public static Object[] getName() {
        return new Object[][] {
                { "Тимоти Шаламе", true},
                { "Т Ш", true}, // длина строки три символа
                { "Тимотей Шаламенский", true}, // длина строки 19-ть символов
                { "Тимофей Шалламенский", false}, // длина строки больше 19-ти символов
                { "ТШ", false}, // длина строки меньше трех символов
                { " ", false}, //пустая строка с пробелом
                { "", false}, // пустая строка без пробела
                { null, false}, // значение null
                { "ТимотейШевроле", false}, // нет хотя бы одного пробела
                { " Тимоти Шаламе", false}, // пробел в начале строки
                { "Тимоти Шаламе ", false}, // пробел в конце строки
                { "Тимотей   Шевроле", false}, // два пробела в середине
        };
    }

    @Test
    public void checkNameForCorrectness() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual); // проверка ожидаемого результата
    }
}