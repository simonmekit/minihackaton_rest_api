package org.perscholas.minihackathon3_rest_api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rating {
    private String source;
    private String value;

    // toString() method for debugging or logging purposes
    @Override
    public String toString() {
        return "Rating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
