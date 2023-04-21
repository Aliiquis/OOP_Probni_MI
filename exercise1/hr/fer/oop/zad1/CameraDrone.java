package hr.fer.oop.zad1;

class CameraDrone extends Aircraft implements Unmanned {
    private final int range;
    private int[] qualities;

    public CameraDrone(String model, String dateProduced, int range, int[] qualities) {
        super(model, dateProduced);
        this.range = range;
        this.qualities = qualities;
    }

    public int getRange() {
        return range;
    }

    public int[] getQualities() {
        return qualities;
    }

    public void setQualities(int[] qualities) {
        this.qualities = qualities;
    }

    @Override
    public Status aircraftStatus() {
        double avg = 0;
        for (int q : qualities) {
            avg += q;
        }
        avg /= qualities.length;
        if (avg > 70) {
            return Status.FUNCTIONAL;
        } else if (avg >= 50) {
            return Status.NEED_CHECK;
        } else {
            return Status.OUT_OF_SERVICE;
        }
    }

    @Override
    public double coverArea(Number height) {
        return (double) height * range;
    }

    @Override
    public String toString() {
        return super.toString() + " and has " + qualities.length + " elements.";
    }
}
