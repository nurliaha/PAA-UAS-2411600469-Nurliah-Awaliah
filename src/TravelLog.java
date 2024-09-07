public class TravelLog {
    int second;
    float distance;

    public TravelLog(int second, float distance) {
        this.second = second;
        this.distance = distance;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "TravelLog{" +
                "second=" + second +
                ", distance=" + distance +
                '}';
    }
}
