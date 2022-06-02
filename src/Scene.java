public class Scene {
    public SceneSpecification sceneSpecification;
    public Event event;

    @Override
    public String toString() {
        return "Scene{" +
                "sceneSpecification=" + sceneSpecification +
                ", event=" + event +
                '}';
    }

    public Scene(SceneSpecification sceneSpecification, Event event) {
        this.sceneSpecification = sceneSpecification;
        this.event = event;
    }
}
