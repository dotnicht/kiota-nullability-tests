use axum::{Json, Router, routing::get};
use utoipa::OpenApi;
use utoipa_swagger_ui::SwaggerUi;

mod models;
use models::*;

#[derive(OpenApi)]
#[openapi(
    paths(get_container, post_container, get_outer, get_tree, get_extended),
    components(schemas(Container, Address, Tag, Outer, Middle, Inner, TreeNode, Extended, Base))
)]
struct Api;

#[utoipa::path(
    get,
    path = "/container",
    responses((status = 200, body = Container))
)]
async fn get_container() -> Json<Container> {
    Json(Container {
        required_non_nullable_address: Address {
            street: "123 Main St".to_string(),
            city: "Springfield".to_string(),
        },
        required_nullable_address: Some(Address {
            street: "456 Elm St".to_string(),
            city: "Shelbyville".to_string(),
        }),
        optional_nullable_address: None,
        required_non_nullable_tags: vec![Tag { name: "rust".to_string() }],
        optional_nullable_tags: None,
    })
}

#[utoipa::path(
    post,
    path = "/container",
    request_body = Container,
    responses((status = 200, body = Container))
)]
async fn post_container(Json(body): Json<Container>) -> Json<Container> {
    Json(body)
}

#[utoipa::path(
    get,
    path = "/outer",
    responses((status = 200, body = Outer))
)]
async fn get_outer() -> Json<Outer> {
    Json(Outer {
        id: 1,
        middle: Middle {
            label: "mid".to_string(),
            inner: Inner {
                value: "deep value".to_string(),
                note: Some("a note".to_string()),
            },
            optional_inner: None,
        },
        nullable_middle: None,
    })
}

#[utoipa::path(
    get,
    path = "/tree",
    responses((status = 200, body = TreeNode))
)]
async fn get_tree() -> Json<TreeNode> {
    Json(TreeNode {
        id: 1,
        label: "root".to_string(),
        children: Some(vec![
            Box::new(TreeNode {
                id: 2,
                label: "child".to_string(),
                children: None,
            }),
        ]),
    })
}

#[utoipa::path(
    get,
    path = "/extended",
    responses((status = 200, body = Extended))
)]
async fn get_extended() -> Json<Extended> {
    Json(Extended {
        base: Base { id: 10, name: "base name".to_string() },
        extra: "extra value".to_string(),
        optional_nullable: Some("present".to_string()),
    })
}

#[tokio::main]
async fn main() {
    let spec = Api::openapi();
    let app = Router::new()
        .route("/container", get(get_container).post(post_container))
        .route("/outer", get(get_outer))
        .route("/tree", get(get_tree))
        .route("/extended", get(get_extended))
        .merge(SwaggerUi::new("/swagger-ui").url("/openapi.json", spec));

    let listener = tokio::net::TcpListener::bind(format!("0.0.0.0:{}", std::env::var("PORT").unwrap_or_else(|_| "8080".into()))).await.unwrap();
    println!("{} listening on :{}", "service-objects", std::env::var("PORT").unwrap_or_else(|_| "8080".into()));
    axum::serve(listener, app).await.unwrap();
}
