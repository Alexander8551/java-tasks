import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // Тесты на проверку логина
    @Test
    public void testValidLogin() {
        assertDoesNotThrow(() -> new User("validLogin", "Password1!", "test@example.com", 25));
    }

    @Test
    public void testInvalidLoginTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("log", "Password1!", "test@example.com", 25)
        );
        assertEquals("Логин должен содержать не менее 6 символов.", exception.getMessage());
    }

    @Test
    public void testNullLogin() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User(null, "Password1!", "test@example.com", 25)
        );
        assertEquals("Логин должен содержать не менее 6 символов.", exception.getMessage());
    }

    // Тесты на проверку пароля
    @Test
    public void testValidPassword() {
        assertDoesNotThrow(() -> new User("validLogin", "Password1!", "test@example.com", 25));
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "password1!", "test@example.com", 25)
        );
        assertEquals("Пароль не соответствует требованиям безопасности.", exception.getMessage());
    }

    @Test
    public void testInvalidPasswordNoLowercase() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "PASSWORD1!", "test@example.com", 25)
        );
        assertEquals("Пароль не соответствует требованиям безопасности.", exception.getMessage());
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Password!", "test@example.com", 25)
        );
        assertEquals("Пароль не соответствует требованиям безопасности.", exception.getMessage());
    }

    @Test
    public void testInvalidPasswordTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "P1!", "test@example.com", 25)
        );
        assertEquals("Пароль не соответствует требованиям безопасности.", exception.getMessage());
    }

    @Test
    public void testInvalidPasswordWithSpaces() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Pass word1!", "test@example.com", 25)
        );
        assertEquals("Пароль не соответствует требованиям безопасности.", exception.getMessage());
    }

    // Тесты на проверку email
    @Test
    public void testValidEmail() {
        assertDoesNotThrow(() -> new User("validLogin", "Password1!", "test@example.com", 25));
    }

    @Test
    public void testInvalidEmailNoAtSymbol() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Password1!", "testexample.com", 25)
        );
        assertEquals("Электронная почта указана в неверном формате.", exception.getMessage());
    }

    @Test
    public void testInvalidEmailNoDomain() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        new User("validLogin", "Password1!", "test@", 25)
    );
    assertEquals("Электронная почта указана в неверном формате.", exception.getMessage());
    }

    @Test
    public void testInvalidEmailNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Password1!", null, 25)
        );
        assertEquals("Электронная почта указана в неверном формате.", exception.getMessage());
    }

    // Тесты на проверку возраста
    @Test
    public void testValidAge() {
        assertDoesNotThrow(() -> new User("validLogin", "Password1!", "test@example.com", 25));
    }

    @Test
    public void testInvalidAgeTooYoung() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Password1!", "test@example.com", 17)
        );
        assertEquals("Возраст должен быть от 18 лет и не превышать разумных значений.", exception.getMessage());
    }

    @Test
    public void testInvalidAgeTooOld() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Password1!", "test@example.com", 121)
        );
        assertEquals("Возраст должен быть от 18 лет и не превышать разумных значений.", exception.getMessage());
    }

    @Test
    public void testInvalidAgeNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new User("validLogin", "Password1!", "test@example.com", -5)
        );
        assertEquals("Возраст должен быть от 18 лет и не превышать разумных значений.", exception.getMessage());
    }
}