package com.dotnicht.kiotatests.serviceenums.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Covers required/nullable quadrants, plus array-of-enum and integer enum.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class EnumContainer implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Integer enum represented as i32 discriminants.
     */
    private Code code;
    /**
     * nullable array of enums (required)
     */
    private java.util.List<Status> nullableStatuses;
    /**
     * String enum with explicit rename values.
     */
    private Priority optionalNonNullablePriority;
    /**
     * The optional_nullable_priority property
     */
    private Priority optionalNullablePriority;
    /**
     * String enum with snake_case serialized values.
     */
    private Status requiredNonNullableStatus;
    /**
     * The required_nullable_status property
     */
    private Status requiredNullableStatus;
    /**
     * array of enum values (required, non-nullable)
     */
    private java.util.List<Status> statuses;
    /**
     * Instantiates a new {@link EnumContainer} and sets the default values.
     */
    public EnumContainer() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link EnumContainer}
     */
    @jakarta.annotation.Nonnull
    public static EnumContainer createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new EnumContainer();
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
     * Gets the code property value. Integer enum represented as i32 discriminants.
     * @return a {@link Code}
     */
    @jakarta.annotation.Nonnull
    public Code getCode() {
        return this.code;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(7);
        deserializerMap.put("code", (n) -> { this.setCode(n.getEnumValue(Code::forValue)); });
        deserializerMap.put("nullable_statuses", (n) -> { this.setNullableStatuses(n.getCollectionOfEnumValues(Status::forValue)); });
        deserializerMap.put("optional_non_nullable_priority", (n) -> { this.setOptionalNonNullablePriority(n.getEnumValue(Priority::forValue)); });
        deserializerMap.put("optional_nullable_priority", (n) -> { this.setOptionalNullablePriority(n.getEnumValue(Priority::forValue)); });
        deserializerMap.put("required_non_nullable_status", (n) -> { this.setRequiredNonNullableStatus(n.getEnumValue(Status::forValue)); });
        deserializerMap.put("required_nullable_status", (n) -> { this.setRequiredNullableStatus(n.getEnumValue(Status::forValue)); });
        deserializerMap.put("statuses", (n) -> { this.setStatuses(n.getCollectionOfEnumValues(Status::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the nullable_statuses property value. nullable array of enums (required)
     * @return a {@link java.util.List<Status>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Status> getNullableStatuses() {
        return this.nullableStatuses;
    }
    /**
     * Gets the optional_non_nullable_priority property value. String enum with explicit rename values.
     * @return a {@link Priority}
     */
    @jakarta.annotation.Nullable
    public Priority getOptionalNonNullablePriority() {
        return this.optionalNonNullablePriority;
    }
    /**
     * Gets the optional_nullable_priority property value. The optional_nullable_priority property
     * @return a {@link Priority}
     */
    @jakarta.annotation.Nullable
    public Priority getOptionalNullablePriority() {
        return this.optionalNullablePriority;
    }
    /**
     * Gets the required_non_nullable_status property value. String enum with snake_case serialized values.
     * @return a {@link Status}
     */
    @jakarta.annotation.Nonnull
    public Status getRequiredNonNullableStatus() {
        return this.requiredNonNullableStatus;
    }
    /**
     * Gets the required_nullable_status property value. The required_nullable_status property
     * @return a {@link Status}
     */
    @jakarta.annotation.Nullable
    public Status getRequiredNullableStatus() {
        return this.requiredNullableStatus;
    }
    /**
     * Gets the statuses property value. array of enum values (required, non-nullable)
     * @return a {@link java.util.List<Status>}
     */
    @jakarta.annotation.Nonnull
    public java.util.List<Status> getStatuses() {
        return this.statuses;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeEnumValue("code", this.getCode());
        writer.writeCollectionOfEnumValues("nullable_statuses", this.getNullableStatuses());
        writer.writeEnumValue("optional_non_nullable_priority", this.getOptionalNonNullablePriority());
        writer.writeEnumValue("optional_nullable_priority", this.getOptionalNullablePriority());
        writer.writeEnumValue("required_non_nullable_status", this.getRequiredNonNullableStatus());
        writer.writeEnumValue("required_nullable_status", this.getRequiredNullableStatus());
        writer.writeCollectionOfEnumValues("statuses", this.getStatuses());
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
     * Sets the code property value. Integer enum represented as i32 discriminants.
     * @param value Value to set for the code property.
     */
    public void setCode(final Code value) {
        this.code = value;
    }
    /**
     * Sets the nullable_statuses property value. nullable array of enums (required)
     * @param value Value to set for the nullable_statuses property.
     */
    public void setNullableStatuses(@jakarta.annotation.Nullable final java.util.List<Status> value) {
        this.nullableStatuses = value;
    }
    /**
     * Sets the optional_non_nullable_priority property value. String enum with explicit rename values.
     * @param value Value to set for the optional_non_nullable_priority property.
     */
    public void setOptionalNonNullablePriority(@jakarta.annotation.Nullable final Priority value) {
        this.optionalNonNullablePriority = value;
    }
    /**
     * Sets the optional_nullable_priority property value. The optional_nullable_priority property
     * @param value Value to set for the optional_nullable_priority property.
     */
    public void setOptionalNullablePriority(@jakarta.annotation.Nullable final Priority value) {
        this.optionalNullablePriority = value;
    }
    /**
     * Sets the required_non_nullable_status property value. String enum with snake_case serialized values.
     * @param value Value to set for the required_non_nullable_status property.
     */
    public void setRequiredNonNullableStatus(final Status value) {
        this.requiredNonNullableStatus = value;
    }
    /**
     * Sets the required_nullable_status property value. The required_nullable_status property
     * @param value Value to set for the required_nullable_status property.
     */
    public void setRequiredNullableStatus(@jakarta.annotation.Nullable final Status value) {
        this.requiredNullableStatus = value;
    }
    /**
     * Sets the statuses property value. array of enum values (required, non-nullable)
     * @param value Value to set for the statuses property.
     */
    public void setStatuses(final java.util.List<Status> value) {
        this.statuses = value;
    }
}
