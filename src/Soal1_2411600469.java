//        Jarak titik A dan titik B 1000 m.
//        Ali berangkat dari titik A ke titik B pukul 08:00:00
//        dengan kecepatan sebagai berikut:
//          10 detik pertama kecepatannya 2 m per detik.
//          10 detik berikutnya kecepatan naik menjadi 2.1 m per detik.
//        Demikian seterusnya, setiap 10 detik berikutnya
//        kecepatannya bertambah dengan 0.1 m per detik.
//
//        Satu menit kemudian , yaitu pukul 08: 01 : 00 ,
//        Badu berangkat juga dari titik A ke titik B, menysul Ali
//        dengan kecepatan tetap , 3 m per detik .
//        Susun program untuk mencetak pukul berapa
//        ( Jam : Menit : Detik ) Badu dapat mendahului Ali.

import java.util.ArrayList;
import java.util.List;

public class Soal1_2411600469 {
    public static void main(String[] args) {
        int distanceInMeters = 1000;

        List<TravelLog> aliTravelLog = new ArrayList<>();
        float speedAliMps = 2F;
        float speedIncrementAli = 0.1F;
        float aliTotalDistance = 0;
        int aliTotalSecond = 0;
        while (aliTotalDistance <= distanceInMeters) {
            if (aliTotalSecond != 0 && aliTotalSecond % 10 == 0) {
                speedAliMps = speedAliMps + speedIncrementAli;
            }
            aliTotalDistance = aliTotalDistance + speedAliMps;
            aliTotalSecond++;
            TravelLog log = new TravelLog(aliTotalSecond, aliTotalDistance);
            aliTravelLog.add(log);
        }

        int aliDepartureInHour = 8;
        int aliDepartureInMinute = 0;
        int aliDepartureInSecond = 0;
        int aliDepartHourToSecond = aliDepartureInHour * 3600;
        int aliDepartMinuteToSeconds = aliDepartureInMinute * 60;
        int aliTotalSecondsDepart = aliDepartHourToSecond + aliDepartMinuteToSeconds + aliDepartureInSecond;
        int aliTotalSecondsArrived = aliTotalSecondsDepart + aliTotalSecond;

        int hours = (aliTotalSecondsArrived / 3600) % 24;
        int minutes = (aliTotalSecondsArrived % 3600) / 60;
        int seconds = aliTotalSecondsArrived % 60;
        String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println("Ali tiba pada: " + timeFormatted + " (durasi perjalanan: " + aliTotalSecond + " detik)");

        List<TravelLog> baduTravelLog = new ArrayList<>();
        int speedBaduMps = 3;
        float baduTotalDistance = 0;
        int baduTotalSecond = 60;
        while (baduTotalDistance <= distanceInMeters) {
            baduTotalDistance = baduTotalDistance + speedBaduMps;
            baduTotalSecond++;
            TravelLog log = new TravelLog(baduTotalSecond, baduTotalDistance);
            baduTravelLog.add(log);
        }

        int baduDepartureInHour = 8;
        int baduDepartureInMinute = 1;
        int baduDepartureInSecond = 0;
        int baduDepartHourToSecond = baduDepartureInHour * 3600;
        int baduDepartMinuteToSeconds = baduDepartureInMinute * 60;
        int baduTotalSecondsDepart = baduDepartHourToSecond + baduDepartMinuteToSeconds + baduDepartureInSecond;
        int baduTotalSecondsArrived = baduTotalSecondsDepart + baduTotalSecond;

        int baduHours = (baduTotalSecondsArrived / 3600) % 24;
        int baduMinutes = (baduTotalSecondsArrived % 3600) / 60;
        int baduSeconds = baduTotalSecondsArrived % 60;
        String baduTimeFormatted = String.format("%02d:%02d:%02d", baduHours, baduMinutes, baduSeconds);
        System.out.println("Badu tiba pada: " + baduTimeFormatted + " (durasi perjalanan: " + baduTotalSecond + " detik)");

        boolean isBaduCanBeatAli = false;
        int beatInSecond = 0;
        for (TravelLog b: baduTravelLog) {
            for (TravelLog a: aliTravelLog) {
                if (b.distance > a.distance && b.second < a.second) {
                    isBaduCanBeatAli = true;
                    beatInSecond = b.second;
                    break;
                }
            }
        }

        if (isBaduCanBeatAli) {
            System.out.println("Badu Mendahului Ali pada detik: " + beatInSecond);
        } else {
            System.out.println("Badu tidak dapat mendahului Ali");
        }
    }
}
