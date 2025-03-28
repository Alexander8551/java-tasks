import java.util.regex.Pattern;

public class User {
    private String login;
    private String password;
    private String email;
    private int age;

    // Конструктор с валидацией
    public User(String login, String password, String email, int age) {
        if (!isValidLogin(login)) {
            throw new IllegalArgumentException("Логин должен содержать не менее 6 символов.");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Пароль не соответствует требованиям безопасности.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Электронная почта указана в неверном формате.");
        }
        if (!isValidAge(age)) {
            throw new IllegalArgumentException("Возраст должен быть от 18 лет и не превышать разумных значений.");
        }

        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    // Проверка логина
    private boolean isValidLogin(String login) {
        return login != null && login.length() >= 6;
    }

    // Проверка пароля
    private boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        // Регулярное выражение для проверки пароля
        String passwordRegex = "^(?=.*[a-zа-я])(?=.*[A-ZА-Я])(?=.*\\d)[a-zA-Zа-яА-Я\\d~!?@#$%^&*(){}_\\-+<>/\\\\|\"'.:,;]{8,128}$";
        return Pattern.matches(passwordRegex, password) && !password.contains(" ");
    }

    // Проверка электронной почты
    private boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        // Регулярное выражение для проверки email
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    // Проверка возраста
    private boolean isValidAge(int age) {
        return age >= 18 && age <= 120; // Предположим, что максимальный возраст - 120 лет
    }

    // Геттеры
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}