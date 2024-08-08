package com.evapharma.queueingsystem.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/evapharma/queueingsystem/core/BaseView;", "", "hideLoading", "", "onError", "error", "Lcom/evapharma/queueingsystem/core/models/ErrorResponse;", "showErrorMsg", "msg", "", "showLoading", "showSuccessMsg", "app_debug"})
public abstract interface BaseView {
    
    public abstract void onError(@org.jetbrains.annotations.Nullable
    com.evapharma.queueingsystem.core.models.ErrorResponse error);
    
    public abstract void showLoading();
    
    public abstract void hideLoading();
    
    public abstract void showSuccessMsg(@org.jetbrains.annotations.NotNull
    java.lang.String msg);
    
    public abstract void showErrorMsg(@org.jetbrains.annotations.NotNull
    java.lang.String msg);
}