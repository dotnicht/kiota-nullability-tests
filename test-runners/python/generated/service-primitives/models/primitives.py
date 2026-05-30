from __future__ import annotations
import datetime
from collections.abc import Callable
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Optional, TYPE_CHECKING, Union
from uuid import UUID

@dataclass
class Primitives(AdditionalDataHolder, Parsable):
    """
    All 4 quadrants × all primitive types.| field                          | required | nullable ||--------------------------------|----------|----------|| required_non_nullable_*        | yes      | no       || required_nullable_*            | yes      | yes      || optional_non_nullable_*        | no       | no       || optional_nullable_*            | no       | yes      |
    """
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: dict[str, Any] = field(default_factory=dict)

    # The optional_non_nullable_bool property
    optional_non_nullable_bool: Optional[bool] = None
    # The optional_non_nullable_double property
    optional_non_nullable_double: Optional[float] = None
    # The optional_non_nullable_float property
    optional_non_nullable_float: Optional[float] = None
    # The optional_non_nullable_int property
    optional_non_nullable_int: Optional[int] = None
    # The optional_non_nullable_int64 property
    optional_non_nullable_int64: Optional[int] = None
    # The optional_non_nullable_string property
    optional_non_nullable_string: Optional[str] = None
    # The optional_nullable_bool property
    optional_nullable_bool: Optional[bool] = None
    # The optional_nullable_double property
    optional_nullable_double: Optional[float] = None
    # The optional_nullable_float property
    optional_nullable_float: Optional[float] = None
    # The optional_nullable_int property
    optional_nullable_int: Optional[int] = None
    # The optional_nullable_int64 property
    optional_nullable_int64: Optional[int] = None
    # The optional_nullable_string property
    optional_nullable_string: Optional[str] = None
    # The required_non_nullable_bool property
    required_non_nullable_bool: bool = None
    # The required_non_nullable_byte property
    required_non_nullable_byte: bytes = None
    # The required_non_nullable_date property
    required_non_nullable_date: datetime.date = None
    # The required_non_nullable_datetime property
    required_non_nullable_datetime: datetime.datetime = None
    # The required_non_nullable_double property
    required_non_nullable_double: float = None
    # The required_non_nullable_float property
    required_non_nullable_float: float = None
    # The required_non_nullable_int property
    required_non_nullable_int: int = None
    # The required_non_nullable_int64 property
    required_non_nullable_int64: int = None
    # The required_non_nullable_string property
    required_non_nullable_string: str = None
    # The required_non_nullable_uuid property
    required_non_nullable_uuid: UUID = None
    # The required_nullable_bool property
    required_nullable_bool: Optional[bool] = None
    # The required_nullable_byte property
    required_nullable_byte: Optional[bytes] = None
    # The required_nullable_date property
    required_nullable_date: Optional[datetime.date] = None
    # The required_nullable_datetime property
    required_nullable_datetime: Optional[datetime.datetime] = None
    # The required_nullable_double property
    required_nullable_double: Optional[float] = None
    # The required_nullable_float property
    required_nullable_float: Optional[float] = None
    # The required_nullable_int property
    required_nullable_int: Optional[int] = None
    # The required_nullable_int64 property
    required_nullable_int64: Optional[int] = None
    # The required_nullable_string property
    required_nullable_string: Optional[str] = None
    # The required_nullable_uuid property
    required_nullable_uuid: Optional[UUID] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: ParseNode) -> Primitives:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Primitives
        """
        if parse_node is None:
            raise TypeError("parse_node cannot be null.")
        return Primitives()
    
    def get_field_deserializers(self,) -> dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: dict[str, Callable[[ParseNode], None]]
        """
        fields: dict[str, Callable[[Any], None]] = {
            "optional_non_nullable_bool": lambda n : setattr(self, 'optional_non_nullable_bool', n.get_bool_value()),
            "optional_non_nullable_double": lambda n : setattr(self, 'optional_non_nullable_double', n.get_float_value()),
            "optional_non_nullable_float": lambda n : setattr(self, 'optional_non_nullable_float', n.get_float_value()),
            "optional_non_nullable_int": lambda n : setattr(self, 'optional_non_nullable_int', n.get_int_value()),
            "optional_non_nullable_int64": lambda n : setattr(self, 'optional_non_nullable_int64', n.get_int_value()),
            "optional_non_nullable_string": lambda n : setattr(self, 'optional_non_nullable_string', n.get_str_value()),
            "optional_nullable_bool": lambda n : setattr(self, 'optional_nullable_bool', n.get_bool_value()),
            "optional_nullable_double": lambda n : setattr(self, 'optional_nullable_double', n.get_float_value()),
            "optional_nullable_float": lambda n : setattr(self, 'optional_nullable_float', n.get_float_value()),
            "optional_nullable_int": lambda n : setattr(self, 'optional_nullable_int', n.get_int_value()),
            "optional_nullable_int64": lambda n : setattr(self, 'optional_nullable_int64', n.get_int_value()),
            "optional_nullable_string": lambda n : setattr(self, 'optional_nullable_string', n.get_str_value()),
            "required_non_nullable_bool": lambda n : setattr(self, 'required_non_nullable_bool', n.get_bool_value()),
            "required_non_nullable_byte": lambda n : setattr(self, 'required_non_nullable_byte', n.get_bytes_value()),
            "required_non_nullable_date": lambda n : setattr(self, 'required_non_nullable_date', n.get_date_value()),
            "required_non_nullable_datetime": lambda n : setattr(self, 'required_non_nullable_datetime', n.get_datetime_value()),
            "required_non_nullable_double": lambda n : setattr(self, 'required_non_nullable_double', n.get_float_value()),
            "required_non_nullable_float": lambda n : setattr(self, 'required_non_nullable_float', n.get_float_value()),
            "required_non_nullable_int": lambda n : setattr(self, 'required_non_nullable_int', n.get_int_value()),
            "required_non_nullable_int64": lambda n : setattr(self, 'required_non_nullable_int64', n.get_int_value()),
            "required_non_nullable_string": lambda n : setattr(self, 'required_non_nullable_string', n.get_str_value()),
            "required_non_nullable_uuid": lambda n : setattr(self, 'required_non_nullable_uuid', n.get_uuid_value()),
            "required_nullable_bool": lambda n : setattr(self, 'required_nullable_bool', n.get_bool_value()),
            "required_nullable_byte": lambda n : setattr(self, 'required_nullable_byte', n.get_bytes_value()),
            "required_nullable_date": lambda n : setattr(self, 'required_nullable_date', n.get_date_value()),
            "required_nullable_datetime": lambda n : setattr(self, 'required_nullable_datetime', n.get_datetime_value()),
            "required_nullable_double": lambda n : setattr(self, 'required_nullable_double', n.get_float_value()),
            "required_nullable_float": lambda n : setattr(self, 'required_nullable_float', n.get_float_value()),
            "required_nullable_int": lambda n : setattr(self, 'required_nullable_int', n.get_int_value()),
            "required_nullable_int64": lambda n : setattr(self, 'required_nullable_int64', n.get_int_value()),
            "required_nullable_string": lambda n : setattr(self, 'required_nullable_string', n.get_str_value()),
            "required_nullable_uuid": lambda n : setattr(self, 'required_nullable_uuid', n.get_uuid_value()),
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
        writer.write_bool_value("optional_non_nullable_bool", self.optional_non_nullable_bool)
        writer.write_float_value("optional_non_nullable_double", self.optional_non_nullable_double)
        writer.write_float_value("optional_non_nullable_float", self.optional_non_nullable_float)
        writer.write_int_value("optional_non_nullable_int", self.optional_non_nullable_int)
        writer.write_int_value("optional_non_nullable_int64", self.optional_non_nullable_int64)
        writer.write_str_value("optional_non_nullable_string", self.optional_non_nullable_string)
        writer.write_bool_value("optional_nullable_bool", self.optional_nullable_bool)
        writer.write_float_value("optional_nullable_double", self.optional_nullable_double)
        writer.write_float_value("optional_nullable_float", self.optional_nullable_float)
        writer.write_int_value("optional_nullable_int", self.optional_nullable_int)
        writer.write_int_value("optional_nullable_int64", self.optional_nullable_int64)
        writer.write_str_value("optional_nullable_string", self.optional_nullable_string)
        writer.write_bool_value("required_non_nullable_bool", self.required_non_nullable_bool)
        writer.write_bytes_value("required_non_nullable_byte", self.required_non_nullable_byte)
        writer.write_date_value("required_non_nullable_date", self.required_non_nullable_date)
        writer.write_datetime_value("required_non_nullable_datetime", self.required_non_nullable_datetime)
        writer.write_float_value("required_non_nullable_double", self.required_non_nullable_double)
        writer.write_float_value("required_non_nullable_float", self.required_non_nullable_float)
        writer.write_int_value("required_non_nullable_int", self.required_non_nullable_int)
        writer.write_int_value("required_non_nullable_int64", self.required_non_nullable_int64)
        writer.write_str_value("required_non_nullable_string", self.required_non_nullable_string)
        writer.write_uuid_value("required_non_nullable_uuid", self.required_non_nullable_uuid)
        writer.write_bool_value("required_nullable_bool", self.required_nullable_bool)
        writer.write_bytes_value("required_nullable_byte", self.required_nullable_byte)
        writer.write_date_value("required_nullable_date", self.required_nullable_date)
        writer.write_datetime_value("required_nullable_datetime", self.required_nullable_datetime)
        writer.write_float_value("required_nullable_double", self.required_nullable_double)
        writer.write_float_value("required_nullable_float", self.required_nullable_float)
        writer.write_int_value("required_nullable_int", self.required_nullable_int)
        writer.write_int_value("required_nullable_int64", self.required_nullable_int64)
        writer.write_str_value("required_nullable_string", self.required_nullable_string)
        writer.write_uuid_value("required_nullable_uuid", self.required_nullable_uuid)
        writer.write_additional_data_value(self.additional_data)
    

