package com.dotnicht.kiotatests.serviceobjects.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Outer implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The middle property
     */
    private Middle middle;
    /**
     * The nullable_middle property
     */
    private Middle nullableMiddle;
    /**
     * Instantiates a new {@link Outer} and sets the default values.
     */
    public Outer() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Outer}
     */
    @jakarta.annotation.Nonnull
    public static Outer createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Outer();
    }
    /**
     * Gets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @return a {@link Map<String, Object>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("middle", (n) -> { this.setMiddle(n.getObjectValue(Middle::createFromDiscriminatorValue)); });
        deserializerMap.put("nullable_middle", (n) -> { this.setNullableMiddle(n.getObjectValue(Middle::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the id property value. The id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nonnull
    public Integer getId() {
        return this.id;
    }
    /**
     * Gets the middle property value. The middle property
     * @return a {@link Middle}
     */
    @jakarta.annotation.Nonnull
    public Middle getMiddle() {
        return this.middle;
    }
    /**
     * Gets the nullable_middle property value. The nullable_middle property
     * @return a {@link Middle}
     */
    @jakarta.annotation.Nullable
    public Middle getNullableMiddle() {
        return this.nullableMiddle;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("id", this.getId());
        writer.writeObjectValue("middle", this.getMiddle());
        writer.writeObjectValue("nullable_middle", this.getNullableMiddle());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(final Integer value) {
        this.id = value;
    }
    /**
     * Sets the middle property value. The middle property
     * @param value Value to set for the middle property.
     */
    public void setMiddle(final Middle value) {
        this.middle = value;
    }
    /**
     * Sets the nullable_middle property value. The nullable_middle property
     * @param value Value to set for the nullable_middle property.
     */
    public void setNullableMiddle(@jakarta.annotation.Nullable final Middle value) {
        this.nullableMiddle = value;
    }
}
