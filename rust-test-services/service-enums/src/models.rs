use serde::{Deserialize, Serialize};
use utoipa::ToSchema;

/// String enum with snake_case serialized values.
#[derive(Debug, Clone, Serialize, Deserialize, ToSchema)]
#[serde(rename_all = "snake_case")]
pub enum Status {
    Active,
    Inactive,
    Pending,
}

/// String enum with explicit rename values.
#[derive(Debug, Clone, Serialize, Deserialize, ToSchema)]
pub enum Priority {
    #[serde(rename = "LOW")]
    Low,
    #[serde(rename = "MEDIUM")]
    Medium,
    #[serde(rename = "HIGH")]
    High,
}

/// Integer enum represented as i32 discriminants.
#[derive(Debug, Clone, Serialize, Deserialize, ToSchema)]
#[repr(i32)]
pub enum Code {
    #[serde(rename = "0")]
    Ok = 0,
    #[serde(rename = "1")]
    Warning = 1,
    #[serde(rename = "2")]
    Error = 2,
}

/// Covers required/nullable quadrants, plus array-of-enum and integer enum.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct EnumContainer {
    /// required + non-nullable enum
    pub required_non_nullable_status: Status,
    /// required + nullable enum
    #[schema(nullable)]
    pub required_nullable_status: Option<Status>,
    /// optional + non-nullable enum
    #[serde(default = "default_priority")]
    pub optional_non_nullable_priority: Priority,
    /// optional + nullable enum
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_priority: Option<Priority>,
    /// integer enum field
    pub code: Code,
    /// array of enum values (required, non-nullable)
    pub statuses: Vec<Status>,
    /// nullable array of enums (required)
    #[schema(nullable)]
    pub nullable_statuses: Option<Vec<Status>>,
}

fn default_priority() -> Priority {
    Priority::Low
}
