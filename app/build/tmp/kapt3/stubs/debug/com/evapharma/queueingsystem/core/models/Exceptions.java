package com.evapharma.queueingsystem.core.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/Exceptions;", "", "()V", "ErrorResponse", "InternalServerError", "Unauthorized", "Lcom/evapharma/queueingsystem/core/models/Exceptions$ErrorResponse;", "Lcom/evapharma/queueingsystem/core/models/Exceptions$InternalServerError;", "Lcom/evapharma/queueingsystem/core/models/Exceptions$Unauthorized;", "app_debug"})
public abstract class Exceptions {
    
    private Exceptions() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/Exceptions$ErrorResponse;", "Lcom/evapharma/queueingsystem/core/models/Exceptions;", "msg", "", "code", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/evapharma/queueingsystem/core/models/Exceptions$ErrorResponse;", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
    public static final class ErrorResponse extends com.evapharma.queueingsystem.core.models.Exceptions {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String msg = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Integer code = null;
        
        public ErrorResponse(@org.jetbrains.annotations.NotNull
        java.lang.String msg, @org.jetbrains.annotations.Nullable
        java.lang.Integer code) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMsg() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer getCode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.evapharma.queueingsystem.core.models.Exceptions.ErrorResponse copy(@org.jetbrains.annotations.NotNull
        java.lang.String msg, @org.jetbrains.annotations.Nullable
        java.lang.Integer code) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/Exceptions$InternalServerError;", "Lcom/evapharma/queueingsystem/core/models/Exceptions;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class InternalServerError extends com.evapharma.queueingsystem.core.models.Exceptions {
        @org.jetbrains.annotations.NotNull
        public static final com.evapharma.queueingsystem.core.models.Exceptions.InternalServerError INSTANCE = null;
        
        private InternalServerError() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/evapharma/queueingsystem/core/models/Exceptions$Unauthorized;", "Lcom/evapharma/queueingsystem/core/models/Exceptions;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Unauthorized extends com.evapharma.queueingsystem.core.models.Exceptions {
        @org.jetbrains.annotations.NotNull
        public static final com.evapharma.queueingsystem.core.models.Exceptions.Unauthorized INSTANCE = null;
        
        private Unauthorized() {
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