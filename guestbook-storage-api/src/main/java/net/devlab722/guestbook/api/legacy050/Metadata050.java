package net.devlab722.guestbook.api.legacy050;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.devlab722.guestbook.api.Metadata;

@Getter
@EqualsAndHashCode
@ToString
@Builder
@JsonDeserialize(builder = Metadata050.Metadata050Builder.class)
public class Metadata050 {

    public static final String VERSION = "0.5.0";

    private final String apiServerName;
    private final String datetimeString;
    private final String filterServerName;
    private final String filterDatetimeString;
    private final String gatewayServerName;
    private final String gatewayDatetimeString;
    private final String errorString;
    private boolean inError = false;

    public Metadata toCurrent() {
        return Metadata.builder()
                .storageServerName(apiServerName)
                .storageDatetimeString(datetimeString)
                .filterServerName(filterServerName)
                .filterDatetimeString(filterDatetimeString)
                .gatewayServerName(gatewayServerName)
                .gatewayDatetimeString(gatewayDatetimeString)
                .errorString(errorString)
                .convertedFromFormat(VERSION)
                .build();
    }

    public static Metadata050Builder of(Metadata050 original) {
        if (original != null) {
            return Metadata050.builder()
                    .apiServerName(original.getApiServerName())
                    .datetimeString(original.getDatetimeString())
                    .filterServerName(original.getFilterServerName())
                    .filterDatetimeString(original.getFilterDatetimeString())
                    .gatewayServerName(original.getGatewayServerName())
                    .gatewayDatetimeString(original.gatewayDatetimeString)
                    .errorString(original.getErrorString());
        } else {
            return Metadata050.builder();
        }
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Metadata050Builder {
    }
}