package com.example.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.l;

public class Create {
    //    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date date = simpleDateFormat.parse("2024-4-28 0:00:00");
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date);
//            for (int i = 1; i < 289; i++) {
//                System.out.println(simpleDateFormat.format(date));
//                calendar.add(Calendar.MINUTE, 5);
//                date = calendar.getTime();
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i <289 ; i++) {
            System.out.println(random.nextDouble()+random.nextInt(31)-50);
        }
    }

}
