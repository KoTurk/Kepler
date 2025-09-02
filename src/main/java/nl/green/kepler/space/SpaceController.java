package nl.green.kepler.space;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import nl.green.kepler.mapper.PageHelper;

@RestController
@RequestMapping("space")
public class SpaceController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${nasa.data.api.key}")
    private String token;

    public SpaceController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String space() throws JsonProcessingException {
        var url = "https://api.nasa.gov/planetary/apod?api_key=" + token + "&count=1&concept_tags";

        var response = restTemplate.getForObject(url, String.class);
        var planetResponses = objectMapper.readValue(response, AstronomyResponse[].class);
        var planetResponse = planetResponses[0];

        return PageHelper.getSpacePage(planetResponse);
    }
}