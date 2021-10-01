package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        LocalDateTime timeNow = LocalDateTime.now();//вызываем текущее время

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");//формат время в строке

        String formatDateTime = timeNow.format(formatter);// переводим текущее время в строку

        /** нужно чтобы заданное время было в тот же день
        * 10:50 того же дня как текущая дата
        * пишем в строку только текущий день без времени
        * прибавляем к дню время и парсим
        */
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");//берем текущею дату без времени
        String formatDateTime1 = timeNow.format(formatter1);// переводим в строку
        String formatDateTime2 = formatDateTime1 + " 10:50";// прибавляем к дню нужное время
        String formatDateTime3 = formatDateTime1 + " 11:45";
        String formatDateTime4 = formatDateTime1 + " 12:40";
        String formatDateTime5 = formatDateTime1 + " 13:30";

        Date dateS = format.parse(formatDateTime);// парсим текущее время
        Date dateE = format.parse(formatDateTime2);// персим нужное время

        long delt = dateE.getTime() - dateS.getTime();

        String result = String.format("%dд %dч %dмин",
                delt / 86400000,
                (delt % 86400000) / 3600000,
                (delt % 3600000) / 60000);

        System.out.println(result);// вывод
    }
}
