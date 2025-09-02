package nl.green.kepler.mars;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.green.kepler.mapper.PageHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        return PageHelper.getRoverPage(roverResponse);
    }

}
