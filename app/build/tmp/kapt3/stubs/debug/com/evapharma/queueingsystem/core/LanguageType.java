package com.evapharma.queueingsystem.core;

@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/evapharma/queueingsystem/core/LanguageType;", "", "Companion", "app_debug"})
@androidx.annotation.StringDef(value = {"en", "ar"})
public abstract @interface LanguageType {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ENGLISH = "en";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ARABIC = "ar";
    @org.jetbrains.annotations.NotNull
    public static final com.evapharma.queueingsystem.core.LanguageType.Companion Companion = null;
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/evapharma/queueingsystem/core/LanguageType$Companion;", "", "()V", "ARABIC", "", "ENGLISH", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ENGLISH = "en";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String ARABIC = "ar";
        
        private Companion() {
            super();
        }
    }
}