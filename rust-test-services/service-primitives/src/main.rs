use axum::{Json, Router, routing::get};
use utoipa::OpenApi;
use utoipa_swagger_ui::SwaggerUi;

mod models;
use models::*;

#[derive(OpenApi)]
#[openapi(
    paths(get_model, post_model),
    components(schemas(Primitives))
)]
struct Api;

#[utoipa::path(
    get,
    path = "/model",
    responses((status = 200, body = Primitives))
)]
async fn get_model() -> Json<Primitives> {
    Json(Primitives {
        required_non_nullable_int: 42,
        required_nullable_int: Some(7),
        optional_non_nullable_int: 0,
        optional_nullable_int: None,

        required_non_nullable_int64: 9_000_000_000i64,
        required_nullable_int64: Some(1_000_000_000i64),
        optional_non_nullable_int64: 0,
        optional_nullable_int64: None,

        required_non_nullable_float: 3.14,
        required_nullable_float: Some(2.71),
        optional_non_nullable_float: 0.0,
        optional_nullable_float: None,

        required_non_nullable_double: 3.141592653589793,
        required_nullable_double: Some(2.718281828459045),
        optional_non_nullable_double: 0.0,
        optional_nullable_double: None,

        required_non_nullable_bool: true,
        required_nullable_bool: Some(false),
        optional_non_nullable_bool: false,
        optional_nullable_bool: None,

        required_non_nullable_string: "hello".to_string(),
        required_nullable_string: Some("world".to_string()),
        optional_non_nullable_string: String::new(),
        optional_nullable_string: None,

        required_non_nullable_date: "2024-01-15".to_string(),
        required_nullable_date: Some("2024-06-30".to_string()),

        required_non_nullable_datetime: "2024-01-15T10:30:00Z".to_string(),
        required_nullable_datetime: Some("2024-06-30T23:59:59Z".to_string()),

        required_non_nullable_uuid: "550e8400-e29b-41d4-a716-446655440000".to_string(),
        required_nullable_uuid: Some("6ba7b810-9dad-11d1-80b4-00c04fd430c8".to_string()),

        required_non_nullable_byte: "SGVsbG8gV29ybGQ=".to_string(),
        required_nullable_byte: Some("Rm9vQmFy".to_string()),
    })
}

#[utoipa::path(
    post,
    path = "/model",
    request_body = Primitives,
    responses((status = 200, body = Primitives))
)]
async fn post_model(Json(body): Json<Primitives>) -> Json<Primitives> {
    Json(body)
}

#[tokio::main]
async fn main() {
    let spec = Api::openapi();
    let app = Router::new()
        .route("/model", get(get_model).post(post_model))
        .merge(SwaggerUi::new("/swagger-ui").url("/openapi.json", spec));

    let listener = tokio::net::TcpListener::bind(format!("0.0.0.0:{}", std::env::var("PORT").unwrap_or_else(|_| "8080".into()))).await.unwrap();
    println!("{} listening on :{}", "service-primitives", std::env::var("PORT").unwrap_or_else(|_| "8080".into()));
    axum::serve(listener, app).await.unwrap();
}
