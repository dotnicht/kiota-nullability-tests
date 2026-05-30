package com.dotnicht.kiotatests.serviceenums.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * String enum with explicit rename values.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum Priority implements ValuedEnum {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");
    public final String value;
    Priority(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static Priority forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "LOW": return LOW;
            case "MEDIUM": return MEDIUM;
            case "HIGH": return HIGH;
            default: return null;
        }
    }
}
