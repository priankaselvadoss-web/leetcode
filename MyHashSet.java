class MyHashSet {

    // Create our giant wall of switches
    private boolean[] set;

    public MyHashSet() {
        // Initialize the array to cover all possible keys from 0 to 1,000,000
        set = new boolean[1000001];
    }

    public void add(int key) {
        // Flip the switch ON for this specific key
        set[key] = true;
    }

    public void remove(int key) {
        // Flip the switch OFF for this specific key
        set[key] = false;
    }

    public boolean contains(int key) {
        // Just look at the switch and return its current state (true or false)
        return set[key];
    }
}