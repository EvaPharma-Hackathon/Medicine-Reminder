package com.evapharma.queueingsystem.core.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001JQ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJQ\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014Je\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018Jq\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u007f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0012\b\u0001\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00132\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJi\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014Jq\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J}\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u008b\u0001\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0012\b\u0001\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00172\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00132\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJQ\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014Je\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018Ji\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014Jq\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\b2\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018JQ\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJQ\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ]\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\u0003\"\u0004\b\u0000\u0010\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/evapharma/queueingsystem/core/network/APIService;", "", "deleteRequest", "Lretrofit2/Response;", "Lcom/google/gson/JsonElement;", "api", "", "headers", "", "param", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRequestV2", "Lcom/evapharma/queueingsystem/core/models/BaseResponse;", "T", "getRequest", "getRequestV2", "postMultiPart", "body", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/RequestBody;", "multipleFiles", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleFile", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleFileTwo", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Lokhttp3/MultipartBody$Part;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postMultiPartV2", "postRequest", "postRequestV2", "putMultiPart", "putMultiPartV2", "putRequest", "putRequestV2", "putRequestWithQuery", "putRequestWithQueryV2", "app_debug"})
public abstract interface APIService {
    
    @retrofit2.http.GET
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRequest(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.QueryMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> param, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.GET
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object getRequestV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.QueryMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> param, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postRequest(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.Body
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object postRequestV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.Body
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putRequest(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.Body
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object putRequestV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.Body
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    /**
     * TODO
     * Put request function that take query map instead of body
     * need to investigate more what is the best practice
     * is it correct that put request can have query parameter or not
     */
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putRequestWithQuery(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.QueryMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> param, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object putRequestWithQueryV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.QueryMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> param, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.DELETE
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRequest(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.QueryMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> param, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.DELETE
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object deleteRequestV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.QueryMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> param, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postMultiPart(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object postMultiPartV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postMultiPart(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object postMultiPartV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postMultiPart(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFile, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFileTwo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object postMultiPartV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFile, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFileTwo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putMultiPart(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object putMultiPartV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Object> body, @retrofit2.http.Part
    @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postMultiPart(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object postMultiPartV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putMultiPart(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.google.gson.JsonElement>> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.PUT
    @kotlin.jvm.JvmSuppressWildcards
    @org.jetbrains.annotations.Nullable
    public abstract <T extends java.lang.Object>java.lang.Object putMultiPartV2(@retrofit2.http.Url
    @org.jetbrains.annotations.NotNull
    java.lang.String api, @retrofit2.http.HeaderMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> headers, @retrofit2.http.PartMap
    @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, okhttp3.RequestBody> body, @retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<retrofit2.Response<com.evapharma.queueingsystem.core.models.BaseResponse<T>>> $completion);
}