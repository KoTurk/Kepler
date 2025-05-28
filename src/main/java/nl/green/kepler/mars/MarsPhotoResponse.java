package nl.green.kepler.mars;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MarsPhotoResponse(
 @JsonProperty("photos") List<Photo> photos
) {
    public record Photo(
        @JsonProperty("id") int id,
        @JsonProperty("sol") int sol,
        @JsonProperty("camera") Camera camera,
        @JsonProperty("img_src") String imgSrc,
        @JsonProperty("earth_date") String earthDate,
        @JsonProperty("rover") Rover rover
) {}

public record Camera(
@JsonProperty("id") int id,
@JsonProperty("name") String name,
@JsonProperty("rover_id") int roverId,
@JsonProperty("full_name") String fullName
) {}

public record Rover(

        @JsonProperty("id") int id,

        @JsonProperty("name") String name,

        @JsonProperty("landing_date") String landingDate,

        @JsonProperty("launch_date") String launchDate,

        @JsonProperty("status") String status
) {}
}

