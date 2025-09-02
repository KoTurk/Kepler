package nl.green.kepler.mapper;

import nl.green.kepler.astroids.AstroidsResponse;
import nl.green.kepler.earth.EarthResponse;
import nl.green.kepler.space.AstronomyResponse;

public class PageHelper {

    public static String getSpacePage(AstronomyResponse planetResponse) {
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
                                            background-image: url(""" + planetResponse.url() + """
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
                    <span class="second">""" + planetResponse.explanation() + """
                    </span>
                    </div>
                </div>
                
                </body>
                </html>""";
    }

    public static String getRoverPage(String roverResponse) {
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

    public static String getEarthPage(EarthResponse planetResponse) {
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

    public static String getAstroidsPage(AstroidsResponse.Item planetResponse) {
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
