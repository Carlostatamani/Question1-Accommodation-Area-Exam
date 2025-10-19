public abstract class AccommodationArea {
    protected String name;
    protected int occupants;
    protected boolean[] lights;

    public AccommodationArea(String name) {
        this.name = name;
        this.occupants = 0;
        this.lights = new boolean[3]; // lights 1,2,3
    }

    public void addOccupants(int n) {
        occupants += n;
    }

    public void removeOccupants(int n) {
        occupants = Math.max(0, occupants - n);
    }

    public void switchOnLight(int lightNum) {
        if (lightNum >= 1 && lightNum <= 3) {
            lights[lightNum - 1] = true;
        }
    }

    public void switchOffLight(int lightNum) {
        if (lightNum >= 1 && lightNum <= 3) {
            lights[lightNum - 1] = false;
        }
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Area: ").append(name).append("\n");
        sb.append("Occupants: ").append(occupants).append("\n");
        sb.append("Lights: ");
        for (int i = 0; i < 3; i++) {
            sb.append("Light ").append(i+1).append(": ").append(lights[i] ? "ON" : "OFF");
            if (i < 2) sb.append(", ");
        }
        return sb.toString();
    }
}
