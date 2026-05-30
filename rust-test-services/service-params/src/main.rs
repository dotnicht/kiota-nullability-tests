use axum::{
    Json, Router,
    extract::{Path, Query},
    routing::get,
};
use serde::{Deserialize, Serialize};
use utoipa::{IntoParams, OpenApi, ToSchema};
use utoipa_swagger_ui::SwaggerUi;

/// Result payload for /search.
#[derive(Debug, Serialize, ToSchema)]
struct SearchResult {
    query: String,
    page: i32,
    sort: String,
    active: Option<bool>,
    count: i32,
}

/// Result payload for /items/{id}.
#[derive(Debug, Serialize, ToSchema)]
struct Item {
    id: i32,
    name: String,
}

/// Result payload for /users/{user_id}/posts/{post_id}.
#[derive(Debug, Serialize, ToSchema)]
struct Post {
    user_id: String,
    post_id: i32,
    title: String,
}

/// Query parameters for /search.
///
/// | param   | required | nullable |
/// |---------|----------|----------|
/// | q       | yes      | no       |
/// | page    | no       | yes      |
/// | sort    | no       | no (default) |
/// | active  | no       | yes      |
#[derive(Debug, Deserialize, IntoParams)]
struct SearchParams {
    /// Required string query param.
    pub q: String,
    /// Optional integer page param.
    pub page: Option<i32>,
    /// Optional sort param with default.
    #[serde(default = "default_sort")]
    pub sort: String,
    /// Optional nullable bool.
    pub active: Option<bool>,
}

fn default_sort() -> String {
    "asc".to_string()
}

#[derive(OpenApi)]
#[openapi(
    paths(search, get_item, get_post),
    components(schemas(SearchResult, Item, Post))
)]
struct Api;

#[utoipa::path(
    get,
    path = "/search",
    params(SearchParams),
    responses((status = 200, body = SearchResult))
)]
async fn search(Query(p): Query<SearchParams>) -> Json<SearchResult> {
    Json(SearchResult {
        query: p.q,
        page: p.page.unwrap_or(1),
        sort: p.sort,
        active: p.active,
        count: 42,
    })
}

#[utoipa::path(
    get,
    path = "/items/{id}",
    params(
        ("id" = i32, Path, description = "Required non-nullable path param")
    ),
    responses((status = 200, body = Item))
)]
async fn get_item(Path(id): Path<i32>) -> Json<Item> {
    Json(Item { id, name: format!("item-{}", id) })
}

#[utoipa::path(
    get,
    path = "/users/{user_id}/posts/{post_id}",
    params(
        ("user_id" = String, Path, description = "User identifier"),
        ("post_id" = i32, Path, description = "Post identifier")
    ),
    responses((status = 200, body = Post))
)]
async fn get_post(Path((user_id, post_id)): Path<(String, i32)>) -> Json<Post> {
    Json(Post {
        user_id,
        post_id,
        title: "A sample post".to_string(),
    })
}

#[tokio::main]
async fn main() {
    let spec = Api::openapi();
    let app = Router::new()
        .route("/search", get(search))
        .route("/items/{id}", get(get_item))
        .route("/users/{user_id}/posts/{post_id}", get(get_post))
        .merge(SwaggerUi::new("/swagger-ui").url("/openapi.json", spec));

    let listener = tokio::net::TcpListener::bind(format!("0.0.0.0:{}", std::env::var("PORT").unwrap_or_else(|_| "8080".into()))).await.unwrap();
    println!("{} listening on :{}", "service-params", std::env::var("PORT").unwrap_or_else(|_| "8080".into()));
    axum::serve(listener, app).await.unwrap();
}
