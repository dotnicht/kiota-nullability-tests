from __future__ import annotations
from collections.abc import Callable
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .extended import Extended

@dataclass
class Composition(AdditionalDataHolder, Parsable):
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: dict[str, Any] = field(default_factory=dict)

    # Extended embeds Base via flatten; utoipa emits allOf in the schema.
    extended: Extended = None
    # The optional_extended property
    optional_extended: Optional[Extended] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: ParseNode) -> Composition:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Composition
        """
        if parse_node is None:
            raise TypeError("parse_node cannot be null.")
        return Composition()
    
    def get_field_deserializers(self,) -> dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: dict[str, Callable[[ParseNode], None]]
        """
        from .extended import Extended

        from .extended import Extended

        fields: dict[str, Callable[[Any], None]] = {
            "extended": lambda n : setattr(self, 'extended', n.get_object_value(Extended)),
            "optional_extended": lambda n : setattr(self, 'optional_extended', n.get_object_value(Extended)),
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
        writer.write_object_value("extended", self.extended)
        writer.write_object_value("optional_extended", self.optional_extended)
        writer.write_additional_data_value(self.additional_data)
    

