use axum::{Json, Router, routing::get};
use utoipa::OpenApi;
use utoipa_swagger_ui::SwaggerUi;

mod models;
use models::*;

#[derive(OpenApi)]
#[openapi(
    paths(get_model, post_model),
    components(schemas(EnumContainer, Status, Priority, Code))
)]
struct Api;

#[utoipa::path(
    get,
    path = "/model",
    responses((status = 200, body = EnumContainer))
)]
async fn get_model() -> Json<EnumContainer> {
    Json(EnumContainer {
        required_non_nullable_status: Status::Active,
        required_nullable_status: Some(Status::Inactive),
        optional_non_nullable_priority: Priority::High,
        optional_nullable_priority: None,
        code: Code::Ok,
        statuses: vec![Status::Active, Status::Pending],
        nullable_statuses: Some(vec![Status::Inactive]),
    })
}

#[utoipa::path(
    post,
    path = "/model",
    request_body = EnumContainer,
    responses((status = 200, body = EnumContainer))
)]
async fn post_model(Json(body): Json<EnumContainer>) -> Json<EnumContainer> {
    Json(body)
}

#[tokio::main]
async fn main() {
    let spec = Api::openapi();
    let app = Router::new()
        .route("/model", get(get_model).post(post_model))
        .merge(SwaggerUi::new("/swagger-ui").url("/openapi.json", spec));

    let listener = tokio::net::TcpListener::bind(format!("0.0.0.0:{}", std::env::var("PORT").unwrap_or_else(|_| "8080".into()))).await.unwrap();
    println!("{} listening on :{}", "service-enums", std::env::var("PORT").unwrap_or_else(|_| "8080".into()));
    axum::serve(listener, app).await.unwrap();
}
