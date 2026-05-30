package com.dotnicht.kiotatests.serviceobjects.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Covers required/nullable quadrants for nested objects and arrays.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Container implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The optional_nullable_address property
     */
    private Address optionalNullableAddress;
    /**
     * optional + nullable array
     */
    private java.util.List<Tag> optionalNullableTags;
    /**
     * The required_non_nullable_address property
     */
    private Address requiredNonNullableAddress;
    /**
     * required + non-nullable array
     */
    private java.util.List<Tag> requiredNonNullableTags;
    /**
     * The required_nullable_address property
     */
    private Address requiredNullableAddress;
    /**
     * Instantiates a new {@link Container} and sets the default values.
     */
    public Container() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Container}
     */
    @jakarta.annotation.Nonnull
    public static Container createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Container();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("optional_nullable_address", (n) -> { this.setOptionalNullableAddress(n.getObjectValue(Address::createFromDiscriminatorValue)); });
        deserializerMap.put("optional_nullable_tags", (n) -> { this.setOptionalNullableTags(n.getCollectionOfObjectValues(Tag::createFromDiscriminatorValue)); });
        deserializerMap.put("required_non_nullable_address", (n) -> { this.setRequiredNonNullableAddress(n.getObjectValue(Address::createFromDiscriminatorValue)); });
        deserializerMap.put("required_non_nullable_tags", (n) -> { this.setRequiredNonNullableTags(n.getCollectionOfObjectValues(Tag::createFromDiscriminatorValue)); });
        deserializerMap.put("required_nullable_address", (n) -> { this.setRequiredNullableAddress(n.getObjectValue(Address::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the optional_nullable_address property value. The optional_nullable_address property
     * @return a {@link Address}
     */
    @jakarta.annotation.Nullable
    public Address getOptionalNullableAddress() {
        return this.optionalNullableAddress;
    }
    /**
     * Gets the optional_nullable_tags property value. optional + nullable array
     * @return a {@link java.util.List<Tag>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Tag> getOptionalNullableTags() {
        return this.optionalNullableTags;
    }
    /**
     * Gets the required_non_nullable_address property value. The required_non_nullable_address property
     * @return a {@link Address}
     */
    @jakarta.annotation.Nonnull
    public Address getRequiredNonNullableAddress() {
        return this.requiredNonNullableAddress;
    }
    /**
     * Gets the required_non_nullable_tags property value. required + non-nullable array
     * @return a {@link java.util.List<Tag>}
     */
    @jakarta.annotation.Nonnull
    public java.util.List<Tag> getRequiredNonNullableTags() {
        return this.requiredNonNullableTags;
    }
    /**
     * Gets the required_nullable_address property value. The required_nullable_address property
     * @return a {@link Address}
     */
    @jakarta.annotation.Nullable
    public Address getRequiredNullableAddress() {
        return this.requiredNullableAddress;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("optional_nullable_address", this.getOptionalNullableAddress());
        writer.writeCollectionOfObjectValues("optional_nullable_tags", this.getOptionalNullableTags());
        writer.writeObjectValue("required_non_nullable_address", this.getRequiredNonNullableAddress());
        writer.writeCollectionOfObjectValues("required_non_nullable_tags", this.getRequiredNonNullableTags());
        writer.writeObjectValue("required_nullable_address", this.getRequiredNullableAddress());
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
     * Sets the optional_nullable_address property value. The optional_nullable_address property
     * @param value Value to set for the optional_nullable_address property.
     */
    public void setOptionalNullableAddress(@jakarta.annotation.Nullable final Address value) {
        this.optionalNullableAddress = value;
    }
    /**
     * Sets the optional_nullable_tags property value. optional + nullable array
     * @param value Value to set for the optional_nullable_tags property.
     */
    public void setOptionalNullableTags(@jakarta.annotation.Nullable final java.util.List<Tag> value) {
        this.optionalNullableTags = value;
    }
    /**
     * Sets the required_non_nullable_address property value. The required_non_nullable_address property
     * @param value Value to set for the required_non_nullable_address property.
     */
    public void setRequiredNonNullableAddress(final Address value) {
        this.requiredNonNullableAddress = value;
    }
    /**
     * Sets the required_non_nullable_tags property value. required + non-nullable array
     * @param value Value to set for the required_non_nullable_tags property.
     */
    public void setRequiredNonNullableTags(final java.util.List<Tag> value) {
        this.requiredNonNullableTags = value;
    }
    /**
     * Sets the required_nullable_address property value. The required_nullable_address property
     * @param value Value to set for the required_nullable_address property.
     */
    public void setRequiredNullableAddress(@jakarta.annotation.Nullable final Address value) {
        this.requiredNullableAddress = value;
    }
}
