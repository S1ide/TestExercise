import java.util.ArrayList;

public class Airport implements Comparable{
    private int id;
    private String airport;
    private String city;
    private String country;
    private String lataCode;
    private String gpsCode;
    private String latitude;
    private String longitude;
    private String elevation;
    private String something1;
    private String something2;
    private String timeZone;
    private String something3;
    private String something4;

    @Override
    public String toString() {
        return id +", " + airport + ", " +city + ", " +country +", " +lataCode +", " +gpsCode + ", " +latitude + ", " +longitude + ", " +elevation + ", " +something1 + ", " +something2 + ", " +timeZone + ", " +something3 + ", " +something4 + ".";
    }

    Airport(int id, String airport, String city, String country, String lataCode, String gpsCode, String latitude, String longitude, String elevation, String something1, String something2, String timeZone, String something3, String something4) {
        this.id = id;
        this.airport = airport;
        this.city = city;
        this.country = country;
        this.lataCode = lataCode;
        this.gpsCode = gpsCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.something1 = something1;
        this.something2 = something2;
        this.timeZone = timeZone;
        this.something3 = something3;
        this.something4 = something4;
    }

    public static ArrayList<Airport> getAirports(ArrayList<Airport> airports, String column, String text) {
        ArrayList<Airport> res = new ArrayList<>();
        switch (column) {
            case ("id"):
                airports.stream().filter(air -> air.id == Integer.parseInt(text)).forEach(res::add);
                break;
            case ("airport"):
                airports.stream().filter(air -> air.airport.contains(text)).forEach(res::add);
                break;
            case ("city"):
                airports.stream().filter(air -> air.city.contains(text)).forEach(res::add);
                break;
            case ("country"):
                airports.stream().filter(air -> air.country.contains(text)).forEach(res::add);
                break;
            case ("lataCode"):
                airports.stream().filter(air -> air.lataCode.contains(text)).forEach(res::add);
                break;
            case ("gpsCode"):
                airports.stream().filter(air -> air.gpsCode.contains(text)).forEach(res::add);
                break;
            case ("latitude"):
                airports.stream().filter(air -> air.latitude.contains(text)).forEach(res::add);
                break;
            case ("longitude"):
                airports.stream().filter(air -> air.longitude.contains(text)).forEach(res::add);
                break;
            case ("elevation"):
                airports.stream().filter(air -> air.elevation.contains(text)).forEach(res::add);
                break;
            case ("something1"):
                airports.stream().filter(air -> air.something1.contains(text)).forEach(res::add);
                break;
            case ("something2"):
                airports.stream().filter(air -> air.something2.contains(text)).forEach(res::add);
                break;
            case ("timeZone"):
                airports.stream().filter(air -> air.timeZone.contains(text)).forEach(res::add);
                break;
            case ("something3"):
                airports.stream().filter(air -> air.something3.contains(text)).forEach(res::add);
                break;
            case ("something4"):
                airports.stream().filter(air -> air.something4.contains(text)).forEach(res::add);
                break;
            default:
                System.out.println("Ошибка ввода");
                return null;
        }
        if (res.size() > 0){
            return res;
        }
        System.out.println("Ничего не найдено");
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.id, ((Airport) o).id);
    }
}
