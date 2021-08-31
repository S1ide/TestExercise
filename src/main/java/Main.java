import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private final static int COLUMNS_COUNT = 14;
    private static String COLUMN = "";
    private static ArrayList<Airport> airPorts = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(".\\src\\main\\data\\airports.dat"), StandardCharsets.UTF_8);
            Properties props = new Properties();
            props.load(new FileInputStream(new File(".\\src\\main\\conf\\param.ini")));
            COLUMN = props.getProperty("COLUMN");
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                String[] data = str.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                if (data.length == COLUMNS_COUNT) {
                    airPorts.add(new Airport(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12], data[13]));
                } else System.out.printf("Неверный формат строки: %s", str);
            }
            System.out.println("Программа готова к работе.");
            while (true) {
                scanner = new Scanner(System.in);
                System.out.printf("Введите колонку для поиска или нажмите ENTER, по умолчанию будет использована колонка %s\n", COLUMN);
                String column = scanner.nextLine();
                if (column.length() < 1) column = COLUMN;
                System.out.println("Введите строку для поиска:\nДля выхода напишите \"exit\".");
                String query = scanner.nextLine();
                if (query.equals("exit")) break;
                try {
                    long time = System.currentTimeMillis();
                    ArrayList<Airport> airports = Airport.getAirports(airPorts, column, query);
                    airports.forEach(airport -> System.out.println(airport.toString()));
                    System.out.println("Найдено аэропортов: " + airports.size());
                    System.out.println("Времени затрачено: " + (System.currentTimeMillis() - time) + " мс");
                } catch (NullPointerException ignored) {
                }
            }
        } catch (IOException e) {
            System.out.println("Необходимые файлы не найдены, проверьте есть ли в каталоге с Jar файлом «airports.dat» и «param.ini».");
        }
    }
}
