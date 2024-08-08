package com.evapharma.queueingsystem.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dJ\b\u0010\"\u001a\u00020\u001dH\u0016J\r\u0010#\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\rJ\u0006\u0010$\u001a\u00020\u001dJ\b\u0010%\u001a\u00020\u001dH&J&\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\u0012\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u001dH&J\b\u00104\u001a\u00020\u001dH\u0016J\b\u00105\u001a\u00020\u001dH\u0004J\u0006\u00106\u001a\u00020\u001dJ\u000e\u00107\u001a\u0002082\u0006\u00101\u001a\u00020\u001fJ\u0010\u00109\u001a\u00020\u001d2\u0006\u00101\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001d2\u0006\u00101\u001a\u00020:H\u0016J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001fH\u0016J\u0006\u0010>\u001a\u00020\u001dJ\b\u0010?\u001a\u00020\u001dH\u0016J+\u0010?\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010@\u001a\u0002082\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010BH\u0096\u0001J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u001fH\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00028\u0001X\u0096.\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006D"}, d2 = {"Lcom/evapharma/queueingsystem/core/BaseFragment;", "V", "Landroidx/viewbinding/ViewBinding;", "VM", "Lcom/evapharma/queueingsystem/core/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "Lcom/evapharma/queueingsystem/core/BaseView;", "Lcom/evapharma/queueingsystem/core/DismissableProgressDialog;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "progressDialog", "Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;", "getProgressDialog", "()Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;", "setProgressDialog", "(Lcom/evapharma/queueingsystem/core/OptionalDismissableProgressDialog;)V", "sessionExpiredDialog", "Lcom/evapharma/queueingsystem/core/dialogs/SessionExpiredDialog;", "viewModel", "getViewModel", "()Lcom/evapharma/queueingsystem/core/BaseViewModel;", "setViewModel", "(Lcom/evapharma/queueingsystem/core/BaseViewModel;)V", "Lcom/evapharma/queueingsystem/core/BaseViewModel;", "firebaseLogScreen", "", "screenClassName", "", "handleExceptions", "hideKeyboard", "hideLoading", "initBinding", "initProgressDialog", "initViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onError", "error", "Lcom/evapharma/queueingsystem/core/models/ErrorResponse;", "onFragmentCreated", "onResume", "onSessionExpired", "resetBinding", "returnError", "", "showCustomError", "Lcom/evapharma/queueingsystem/core/models/Exceptions$ErrorResponse;", "showError", "showErrorMsg", "msg", "showKeyboard", "showLoading", "isCancelable", "onDismissAction", "Lkotlin/Function0;", "showSuccessMsg", "app_debug"})
public abstract class BaseFragment<V extends androidx.viewbinding.ViewBinding, VM extends com.evapharma.queueingsystem.core.BaseViewModel> extends androidx.fragment.app.Fragment implements com.evapharma.queueingsystem.core.BaseView, com.evapharma.queueingsystem.core.DismissableProgressDialog {
    @org.jetbrains.annotations.Nullable
    private V _binding;
    public VM viewModel;
    @org.jetbrains.annotations.Nullable
    private com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog progressDialog;
    private com.evapharma.queueingsystem.core.dialogs.SessionExpiredDialog sessionExpiredDialog;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final V getBinding() {
        return null;
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
    
    public abstract void onFragmentCreated();
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void handleExceptions() {
    }
    
    public void showCustomError(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.models.Exceptions.ErrorResponse error) {
    }
    
    public void showError(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.models.Exceptions.ErrorResponse error) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onError(@org.jetbrains.annotations.Nullable
    com.evapharma.queueingsystem.core.models.ErrorResponse error) {
    }
    
    public final void initProgressDialog() {
    }
    
    @java.lang.Override
    public void showLoading() {
    }
    
    @java.lang.Override
    public void hideLoading() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    public final void firebaseLogScreen(@org.jetbrains.annotations.NotNull
    java.lang.String screenClassName) {
    }
    
    public final boolean returnError(@org.jetbrains.annotations.NotNull
    java.lang.String error) {
        return false;
    }
    
    @java.lang.Override
    public void showSuccessMsg(@org.jetbrains.annotations.NotNull
    java.lang.String msg) {
    }
    
    @java.lang.Override
    public void showErrorMsg(@org.jetbrains.annotations.NotNull
    java.lang.String msg) {
    }
    
    public final void showKeyboard() {
    }
    
    public final void hideKeyboard() {
    }
    
    protected final void onSessionExpired() {
    }
    
    public final void resetBinding() {
    }
    
    @java.lang.Override
    public void showLoading(@org.jetbrains.annotations.NotNull
    com.evapharma.queueingsystem.core.OptionalDismissableProgressDialog progressDialog, boolean isCancelable, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissAction) {
    }
}