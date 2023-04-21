package hr.fer.oop.zad1;

class Plane extends Aircraft {
    private int capacity;
    private int[] motorsStatus;

    public Plane(String model, String dateProduced, int capacity, int[] motorsStatus) {
        super(model, dateProduced);
        this.capacity = capacity;
        this.motorsStatus = motorsStatus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int[] getMotorsStatus() {
        return motorsStatus;
    }

    public void setMotorsStatus(int[] motorsStatus) {
        this.motorsStatus = motorsStatus;
    }

    @Override
    public Status aircraftStatus() {
        int min = Integer.MAX_VALUE;
        for (int s : motorsStatus) {
            if (s < min) {
                min = s;
            }
        }
        if (min < 80) {
            return Status.OUT_OF_SERVICE;
        } else if (min < 100) {
            return Status.NEED_CHECK;
        } else {
            return Status.FUNCTIONAL;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " and has " + motorsStatus.length + " motors and capacity of " + capacity + '.';
    }
}
