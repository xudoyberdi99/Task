public class City {
    private int cityCode;
    private String city;

    public City() {
    }
    public City(int city_code, String city) {
        this.cityCode = city_code;
        this.city = city;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    @Override
    public String toString() {
        return "City{" +
                "cityCode=" + cityCode +
                ", city='" + city + '\'' +
                '}';
    }
}
