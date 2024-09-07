//        Jarak titik A dan titik B 1000 m.
//        Ali berangkat dari titik A ke titik B pukul 8 tepat ( 08:00:00 )
//        dengan kecepatan sebagai berikut :
//          Pada detik ke-1 kecepatannya 2 m per detik.
//          Pada detik ke-2 kecepatannya 2.1 m per detik
//          Pada detik ke-3 kecepatannya 2.2 m per detik
//        Demikian seterusnya setiap detik berikutnya kecepatannya selalu betmabah 0.1 m per detik.
//
//        Badu berangkat dari titik B ke titik A pukul 8 lewat 10 detik (08:00:10)
//        dengan kecepatan 3 m per detik.
//        Susun program untuk mencetak pada detik keberapa setelah pukul 8 Ali dan Badu berpapasan di jalan.
//        Juga mencetak jarak Badu dengan titik B setelah detik merekaberpapasan.

import java.util.ArrayList;
import java.util.List;

public class Soal2_2411600469 {
    public static void main(String[] args) {
        int distanceInMeters = 1000;

        List<TravelLog> aliTravelLog = new ArrayList<>();
        float speedAliMps = 2F;
        float speedIncrementAli = 0.1F;
        float aliTotalDistance = 0;
        int aliTotalSecond = 0;
        while (aliTotalDistance <= distanceInMeters) {
            if (aliTotalSecond != 0) {
                speedAliMps = speedAliMps + speedIncrementAli;
            }
            aliTotalDistance = aliTotalDistance + speedAliMps;
            aliTotalSecond++;
            TravelLog log = new TravelLog(aliTotalSecond, aliTotalDistance);
            aliTravelLog.add(log);
        }

//        System.out.println("Ali: " + aliTravelLog);

        List<TravelLog> baduTravelLog = new ArrayList<>();
        int speedBaduMps = 3;
        float baduTotalDistance = 0;
        int baduTotalSecond = 0;
        while (baduTotalDistance <= distanceInMeters) {
            baduTotalDistance = baduTotalDistance + speedBaduMps;
            baduTotalSecond++;
            TravelLog log = new TravelLog(baduTotalSecond, baduTotalDistance);
            baduTravelLog.add(log);
        }

//        System.out.println("Badu: " + baduTravelLog);

        float baduDistanceRemaining = 0F;
        int crossPathInSecond = 0;
        boolean found = false;
        for (TravelLog b: baduTravelLog) {
            for (TravelLog a: aliTravelLog) {
                if (Math.abs(b.distance + a.distance - distanceInMeters) < 0.1) {
                    baduDistanceRemaining = distanceInMeters - b.distance;
                    crossPathInSecond = b.second;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        int departureInHour = 8;
        int departureInMinute = 0;
        int departureInSecond = 10;
        int departHourToSecond = departureInHour * 3600;
        int departMinuteToSeconds = departureInMinute * 60;
        int totalCrossPathInSecond = departHourToSecond + departMinuteToSeconds + departureInSecond + crossPathInSecond;

        int hours = (totalCrossPathInSecond / 3600) % 24;
        int minutes = (totalCrossPathInSecond % 3600) / 60;
        int seconds = totalCrossPathInSecond % 60;
        String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println("Badu Berpapasan dengan Ali pada: " + timeFormatted + " atau pada detik: " + crossPathInSecond);
        System.out.println("Sisa Jarak Badu adalah: " + baduDistanceRemaining + " meter");
    }
}
