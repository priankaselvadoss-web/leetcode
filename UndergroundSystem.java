class UndergroundSystem {

    // Stores: id -> (stationName, checkInTime)
    private Map<Integer, CheckIn> checkInMap;

    // Stores: "start->end" -> (totalTime, tripCount)
    private Map<String, Route> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String route = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Route stats = travelMap.getOrDefault(route, new Route());
        stats.totalTime += travelTime;
        stats.tripCount++;
        travelMap.put(route, stats);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Route stats = travelMap.get(route);
        return (double) stats.totalTime / stats.tripCount;
    }

    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class Route {
        long totalTime;
        int tripCount;
    }
}