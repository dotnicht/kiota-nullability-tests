from __future__ import annotations
from collections.abc import Callable
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .collections_item_map import Collections_item_map
    from .collections_nullable_value_map import Collections_nullable_value_map
    from .collections_string_map import Collections_string_map
    from .item import Item

@dataclass
class Collections(AdditionalDataHolder, Parsable):
    """
    Covers every array/map nullability permutation.| field                        | required | nullable array | nullable items ||------------------------------|----------|----------------|----------------|| required_strings             | yes      | no             | no             || required_nullable_strings    | yes      | yes            | no             || optional_strings             | no       | no             | no             || optional_nullable_strings    | no       | yes            | no             || nullable_item_strings        | yes      | no             | yes            || required_items               | yes      | no             | no             || nested                       | yes      | no             | no             || string_map                   | yes      | —              | no             || nullable_value_map           | yes      | —              | yes            || item_map                     | yes      | —              | no             |
    """
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: dict[str, Any] = field(default_factory=dict)

    # Map of objects — additionalProperties: $ref Item.
    item_map: Collections_item_map = None
    # Array whose items may be null.
    nullable_item_strings: list[str] = None
    # Map with nullable values — additionalProperties: { type: string, nullable: true }.
    nullable_value_map: Collections_nullable_value_map = None
    # Optional nullable array of strings.
    optional_nullable_strings: Optional[list[str]] = None
    # Optional non-nullable array of strings (not in required[]).
    optional_strings: Optional[list[str]] = None
    # Required array of inline objects.
    required_items: list[Item] = None
    # Required nullable array of strings.
    required_nullable_strings: Optional[list[str]] = None
    # Required non-nullable array of strings.
    required_strings: list[str] = None
    # Map<string, string> — additionalProperties: { type: string }.
    string_map: Collections_string_map = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: ParseNode) -> Collections:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Collections
        """
        if parse_node is None:
            raise TypeError("parse_node cannot be null.")
        return Collections()
    
    def get_field_deserializers(self,) -> dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: dict[str, Callable[[ParseNode], None]]
        """
        from .collections_item_map import Collections_item_map
        from .collections_nullable_value_map import Collections_nullable_value_map
        from .collections_string_map import Collections_string_map
        from .item import Item

        from .collections_item_map import Collections_item_map
        from .collections_nullable_value_map import Collections_nullable_value_map
        from .collections_string_map import Collections_string_map
        from .item import Item

        fields: dict[str, Callable[[Any], None]] = {
            "item_map": lambda n : setattr(self, 'item_map', n.get_object_value(Collections_item_map)),
            "nullable_item_strings": lambda n : setattr(self, 'nullable_item_strings', n.get_collection_of_primitive_values(str)),
            "nullable_value_map": lambda n : setattr(self, 'nullable_value_map', n.get_object_value(Collections_nullable_value_map)),
            "optional_nullable_strings": lambda n : setattr(self, 'optional_nullable_strings', n.get_collection_of_primitive_values(str)),
            "optional_strings": lambda n : setattr(self, 'optional_strings', n.get_collection_of_primitive_values(str)),
            "required_items": lambda n : setattr(self, 'required_items', n.get_collection_of_object_values(Item)),
            "required_nullable_strings": lambda n : setattr(self, 'required_nullable_strings', n.get_collection_of_primitive_values(str)),
            "required_strings": lambda n : setattr(self, 'required_strings', n.get_collection_of_primitive_values(str)),
            "string_map": lambda n : setattr(self, 'string_map', n.get_object_value(Collections_string_map)),
        }
        return fields
    
    def serialize(self,writer: SerializationWriter) -> None:
        """
        Serializes information the current object
        param writer: Serialization writer to use to serialize this model
        Returns: None
        """
        if writer is None:
            raise TypeError("writer cannot be null.")
        writer.write_object_value("item_map", self.item_map)
        writer.write_collection_of_primitive_values("nullable_item_strings", self.nullable_item_strings)
        writer.write_object_value("nullable_value_map", self.nullable_value_map)
        writer.write_collection_of_primitive_values("optional_nullable_strings", self.optional_nullable_strings)
        writer.write_collection_of_primitive_values("optional_strings", self.optional_strings)
        writer.write_collection_of_object_values("required_items", self.required_items)
        writer.write_collection_of_primitive_values("required_nullable_strings", self.required_nullable_strings)
        writer.write_collection_of_primitive_values("required_strings", self.required_strings)
        writer.write_object_value("string_map", self.string_map)
        writer.write_additional_data_value(self.additional_data)
    

