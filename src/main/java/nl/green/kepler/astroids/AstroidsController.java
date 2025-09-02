package nl.green.kepler.astroids;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.green.kepler.mapper.PageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("astroids")
public class AstroidsController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public AstroidsController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String astroids() throws JsonProcessingException {
        var url = "https://images-api.nasa.gov/search?q=Apophis";
        var response = restTemplate.getForObject(url, String.class);
        var planetResponses = objectMapper.readValue(response, AstroidsResponse.class);
        var planetResponse = planetResponses.collection().items().get(0);

        return PageHelper.getAstroidsPage(planetResponse);
    }
}
