package com.evapharma.queueingsystem.core.utils;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/evapharma/queueingsystem/core/utils/StringLocale;", "", "()V", "appContextProvider", "Lcom/evapharma/queueingsystem/core/utils/AppContextProvider;", "getAppContextProvider", "()Lcom/evapharma/queueingsystem/core/utils/AppContextProvider;", "setAppContextProvider", "(Lcom/evapharma/queueingsystem/core/utils/AppContextProvider;)V", "getLanguage", "", "localize", "resId", "", "Companion", "app_debug"})
public final class StringLocale {
    @javax.inject.Inject
    public com.evapharma.queueingsystem.core.utils.AppContextProvider appContextProvider;
    public static com.evapharma.queueingsystem.core.utils.StringLocale instance;
    @org.jetbrains.annotations.NotNull
    public static final com.evapharma.queueingsystem.core.utils.StringLocale.Companion Companion = null;
    
    @javax.inject.Inject
    public StringLocale() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.evapharma.queueingsystem.core.utils.AppContextProvider getAppContextProvider() {
        return null;
    }
    
    public final void setAppContextProvider(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.utils.AppContextProvider p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String localize(@androidx.annotation.StringRes
    int resId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/evapharma/queueingsystem/core/utils/StringLocale$Companion;", "", "()V", "instance", "Lcom/evapharma/queueingsystem/core/utils/StringLocale;", "getInstance", "()Lcom/evapharma/queueingsystem/core/utils/StringLocale;", "setInstance", "(Lcom/evapharma/queueingsystem/core/utils/StringLocale;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.evapharma.queueingsystem.core.utils.StringLocale getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull
        com.evapharma.queueingsystem.core.utils.StringLocale p0) {
        }
    }
}