package nl.green.kepler.mars;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
@RequestMapping("marsrover")
public class RoverController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${nasa.data.api.key}") private String token;

    public RoverController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String rover() throws JsonProcessingException {
        int randomSol = (int) (Math.random() * (2000 - 1000 + 1)) + 1000;

        var url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=" + randomSol +  "&api_key=" + token;

        var response = restTemplate.getForObject(url, String.class);
        var roverResponses = objectMapper.readValue(response, MarsPhotoResponse.class);
        var roverResponse = roverResponses.photos().get(0).imgSrc();
        System.out.println("Rover image url: " + roverResponse);

        return """
                <!DOCTYPE html>
                <html>
                <head>
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <style>
                body, html {
                  height: 100%;
                  margin: 0;
                  font: 400 15px/1.8 "Lato", sans-serif;
                }
        
                .bgimg-1 {
                  position: relative;
                  background-image: url(""" + roverResponse + """
                  );
                  background-position: center;
                  background-repeat: no-repeat;
                  background-size: cover;
                  height: 100%;
                }
                </style>
                </head>
                <body>
        
                <div class="bgimg-1"></div>
        
                </body>
                </html>
                """;
}
}
