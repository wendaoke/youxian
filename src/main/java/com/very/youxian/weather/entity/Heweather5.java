package com.very.youxian.weather.entity;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Auto-generated: 2017-07-19 0:34:26
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Heweather5 {

    private Aqi aqi;
    private Basic basic;
    @JsonProperty("daily_forecast")
    private List<DailyForecast> dailyForecast;
    @JsonProperty("hourly_forecast")
    private List<String> hourlyForecast;
    private Now now;
    private String status;
    private Suggestion suggestion;
    public void setAqi(Aqi aqi) {
         this.aqi = aqi;
     }
     public Aqi getAqi() {
         return aqi;
     }

    public void setBasic(Basic basic) {
         this.basic = basic;
     }
     public Basic getBasic() {
         return basic;
     }

    public void setDailyForecast(List<DailyForecast> dailyForecast) {
         this.dailyForecast = dailyForecast;
     }
     public List<DailyForecast> getDailyForecast() {
         return dailyForecast;
     }

    public void setHourlyForecast(List<String> hourlyForecast) {
         this.hourlyForecast = hourlyForecast;
     }
     public List<String> getHourlyForecast() {
         return hourlyForecast;
     }

    public void setNow(Now now) {
         this.now = now;
     }
     public Now getNow() {
         return now;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setSuggestion(Suggestion suggestion) {
         this.suggestion = suggestion;
     }
     public Suggestion getSuggestion() {
         return suggestion;
     }

}