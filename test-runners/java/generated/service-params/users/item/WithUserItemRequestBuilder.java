package com.dotnicht.kiotatests.serviceparams.users.item;

import com.dotnicht.kiotatests.serviceparams.users.item.posts.PostsRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /users/{user_id}
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class WithUserItemRequestBuilder extends BaseRequestBuilder {
    /**
     * The posts property
     * @return a {@link PostsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public PostsRequestBuilder posts() {
        return new PostsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link WithUserItemRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithUserItemRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/users/{user_id}", pathParameters);
    }
    /**
     * Instantiates a new {@link WithUserItemRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithUserItemRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/users/{user_id}", rawUrl);
    }
}
