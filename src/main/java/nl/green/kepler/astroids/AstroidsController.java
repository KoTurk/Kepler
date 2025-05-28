package nl.green.kepler.astroids;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.green.kepler.astroids.AstroidsResponse;
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
                                            background-image: url(""" + planetResponse.links().get(0).href() + """
                                            );
                                            height: 100%;
                                        }
                
                       .explanation {
                         position: absolute;
                         left: 0;
                         top: 80%;
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
                           <span class="second">""" + planetResponse.data().get(0).description() + """
                           </span>
                           </div>
                       </div>
                
                       </body>
                       </html>""";
}
}
