package app;

import tasks.Date;
import tasks.Prism;
import tasks.Calendar;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");
        Date.main(args);
        Prism prism = new Prism(5, 3);
        System.out.println("Площа бічної основи = " + prism.getSide());
        System.out.println("Об'єм призми = " + prism.getVolume());
        System.out.println(Calendar.getDay(32, 2002));
    }
}
