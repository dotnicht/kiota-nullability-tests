use serde::{Deserialize, Serialize};
use utoipa::ToSchema;

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Address {
    pub street: String,
    pub city: String,
}

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Tag {
    pub name: String,
}

/// Covers required/nullable quadrants for nested objects and arrays.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Container {
    /// required + non-nullable object
    pub required_non_nullable_address: Address,
    /// required + nullable object
    #[schema(nullable)]
    pub required_nullable_address: Option<Address>,
    /// optional + nullable object
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_address: Option<Address>,
    /// required + non-nullable array
    pub required_non_nullable_tags: Vec<Tag>,
    /// optional + nullable array
    #[serde(default)]
    #[schema(nullable)]
    pub optional_nullable_tags: Option<Vec<Tag>>,
}

// ---- Deeply nested (3 levels) ----

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Inner {
    pub value: String,
    #[schema(nullable)]
    pub note: Option<String>,
}

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Middle {
    pub label: String,
    pub inner: Inner,
    #[schema(nullable)]
    pub optional_inner: Option<Inner>,
}

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Outer {
    pub id: i32,
    pub middle: Middle,
    #[schema(nullable)]
    pub nullable_middle: Option<Middle>,
}

// ---- Self-referential tree node ----

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct TreeNode {
    pub id: i32,
    pub label: String,
    /// Children are optional and nullable; Box breaks the recursive layout.
    #[serde(default)]
    #[schema(nullable)]
    pub children: Option<Vec<Box<TreeNode>>>,
}

// ---- Flattened / allOf simulation ----

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Base {
    pub id: i32,
    pub name: String,
}

/// Extended embeds Base via flatten, which utoipa maps to allOf.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Extended {
    #[serde(flatten)]
    pub base: Base,
    pub extra: String,
    #[schema(nullable)]
    pub optional_nullable: Option<String>,
}
