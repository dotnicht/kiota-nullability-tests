use std::collections::HashMap;
use serde::{Deserialize, Serialize};
use utoipa::ToSchema;

/// Inline object used as array element and map value.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Item {
    pub id: i32,
    pub label: String,
}

/// Covers every array/map nullability permutation.
///
/// | field                        | required | nullable array | nullable items |
/// |------------------------------|----------|----------------|----------------|
/// | required_strings             | yes      | no             | no             |
/// | required_nullable_strings    | yes      | yes            | no             |
/// | optional_strings             | no       | no             | no             |
/// | optional_nullable_strings    | no       | yes            | no             |
/// | nullable_item_strings        | yes      | no             | yes            |
/// | required_items               | yes      | no             | no             |
/// | nested                       | yes      | no             | no             |
/// | string_map                   | yes      | —              | no             |
/// | nullable_value_map           | yes      | —              | yes            |
/// | item_map                     | yes      | —              | no             |
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Collections {
    /// Required non-nullable array of strings.
    pub required_strings: Vec<String>,

    /// Required nullable array of strings.
    #[schema(nullable)]
    pub required_nullable_strings: Option<Vec<String>>,

    /// Optional non-nullable array of strings (not in required[]).
    #[serde(default)]
    pub optional_strings: Vec<String>,

    /// Optional nullable array of strings.
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_strings: Option<Vec<String>>,

    /// Array whose items may be null.
    pub nullable_item_strings: Vec<Option<String>>,

    /// Required array of inline objects.
    pub required_items: Vec<Item>,

    /// Nested array (array of arrays).
    pub nested: Vec<Vec<String>>,

    /// Map<string, string> — additionalProperties: { type: string }.
    pub string_map: HashMap<String, String>,

    /// Map with nullable values — additionalProperties: { type: string, nullable: true }.
    pub nullable_value_map: HashMap<String, Option<String>>,

    /// Map of objects — additionalProperties: $ref Item.
    pub item_map: HashMap<String, Item>,
}
