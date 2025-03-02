package exercise;

import java.util.ArrayList;

class SafetyList {
    // BEGIN
    private ArrayList list = new ArrayList<Integer>();

    public synchronized void add(int n) {
        list.add(n);
    }

    public Integer get(int index) {
        return (Integer) list.get(index);
    }

    public int getSize() {
        return list.size();
    }
    // END
}
