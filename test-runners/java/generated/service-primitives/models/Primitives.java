package com.dotnicht.kiotatests.serviceprimitives.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
/**
 * All 4 quadrants  all primitive types.| field                          | required | nullable ||--------------------------------|----------|----------|| required_non_nullable_*        | yes      | no       || required_nullable_*            | yes      | yes      || optional_non_nullable_*        | no       | no       || optional_nullable_*            | no       | yes      |
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class Primitives implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The optional_non_nullable_bool property
     */
    private Boolean optionalNonNullableBool;
    /**
     * The optional_non_nullable_double property
     */
    private Double optionalNonNullableDouble;
    /**
     * The optional_non_nullable_float property
     */
    private Float optionalNonNullableFloat;
    /**
     * The optional_non_nullable_int property
     */
    private Integer optionalNonNullableInt;
    /**
     * The optional_non_nullable_int64 property
     */
    private Long optionalNonNullableInt64;
    /**
     * The optional_non_nullable_string property
     */
    private String optionalNonNullableString;
    /**
     * The optional_nullable_bool property
     */
    private Boolean optionalNullableBool;
    /**
     * The optional_nullable_double property
     */
    private Double optionalNullableDouble;
    /**
     * The optional_nullable_float property
     */
    private Float optionalNullableFloat;
    /**
     * The optional_nullable_int property
     */
    private Integer optionalNullableInt;
    /**
     * The optional_nullable_int64 property
     */
    private Long optionalNullableInt64;
    /**
     * The optional_nullable_string property
     */
    private String optionalNullableString;
    /**
     * The required_non_nullable_bool property
     */
    private Boolean requiredNonNullableBool;
    /**
     * The required_non_nullable_byte property
     */
    private byte[] requiredNonNullableByte;
    /**
     * The required_non_nullable_date property
     */
    private LocalDate requiredNonNullableDate;
    /**
     * The required_non_nullable_datetime property
     */
    private OffsetDateTime requiredNonNullableDatetime;
    /**
     * The required_non_nullable_double property
     */
    private Double requiredNonNullableDouble;
    /**
     * The required_non_nullable_float property
     */
    private Float requiredNonNullableFloat;
    /**
     * The required_non_nullable_int property
     */
    private Integer requiredNonNullableInt;
    /**
     * The required_non_nullable_int64 property
     */
    private Long requiredNonNullableInt64;
    /**
     * The required_non_nullable_string property
     */
    private String requiredNonNullableString;
    /**
     * The required_non_nullable_uuid property
     */
    private UUID requiredNonNullableUuid;
    /**
     * The required_nullable_bool property
     */
    private Boolean requiredNullableBool;
    /**
     * The required_nullable_byte property
     */
    private byte[] requiredNullableByte;
    /**
     * The required_nullable_date property
     */
    private LocalDate requiredNullableDate;
    /**
     * The required_nullable_datetime property
     */
    private OffsetDateTime requiredNullableDatetime;
    /**
     * The required_nullable_double property
     */
    private Double requiredNullableDouble;
    /**
     * The required_nullable_float property
     */
    private Float requiredNullableFloat;
    /**
     * The required_nullable_int property
     */
    private Integer requiredNullableInt;
    /**
     * The required_nullable_int64 property
     */
    private Long requiredNullableInt64;
    /**
     * The required_nullable_string property
     */
    private String requiredNullableString;
    /**
     * The required_nullable_uuid property
     */
    private UUID requiredNullableUuid;
    /**
     * Instantiates a new {@link Primitives} and sets the default values.
     */
    public Primitives() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link Primitives}
     */
    @jakarta.annotation.Nonnull
    public static Primitives createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new Primitives();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(32);
        deserializerMap.put("optional_non_nullable_bool", (n) -> { this.setOptionalNonNullableBool(n.getBooleanValue()); });
        deserializerMap.put("optional_non_nullable_double", (n) -> { this.setOptionalNonNullableDouble(n.getDoubleValue()); });
        deserializerMap.put("optional_non_nullable_float", (n) -> { this.setOptionalNonNullableFloat(n.getFloatValue()); });
        deserializerMap.put("optional_non_nullable_int", (n) -> { this.setOptionalNonNullableInt(n.getIntegerValue()); });
        deserializerMap.put("optional_non_nullable_int64", (n) -> { this.setOptionalNonNullableInt64(n.getLongValue()); });
        deserializerMap.put("optional_non_nullable_string", (n) -> { this.setOptionalNonNullableString(n.getStringValue()); });
        deserializerMap.put("optional_nullable_bool", (n) -> { this.setOptionalNullableBool(n.getBooleanValue()); });
        deserializerMap.put("optional_nullable_double", (n) -> { this.setOptionalNullableDouble(n.getDoubleValue()); });
        deserializerMap.put("optional_nullable_float", (n) -> { this.setOptionalNullableFloat(n.getFloatValue()); });
        deserializerMap.put("optional_nullable_int", (n) -> { this.setOptionalNullableInt(n.getIntegerValue()); });
        deserializerMap.put("optional_nullable_int64", (n) -> { this.setOptionalNullableInt64(n.getLongValue()); });
        deserializerMap.put("optional_nullable_string", (n) -> { this.setOptionalNullableString(n.getStringValue()); });
        deserializerMap.put("required_non_nullable_bool", (n) -> { this.setRequiredNonNullableBool(n.getBooleanValue()); });
        deserializerMap.put("required_non_nullable_byte", (n) -> { this.setRequiredNonNullableByte(n.getByteArrayValue()); });
        deserializerMap.put("required_non_nullable_date", (n) -> { this.setRequiredNonNullableDate(n.getLocalDateValue()); });
        deserializerMap.put("required_non_nullable_datetime", (n) -> { this.setRequiredNonNullableDatetime(n.getOffsetDateTimeValue()); });
        deserializerMap.put("required_non_nullable_double", (n) -> { this.setRequiredNonNullableDouble(n.getDoubleValue()); });
        deserializerMap.put("required_non_nullable_float", (n) -> { this.setRequiredNonNullableFloat(n.getFloatValue()); });
        deserializerMap.put("required_non_nullable_int", (n) -> { this.setRequiredNonNullableInt(n.getIntegerValue()); });
        deserializerMap.put("required_non_nullable_int64", (n) -> { this.setRequiredNonNullableInt64(n.getLongValue()); });
        deserializerMap.put("required_non_nullable_string", (n) -> { this.setRequiredNonNullableString(n.getStringValue()); });
        deserializerMap.put("required_non_nullable_uuid", (n) -> { this.setRequiredNonNullableUuid(n.getUUIDValue()); });
        deserializerMap.put("required_nullable_bool", (n) -> { this.setRequiredNullableBool(n.getBooleanValue()); });
        deserializerMap.put("required_nullable_byte", (n) -> { this.setRequiredNullableByte(n.getByteArrayValue()); });
        deserializerMap.put("required_nullable_date", (n) -> { this.setRequiredNullableDate(n.getLocalDateValue()); });
        deserializerMap.put("required_nullable_datetime", (n) -> { this.setRequiredNullableDatetime(n.getOffsetDateTimeValue()); });
        deserializerMap.put("required_nullable_double", (n) -> { this.setRequiredNullableDouble(n.getDoubleValue()); });
        deserializerMap.put("required_nullable_float", (n) -> { this.setRequiredNullableFloat(n.getFloatValue()); });
        deserializerMap.put("required_nullable_int", (n) -> { this.setRequiredNullableInt(n.getIntegerValue()); });
        deserializerMap.put("required_nullable_int64", (n) -> { this.setRequiredNullableInt64(n.getLongValue()); });
        deserializerMap.put("required_nullable_string", (n) -> { this.setRequiredNullableString(n.getStringValue()); });
        deserializerMap.put("required_nullable_uuid", (n) -> { this.setRequiredNullableUuid(n.getUUIDValue()); });
        return deserializerMap;
    }
    /**
     * Gets the optional_non_nullable_bool property value. The optional_non_nullable_bool property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getOptionalNonNullableBool() {
        return this.optionalNonNullableBool;
    }
    /**
     * Gets the optional_non_nullable_double property value. The optional_non_nullable_double property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getOptionalNonNullableDouble() {
        return this.optionalNonNullableDouble;
    }
    /**
     * Gets the optional_non_nullable_float property value. The optional_non_nullable_float property
     * @return a {@link Float}
     */
    @jakarta.annotation.Nullable
    public Float getOptionalNonNullableFloat() {
        return this.optionalNonNullableFloat;
    }
    /**
     * Gets the optional_non_nullable_int property value. The optional_non_nullable_int property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getOptionalNonNullableInt() {
        return this.optionalNonNullableInt;
    }
    /**
     * Gets the optional_non_nullable_int64 property value. The optional_non_nullable_int64 property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getOptionalNonNullableInt64() {
        return this.optionalNonNullableInt64;
    }
    /**
     * Gets the optional_non_nullable_string property value. The optional_non_nullable_string property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getOptionalNonNullableString() {
        return this.optionalNonNullableString;
    }
    /**
     * Gets the optional_nullable_bool property value. The optional_nullable_bool property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getOptionalNullableBool() {
        return this.optionalNullableBool;
    }
    /**
     * Gets the optional_nullable_double property value. The optional_nullable_double property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getOptionalNullableDouble() {
        return this.optionalNullableDouble;
    }
    /**
     * Gets the optional_nullable_float property value. The optional_nullable_float property
     * @return a {@link Float}
     */
    @jakarta.annotation.Nullable
    public Float getOptionalNullableFloat() {
        return this.optionalNullableFloat;
    }
    /**
     * Gets the optional_nullable_int property value. The optional_nullable_int property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getOptionalNullableInt() {
        return this.optionalNullableInt;
    }
    /**
     * Gets the optional_nullable_int64 property value. The optional_nullable_int64 property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getOptionalNullableInt64() {
        return this.optionalNullableInt64;
    }
    /**
     * Gets the optional_nullable_string property value. The optional_nullable_string property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getOptionalNullableString() {
        return this.optionalNullableString;
    }
    /**
     * Gets the required_non_nullable_bool property value. The required_non_nullable_bool property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nonnull
    public Boolean getRequiredNonNullableBool() {
        return this.requiredNonNullableBool;
    }
    /**
     * Gets the required_non_nullable_byte property value. The required_non_nullable_byte property
     * @return a {@link byte[]}
     */
    @jakarta.annotation.Nonnull
    public byte[] getRequiredNonNullableByte() {
        return this.requiredNonNullableByte;
    }
    /**
     * Gets the required_non_nullable_date property value. The required_non_nullable_date property
     * @return a {@link LocalDate}
     */
    @jakarta.annotation.Nonnull
    public LocalDate getRequiredNonNullableDate() {
        return this.requiredNonNullableDate;
    }
    /**
     * Gets the required_non_nullable_datetime property value. The required_non_nullable_datetime property
     * @return a {@link OffsetDateTime}
     */
    @jakarta.annotation.Nonnull
    public OffsetDateTime getRequiredNonNullableDatetime() {
        return this.requiredNonNullableDatetime;
    }
    /**
     * Gets the required_non_nullable_double property value. The required_non_nullable_double property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nonnull
    public Double getRequiredNonNullableDouble() {
        return this.requiredNonNullableDouble;
    }
    /**
     * Gets the required_non_nullable_float property value. The required_non_nullable_float property
     * @return a {@link Float}
     */
    @jakarta.annotation.Nonnull
    public Float getRequiredNonNullableFloat() {
        return this.requiredNonNullableFloat;
    }
    /**
     * Gets the required_non_nullable_int property value. The required_non_nullable_int property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nonnull
    public Integer getRequiredNonNullableInt() {
        return this.requiredNonNullableInt;
    }
    /**
     * Gets the required_non_nullable_int64 property value. The required_non_nullable_int64 property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nonnull
    public Long getRequiredNonNullableInt64() {
        return this.requiredNonNullableInt64;
    }
    /**
     * Gets the required_non_nullable_string property value. The required_non_nullable_string property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getRequiredNonNullableString() {
        return this.requiredNonNullableString;
    }
    /**
     * Gets the required_non_nullable_uuid property value. The required_non_nullable_uuid property
     * @return a {@link UUID}
     */
    @jakarta.annotation.Nonnull
    public UUID getRequiredNonNullableUuid() {
        return this.requiredNonNullableUuid;
    }
    /**
     * Gets the required_nullable_bool property value. The required_nullable_bool property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getRequiredNullableBool() {
        return this.requiredNullableBool;
    }
    /**
     * Gets the required_nullable_byte property value. The required_nullable_byte property
     * @return a {@link byte[]}
     */
    @jakarta.annotation.Nullable
    public byte[] getRequiredNullableByte() {
        return this.requiredNullableByte;
    }
    /**
     * Gets the required_nullable_date property value. The required_nullable_date property
     * @return a {@link LocalDate}
     */
    @jakarta.annotation.Nullable
    public LocalDate getRequiredNullableDate() {
        return this.requiredNullableDate;
    }
    /**
     * Gets the required_nullable_datetime property value. The required_nullable_datetime property
     * @return a {@link OffsetDateTime}
     */
    @jakarta.annotation.Nullable
    public OffsetDateTime getRequiredNullableDatetime() {
        return this.requiredNullableDatetime;
    }
    /**
     * Gets the required_nullable_double property value. The required_nullable_double property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getRequiredNullableDouble() {
        return this.requiredNullableDouble;
    }
    /**
     * Gets the required_nullable_float property value. The required_nullable_float property
     * @return a {@link Float}
     */
    @jakarta.annotation.Nullable
    public Float getRequiredNullableFloat() {
        return this.requiredNullableFloat;
    }
    /**
     * Gets the required_nullable_int property value. The required_nullable_int property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRequiredNullableInt() {
        return this.requiredNullableInt;
    }
    /**
     * Gets the required_nullable_int64 property value. The required_nullable_int64 property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getRequiredNullableInt64() {
        return this.requiredNullableInt64;
    }
    /**
     * Gets the required_nullable_string property value. The required_nullable_string property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getRequiredNullableString() {
        return this.requiredNullableString;
    }
    /**
     * Gets the required_nullable_uuid property value. The required_nullable_uuid property
     * @return a {@link UUID}
     */
    @jakarta.annotation.Nullable
    public UUID getRequiredNullableUuid() {
        return this.requiredNullableUuid;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeBooleanValue("optional_non_nullable_bool", this.getOptionalNonNullableBool());
        writer.writeDoubleValue("optional_non_nullable_double", this.getOptionalNonNullableDouble());
        writer.writeFloatValue("optional_non_nullable_float", this.getOptionalNonNullableFloat());
        writer.writeIntegerValue("optional_non_nullable_int", this.getOptionalNonNullableInt());
        writer.writeLongValue("optional_non_nullable_int64", this.getOptionalNonNullableInt64());
        writer.writeStringValue("optional_non_nullable_string", this.getOptionalNonNullableString());
        writer.writeBooleanValue("optional_nullable_bool", this.getOptionalNullableBool());
        writer.writeDoubleValue("optional_nullable_double", this.getOptionalNullableDouble());
        writer.writeFloatValue("optional_nullable_float", this.getOptionalNullableFloat());
        writer.writeIntegerValue("optional_nullable_int", this.getOptionalNullableInt());
        writer.writeLongValue("optional_nullable_int64", this.getOptionalNullableInt64());
        writer.writeStringValue("optional_nullable_string", this.getOptionalNullableString());
        writer.writeBooleanValue("required_non_nullable_bool", this.getRequiredNonNullableBool());
        writer.writeByteArrayValue("required_non_nullable_byte", this.getRequiredNonNullableByte());
        writer.writeLocalDateValue("required_non_nullable_date", this.getRequiredNonNullableDate());
        writer.writeOffsetDateTimeValue("required_non_nullable_datetime", this.getRequiredNonNullableDatetime());
        writer.writeDoubleValue("required_non_nullable_double", this.getRequiredNonNullableDouble());
        writer.writeFloatValue("required_non_nullable_float", this.getRequiredNonNullableFloat());
        writer.writeIntegerValue("required_non_nullable_int", this.getRequiredNonNullableInt());
        writer.writeLongValue("required_non_nullable_int64", this.getRequiredNonNullableInt64());
        writer.writeStringValue("required_non_nullable_string", this.getRequiredNonNullableString());
        writer.writeUUIDValue("required_non_nullable_uuid", this.getRequiredNonNullableUuid());
        writer.writeBooleanValue("required_nullable_bool", this.getRequiredNullableBool());
        writer.writeByteArrayValue("required_nullable_byte", this.getRequiredNullableByte());
        writer.writeLocalDateValue("required_nullable_date", this.getRequiredNullableDate());
        writer.writeOffsetDateTimeValue("required_nullable_datetime", this.getRequiredNullableDatetime());
        writer.writeDoubleValue("required_nullable_double", this.getRequiredNullableDouble());
        writer.writeFloatValue("required_nullable_float", this.getRequiredNullableFloat());
        writer.writeIntegerValue("required_nullable_int", this.getRequiredNullableInt());
        writer.writeLongValue("required_nullable_int64", this.getRequiredNullableInt64());
        writer.writeStringValue("required_nullable_string", this.getRequiredNullableString());
        writer.writeUUIDValue("required_nullable_uuid", this.getRequiredNullableUuid());
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
     * Sets the optional_non_nullable_bool property value. The optional_non_nullable_bool property
     * @param value Value to set for the optional_non_nullable_bool property.
     */
    public void setOptionalNonNullableBool(@jakarta.annotation.Nullable final Boolean value) {
        this.optionalNonNullableBool = value;
    }
    /**
     * Sets the optional_non_nullable_double property value. The optional_non_nullable_double property
     * @param value Value to set for the optional_non_nullable_double property.
     */
    public void setOptionalNonNullableDouble(@jakarta.annotation.Nullable final Double value) {
        this.optionalNonNullableDouble = value;
    }
    /**
     * Sets the optional_non_nullable_float property value. The optional_non_nullable_float property
     * @param value Value to set for the optional_non_nullable_float property.
     */
    public void setOptionalNonNullableFloat(@jakarta.annotation.Nullable final Float value) {
        this.optionalNonNullableFloat = value;
    }
    /**
     * Sets the optional_non_nullable_int property value. The optional_non_nullable_int property
     * @param value Value to set for the optional_non_nullable_int property.
     */
    public void setOptionalNonNullableInt(@jakarta.annotation.Nullable final Integer value) {
        this.optionalNonNullableInt = value;
    }
    /**
     * Sets the optional_non_nullable_int64 property value. The optional_non_nullable_int64 property
     * @param value Value to set for the optional_non_nullable_int64 property.
     */
    public void setOptionalNonNullableInt64(@jakarta.annotation.Nullable final Long value) {
        this.optionalNonNullableInt64 = value;
    }
    /**
     * Sets the optional_non_nullable_string property value. The optional_non_nullable_string property
     * @param value Value to set for the optional_non_nullable_string property.
     */
    public void setOptionalNonNullableString(@jakarta.annotation.Nullable final String value) {
        this.optionalNonNullableString = value;
    }
    /**
     * Sets the optional_nullable_bool property value. The optional_nullable_bool property
     * @param value Value to set for the optional_nullable_bool property.
     */
    public void setOptionalNullableBool(@jakarta.annotation.Nullable final Boolean value) {
        this.optionalNullableBool = value;
    }
    /**
     * Sets the optional_nullable_double property value. The optional_nullable_double property
     * @param value Value to set for the optional_nullable_double property.
     */
    public void setOptionalNullableDouble(@jakarta.annotation.Nullable final Double value) {
        this.optionalNullableDouble = value;
    }
    /**
     * Sets the optional_nullable_float property value. The optional_nullable_float property
     * @param value Value to set for the optional_nullable_float property.
     */
    public void setOptionalNullableFloat(@jakarta.annotation.Nullable final Float value) {
        this.optionalNullableFloat = value;
    }
    /**
     * Sets the optional_nullable_int property value. The optional_nullable_int property
     * @param value Value to set for the optional_nullable_int property.
     */
    public void setOptionalNullableInt(@jakarta.annotation.Nullable final Integer value) {
        this.optionalNullableInt = value;
    }
    /**
     * Sets the optional_nullable_int64 property value. The optional_nullable_int64 property
     * @param value Value to set for the optional_nullable_int64 property.
     */
    public void setOptionalNullableInt64(@jakarta.annotation.Nullable final Long value) {
        this.optionalNullableInt64 = value;
    }
    /**
     * Sets the optional_nullable_string property value. The optional_nullable_string property
     * @param value Value to set for the optional_nullable_string property.
     */
    public void setOptionalNullableString(@jakarta.annotation.Nullable final String value) {
        this.optionalNullableString = value;
    }
    /**
     * Sets the required_non_nullable_bool property value. The required_non_nullable_bool property
     * @param value Value to set for the required_non_nullable_bool property.
     */
    public void setRequiredNonNullableBool(final Boolean value) {
        this.requiredNonNullableBool = value;
    }
    /**
     * Sets the required_non_nullable_byte property value. The required_non_nullable_byte property
     * @param value Value to set for the required_non_nullable_byte property.
     */
    public void setRequiredNonNullableByte(final byte[] value) {
        this.requiredNonNullableByte = value;
    }
    /**
     * Sets the required_non_nullable_date property value. The required_non_nullable_date property
     * @param value Value to set for the required_non_nullable_date property.
     */
    public void setRequiredNonNullableDate(final LocalDate value) {
        this.requiredNonNullableDate = value;
    }
    /**
     * Sets the required_non_nullable_datetime property value. The required_non_nullable_datetime property
     * @param value Value to set for the required_non_nullable_datetime property.
     */
    public void setRequiredNonNullableDatetime(final OffsetDateTime value) {
        this.requiredNonNullableDatetime = value;
    }
    /**
     * Sets the required_non_nullable_double property value. The required_non_nullable_double property
     * @param value Value to set for the required_non_nullable_double property.
     */
    public void setRequiredNonNullableDouble(final Double value) {
        this.requiredNonNullableDouble = value;
    }
    /**
     * Sets the required_non_nullable_float property value. The required_non_nullable_float property
     * @param value Value to set for the required_non_nullable_float property.
     */
    public void setRequiredNonNullableFloat(final Float value) {
        this.requiredNonNullableFloat = value;
    }
    /**
     * Sets the required_non_nullable_int property value. The required_non_nullable_int property
     * @param value Value to set for the required_non_nullable_int property.
     */
    public void setRequiredNonNullableInt(final Integer value) {
        this.requiredNonNullableInt = value;
    }
    /**
     * Sets the required_non_nullable_int64 property value. The required_non_nullable_int64 property
     * @param value Value to set for the required_non_nullable_int64 property.
     */
    public void setRequiredNonNullableInt64(final Long value) {
        this.requiredNonNullableInt64 = value;
    }
    /**
     * Sets the required_non_nullable_string property value. The required_non_nullable_string property
     * @param value Value to set for the required_non_nullable_string property.
     */
    public void setRequiredNonNullableString(final String value) {
        this.requiredNonNullableString = value;
    }
    /**
     * Sets the required_non_nullable_uuid property value. The required_non_nullable_uuid property
     * @param value Value to set for the required_non_nullable_uuid property.
     */
    public void setRequiredNonNullableUuid(final UUID value) {
        this.requiredNonNullableUuid = value;
    }
    /**
     * Sets the required_nullable_bool property value. The required_nullable_bool property
     * @param value Value to set for the required_nullable_bool property.
     */
    public void setRequiredNullableBool(@jakarta.annotation.Nullable final Boolean value) {
        this.requiredNullableBool = value;
    }
    /**
     * Sets the required_nullable_byte property value. The required_nullable_byte property
     * @param value Value to set for the required_nullable_byte property.
     */
    public void setRequiredNullableByte(@jakarta.annotation.Nullable final byte[] value) {
        this.requiredNullableByte = value;
    }
    /**
     * Sets the required_nullable_date property value. The required_nullable_date property
     * @param value Value to set for the required_nullable_date property.
     */
    public void setRequiredNullableDate(@jakarta.annotation.Nullable final LocalDate value) {
        this.requiredNullableDate = value;
    }
    /**
     * Sets the required_nullable_datetime property value. The required_nullable_datetime property
     * @param value Value to set for the required_nullable_datetime property.
     */
    public void setRequiredNullableDatetime(@jakarta.annotation.Nullable final OffsetDateTime value) {
        this.requiredNullableDatetime = value;
    }
    /**
     * Sets the required_nullable_double property value. The required_nullable_double property
     * @param value Value to set for the required_nullable_double property.
     */
    public void setRequiredNullableDouble(@jakarta.annotation.Nullable final Double value) {
        this.requiredNullableDouble = value;
    }
    /**
     * Sets the required_nullable_float property value. The required_nullable_float property
     * @param value Value to set for the required_nullable_float property.
     */
    public void setRequiredNullableFloat(@jakarta.annotation.Nullable final Float value) {
        this.requiredNullableFloat = value;
    }
    /**
     * Sets the required_nullable_int property value. The required_nullable_int property
     * @param value Value to set for the required_nullable_int property.
     */
    public void setRequiredNullableInt(@jakarta.annotation.Nullable final Integer value) {
        this.requiredNullableInt = value;
    }
    /**
     * Sets the required_nullable_int64 property value. The required_nullable_int64 property
     * @param value Value to set for the required_nullable_int64 property.
     */
    public void setRequiredNullableInt64(@jakarta.annotation.Nullable final Long value) {
        this.requiredNullableInt64 = value;
    }
    /**
     * Sets the required_nullable_string property value. The required_nullable_string property
     * @param value Value to set for the required_nullable_string property.
     */
    public void setRequiredNullableString(@jakarta.annotation.Nullable final String value) {
        this.requiredNullableString = value;
    }
    /**
     * Sets the required_nullable_uuid property value. The required_nullable_uuid property
     * @param value Value to set for the required_nullable_uuid property.
     */
    public void setRequiredNullableUuid(@jakarta.annotation.Nullable final UUID value) {
        this.requiredNullableUuid = value;
    }
}
