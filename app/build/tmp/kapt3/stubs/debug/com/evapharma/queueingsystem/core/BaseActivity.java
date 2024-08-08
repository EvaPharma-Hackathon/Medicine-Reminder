package com.evapharma.queueingsystem.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\b\u0010#\u001a\u00020\u001cH\u0016J\r\u0010$\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000bJ\b\u0010%\u001a\u00020\u001cH&J\b\u0010&\u001a\u00020\u001cH&J\u0012\u0010\'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001cH\u0014J\u000e\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020!J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020!H\u0016J\u0006\u00102\u001a\u00020\u001cJ\b\u00103\u001a\u00020\u001cH\u0016J+\u00103\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u00020/2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000106H\u0096\u0001J\u0010\u00107\u001a\u00020\u001c2\u0006\u00101\u001a\u00020!H\u0016R\u001c\u0010\t\u001a\u00028\u0000X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00028\u0001X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u00068"}, d2 = {"Lcom/evapharma/queueingsystem/core/BaseActivity;", "V", "Landroidx/viewbinding/ViewBinding;", "VM", "Lcom/evapharma/queueingsystem/core/BaseViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/evapharma/queueingsystem/core/BaseView;", "Lcom/evapharma/queueingsystem/core/DismissableProgressDialog;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "progressDialog", "Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;", "getProgressDialog", "()Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;", "setProgressDialog", "(Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;)V", "viewModel", "getViewModel", "()Lcom/evapharma/queueingsystem/core/BaseViewModel;", "setViewModel", "(Lcom/evapharma/queueingsystem/core/BaseViewModel;)V", "Lcom/evapharma/queueingsystem/core/BaseViewModel;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "firebaseLogScreen", "screenClassName", "", "hideKeyboard", "hideLoading", "initBinding", "initViewModel", "onActivityCreated", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "error", "Lcom/evapharma/queueingsystem/core/models/ErrorResponse;", "onResume", "returnError", "", "showErrorMsg", "msg", "showKeyboard", "showLoading", "isCancelable", "onDismissAction", "Lkotlin/Function0;", "showSuccessMsg", "app_debug"})
public abstract class BaseActivity<V extends androidx.viewbinding.ViewBinding, VM extends com.evapharma.queueingsystem.core.BaseViewModel> extends androidx.appcompat.app.AppCompatActivity implements com.evapharma.queueingsystem.core.BaseView, com.evapharma.queueingsystem.core.DismissableProgressDialog {
    public V binding;
    public VM viewModel;
    @org.jetbrains.annotations.Nullable
    private com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog progressDialog;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public V getBinding() {
        return null;
    }
    
    public void setBinding(@org.jetbrains.annotations.NotNull
    V p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public VM getViewModel() {
        return null;
    }
    
    public void setViewModel(@org.jetbrains.annotations.NotNull
    VM p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog getProgressDialog() {
        return null;
    }
    
    public final void setProgressDialog(@org.jetbrains.annotations.Nullable
    com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract V initBinding();
    
    public abstract void initViewModel();
    
    public abstract void onActivityCreated();
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    public void onError(@org.jetbrains.annotations.Nullable
    com.evapharma.queueingsystem.core.models.ErrorResponse error) {
    }
    
    @java.lang.Override
    public void showLoading() {
    }
    
    @java.lang.Override
    public void hideLoading() {
    }
    
    @java.lang.Override
    public void showSuccessMsg(@org.jetbrains.annotations.NotNull
    java.lang.String msg) {
    }
    
    @java.lang.Override
    public void showErrorMsg(@org.jetbrains.annotations.NotNull
    java.lang.String msg) {
    }
    
    private final void firebaseLogScreen(java.lang.String screenClassName) {
    }
    
    public final boolean returnError(@org.jetbrains.annotations.NotNull
    java.lang.String error) {
        return false;
    }
    
    public final void showKeyboard() {
    }
    
    public final void hideKeyboard() {
    }
    
    @java.lang.Override
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull
    android.content.Context newBase) {
    }
    
    @java.lang.Override
    public void showLoading(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog progressDialog, boolean isCancelable, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissAction) {
    }
}