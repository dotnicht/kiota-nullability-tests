package com.dotnicht.kiotatests.serviceenums.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * String enum with snake_case serialized values.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum Status implements ValuedEnum {
    Active("active"),
    Inactive("inactive"),
    Pending("pending");
    public final String value;
    Status(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static Status forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "active": return Active;
            case "inactive": return Inactive;
            case "pending": return Pending;
            default: return null;
        }
    }
}
