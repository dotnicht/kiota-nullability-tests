package com.dotnicht.kiotatests.serviceobjects.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Address implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The city property
     */
    private String city;
    /**
     * The street property
     */
    private String street;
    /**
     * Instantiates a new {@link Address} and sets the default values.
     */
    public Address() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Address}
     */
    @jakarta.annotation.Nonnull
    public static Address createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Address();
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
     * Gets the city property value. The city property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getCity() {
        return this.city;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(2);
        deserializerMap.put("city", (n) -> { this.setCity(n.getStringValue()); });
        deserializerMap.put("street", (n) -> { this.setStreet(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the street property value. The street property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getStreet() {
        return this.street;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("city", this.getCity());
        writer.writeStringValue("street", this.getStreet());
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
     * Sets the city property value. The city property
     * @param value Value to set for the city property.
     */
    public void setCity(final String value) {
        this.city = value;
    }
    /**
     * Sets the street property value. The street property
     * @param value Value to set for the street property.
     */
    public void setStreet(final String value) {
        this.street = value;
    }
}
