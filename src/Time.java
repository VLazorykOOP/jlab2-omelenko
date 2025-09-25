import static java.lang.Math.abs;

public class Time {
    private short hour;
    private short minute;
    private short second;

    public Time(int hour, int minute, int second) {
        this.hour = (short) hour;
        this.minute = (short) minute;
        this.second = (short) second;
    }

    public Time(String time) {
        String[] parts = time.split(":");
        this.hour = Short.parseShort(parts[0]);
        this.minute = Short.parseShort(parts[1]);
        this.second = Short.parseShort(parts[2]);
    }

    public Time(int seconds) {
        this.hour = (short) (seconds / 3600);
        this.minute = (short) ((seconds % 3600) / 60);
        this.second = (short) (seconds % 60);
    }

    public void addSeconds(int seconds) {
        this.hour += (short) (seconds / 3600);
        this.minute += (short) ((seconds % 3600) / 60);
        this.second += (short) (seconds % 60);
    }

    public void removeSeconds(int seconds) {
        this.hour -= (short) (seconds / 3600);
        this.minute -= (short) ((seconds % 3600) / 60);
        this.second += (short) (seconds % 60);
    }

    public void addTime(int hour, int minute, int second) {
        this.hour += (short) hour;
        this.minute += (short) minute;
        this.second += (short) second;
    }

    public void removeTime(int hour, int minute, int second) {
        this.hour -= (short) hour;
        this.minute -= (short) minute;
        this.second += (short) second;
    }

    public int toSeconds() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    public int toMinutes() {
        if (this.second > 30)
        {
            return this.hour * 60 + this.minute + 1;
        }
        return this.hour * 60 + this.minute;
    }

    public int TimeDifferenceSeconds(Time time1, Time time2) { return time1.toSeconds() - time2.toSeconds(); }

    public Time TimeDifference(Time time1, Time time2) {
        return new Time(abs(time1.toSeconds() - time2.toSeconds()));
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static void main(String[] args) {
        System.out.println("Тестування конструкторів:");
        Time time1 = new Time(10, 30, 45); // Конструктор з годинами, хвилинами, секундами
        System.out.println("Time1 (год:хв:сек): " + time1);

        Time time2 = new Time("14:20:15"); // Конструктор із рядка
        System.out.println("Time2 (з рядка): " + time2);

        Time time3 = new Time(3665); // Конструктор із секундами (3665 секунд = 1:01:05)
        System.out.println("Time3 (з секунд): " + time3);

        // Тестування додавання секунд
        System.out.println("\nТестування addSeconds:");
        time1.addSeconds(125); // Додаємо 125 секунд (2 хв 5 сек)
        System.out.println("Time1 після додавання 125 секунд: " + time1);

        // Тестування видалення секунд
        System.out.println("\nТестування removeSeconds:");
        time2.removeSeconds(125); // Видаляємо 125 секунд
        System.out.println("Time2 після видалення 125 секунд: " + time2);

        // Тестування додавання часу
        System.out.println("\nТестування addTime:");
        time3.addTime(1, 10, 20); // Додаємо 1 год, 10 хв, 20 сек
        System.out.println("Time3 після додавання 1:10:20: " + time3);

        // Тестування видалення часу
        System.out.println("\nТестування removeTime:");
        time1.removeTime(1, 10, 20); // Видаляємо 1 год, 10 хв, 20 сек
        System.out.println("Time1 після видалення 1:10:20: " + time1);

        // Тестування конвертації в секунди
        System.out.println("\nТестування toSeconds:");
        System.out.println("Time2 у секундах: " + time2.toSeconds());

        // Тестування конвертації в хвилини
        System.out.println("\nТестування toMinutes:");
        Time time4 = new Time(10, 30, 45); // Секунди > 30, має округлити хвилини
        System.out.println("Time4 (10:30:45) у хвилинах: " + time4.toMinutes());
        Time time5 = new Time(10, 30, 15); // Секунди ≤ 30, без округлення
        System.out.println("Time5 (10:30:15) у хвилинах: " + time5.toMinutes());

        // Тестування різниці часу
        System.out.println("\nТестування TimeDifferenceSeconds:");
        System.out.println("Різниця між Time1 і Time2 у секундах: " + time1.TimeDifferenceSeconds(time1, time2));

        System.out.println("\nТестування TimeDifference:");
        Time diff = time1.TimeDifference(time1, time2);
        System.out.println("Різниця між Time1 і Time2: " + diff);
    }
}
