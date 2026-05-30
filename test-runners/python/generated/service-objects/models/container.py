from __future__ import annotations
from collections.abc import Callable
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .address import Address
    from .tag import Tag

@dataclass
class Container(AdditionalDataHolder, Parsable):
    """
    Covers required/nullable quadrants for nested objects and arrays.
    """
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: dict[str, Any] = field(default_factory=dict)

    # The optional_nullable_address property
    optional_nullable_address: Optional[Address] = None
    # optional + nullable array
    optional_nullable_tags: Optional[list[Tag]] = None
    # The required_non_nullable_address property
    required_non_nullable_address: Address = None
    # required + non-nullable array
    required_non_nullable_tags: list[Tag] = None
    # The required_nullable_address property
    required_nullable_address: Optional[Address] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: ParseNode) -> Container:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Container
        """
        if parse_node is None:
            raise TypeError("parse_node cannot be null.")
        return Container()
    
    def get_field_deserializers(self,) -> dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: dict[str, Callable[[ParseNode], None]]
        """
        from .address import Address
        from .tag import Tag

        from .address import Address
        from .tag import Tag

        fields: dict[str, Callable[[Any], None]] = {
            "optional_nullable_address": lambda n : setattr(self, 'optional_nullable_address', n.get_object_value(Address)),
            "optional_nullable_tags": lambda n : setattr(self, 'optional_nullable_tags', n.get_collection_of_object_values(Tag)),
            "required_non_nullable_address": lambda n : setattr(self, 'required_non_nullable_address', n.get_object_value(Address)),
            "required_non_nullable_tags": lambda n : setattr(self, 'required_non_nullable_tags', n.get_collection_of_object_values(Tag)),
            "required_nullable_address": lambda n : setattr(self, 'required_nullable_address', n.get_object_value(Address)),
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
        writer.write_object_value("optional_nullable_address", self.optional_nullable_address)
        writer.write_collection_of_object_values("optional_nullable_tags", self.optional_nullable_tags)
        writer.write_object_value("required_non_nullable_address", self.required_non_nullable_address)
        writer.write_collection_of_object_values("required_non_nullable_tags", self.required_non_nullable_tags)
        writer.write_object_value("required_nullable_address", self.required_nullable_address)
        writer.write_additional_data_value(self.additional_data)
    

