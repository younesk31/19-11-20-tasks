public class City {
    private final int id;
    private final String name;
    private final int population;
    private final String countryCode;

    public City(int id, String name, String countryCode, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
    }

    @Override
    public String toString() {
        return  "ID:" + id + " --> City Name: (" + name + ") --> CountryCode: (" + countryCode + ") --> Population: "+ population;
    }
}