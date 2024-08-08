package com.evapharma.queueingsystem.core.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002JI\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010JI\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J0\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0002JQ\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ[\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\r2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJe\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\r2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 JS\u0010!\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000f2\b\b\u0002\u0010\"\u001a\u00020#H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$JQ\u0010%\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ[\u0010%\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\r2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJS\u0010&\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000f2\b\b\u0002\u0010\"\u001a\u00020#H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$JI\u0010\'\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010(\u001a\u00020)2\b\b\u0002\u0010\"\u001a\u00020#R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/evapharma/queueingsystem/core/network/NetworkManager;", "", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "deleteRequest", "Lcom/evapharma/queueingsystem/core/models/BaseResponse;", "T", "api", "param", "", "parseClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRequest", "parseResponse", "response", "Lretrofit2/Response;", "Lcom/google/gson/JsonElement;", "postMultiPart", "body", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Ljava/util/Map;Lokhttp3/MultipartBody$Part;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/RequestBody;", "multipleFiles", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleFile", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lokhttp3/MultipartBody$Part;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postRequest", "isResetPassword", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Class;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putMultiPart", "putRequest", "putRequestWithQuery", "updateHeaders", "", "app_debug"})
public final class NetworkManager {
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.String> headers = null;
    
    @javax.inject.Inject
    public NetworkManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return null;
    }
    
    public final void updateHeaders(boolean isResetPassword) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object getRequest(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> param, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object postRequest(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> body, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, boolean isResetPassword, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object postMultiPart(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> body, @org.jetbrains.annotations.NotNull
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object postMultiPart(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> body, @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.Nullable
    okhttp3.MultipartBody.Part singleFile, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object postMultiPart(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> body, @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object deleteRequest(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> param, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object putMultiPart(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends okhttp3.RequestBody> body, @org.jetbrains.annotations.NotNull
    java.util.List<okhttp3.MultipartBody.Part> multipleFiles, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object putRequest(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> body, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, boolean isResetPassword, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object putRequestWithQuery(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> param, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>java.lang.Object putMultiPart(@org.jetbrains.annotations.NotNull
    java.lang.String api, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.lang.Object> body, @org.jetbrains.annotations.NotNull
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> parseClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.evapharma.queueingsystem.core.models.BaseResponse<T>> $completion) {
        return null;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {com.evapharma.queueingsystem.core.models.ErrorResponse.class, java.io.IOException.class, java.lang.InstantiationException.class, java.lang.IllegalAccessException.class, org.json.JSONException.class})
    private final <T extends java.lang.Object>com.evapharma.queueingsystem.core.models.BaseResponse<T> parseResponse(retrofit2.Response<com.google.gson.JsonElement> response, java.lang.Class<T> parseClass) {
        return null;
    }
}