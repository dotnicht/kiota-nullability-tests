from __future__ import annotations
from collections.abc import Callable
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .code import Code
    from .priority import Priority
    from .status import Status

@dataclass
class EnumContainer(AdditionalDataHolder, Parsable):
    """
    Covers required/nullable quadrants, plus array-of-enum and integer enum.
    """
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: dict[str, Any] = field(default_factory=dict)

    # Integer enum represented as i32 discriminants.
    code: Code = None
    # nullable array of enums (required)
    nullable_statuses: Optional[list[Status]] = None
    # String enum with explicit rename values.
    optional_non_nullable_priority: Optional[Priority] = None
    # The optional_nullable_priority property
    optional_nullable_priority: Optional[Priority] = None
    # String enum with snake_case serialized values.
    required_non_nullable_status: Status = None
    # The required_nullable_status property
    required_nullable_status: Optional[Status] = None
    # array of enum values (required, non-nullable)
    statuses: list[Status] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: ParseNode) -> EnumContainer:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: EnumContainer
        """
        if parse_node is None:
            raise TypeError("parse_node cannot be null.")
        return EnumContainer()
    
    def get_field_deserializers(self,) -> dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: dict[str, Callable[[ParseNode], None]]
        """
        from .code import Code
        from .priority import Priority
        from .status import Status

        from .code import Code
        from .priority import Priority
        from .status import Status

        fields: dict[str, Callable[[Any], None]] = {
            "code": lambda n : setattr(self, 'code', n.get_enum_value(Code)),
            "nullable_statuses": lambda n : setattr(self, 'nullable_statuses', n.get_collection_of_enum_values(Status)),
            "optional_non_nullable_priority": lambda n : setattr(self, 'optional_non_nullable_priority', n.get_enum_value(Priority)),
            "optional_nullable_priority": lambda n : setattr(self, 'optional_nullable_priority', n.get_enum_value(Priority)),
            "required_non_nullable_status": lambda n : setattr(self, 'required_non_nullable_status', n.get_enum_value(Status)),
            "required_nullable_status": lambda n : setattr(self, 'required_nullable_status', n.get_enum_value(Status)),
            "statuses": lambda n : setattr(self, 'statuses', n.get_collection_of_enum_values(Status)),
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
        writer.write_enum_value("code", self.code)
        writer.write_collection_of_enum_values("nullable_statuses", self.nullable_statuses)
        writer.write_enum_value("optional_non_nullable_priority", self.optional_non_nullable_priority)
        writer.write_enum_value("optional_nullable_priority", self.optional_nullable_priority)
        writer.write_enum_value("required_non_nullable_status", self.required_non_nullable_status)
        writer.write_enum_value("required_nullable_status", self.required_nullable_status)
        writer.write_collection_of_enum_values("statuses", self.statuses)
        writer.write_additional_data_value(self.additional_data)
    

