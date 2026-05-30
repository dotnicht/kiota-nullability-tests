from __future__ import annotations
from collections.abc import Callable
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .middle import Middle

@dataclass
class Outer(AdditionalDataHolder, Parsable):
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: dict[str, Any] = field(default_factory=dict)

    # The id property
    id: int = None
    # The middle property
    middle: Middle = None
    # The nullable_middle property
    nullable_middle: Optional[Middle] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: ParseNode) -> Outer:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Outer
        """
        if parse_node is None:
            raise TypeError("parse_node cannot be null.")
        return Outer()
    
    def get_field_deserializers(self,) -> dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: dict[str, Callable[[ParseNode], None]]
        """
        from .middle import Middle

        from .middle import Middle

        fields: dict[str, Callable[[Any], None]] = {
            "id": lambda n : setattr(self, 'id', n.get_int_value()),
            "middle": lambda n : setattr(self, 'middle', n.get_object_value(Middle)),
            "nullable_middle": lambda n : setattr(self, 'nullable_middle', n.get_object_value(Middle)),
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
        writer.write_int_value("id", self.id)
        writer.write_object_value("middle", self.middle)
        writer.write_object_value("nullable_middle", self.nullable_middle)
        writer.write_additional_data_value(self.additional_data)
    

