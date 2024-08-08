package com.evapharma.queueingsystem.core;

/**
 * Interface definition of the Result that will be reduced to [ViewState]
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/evapharma/queueingsystem/core/Result;", "VS", "Lcom/evapharma/queueingsystem/core/ViewState;", "", "reduce", "defaultState", "oldState", "(Lcom/evapharma/queueingsystem/core/ViewState;Lcom/evapharma/queueingsystem/core/ViewState;)Lcom/evapharma/queueingsystem/core/ViewState;", "app_debug"})
public abstract interface Result<VS extends com.evapharma.queueingsystem.core.ViewState> {
    
    @org.jetbrains.annotations.NotNull
    public abstract VS reduce(@org.jetbrains.annotations.NotNull
    VS defaultState, @org.jetbrains.annotations.NotNull
    VS oldState);
}