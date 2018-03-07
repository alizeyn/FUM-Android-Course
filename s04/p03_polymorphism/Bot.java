package p03_polymorphism;

public class Bot implements Comparable<Bot>{
    private int x, y, z;
    private String code;
    private boolean alive;

    public Bot(String code) {
        this.alive = true;
        this.code = code;
    }

    void move(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    void selfDestruction() {
        this.alive = false;
        this.code = null;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(Bot o) {
        if (o.getCode() == this.getCode()) {
            return 0;
        }
        return -1;
    }
}
