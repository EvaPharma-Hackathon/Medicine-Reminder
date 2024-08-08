package com.evapharma.queueingsystem.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 JY\u0010\"\u001a\u00020\u001b*\u00020#2)\b\b\u0010$\u001a#\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0&\u0012\u0006\u0012\u0004\u0018\u00010\'0%\u00a2\u0006\u0002\b(2\u0014\b\u0004\u0010)\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0*H\u0086\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0018\u0010\u0010\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006,"}, d2 = {"Lcom/evapharma/queueingsystem/core/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_errorStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/evapharma/queueingsystem/core/models/Exceptions;", "cityName", "", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "errorLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/evapharma/queueingsystem/core/models/ErrorResponse;", "getErrorLiveData", "()Landroidx/lifecycle/MutableLiveData;", "errorLiveData$delegate", "Lkotlin/Lazy;", "errorStateFlow", "getErrorStateFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "userLoggedInLiveData", "", "getUserLoggedInLiveData", "userLoggedInLiveData$delegate", "emitException", "", "e", "(Lcom/evapharma/queueingsystem/core/models/Exceptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorResponse", "t", "", "handleError", "launchCatching", "Lkotlinx/coroutines/CoroutineScope;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onError", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "app_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableSharedFlow<com.evapharma.queueingsystem.core.models.Exceptions> _errorStateFlow;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.evapharma.queueingsystem.core.models.Exceptions> errorStateFlow = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String cityName;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy userLoggedInLiveData$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy errorLiveData$delegate = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableSharedFlow<com.evapharma.queueingsystem.core.models.Exceptions> getErrorStateFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object emitException(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.models.Exceptions e, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCityName() {
        return null;
    }
    
    public final void setCityName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final void launchCatching(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope $this$launchCatching, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getUserLoggedInLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.evapharma.queueingsystem.core.models.ErrorResponse> getErrorLiveData() {
        return null;
    }
    
    public final void handleError(@org.jetbrains.annotations.NotNull
    java.lang.Throwable t) {
    }
    
    /**
     * this function is used to prevent duplicated code in
     * error handling.
     * for example, look at "handlePromoCodeError" function in
     * "BookingJourneyViewModel"
     */
    @org.jetbrains.annotations.NotNull
    public final com.evapharma.queueingsystem.core.models.ErrorResponse errorResponse(@org.jetbrains.annotations.NotNull
    java.lang.Throwable t) {
        return null;
    }
}