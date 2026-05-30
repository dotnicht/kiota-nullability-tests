package com.dotnicht.kiotatests.serviceenums.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Integer enum represented as i32 discriminants.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum Code implements ValuedEnum {
    Zero("0"),
    One("1"),
    Two("2");
    public final String value;
    Code(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static Code forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "0": return Zero;
            case "1": return One;
            case "2": return Two;
            default: return null;
        }
    }
}
