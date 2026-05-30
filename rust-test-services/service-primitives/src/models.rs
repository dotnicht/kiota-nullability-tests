use serde::{Deserialize, Serialize};
use utoipa::ToSchema;

fn default_string() -> String {
    String::new()
}

fn default_i32() -> i32 {
    0
}

fn default_i64() -> i64 {
    0
}

fn default_f32() -> f32 {
    0.0
}

fn default_f64() -> f64 {
    0.0
}

fn default_bool() -> bool {
    false
}

/// All 4 quadrants × all primitive types.
///
/// | field                          | required | nullable |
/// |--------------------------------|----------|----------|
/// | required_non_nullable_*        | yes      | no       |
/// | required_nullable_*            | yes      | yes      |
/// | optional_non_nullable_*        | no       | no       |
/// | optional_nullable_*            | no       | yes      |
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Primitives {
    // ---- i32 ----
    pub required_non_nullable_int: i32,
    #[schema(nullable)]
    pub required_nullable_int: Option<i32>,
    #[serde(default = "default_i32")]
    pub optional_non_nullable_int: i32,
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_int: Option<i32>,

    // ---- i64 ----
    pub required_non_nullable_int64: i64,
    #[schema(nullable)]
    pub required_nullable_int64: Option<i64>,
    #[serde(default = "default_i64")]
    pub optional_non_nullable_int64: i64,
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_int64: Option<i64>,

    // ---- f32 ----
    pub required_non_nullable_float: f32,
    #[schema(nullable)]
    pub required_nullable_float: Option<f32>,
    #[serde(default = "default_f32")]
    pub optional_non_nullable_float: f32,
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_float: Option<f32>,

    // ---- f64 ----
    pub required_non_nullable_double: f64,
    #[schema(nullable)]
    pub required_nullable_double: Option<f64>,
    #[serde(default = "default_f64")]
    pub optional_non_nullable_double: f64,
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_double: Option<f64>,

    // ---- bool ----
    pub required_non_nullable_bool: bool,
    #[schema(nullable)]
    pub required_nullable_bool: Option<bool>,
    #[serde(default = "default_bool")]
    pub optional_non_nullable_bool: bool,
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_bool: Option<bool>,

    // ---- plain string ----
    pub required_non_nullable_string: String,
    #[schema(nullable)]
    pub required_nullable_string: Option<String>,
    #[serde(default = "default_string")]
    pub optional_non_nullable_string: String,
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_string: Option<String>,

    // ---- date (format: date) ----
    #[schema(value_type = String, format = Date)]
    pub required_non_nullable_date: String,
    #[schema(value_type = String, format = Date, nullable)]
    pub required_nullable_date: Option<String>,

    // ---- date-time (format: date-time) ----
    #[schema(value_type = String, format = DateTime)]
    pub required_non_nullable_datetime: String,
    #[schema(value_type = String, format = DateTime, nullable)]
    pub required_nullable_datetime: Option<String>,

    // ---- uuid (format: uuid via custom format string) ----
    #[schema(value_type = String, format = "uuid")]
    pub required_non_nullable_uuid: String,
    #[schema(value_type = String, format = "uuid", nullable)]
    pub required_nullable_uuid: Option<String>,

    // ---- byte/base64 (format: byte) ----
    #[schema(value_type = String, format = Byte)]
    pub required_non_nullable_byte: String,
    #[schema(value_type = String, format = Byte, nullable)]
    pub required_nullable_byte: Option<String>,
}
