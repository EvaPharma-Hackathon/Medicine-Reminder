package com.evapharma.queueingsystem.core.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/evapharma/queueingsystem/core/network/BaseURLFactory;", "", "()V", "Companion", "app_debug"})
public final class BaseURLFactory {
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull
    private static retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull
    public static final com.evapharma.queueingsystem.core.network.BaseURLFactory.Companion Companion = null;
    
    public BaseURLFactory() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/evapharma/queueingsystem/core/network/BaseURLFactory$Companion;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "timeout", "", "provideRetrofit", "resetBaseURL", "", "url", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final com.google.gson.Gson getGson() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final retrofit2.Retrofit getRetrofit() {
            return null;
        }
        
        public final void setRetrofit(@org.jetbrains.annotations.NotNull
        retrofit2.Retrofit p0) {
        }
        
        public final void resetBaseURL(@org.jetbrains.annotations.NotNull
        java.lang.String url) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final retrofit2.Retrofit provideRetrofit(long timeout) {
            return null;
        }
        
        private final okhttp3.OkHttpClient provideOkHttpClient(long timeout) {
            return null;
        }
    }
}