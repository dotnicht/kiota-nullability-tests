from enum import Enum

class Status(str, Enum):
    Active = "active",
    Inactive = "inactive",
    Pending = "pending",

