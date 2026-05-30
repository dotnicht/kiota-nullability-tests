package com.dotnicht.kiotatests.serviceobjects.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class TreeNode implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Children are optional and nullable; Box breaks the recursive layout.
     */
    private java.util.List<TreeNode> children;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The label property
     */
    private String label;
    /**
     * Instantiates a new {@link TreeNode} and sets the default values.
     */
    public TreeNode() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link TreeNode}
     */
    @jakarta.annotation.Nonnull
    public static TreeNode createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new TreeNode();
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
     * Gets the children property value. Children are optional and nullable; Box breaks the recursive layout.
     * @return a {@link java.util.List<TreeNode>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<TreeNode> getChildren() {
        return this.children;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("children", (n) -> { this.setChildren(n.getCollectionOfObjectValues(TreeNode::createFromDiscriminatorValue)); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("label", (n) -> { this.setLabel(n.getStringValue()); });
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
     * Gets the label property value. The label property
     * @return a {@link String}
     */
    @jakarta.annotation.Nonnull
    public String getLabel() {
        return this.label;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfObjectValues("children", this.getChildren());
        writer.writeIntegerValue("id", this.getId());
        writer.writeStringValue("label", this.getLabel());
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
     * Sets the children property value. Children are optional and nullable; Box breaks the recursive layout.
     * @param value Value to set for the children property.
     */
    public void setChildren(@jakarta.annotation.Nullable final java.util.List<TreeNode> value) {
        this.children = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(final Integer value) {
        this.id = value;
    }
    /**
     * Sets the label property value. The label property
     * @param value Value to set for the label property.
     */
    public void setLabel(final String value) {
        this.label = value;
    }
}
