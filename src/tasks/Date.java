package tasks;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date implements Comparable<Date> {
    private byte year;
    private byte month;
    private byte day;

    public Date(int year, int month, int day) {
        setDate(year, month, day);
    }

    public Date(String dateStr) {
        String[] parts = dateStr.split("\\.");
        if (parts.length != 3)
            throw new IllegalArgumentException("Невірний формат дати!");
        setDate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    public Date(Date other) {
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }

    private void setDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        this.year = (byte) date.getYear();
        this.month = (byte) date.getMonthValue();
        this.day = (byte) date.getDayOfMonth();
    }

    private LocalDate toLocalDate() {
        return LocalDate.of(Byte.toUnsignedInt(year),
                Byte.toUnsignedInt(month),
                Byte.toUnsignedInt(day));
    }

    public void addDays(int days) {
        LocalDate newDate = toLocalDate().plusDays(days);
        setDate(newDate.getYear(), newDate.getMonthValue(), newDate.getDayOfMonth());
    }

    public void subtractDays(int days) {
        LocalDate newDate = toLocalDate().minusDays(days);
        setDate(newDate.getYear(), newDate.getMonthValue(), newDate.getDayOfMonth());
    }

    public boolean isLeapYear() {
        return java.time.Year.isLeap(Byte.toUnsignedInt(year));
    }

    public int getYear() {
        return Byte.toUnsignedInt(year);
    }

    public int getMonth() {
        return Byte.toUnsignedInt(month);
    }

    public int getDay() {
        return Byte.toUnsignedInt(day);
    }

    public void setYear(int year) {
        setDate(year, getMonth(), getDay());
    }

    public void setMonth(int month) {
        setDate(getYear(), month, getDay());
    }

    public void setDay(int day) {
        setDate(getYear(), getMonth(), day);
    }

    @Override
    public int compareTo(Date other) {
        System.out.println("compareTo = " + this.toLocalDate().compareTo(other.toLocalDate()));
        return this.toLocalDate().compareTo(other.toLocalDate());
    }

    public boolean equals(Date other) {
        return this.toLocalDate().equals(other.toLocalDate());
    }

    public boolean before(Date other) {
        return this.toLocalDate().isBefore(other.toLocalDate());
    }

    public boolean after(Date other) {
        return this.toLocalDate().isAfter(other.toLocalDate());
    }

    public long daysBetween(Date other) {
        return ChronoUnit.DAYS.between(this.toLocalDate(), other.toLocalDate());
    }

    @Override
    public String toString() {
        return String.format("%d.%02d.%02d", getYear(), getMonth(), getDay());
    }

    public static void main(String[] args) {
        Date d1 = new Date(2024, 2, 28);
        System.out.println("d1 = " + d1);

        d1.addDays(1);
        System.out.println("Після +1 день = " + d1); // 2024.02.29

        d1.addDays(1);
        System.out.println("Після +1 день = " + d1); // 2024.03.01

        Date d2 = new Date("2024.03.10");
        System.out.println("d2 = " + d2);

        System.out.println("d1 before d2? " + d1.before(d2));
        System.out.println("Кількість днів між d1 і d2 = " + d1.daysBetween(d2));
        Date d3 = new Date(d2);
        System.out.println("d3 (копія d2) = " + d3);
    }
}
