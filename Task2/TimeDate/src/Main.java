public class Main {
    public static void main(String[] args) {
        // Пример использования классов
        Date date = new Date(2024, 1, 10);
        System.out.println("Date: " + date.formatDate("dd.MM.yyyy"));
        System.out.println("Leap year? " + date.isLeapYear()); // Високосный год?
        System.out.println("Timestamp: " + date.toTimestamp());

        TimeDate timeDate = new TimeDate(2023, 3, 11, 14, 30, 45);
        System.out.println("Date and time: " + timeDate.formatDate("dd-MM-yyyy") + " " + timeDate.formatTime());
        timeDate.modifyTime(16, 45, 0);
        System.out.println("Modified time: " + timeDate.formatTime());
    }
}

class Date {
    protected int year;
    protected int month;
    protected int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Проверка, является ли год високосным
    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Преобразование даты в timestamp
    public long toTimestamp() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day, 0, 0, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    // Форматирование даты в строку в указанном формате
    public String formatDate(String format) {
        String formattedDate = format;
        formattedDate = formattedDate.replace("dd", String.format("%02d", day));
        formattedDate = formattedDate.replace("MM", String.format("%02d", month));
        formattedDate = formattedDate.replace("yyyy", String.valueOf(year));
        return formattedDate;
    }
}

// Класс TimeDate, наследующий Date
class TimeDate extends Date {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeDate(int year, int month, int day, int hours, int minutes, int seconds) {
        super(year, month, day);
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Форматирование времени в строку (без даты)
    public String formatTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Модификация времени
    public void modifyTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}
