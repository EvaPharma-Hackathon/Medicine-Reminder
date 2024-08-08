package com.evapharma.queueingsystem.core.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0005\u0018\u0019\u001a\u001b\u001cBC\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\r\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0005\u001d\u001e\u001f !\u00a8\u0006\""}, d2 = {"Lcom/evapharma/queueingsystem/core/models/DataState;", "T", "", "loading", "", "data", "code", "", "reason", "", "", "exception", "Lcom/evapharma/queueingsystem/core/models/Exceptions;", "(ZLjava/lang/Object;ILjava/util/List;Lcom/evapharma/queueingsystem/core/models/Exceptions;)V", "getCode", "()I", "Ljava/lang/Object;", "getException", "()Lcom/evapharma/queueingsystem/core/models/Exceptions;", "getLoading", "()Z", "getReason", "()Ljava/util/List;", "()Ljava/lang/Object;", "Error", "ErrorV2", "Idle", "Loading", "Success", "Lcom/evapharma/queueingsystem/core/models/DataState$Error;", "Lcom/evapharma/queueingsystem/core/models/DataState$ErrorV2;", "Lcom/evapharma/queueingsystem/core/models/DataState$Idle;", "Lcom/evapharma/queueingsystem/core/models/DataState$Loading;", "Lcom/evapharma/queueingsystem/core/models/DataState$Success;", "app_debug"})
public abstract class DataState<T extends java.lang.Object> {
    private final boolean loading = false;
    @org.jetbrains.annotations.Nullable
    private final T data = null;
    private final int code = 0;
    @org.jetbrains.annotations.Nullable
    private final java.util.List<java.lang.String> reason = null;
    @org.jetbrains.annotations.Nullable
    private final com.evapharma.queueingsystem.core.models.Exceptions exception = null;
    
    private DataState(boolean loading, T data, int code, java.util.List<java.lang.String> reason, com.evapharma.queueingsystem.core.models.Exceptions exception) {
        super();
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    public final int getCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getReason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.evapharma.queueingsystem.core.models.Exceptions getException() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final T data() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/DataState$Error;", "T", "Lcom/evapharma/queueingsystem/core/models/DataState;", "code", "", "reason", "", "", "(ILjava/util/List;)V", "app_debug"})
    public static final class Error<T extends java.lang.Object> extends com.evapharma.queueingsystem.core.models.DataState<T> {
        
        public Error(int code, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> reason) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/DataState$ErrorV2;", "T", "Lcom/evapharma/queueingsystem/core/models/DataState;", "e", "Lcom/evapharma/queueingsystem/core/models/Exceptions;", "(Lcom/evapharma/queueingsystem/core/models/Exceptions;)V", "getE", "()Lcom/evapharma/queueingsystem/core/models/Exceptions;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ErrorV2<T extends java.lang.Object> extends com.evapharma.queueingsystem.core.models.DataState<T> {
        @org.jetbrains.annotations.NotNull
        private final com.evapharma.queueingsystem.core.models.Exceptions e = null;
        
        public ErrorV2(@org.jetbrains.annotations.NotNull
        com.evapharma.queueingsystem.core.models.Exceptions e) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.evapharma.queueingsystem.core.models.Exceptions getE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.evapharma.queueingsystem.core.models.Exceptions component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.evapharma.queueingsystem.core.models.DataState.ErrorV2<T> copy(@org.jetbrains.annotations.NotNull
        com.evapharma.queueingsystem.core.models.Exceptions e) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/DataState$Idle;", "Lcom/evapharma/queueingsystem/core/models/DataState;", "", "()V", "app_debug"})
    public static final class Idle extends com.evapharma.queueingsystem.core.models.DataState {
        @org.jetbrains.annotations.NotNull
        public static final com.evapharma.queueingsystem.core.models.DataState.Idle INSTANCE = null;
        
        private Idle() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/DataState$Loading;", "T", "Lcom/evapharma/queueingsystem/core/models/DataState;", "cachedData", "(Ljava/lang/Object;)V", "getCachedData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.evapharma.queueingsystem.core.models.DataState<T> {
        @org.jetbrains.annotations.Nullable
        private final T cachedData = null;
        
        public Loading(@org.jetbrains.annotations.Nullable
        T cachedData) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final T getCachedData() {
            return null;
        }
        
        public Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001H\u00c6\u0001\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0013\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/DataState$Success;", "T", "Lcom/evapharma/queueingsystem/core/models/DataState;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/evapharma/queueingsystem/core/models/DataState$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.evapharma.queueingsystem.core.models.DataState<T> {
        private final T data = null;
        
        public Success(T data) {
        }
        
        public final T getData() {
            return null;
        }
        
        public final T component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.evapharma.queueingsystem.core.models.DataState.Success<T> copy(T data) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}