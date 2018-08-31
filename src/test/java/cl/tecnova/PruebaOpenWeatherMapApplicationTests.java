
package cl.tecnova;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cl.tecnova.weather.integration.ows.WeatherService;
import cl.tecnova.weather.web.WeatherApiController;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherApiController.class)
public class PruebaOpenWeatherMapApplicationTests {

	@MockBean
	private WeatherService weatherService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void weather() throws Exception {
		
		this.mvc.perform(get("/api/weather/now/Santiago"))
				.andExpect(status().isOk());
			
		verify(this.weatherService).getWeather("Santiago");
	}
	
	@Test
	public void weatherForecast() throws Exception {
		
		this.mvc.perform(get("/api/weather/weekly/Santiago"))
				.andExpect(status().isOk());
			
		verify(this.weatherService).getWeatherForecast("Santiago");
	}
	
}
