package networking.external;

import java.io.Serializable;

public class MyData implements Serializable {
    // final static long serialVersionUID = 2020_11_17L;

    public int x;
    public String y;
    // public List<Integer> z;

    public MyData(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("MyData(%d, %s)", x, y);
    }
}
