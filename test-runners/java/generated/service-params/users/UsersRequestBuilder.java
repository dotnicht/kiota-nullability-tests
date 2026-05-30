package com.dotnicht.kiotatests.serviceparams.users;

import com.dotnicht.kiotatests.serviceparams.users.item.WithUserItemRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /users
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class UsersRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the com.dotnicht.kiotatests.serviceparams.users.item collection
     * @param user_id User identifier
     * @return a {@link WithUserItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithUserItemRequestBuilder byUser_id(@jakarta.annotation.Nonnull final String user_id) {
        Objects.requireNonNull(user_id);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("user_id", user_id);
        return new WithUserItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link UsersRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public UsersRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/users", pathParameters);
    }
    /**
     * Instantiates a new {@link UsersRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public UsersRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/users", rawUrl);
    }
}
