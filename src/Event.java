import java.time.Duration;
import java.time.LocalTime;

public class Event {
    LocalTime start;
    LocalTime finish;
    String title;
    double price;

    public Duration getDuration(LocalTime start, LocalTime finish){
        Duration dur = Duration.between(start, finish);
        return dur;
    }

    public Event() {

    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public static Event of(LocalTime start, LocalTime finish, String title, double price){
        Event ev = new Event();
        ev.start = start;
        ev.finish = finish;
        ev.title = title;
        ev.price = price;
        return ev;
    }
}
