package nl.green.kepler.astroids;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AstroidsResponse(
    @JsonProperty("collection") Collection collection
) {
    public record Collection(
        @JsonProperty("version") String version,
        @JsonProperty("href") String href,
        @JsonProperty("items") List<Item> items
    ) {}

    public record Item(
        @JsonProperty("href") String href,
        @JsonProperty("data") List<Data> data,
        @JsonProperty("links") List<Link> links) {}

    public record Data(
        @JsonProperty("center") String center,
        @JsonProperty("date_created") String dateCreated,
        @JsonProperty("description") String description,
        @JsonProperty("description_508") String description508,
        @JsonProperty("keywords") List<String> keywords,
        @JsonProperty("media_type") String mediaType,
        @JsonProperty("nasa_id") String nasaId,
        @JsonProperty("secondary_creator") String secondaryCreator,
        @JsonProperty("title") String title
    ) {}

    public record Link(
        @JsonProperty("href") String href,
        @JsonProperty("rel") String rel,
        @JsonProperty("render") String render,
        @JsonProperty("width") int width,
        @JsonProperty("size") int size,
        @JsonProperty("height") int height
    ) {}
}

