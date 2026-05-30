package com.dotnicht.kiotatests.servicecompositions.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import com.microsoft.kiota.serialization.UntypedNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Composition implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Discriminator-based union: serialises as `{ &quot;type&quot;: &quot;Dog&quot;, ... }`.
     */
    private UntypedNode animal;
    /**
     * Extended embeds Base via flatten; utoipa emits allOf in the schema.
     */
    private Extended extended;
    /**
     * Required nullable oneOf field.
     */
    private UntypedNode nullableValue;
    /**
     * The optional_extended property
     */
    private Extended optionalExtended;
    /**
     * Required non-nullable oneOf field.
     */
    private UntypedNode value;
    /**
     * Instantiates a new {@link Composition} and sets the default values.
     */
    public Composition() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Composition}
     */
    @jakarta.annotation.Nonnull
    public static Composition createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Composition();
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
     * Gets the animal property value. Discriminator-based union: serialises as `{ &quot;type&quot;: &quot;Dog&quot;, ... }`.
     * @return a {@link UntypedNode}
     */
    @jakarta.annotation.Nonnull
    public UntypedNode getAnimal() {
        return this.animal;
    }
    /**
     * Gets the extended property value. Extended embeds Base via flatten; utoipa emits allOf in the schema.
     * @return a {@link Extended}
     */
    @jakarta.annotation.Nonnull
    public Extended getExtended() {
        return this.extended;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("animal", (n) -> { this.setAnimal(n.getObjectValue(UntypedNode::createFromDiscriminatorValue)); });
        deserializerMap.put("extended", (n) -> { this.setExtended(n.getObjectValue(Extended::createFromDiscriminatorValue)); });
        deserializerMap.put("nullable_value", (n) -> { this.setNullableValue(n.getObjectValue(UntypedNode::createFromDiscriminatorValue)); });
        deserializerMap.put("optional_extended", (n) -> { this.setOptionalExtended(n.getObjectValue(Extended::createFromDiscriminatorValue)); });
        deserializerMap.put("value", (n) -> { this.setValue(n.getObjectValue(UntypedNode::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the nullable_value property value. Required nullable oneOf field.
     * @return a {@link UntypedNode}
     */
    @jakarta.annotation.Nullable
    public UntypedNode getNullableValue() {
        return this.nullableValue;
    }
    /**
     * Gets the optional_extended property value. The optional_extended property
     * @return a {@link Extended}
     */
    @jakarta.annotation.Nullable
    public Extended getOptionalExtended() {
        return this.optionalExtended;
    }
    /**
     * Gets the value property value. Required non-nullable oneOf field.
     * @return a {@link UntypedNode}
     */
    @jakarta.annotation.Nonnull
    public UntypedNode getValue() {
        return this.value;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("animal", this.getAnimal());
        writer.writeObjectValue("extended", this.getExtended());
        writer.writeObjectValue("nullable_value", this.getNullableValue());
        writer.writeObjectValue("optional_extended", this.getOptionalExtended());
        writer.writeObjectValue("value", this.getValue());
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
     * Sets the animal property value. Discriminator-based union: serialises as `{ &quot;type&quot;: &quot;Dog&quot;, ... }`.
     * @param value Value to set for the animal property.
     */
    public void setAnimal(final UntypedNode value) {
        this.animal = value;
    }
    /**
     * Sets the extended property value. Extended embeds Base via flatten; utoipa emits allOf in the schema.
     * @param value Value to set for the extended property.
     */
    public void setExtended(final Extended value) {
        this.extended = value;
    }
    /**
     * Sets the nullable_value property value. Required nullable oneOf field.
     * @param value Value to set for the nullable_value property.
     */
    public void setNullableValue(@jakarta.annotation.Nullable final UntypedNode value) {
        this.nullableValue = value;
    }
    /**
     * Sets the optional_extended property value. The optional_extended property
     * @param value Value to set for the optional_extended property.
     */
    public void setOptionalExtended(@jakarta.annotation.Nullable final Extended value) {
        this.optionalExtended = value;
    }
    /**
     * Sets the value property value. Required non-nullable oneOf field.
     * @param value Value to set for the value property.
     */
    public void setValue(final UntypedNode value) {
        this.value = value;
    }
}
