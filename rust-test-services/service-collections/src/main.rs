use std::collections::HashMap;
use axum::{Json, Router, routing::get};
use utoipa::OpenApi;
use utoipa_swagger_ui::SwaggerUi;

mod models;
use models::*;

#[derive(OpenApi)]
#[openapi(
    paths(get_model, post_model),
    components(schemas(Collections, Item))
)]
struct Api;

#[utoipa::path(
    get,
    path = "/model",
    responses((status = 200, body = Collections))
)]
async fn get_model() -> Json<Collections> {
    let mut string_map = HashMap::new();
    string_map.insert("key1".to_string(), "value1".to_string());

    let mut nullable_map = HashMap::new();
    nullable_map.insert("k1".to_string(), Some("v1".to_string()));
    nullable_map.insert("k2".to_string(), None);

    let mut item_map = HashMap::new();
    item_map.insert("a".to_string(), Item { id: 1, label: "alpha".to_string() });

    Json(Collections {
        required_strings: vec!["foo".to_string(), "bar".to_string()],
        required_nullable_strings: Some(vec!["baz".to_string()]),
        optional_strings: vec![],
        optional_nullable_strings: None,
        nullable_item_strings: vec![Some("present".to_string()), None],
        required_items: vec![Item { id: 1, label: "item1".to_string() }],
        nested: vec![vec!["a".to_string(), "b".to_string()], vec!["c".to_string()]],
        string_map,
        nullable_value_map: nullable_map,
        item_map,
    })
}

#[utoipa::path(
    post,
    path = "/model",
    request_body = Collections,
    responses((status = 200, body = Collections))
)]
async fn post_model(Json(body): Json<Collections>) -> Json<Collections> {
    Json(body)
}

#[tokio::main]
async fn main() {
    let spec = Api::openapi();
    let app = Router::new()
        .route("/model", get(get_model).post(post_model))
        .merge(SwaggerUi::new("/swagger-ui").url("/openapi.json", spec));

    let listener = tokio::net::TcpListener::bind(format!("0.0.0.0:{}", std::env::var("PORT").unwrap_or_else(|_| "8080".into()))).await.unwrap();
    println!("{} listening on :{}", "service-collections", std::env::var("PORT").unwrap_or_else(|_| "8080".into()));
    axum::serve(listener, app).await.unwrap();
}
