public enum SceneSpecification {
    YELLOW_1(1), PINK_2(2), ORANGE_3(3), BLACK_4(4), GREEN_5(5), PURPLE_6(6);

    private final int id;

    public int getId() {
        return id;
    }
    SceneSpecification(int a){
        this.id = a-1;
    }

    @Override
    public String toString() {
        return "SceneSpecification{" +
                "id=" + id +
                '}';
    }
}
