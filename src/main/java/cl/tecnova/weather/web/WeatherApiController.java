package cl.tecnova.weather.web;

import cl.tecnova.weather.integration.ows.Weather;
import cl.tecnova.weather.integration.ows.WeatherForecast;
import cl.tecnova.weather.integration.ows.WeatherService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

	private final WeatherService weatherService;

	public WeatherApiController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/now/{city}")
	public Weather getWeather(@PathVariable String city) {
		return this.weatherService.getWeather(city);
	}

	@RequestMapping("/weekly/{city}")
	public WeatherForecast getWeatherForecast(@PathVariable String city) {
		return this.weatherService.getWeatherForecast(city);
	}

}
