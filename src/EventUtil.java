import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventUtil {
    public static final double priceForKM = 2.5;

    public static ArrayList<Scene> createConcertPlan(Scene[] scene){
        LocalTime[] startTime = new LocalTime[scene.length];
        LocalTime[] finishTime = new LocalTime[scene.length];
        for(int i =0; i<scene.length; i++){
            startTime[i] = scene[i].event.getStart();
            finishTime[i] = scene[i].event.getFinish();
        }
        int n = startTime.length;

        ArrayList<Scene> scenes = new ArrayList<>();
        int i = 0;
        for(int j = 1; j< scene.length; j++){
            if(startTime[j].isAfter(finishTime[i]) || startTime[j].equals(finishTime[i])){
                scenes.add(scene[j]);
            }
            i=j;
        }
        return scenes;
    }
    public static int[] shortestPathBetweenScene(LocationsMap im, int src){
        int[] distance = new int[im.numOfScenes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[im.numOfScenes];
        Arrays.fill(visited, false);
        distance[0] = 0;
        for(int i= 0; i<im.numOfScenes; i++){
            int closesLocation = getClosesLocation(distance, visited);
            visited[closesLocation] = true;
            for(int j = 0; j<im.numOfScenes; j++){
                if(!visited[j]){
                    if(im.adjoinMatrix[closesLocation][j] != 0){
                        int d = distance[closesLocation] + im.adjoinMatrix[closesLocation][j];
                        if(d<distance[j]){
                            distance[j] = d;
                        }
                    }
                }
            }
        }
        return distance;
    }
    public static int getClosesLocation(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minInd = -1;
        for(int i = 0; i<distance.length; i++){
            if(distance[i]<min){
                if(!visited[i]){
                    min = distance[i];
                    minInd = i;
                }
            }
        }
        return minInd;
    }
}
