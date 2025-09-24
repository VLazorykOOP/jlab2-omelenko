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
}
