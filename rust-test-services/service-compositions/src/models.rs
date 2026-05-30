use serde::{Deserialize, Serialize};
use utoipa::ToSchema;

// ---- allOf simulation via flatten ----

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Base {
    pub id: i32,
    pub name: String,
}

/// Extended embeds Base via flatten; utoipa emits allOf in the schema.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Extended {
    #[serde(flatten)]
    pub base: Base,
    pub extra: String,
    #[schema(nullable)]
    pub optional_nullable: Option<String>,
}

// ---- oneOf simulation via untagged enum ----

/// Can hold a string or an integer; utoipa generates oneOf.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
#[serde(untagged)]
pub enum Value {
    Text(String),
    Number(i32),
}

// ---- discriminator-based polymorphism via internally-tagged enum ----

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Dog {
    pub breed: String,
}

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Cat {
    pub indoor: bool,
}

/// Discriminator-based union: serialises as `{ "type": "Dog", ... }`.
#[derive(Debug, Serialize, Deserialize, ToSchema)]
#[serde(tag = "type")]
pub enum Animal {
    Dog(Dog),
    Cat(Cat),
}

// ---- container exercising all composition patterns ----

#[derive(Debug, Serialize, Deserialize, ToSchema)]
pub struct Composition {
    /// Required non-nullable oneOf field.
    pub value: Value,
    /// Required nullable oneOf field.
    #[schema(nullable)]
    pub nullable_value: Option<Value>,
    /// Required non-nullable allOf field.
    pub extended: Extended,
    /// Optional allOf-extended field.
    #[serde(default)]
    #[schema(nullable)]
    pub optional_extended: Option<Extended>,
    /// Discriminator-based polymorphism.
    pub animal: Animal,
}
