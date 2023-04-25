package hr.fer.oop.zad1;

interface SpecialRequirements {
    String covid19Info();

    static boolean canIFlyCovid19(Status[] statusList, int fromCountryZone, int toCountryZone) {
        if (fromCountryZone <= toCountryZone) return true;
        if (fromCountryZone == 2) {
            for (Status s : statusList) {
                if (s == Status.VACCINATED || s == Status.RECOVERED || s == Status.TESTED) {
                    return true;
                }
            }
        }
        if (fromCountryZone == 3) {
            int v = 0, r = 0, t = 0;
            for (int i = 0; i < statusList.length; i++) {
                Status s = statusList[i];
                if (s == Status.VACCINATED) v++;
                if (s == Status.RECOVERED) r++;
                if (s == Status.TESTED) t++;
            }
            if (t > 0) {
                if (v > 0 || r > 0) return true;
                if (t > 1) return true;
            }
        }
        return false;
    }
}
