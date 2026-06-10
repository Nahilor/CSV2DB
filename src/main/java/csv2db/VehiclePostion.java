package csv2db;

public class VehiclePostion {
    private String vehicle_id;
    private double latitude;
    private double longitude;
    private String timestamp;
    private String route_id;
    private double speed;


    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getVehicle_id() {
        return this.vehicle_id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getRoute_id() {
        return this.route_id;
    }

    public double getSpeed() {
        return this.speed;
    }
}
