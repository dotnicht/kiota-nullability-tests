package com.dotnicht.kiotatests.serviceobjects.models;

import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Extended embeds Base via flatten, which utoipa maps to allOf.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Extended extends Base implements Parsable {
    /**
     * The extra property
     */
    private String extra;
    /**
     * The optional_nullable property
     */
    private String optionalNullable;
    /**
     * Instantiates a new {@link Extended} and sets the default values.
     */
    public Extended() {
        super();
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Extended}
     */
    @jakarta.annotation.Nonnull
    public static Extended createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Extended();
    }
    /**
     * Gets the extra property value. The extra property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getExtra() {
        return this.extra;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(super.getFieldDeserializers());
        deserializerMap.put("extra", (n) -> { this.setExtra(n.getStringValue()); });
        deserializerMap.put("optional_nullable", (n) -> { this.setOptionalNullable(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the optional_nullable property value. The optional_nullable property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getOptionalNullable() {
        return this.optionalNullable;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        super.serialize(writer);
        writer.writeStringValue("extra", this.getExtra());
        writer.writeStringValue("optional_nullable", this.getOptionalNullable());
    }
    /**
     * Sets the extra property value. The extra property
     * @param value Value to set for the extra property.
     */
    public void setExtra(@jakarta.annotation.Nullable final String value) {
        this.extra = value;
    }
    /**
     * Sets the optional_nullable property value. The optional_nullable property
     * @param value Value to set for the optional_nullable property.
     */
    public void setOptionalNullable(@jakarta.annotation.Nullable final String value) {
        this.optionalNullable = value;
    }
}
