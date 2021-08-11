package BOT;

public class PingPong {

    public String getPing(long time) {
        return "Ping: " + (System.currentTimeMillis() - time) + "ms";
    }
}

