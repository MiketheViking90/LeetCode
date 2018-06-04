package seventeen.algorithms;

public class BulbSwitcher {

    public int bulbSwitch(int n) {
        if (n <= 1) {
            return n;
        }
        int count = 1;
        while (count*count <= n) {
            count++;
        }
        return count-1;
    }

}
