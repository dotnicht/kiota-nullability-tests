use axum::{Json, Router, routing::get};
use utoipa::OpenApi;
use utoipa_swagger_ui::SwaggerUi;

mod models;
use models::*;

#[derive(OpenApi)]
#[openapi(
    paths(get_model, post_model),
    components(schemas(Composition, Extended, Base, Value, Animal, Dog, Cat))
)]
struct Api;

#[utoipa::path(
    get,
    path = "/model",
    responses((status = 200, body = Composition))
)]
async fn get_model() -> Json<Composition> {
    Json(Composition {
        value: Value::Text("hello".to_string()),
        nullable_value: Some(Value::Number(42)),
        extended: Extended {
            base: Base { id: 1, name: "base".to_string() },
            extra: "extra value".to_string(),
            optional_nullable: Some("present".to_string()),
        },
        optional_extended: None,
        animal: Animal::Dog(Dog { breed: "Labrador".to_string() }),
    })
}

#[utoipa::path(
    post,
    path = "/model",
    request_body = Composition,
    responses((status = 200, body = Composition))
)]
async fn post_model(Json(body): Json<Composition>) -> Json<Composition> {
    Json(body)
}

#[tokio::main]
async fn main() {
    let spec = Api::openapi();
    let app = Router::new()
        .route("/model", get(get_model).post(post_model))
        .merge(SwaggerUi::new("/swagger-ui").url("/openapi.json", spec));

    let listener = tokio::net::TcpListener::bind(format!("0.0.0.0:{}", std::env::var("PORT").unwrap_or_else(|_| "8080".into()))).await.unwrap();
    println!("{} listening on :{}", "service-compositions", std::env::var("PORT").unwrap_or_else(|_| "8080".into()));
    axum::serve(listener, app).await.unwrap();
}
