package com.dotnicht.kiotatests.serviceparams.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Result payload for /search.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class SearchResult implements AdditionalDataHolder, Parsable {
    /**
     * The active property
     */
    private Boolean active;
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The count property
     */
    private Integer count;
    /**
     * The page property
     */
    private Integer page;
    /**
     * The query property
     */
    private String query;
    /**
     * The sort property
     */
    private String sort;
    /**
     * Instantiates a new {@link SearchResult} and sets the default values.
     */
    public SearchResult() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link SearchResult}
     */
    @jakarta.annotation.Nonnull
    public static SearchResult createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new SearchResult();
    }
    /**
     * Gets the active property value. The active property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getActive() {
        return this.active;
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
     * Gets the count property value. The count property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nonnull
    public Integer getCount() {
        return this.count;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("active", (n) -> { this.setActive(n.getBooleanValue()); });
        deserializerMap.put("count", (n) -> { this.setCount(n.getIntegerValue()); });
        deserializerMap.put("page", (n) -> { this.setPage(n.getIntegerValue()); });
        deserializerMap.put("query", (n) -> { this.setQuery(n.getStringValue()); });
        deserializerMap.put("sort", (n) -> { this.setSort(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the page property value. The page property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nonnull
    public Integer getPage() {
        return this.page;
    }
    /**
     * Gets the query property value. The query property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getQuery() {
        return this.query;
    }
    /**
     * Gets the sort property value. The sort property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getSort() {
        return this.sort;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeBooleanValue("active", this.getActive());
        writer.writeIntegerValue("count", this.getCount());
        writer.writeIntegerValue("page", this.getPage());
        writer.writeStringValue("query", this.getQuery());
        writer.writeStringValue("sort", this.getSort());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the active property value. The active property
     * @param value Value to set for the active property.
     */
    public void setActive(@jakarta.annotation.Nullable final Boolean value) {
        this.active = value;
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the count property value. The count property
     * @param value Value to set for the count property.
     */
    public void setCount(final Integer value) {
        this.count = value;
    }
    /**
     * Sets the page property value. The page property
     * @param value Value to set for the page property.
     */
    public void setPage(final Integer value) {
        this.page = value;
    }
    /**
     * Sets the query property value. The query property
     * @param value Value to set for the query property.
     */
    public void setQuery(final String value) {
        this.query = value;
    }
    /**
     * Sets the sort property value. The sort property
     * @param value Value to set for the sort property.
     */
    public void setSort(final String value) {
        this.sort = value;
    }
}
