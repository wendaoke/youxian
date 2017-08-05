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
public class HeWeatherV5 {

    @JsonProperty("HeWeather5")
    private List<Heweather5> heweather5;
    public void setHeweather5(List<Heweather5> heweather5) {
         this.heweather5 = heweather5;
     }
     public List<Heweather5> getHeweather5() {
         return heweather5;
     }

}