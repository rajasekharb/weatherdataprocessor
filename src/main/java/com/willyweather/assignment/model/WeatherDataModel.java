package com.willyweather.assignment.model;

/**
 * A pojo class to hold one row of the data file
 *
 * @author Rajasekhar
 */
@SuppressWarnings("unused")
public class WeatherDataModel {

    private String stationNumber;

    private int weatherBureauAirForceNavy;

    private int yearMonthDay;

    private String meanMeanTemperature;

    private String meanDewPoint;

    private String seaLevelPressure;

    private String meanStationPressure;

    private String visibility;

    private String meanWindSpeed;

    private float maximumSustainedWindSpeed;

    private float maximumWindGust;

    private String maxTemperature;

    private String minTemperature;

    private String precipitation;

    private float snowDepth;

    private String fogRainSnowHailThunderTornado;

    public String getStationNumber() {
        return stationNumber;
    }

    public WeatherDataModel setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber;
        return this;
    }

    public int getWeatherBureauAirForceNavy() {
        return weatherBureauAirForceNavy;
    }

    public WeatherDataModel setWeatherBureauAirForceNavy(int weatherBureauAirForceNavy) {
        this.weatherBureauAirForceNavy = weatherBureauAirForceNavy;
        return this;
    }

    public int getYearMonthDay() {
        return yearMonthDay;
    }

    public WeatherDataModel setYearMonthDay(int yearMonthDay) {
        this.yearMonthDay = yearMonthDay;
        return this;
    }

    public String getMeanMeanTemperature() {
        return meanMeanTemperature;
    }

    public WeatherDataModel setMeanMeanTemperature(String meanMeanTemperature) {
        this.meanMeanTemperature = meanMeanTemperature;
        return this;
    }

    public String getMeanDewPoint() {
        return meanDewPoint;
    }

    public WeatherDataModel setMeanDewPoint(String meanDewPoint) {
        this.meanDewPoint = meanDewPoint;
        return this;
    }

    public String getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public WeatherDataModel setSeaLevelPressure(String seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
        return this;
    }

    public String getMeanStationPressure() {
        return meanStationPressure;
    }

    public WeatherDataModel setMeanStationPressure(String meanStationPressure) {
        this.meanStationPressure = meanStationPressure;
        return this;
    }

    public String getVisibility() {
        return visibility;
    }

    public WeatherDataModel setVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public String getMeanWindSpeed() {
        return meanWindSpeed;
    }

    public WeatherDataModel setMeanWindSpeed(String meanWindSpeed) {
        this.meanWindSpeed = meanWindSpeed;
        return this;
    }

    public float getMaximumSustainedWindSpeed() {
        return maximumSustainedWindSpeed;
    }

    public WeatherDataModel setMaximumSustainedWindSpeed(float maximumSustainedWindSpeed) {
        this.maximumSustainedWindSpeed = maximumSustainedWindSpeed;
        return this;
    }

    public float getMaximumWindGust() {
        return maximumWindGust;
    }

    public WeatherDataModel setMaximumWindGust(float maximumWindGust) {
        this.maximumWindGust = maximumWindGust;
        return this;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public WeatherDataModel setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
        return this;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public WeatherDataModel setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
        return this;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public WeatherDataModel setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
        return this;
    }

    public float getSnowDepth() {
        return snowDepth;
    }

    public WeatherDataModel setSnowDepth(float snowDepth) {
        this.snowDepth = snowDepth;
        return this;
    }

    public String getFogRainSnowHailThunderTornado() {
        return fogRainSnowHailThunderTornado;
    }

    public WeatherDataModel setFogRainSnowHailThunderTornado(String fogRainSnowHailThunderTornado) {
        this.fogRainSnowHailThunderTornado = fogRainSnowHailThunderTornado;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        WeatherDataModel that = (WeatherDataModel) object;

        if (weatherBureauAirForceNavy != that.weatherBureauAirForceNavy) return false;
        if (yearMonthDay != that.yearMonthDay) return false;
        if (Float.compare(that.maximumSustainedWindSpeed, maximumSustainedWindSpeed) != 0)
            return false;
        if (Float.compare(that.maximumWindGust, maximumWindGust) != 0) return false;
        if (Float.compare(that.snowDepth, snowDepth) != 0) return false;
        if (stationNumber != null ? !stationNumber.equals(that.stationNumber) : that
                .stationNumber != null)
            return false;
        if (meanMeanTemperature != null ? !meanMeanTemperature.equals(that.meanMeanTemperature) :
                that.meanMeanTemperature != null)
            return false;
        if (meanDewPoint != null ? !meanDewPoint.equals(that.meanDewPoint) : that.meanDewPoint !=
                null)
            return false;
        if (seaLevelPressure != null ? !seaLevelPressure.equals(that.seaLevelPressure) : that
                .seaLevelPressure != null)
            return false;
        if (meanStationPressure != null ? !meanStationPressure.equals(that.meanStationPressure) :
                that.meanStationPressure != null)
            return false;
        if (visibility != null ? !visibility.equals(that.visibility) : that.visibility != null)
            return false;
        if (meanWindSpeed != null ? !meanWindSpeed.equals(that.meanWindSpeed) : that
                .meanWindSpeed != null)
            return false;
        if (maxTemperature != null ? !maxTemperature.equals(that.maxTemperature) : that
                .maxTemperature != null)
            return false;
        if (minTemperature != null ? !minTemperature.equals(that.minTemperature) : that
                .minTemperature != null)
            return false;

        //noinspection SimplifiableIfStatement
        if (precipitation != null ? !precipitation.equals(that.precipitation) : that
                .precipitation != null)
            return false;
        return fogRainSnowHailThunderTornado != null ? fogRainSnowHailThunderTornado.equals(that
                .fogRainSnowHailThunderTornado) : that.fogRainSnowHailThunderTornado == null;

    }

    @Override
    public int hashCode() {
        int result = stationNumber != null ? stationNumber.hashCode() : 0;
        result = 31 * result + weatherBureauAirForceNavy;
        result = 31 * result + yearMonthDay;
        result = 31 * result + (meanMeanTemperature != null ? meanMeanTemperature.hashCode() : 0);
        result = 31 * result + (meanDewPoint != null ? meanDewPoint.hashCode() : 0);
        result = 31 * result + (seaLevelPressure != null ? seaLevelPressure.hashCode() : 0);
        result = 31 * result + (meanStationPressure != null ? meanStationPressure.hashCode() : 0);
        result = 31 * result + (visibility != null ? visibility.hashCode() : 0);
        result = 31 * result + (meanWindSpeed != null ? meanWindSpeed.hashCode() : 0);
        result = 31 * result + (maximumSustainedWindSpeed != +0.0f ? Float.floatToIntBits
                (maximumSustainedWindSpeed) : 0);
        result = 31 * result + (maximumWindGust != +0.0f ? Float.floatToIntBits(maximumWindGust)
                : 0);
        result = 31 * result + (maxTemperature != null ? maxTemperature.hashCode() : 0);
        result = 31 * result + (minTemperature != null ? minTemperature.hashCode() : 0);
        result = 31 * result + (precipitation != null ? precipitation.hashCode() : 0);
        result = 31 * result + (snowDepth != +0.0f ? Float.floatToIntBits(snowDepth) : 0);
        result = 31 * result + (fogRainSnowHailThunderTornado != null ?
                fogRainSnowHailThunderTornado.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WeatherDataModel{" +
                "stationNumber='" + stationNumber + '\'' +
                ", weatherBureauAirForceNavy=" + weatherBureauAirForceNavy +
                ", yearMonthDay=" + yearMonthDay +
                ", meanMeanTemperature='" + meanMeanTemperature + '\'' +
                ", meanDewPoint='" + meanDewPoint + '\'' +
                ", seaLevelPressure='" + seaLevelPressure + '\'' +
                ", meanStationPressure='" + meanStationPressure + '\'' +
                ", visibility='" + visibility + '\'' +
                ", meanWindSpeed='" + meanWindSpeed + '\'' +
                ", maximumSustainedWindSpeed=" + maximumSustainedWindSpeed +
                ", maximumWindGust=" + maximumWindGust +
                ", maxTemperature='" + maxTemperature + '\'' +
                ", minTemperature='" + minTemperature + '\'' +
                ", precipitation='" + precipitation + '\'' +
                ", snowDepth=" + snowDepth +
                ", fogRainSnowHailThunderTornado='" + fogRainSnowHailThunderTornado + '\'' +
                '}';
    }
}