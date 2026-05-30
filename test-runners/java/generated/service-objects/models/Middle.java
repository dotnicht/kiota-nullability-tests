package com.dotnicht.kiotatests.serviceobjects.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Middle implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The inner property
     */
    private Inner inner;
    /**
     * The label property
     */
    private String label;
    /**
     * The optional_inner property
     */
    private Inner optionalInner;
    /**
     * Instantiates a new {@link Middle} and sets the default values.
     */
    public Middle() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Middle}
     */
    @jakarta.annotation.Nonnull
    public static Middle createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Middle();
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
        deserializerMap.put("inner", (n) -> { this.setInner(n.getObjectValue(Inner::createFromDiscriminatorValue)); });
        deserializerMap.put("label", (n) -> { this.setLabel(n.getStringValue()); });
        deserializerMap.put("optional_inner", (n) -> { this.setOptionalInner(n.getObjectValue(Inner::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the inner property value. The inner property
     * @return a {@link Inner}
     */
    @jakarta.annotation.Nonnull
    public Inner getInner() {
        return this.inner;
    }
    /**
     * Gets the label property value. The label property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getLabel() {
        return this.label;
    }
    /**
     * Gets the optional_inner property value. The optional_inner property
     * @return a {@link Inner}
     */
    @jakarta.annotation.Nullable
    public Inner getOptionalInner() {
        return this.optionalInner;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("inner", this.getInner());
        writer.writeStringValue("label", this.getLabel());
        writer.writeObjectValue("optional_inner", this.getOptionalInner());
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
     * Sets the inner property value. The inner property
     * @param value Value to set for the inner property.
     */
    public void setInner(final Inner value) {
        this.inner = value;
    }
    /**
     * Sets the label property value. The label property
     * @param value Value to set for the label property.
     */
    public void setLabel(final String value) {
        this.label = value;
    }
    /**
     * Sets the optional_inner property value. The optional_inner property
     * @param value Value to set for the optional_inner property.
     */
    public void setOptionalInner(@jakarta.annotation.Nullable final Inner value) {
        this.optionalInner = value;
    }
}
