package com.evapharma.queueingsystem.core;

/**
 * Base class for all view models that follow the MVI architecture
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00050\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ+\u0010\u0019\u001a\u00020\u001a2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u00020\u001cH\u0002J\u0013\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\"J\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$2\u0006\u0010!\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020\u001aH\u0014J\u0015\u0010(\u001a\u00028\u00022\u0006\u0010)\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010*R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\nX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00028\u0002X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006+"}, d2 = {"Lcom/evapharma/queueingsystem/core/MVIBaseViewModel;", "A", "Lcom/evapharma/queueingsystem/core/Action;", "R", "Lcom/evapharma/queueingsystem/core/Result;", "VS", "Lcom/evapharma/queueingsystem/core/ViewState;", "Lcom/evapharma/queueingsystem/core/BaseViewModel;", "()V", "_viewStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get_viewStates$annotations", "actionsChannel", "Lkotlinx/coroutines/channels/Channel;", "defaultViewState", "getDefaultViewState", "()Lcom/evapharma/queueingsystem/core/ViewState;", "viewEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "getViewEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "viewStates", "Lkotlinx/coroutines/flow/StateFlow;", "getViewStates", "()Lkotlinx/coroutines/flow/StateFlow;", "emitState", "", "stateReducer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "oldState", "executeAction", "action", "(Lcom/evapharma/queueingsystem/core/Action;)V", "handleAction", "Lkotlinx/coroutines/flow/Flow;", "(Lcom/evapharma/queueingsystem/core/Action;)Lkotlinx/coroutines/flow/Flow;", "observeOnActionsChannel", "onCleared", "reduce", "result", "(Lcom/evapharma/queueingsystem/core/Result;)Lcom/evapharma/queueingsystem/core/ViewState;", "app_debug"})
public abstract class MVIBaseViewModel<A extends com.evapharma.queueingsystem.core.Action, R extends com.evapharma.queueingsystem.core.Result<VS>, VS extends com.evapharma.queueingsystem.core.ViewState> extends com.evapharma.queueingsystem.core.BaseViewModel {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.channels.Channel<A> actionsChannel = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<VS> _viewStates = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<VS> viewStates = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<VS> viewEvents = null;
    
    public MVIBaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract VS getDefaultViewState();
    
    @kotlin.Suppress(names = {"LeakingThis"})
    @java.lang.Deprecated
    private static void get_viewStates$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<VS> getViewStates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<VS> getViewEvents() {
        return null;
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    private final void observeOnActionsChannel() {
    }
    
    @kotlin.jvm.Synchronized
    private final synchronized void emitState(kotlin.jvm.functions.Function1<? super VS, ? extends VS> stateReducer) {
    }
    
    public final void executeAction(@org.jetbrains.annotations.NotNull
    A action) {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<R> handleAction(@org.jetbrains.annotations.NotNull
    A action);
    
    @org.jetbrains.annotations.NotNull
    public VS reduce(@org.jetbrains.annotations.NotNull
    R result) {
        return null;
    }
}