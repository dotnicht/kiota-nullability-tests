package com.dotnicht.kiotatests.servicecollections.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import com.microsoft.kiota.serialization.UntypedNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Covers every array/map nullability permutation.| field                        | required | nullable array | nullable items ||------------------------------|----------|----------------|----------------|| required_strings             | yes      | no             | no             || required_nullable_strings    | yes      | yes            | no             || optional_strings             | no       | no             | no             || optional_nullable_strings    | no       | yes            | no             || nullable_item_strings        | yes      | no             | yes            || required_items               | yes      | no             | no             || nested                       | yes      | no             | no             || string_map                   | yes      |               | no             || nullable_value_map           | yes      |               | yes            || item_map                     | yes      |               | no             |
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Collections implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Map of objects  additionalProperties: $ref Item.
     */
    private CollectionsItemMap itemMap;
    /**
     * Nested array (array of arrays).
     */
    private UntypedNode nested;
    /**
     * Array whose items may be null.
     */
    private java.util.List<String> nullableItemStrings;
    /**
     * Map with nullable values  additionalProperties: { type: string, nullable: true }.
     */
    private CollectionsNullableValueMap nullableValueMap;
    /**
     * Optional nullable array of strings.
     */
    private java.util.List<String> optionalNullableStrings;
    /**
     * Optional non-nullable array of strings (not in required[]).
     */
    private java.util.List<String> optionalStrings;
    /**
     * Required array of inline objects.
     */
    private java.util.List<Item> requiredItems;
    /**
     * Required nullable array of strings.
     */
    private java.util.List<String> requiredNullableStrings;
    /**
     * Required non-nullable array of strings.
     */
    private java.util.List<String> requiredStrings;
    /**
     * Map&lt;string, string&gt;  additionalProperties: { type: string }.
     */
    private CollectionsStringMap stringMap;
    /**
     * Instantiates a new {@link Collections} and sets the default values.
     */
    public Collections() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Collections}
     */
    @jakarta.annotation.Nonnull
    public static Collections createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Collections();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(10);
        deserializerMap.put("item_map", (n) -> { this.setItemMap(n.getObjectValue(CollectionsItemMap::createFromDiscriminatorValue)); });
        deserializerMap.put("nested", (n) -> { this.setNested(n.getObjectValue(UntypedNode::createFromDiscriminatorValue)); });
        deserializerMap.put("nullable_item_strings", (n) -> { this.setNullableItemStrings(n.getCollectionOfPrimitiveValues(String.class)); });
        deserializerMap.put("nullable_value_map", (n) -> { this.setNullableValueMap(n.getObjectValue(CollectionsNullableValueMap::createFromDiscriminatorValue)); });
        deserializerMap.put("optional_nullable_strings", (n) -> { this.setOptionalNullableStrings(n.getCollectionOfPrimitiveValues(String.class)); });
        deserializerMap.put("optional_strings", (n) -> { this.setOptionalStrings(n.getCollectionOfPrimitiveValues(String.class)); });
        deserializerMap.put("required_items", (n) -> { this.setRequiredItems(n.getCollectionOfObjectValues(Item::createFromDiscriminatorValue)); });
        deserializerMap.put("required_nullable_strings", (n) -> { this.setRequiredNullableStrings(n.getCollectionOfPrimitiveValues(String.class)); });
        deserializerMap.put("required_strings", (n) -> { this.setRequiredStrings(n.getCollectionOfPrimitiveValues(String.class)); });
        deserializerMap.put("string_map", (n) -> { this.setStringMap(n.getObjectValue(CollectionsStringMap::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the item_map property value. Map of objects  additionalProperties: $ref Item.
     * @return a {@link CollectionsItemMap}
     */
    @jakarta.annotation.Nonnull
    public CollectionsItemMap getItemMap() {
        return this.itemMap;
    }
    /**
     * Gets the nested property value. Nested array (array of arrays).
     * @return a {@link UntypedNode}
     */
    @jakarta.annotation.Nonnull
    public UntypedNode getNested() {
        return this.nested;
    }
    /**
     * Gets the nullable_item_strings property value. Array whose items may be null.
     * @return a {@link java.util.List<String>}
     */
    @jakarta.annotation.Nonnull
    public java.util.List<String> getNullableItemStrings() {
        return this.nullableItemStrings;
    }
    /**
     * Gets the nullable_value_map property value. Map with nullable values  additionalProperties: { type: string, nullable: true }.
     * @return a {@link CollectionsNullableValueMap}
     */
    @jakarta.annotation.Nonnull
    public CollectionsNullableValueMap getNullableValueMap() {
        return this.nullableValueMap;
    }
    /**
     * Gets the optional_nullable_strings property value. Optional nullable array of strings.
     * @return a {@link java.util.List<String>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<String> getOptionalNullableStrings() {
        return this.optionalNullableStrings;
    }
    /**
     * Gets the optional_strings property value. Optional non-nullable array of strings (not in required[]).
     * @return a {@link java.util.List<String>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<String> getOptionalStrings() {
        return this.optionalStrings;
    }
    /**
     * Gets the required_items property value. Required array of inline objects.
     * @return a {@link java.util.List<Item>}
     */
    @jakarta.annotation.Nonnull
    public java.util.List<Item> getRequiredItems() {
        return this.requiredItems;
    }
    /**
     * Gets the required_nullable_strings property value. Required nullable array of strings.
     * @return a {@link java.util.List<String>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<String> getRequiredNullableStrings() {
        return this.requiredNullableStrings;
    }
    /**
     * Gets the required_strings property value. Required non-nullable array of strings.
     * @return a {@link java.util.List<String>}
     */
    @jakarta.annotation.Nonnull
    public java.util.List<String> getRequiredStrings() {
        return this.requiredStrings;
    }
    /**
     * Gets the string_map property value. Map&lt;string, string&gt;  additionalProperties: { type: string }.
     * @return a {@link CollectionsStringMap}
     */
    @jakarta.annotation.Nonnull
    public CollectionsStringMap getStringMap() {
        return this.stringMap;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("item_map", this.getItemMap());
        writer.writeObjectValue("nested", this.getNested());
        writer.writeCollectionOfPrimitiveValues("nullable_item_strings", this.getNullableItemStrings());
        writer.writeObjectValue("nullable_value_map", this.getNullableValueMap());
        writer.writeCollectionOfPrimitiveValues("optional_nullable_strings", this.getOptionalNullableStrings());
        writer.writeCollectionOfPrimitiveValues("optional_strings", this.getOptionalStrings());
        writer.writeCollectionOfObjectValues("required_items", this.getRequiredItems());
        writer.writeCollectionOfPrimitiveValues("required_nullable_strings", this.getRequiredNullableStrings());
        writer.writeCollectionOfPrimitiveValues("required_strings", this.getRequiredStrings());
        writer.writeObjectValue("string_map", this.getStringMap());
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
     * Sets the item_map property value. Map of objects  additionalProperties: $ref Item.
     * @param value Value to set for the item_map property.
     */
    public void setItemMap(final CollectionsItemMap value) {
        this.itemMap = value;
    }
    /**
     * Sets the nested property value. Nested array (array of arrays).
     * @param value Value to set for the nested property.
     */
    public void setNested(final UntypedNode value) {
        this.nested = value;
    }
    /**
     * Sets the nullable_item_strings property value. Array whose items may be null.
     * @param value Value to set for the nullable_item_strings property.
     */
    public void setNullableItemStrings(final java.util.List<String> value) {
        this.nullableItemStrings = value;
    }
    /**
     * Sets the nullable_value_map property value. Map with nullable values  additionalProperties: { type: string, nullable: true }.
     * @param value Value to set for the nullable_value_map property.
     */
    public void setNullableValueMap(final CollectionsNullableValueMap value) {
        this.nullableValueMap = value;
    }
    /**
     * Sets the optional_nullable_strings property value. Optional nullable array of strings.
     * @param value Value to set for the optional_nullable_strings property.
     */
    public void setOptionalNullableStrings(@jakarta.annotation.Nullable final java.util.List<String> value) {
        this.optionalNullableStrings = value;
    }
    /**
     * Sets the optional_strings property value. Optional non-nullable array of strings (not in required[]).
     * @param value Value to set for the optional_strings property.
     */
    public void setOptionalStrings(@jakarta.annotation.Nullable final java.util.List<String> value) {
        this.optionalStrings = value;
    }
    /**
     * Sets the required_items property value. Required array of inline objects.
     * @param value Value to set for the required_items property.
     */
    public void setRequiredItems(final java.util.List<Item> value) {
        this.requiredItems = value;
    }
    /**
     * Sets the required_nullable_strings property value. Required nullable array of strings.
     * @param value Value to set for the required_nullable_strings property.
     */
    public void setRequiredNullableStrings(@jakarta.annotation.Nullable final java.util.List<String> value) {
        this.requiredNullableStrings = value;
    }
    /**
     * Sets the required_strings property value. Required non-nullable array of strings.
     * @param value Value to set for the required_strings property.
     */
    public void setRequiredStrings(final java.util.List<String> value) {
        this.requiredStrings = value;
    }
    /**
     * Sets the string_map property value. Map&lt;string, string&gt;  additionalProperties: { type: string }.
     * @param value Value to set for the string_map property.
     */
    public void setStringMap(final CollectionsStringMap value) {
        this.stringMap = value;
    }
}
