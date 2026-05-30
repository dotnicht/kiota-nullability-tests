package com.dotnicht.kiotatests.serviceparams.items;

import com.dotnicht.kiotatests.serviceparams.items.item.ItemsItemRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /items
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the com.dotnicht.kiotatests.serviceparams.items.item collection
     * @param id Required non-nullable path param
     * @return a {@link ItemsItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ItemsItemRequestBuilder byId(@jakarta.annotation.Nonnull final Integer id) {
        Objects.requireNonNull(id);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("id", id);
        return new ItemsItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link ItemsRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ItemsRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/items", pathParameters);
    }
    /**
     * Instantiates a new {@link ItemsRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ItemsRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/items", rawUrl);
    }
}
