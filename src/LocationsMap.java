public class LocationsMap {
    int[][] adjoinMatrix;
    int numOfScenes;

    LocationsMap( int numOfScenes){
        this.adjoinMatrix = new int[numOfScenes][numOfScenes];
        this.numOfScenes = numOfScenes;
    }
    public void addRoad(int src, int dest, int distance){
        adjoinMatrix[src][dest] = distance;
        adjoinMatrix[dest][src] = distance;
    }
}
