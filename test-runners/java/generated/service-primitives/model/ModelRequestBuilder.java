package com.dotnicht.kiotatests.serviceprimitives.model;

import com.dotnicht.kiotatests.serviceprimitives.models.Primitives;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.BaseRequestConfiguration;
import com.microsoft.kiota.HttpMethod;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.RequestInformation;
import com.microsoft.kiota.RequestOption;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParsableFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /model
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ModelRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new {@link ModelRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ModelRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/model", pathParameters);
    }
    /**
     * Instantiates a new {@link ModelRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ModelRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/model", rawUrl);
    }
    /**
     * @return a {@link Primitives}
     */
    @jakarta.annotation.Nullable
    public Primitives get() {
        return get(null);
    }
    /**
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link Primitives}
     */
    @jakarta.annotation.Nullable
    public Primitives get(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toGetRequestInformation(requestConfiguration);
        return this.requestAdapter.send(requestInfo, null, Primitives::createFromDiscriminatorValue);
    }
    /**
     * @param body All 4 quadrants  all primitive types.| field                          | required | nullable ||--------------------------------|----------|----------|| required_non_nullable_*        | yes      | no       || required_nullable_*            | yes      | yes      || optional_non_nullable_*        | no       | no       || optional_nullable_*            | no       | yes      |
     * @return a {@link Primitives}
     */
    @jakarta.annotation.Nullable
    public Primitives post(@jakarta.annotation.Nonnull final Primitives body) {
        return post(body, null);
    }
    /**
     * @param body All 4 quadrants  all primitive types.| field                          | required | nullable ||--------------------------------|----------|----------|| required_non_nullable_*        | yes      | no       || required_nullable_*            | yes      | yes      || optional_non_nullable_*        | no       | no       || optional_nullable_*            | no       | yes      |
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link Primitives}
     */
    @jakarta.annotation.Nullable
    public Primitives post(@jakarta.annotation.Nonnull final Primitives body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPostRequestInformation(body, requestConfiguration);
        return this.requestAdapter.send(requestInfo, null, Primitives::createFromDiscriminatorValue);
    }
    /**
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation() {
        return toGetRequestInformation(null);
    }
    /**
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.GET, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, GetRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        return requestInfo;
    }
    /**
     * @param body All 4 quadrants  all primitive types.| field                          | required | nullable ||--------------------------------|----------|----------|| required_non_nullable_*        | yes      | no       || required_nullable_*            | yes      | yes      || optional_non_nullable_*        | no       | no       || optional_nullable_*            | no       | yes      |
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final Primitives body) {
        return toPostRequestInformation(body, null);
    }
    /**
     * @param body All 4 quadrants  all primitive types.| field                          | required | nullable ||--------------------------------|----------|----------|| required_non_nullable_*        | yes      | no       || required_nullable_*            | yes      | yes      || optional_non_nullable_*        | no       | no       || optional_nullable_*            | no       | yes      |
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final Primitives body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.POST, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PostRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link ModelRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ModelRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new ModelRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class GetRequestConfiguration extends BaseRequestConfiguration {
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PostRequestConfiguration extends BaseRequestConfiguration {
    }
}
