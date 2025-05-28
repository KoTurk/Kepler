package nl.green.kepler.earth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("earth")
public class EarthController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${nasa.data.api.key}") private String token;

    public EarthController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String earth() throws JsonProcessingException {
        var url = "https://api.nasa.gov/planetary/apod?api_key=" + token + "&count=1&concept_tags";

        var response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        var planetResponses = objectMapper.readValue(response, EarthResponse[].class);
        var planetResponse = planetResponses[0];
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
                
                       .bgimg-1, .bgimg-2, .bgimg-3 {
                         position: relative;
                         background-position: center;
                         background-repeat: no-repeat;
                         background-size: cover;
                
                       }
                       .bgimg-1 {
                                            background-image: url(""" + planetResponse.hdurl() + """
                                            );
                                            height: 100%;
                                        }
                
                       .explanation {
                         position: absolute;
                         left: 0;
                         top: 50%;
                         width: 100%;
                         text-align: center;
                       }
                
                       .explanation {
                         background-color: #111;
                          opacity: 0.4;
                       }
                
                       .explanation span.second {
                         background-color: #111;
                         color: #fff;
                         font-size: 20px;
                       }
                
                
                       h3 {
                         letter-spacing: 5px;
                         text-transform: uppercase;
                         font: 20px "Lato", sans-serif;
                         color: #111;
                       }
                
                       </style>
                       </head>
                       <body>
                
                       <div class="bgimg-1">
                          <div class="explanation">
                           <span class="second">""" + planetResponse.explanation() + """
                           </span>
                           </div>
                       </div>
                
                       </body>
                       </html>""";
}
}
