import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scene yellow_1 = new Scene(SceneSpecification.YELLOW_1, new Event().of(LocalTime.of(16, 00), LocalTime.of(18, 20), "Iron Maiden", 130));
        Scene pink_2 = new Scene(SceneSpecification.PINK_2, new Event().of(LocalTime.of(17,00), LocalTime.of(19,50), "Judas Priest", 85.7));
        Scene orange_3 = new Scene(SceneSpecification.ORANGE_3, new Event().of(LocalTime.of(18,50), LocalTime.of(20,20), "Metallica", 110));
        Scene black_4 = new Scene(SceneSpecification.BLACK_4, new Event().of(LocalTime.of(19,30), LocalTime.of(22,20), "ACCD", 116));
        Scene green_5 = new Scene(SceneSpecification.GREEN_5, new Event().of(LocalTime.of(20,50), LocalTime.of(22,30), "RHCP", 99));
        Scene purple_6 = new Scene(SceneSpecification.PURPLE_6, new Event().of(LocalTime.of(17,00), LocalTime.of(19,30), "Guns N' Roses", 78.5));


        LocationsMap locationsMap = new LocationsMap(SceneSpecification.values().length);
        locationsMap.addRoad(SceneSpecification.YELLOW_1.getId(), SceneSpecification.PINK_2.getId(), 2);
        locationsMap.addRoad(SceneSpecification.PINK_2.getId(), SceneSpecification.ORANGE_3.getId(), 2);
        locationsMap.addRoad(SceneSpecification.ORANGE_3.getId(), SceneSpecification.BLACK_4.getId(), 3);
        locationsMap.addRoad(SceneSpecification.BLACK_4.getId(), SceneSpecification.GREEN_5.getId(), 2);
        locationsMap.addRoad(SceneSpecification.GREEN_5.getId(), SceneSpecification.PURPLE_6.getId(), 2);
        locationsMap.addRoad(SceneSpecification.PURPLE_6.getId(), SceneSpecification.YELLOW_1.getId(), 3);
        locationsMap.addRoad(SceneSpecification.YELLOW_1.getId(), SceneSpecification.GREEN_5.getId(), 6);
        locationsMap.addRoad(SceneSpecification.PINK_2.getId(), SceneSpecification.GREEN_5.getId(), 3);
        locationsMap.addRoad(SceneSpecification.ORANGE_3.getId(), SceneSpecification.GREEN_5.getId(), 6);


        ArrayList<Scene> scenes = EventUtil.createConcertPlan(new Scene[]{yellow_1, pink_2, orange_3, black_4, green_5, purple_6});
        scenes. stream().forEach(System.out::println);
    }
}
