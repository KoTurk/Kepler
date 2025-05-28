package nl.green.kepler.space;

// is a response from the NASA API
// it contains the date, explanation, hdurl, media_type, service_version, title and url
// it is used to deserialize the response from the NASA API
import com.fasterxml.jackson.annotation.JsonProperty;

// @JsonProperty is used to map the JSON property to the Java field
public record AstronomyResponse(
    @JsonProperty("date") String date,

    @JsonProperty("explanation") String explanation,

    @JsonProperty("hdurl") String hdurl,

    @JsonProperty("media_type") String mediaType,

    @JsonProperty("service_version") String serviceVersion,

    @JsonProperty("title") String title,

    @JsonProperty("url") String url) {}
