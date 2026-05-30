package com.dotnicht.kiotatests.serviceobjects;

import com.dotnicht.kiotatests.serviceobjects.container.ContainerRequestBuilder;
import com.dotnicht.kiotatests.serviceobjects.extended.ExtendedRequestBuilder;
import com.dotnicht.kiotatests.serviceobjects.outer.OuterRequestBuilder;
import com.dotnicht.kiotatests.serviceobjects.tree.TreeRequestBuilder;
import com.microsoft.kiota.ApiClientBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.serialization.FormParseNodeFactory;
import com.microsoft.kiota.serialization.FormSerializationWriterFactory;
import com.microsoft.kiota.serialization.JsonParseNodeFactory;
import com.microsoft.kiota.serialization.JsonSerializationWriterFactory;
import com.microsoft.kiota.serialization.MultipartSerializationWriterFactory;
import com.microsoft.kiota.serialization.ParseNodeFactoryRegistry;
import com.microsoft.kiota.serialization.SerializationWriterFactoryRegistry;
import com.microsoft.kiota.serialization.TextParseNodeFactory;
import com.microsoft.kiota.serialization.TextSerializationWriterFactory;
import java.util.HashMap;
import java.util.Objects;
/**
 * The main entry point of the SDK, exposes the configuration and the fluent API.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ServiceObjectsClient extends BaseRequestBuilder {
    /**
     * The container property
     * @return a {@link ContainerRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ContainerRequestBuilder container() {
        return new ContainerRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The extended property
     * @return a {@link ExtendedRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ExtendedRequestBuilder extended() {
        return new ExtendedRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The outer property
     * @return a {@link OuterRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public OuterRequestBuilder outer() {
        return new OuterRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The tree property
     * @return a {@link TreeRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public TreeRequestBuilder tree() {
        return new TreeRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link ServiceObjectsClient} and sets the default values.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ServiceObjectsClient(@jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}");
        this.pathParameters = new HashMap<>();
        ApiClientBuilder.registerDefaultSerializer(() -> new JsonSerializationWriterFactory());
        ApiClientBuilder.registerDefaultSerializer(() -> new TextSerializationWriterFactory());
        ApiClientBuilder.registerDefaultSerializer(() -> new FormSerializationWriterFactory());
        ApiClientBuilder.registerDefaultSerializer(() -> new MultipartSerializationWriterFactory());
        ApiClientBuilder.registerDefaultDeserializer(() -> new JsonParseNodeFactory());
        ApiClientBuilder.registerDefaultDeserializer(() -> new FormParseNodeFactory());
        ApiClientBuilder.registerDefaultDeserializer(() -> new TextParseNodeFactory());
    }
}
