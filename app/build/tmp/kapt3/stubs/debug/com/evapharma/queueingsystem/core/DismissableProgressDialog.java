package com.evapharma.queueingsystem.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/evapharma/queueingsystem/core/DismissableProgressDialog;", "", "showLoading", "", "progressDialog", "Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;", "isCancelable", "", "onDismissAction", "Lkotlin/Function0;", "app_debug"})
public abstract interface DismissableProgressDialog {
    
    public abstract void showLoading(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog progressDialog, boolean isCancelable, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissAction);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}