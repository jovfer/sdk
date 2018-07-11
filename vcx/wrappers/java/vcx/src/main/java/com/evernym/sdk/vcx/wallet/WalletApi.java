package com.evernym.sdk.vcx.wallet;

import com.evernym.sdk.vcx.LibVcx;
import com.evernym.sdk.vcx.ParamGuard;
import com.evernym.sdk.vcx.VcxException;
import com.evernym.sdk.vcx.VcxJava;
import com.sun.jna.Callback;

import java9.util.concurrent.CompletableFuture;

public class WalletApi extends VcxJava.API {

    private WalletApi(){}

    private static Callback vcxExportWalletCB = new Callback() {
        public void callback(int command_handle, int err, int export_handle){
            CompletableFuture<Integer> future = (CompletableFuture<Integer>) removeFuture(command_handle);
            if(!checkCallback(future,err)) return;
            Integer result = export_handle;
            future.complete(result);
        }
    };

    public static CompletableFuture<Integer> exportWallet(
            String exportPath,
            String encryptionKey
    ) throws VcxException {
        ParamGuard.notNull(exportPath, "exportPath");
        ParamGuard.notNull(encryptionKey, "encryptionKey");
        CompletableFuture<Integer> future = new CompletableFuture<Integer>();
        int commandHandle = addFuture(future);

        int result = LibVcx.api.vcx_wallet_export(commandHandle, exportPath, encryptionKey, vcxExportWalletCB);
        checkResult(result);

        return future;
    }

    private static Callback vcxImportWalletCB = new Callback() {
        public void callback(int command_handle, int err, int import_handle){
            CompletableFuture<Integer> future = (CompletableFuture<Integer>) removeFuture(command_handle);
            if(!checkCallback(future,err)) return;
            Integer result = import_handle;
            future.complete(result);
        }
    };

    public static CompletableFuture<Integer> importWallet(
            String importPath,
            String encryptionKey
    ) throws VcxException {
        ParamGuard.notNull(importPath, "importPath");
        ParamGuard.notNull(encryptionKey, "encryptionKey");
        CompletableFuture<Integer> future = new CompletableFuture<Integer>();
        int commandHandle = addFuture(future);

        int result = LibVcx.api.vcx_wallet_import(commandHandle, importPath, encryptionKey, vcxImportWalletCB);
        checkResult(result);

        return future;
    }

    private static Callback vcxAddRecordWalletCB = new Callback() {
        public void callback(int command_handle, int err, int wallet_handle){
            CompletableFuture<Integer> future = (CompletableFuture<Integer>) removeFuture(command_handle);
            if(!checkCallback(future,err)) return;
            Integer result = wallet_handle;
            future.complete(result);
        }
    };

    public static CompletableFuture<Integer> addRecordWallet(
            String recordType,
            String recordId,
            String recordValue
    ) throws VcxException {
        ParamGuard.notNull(recordType, "recordType");
        ParamGuard.notNull(recordId, "recordId");
        ParamGuard.notNull(recordValue, "recordValue");
        CompletableFuture<Integer> future = new CompletableFuture<Integer>();
        int commandHandle = addFuture(future);
        String recordTag = "{}";

        int result = LibVcx.api.vcx_wallet_add_record( commandHandle, recordType, recordId, recordValue, recordTag, vcxAddRecordWalletCB);
        checkResult(result);

        return future;
    }

    private static Callback vcxDeleteRecordWalletCB = new Callback() {
        public void callback(int command_handle, int err, int wallet_handle){
            CompletableFuture<Integer> future = (CompletableFuture<Integer>) removeFuture(command_handle);
            if(!checkCallback(future,err)) return;
            Integer result = wallet_handle;
            future.complete(result);
        }
    };

    public static CompletableFuture<Integer> deleteRecordWallet(
            String recordType,
            String recordId
    ) throws VcxException {
        ParamGuard.notNull(recordType, "recordType");
        ParamGuard.notNull(recordId, "recordId");
        CompletableFuture<Integer> future = new CompletableFuture<Integer>();
        int commandHandle = addFuture(future);

        int result = LibVcx.api.vcx_wallet_delete_record( commandHandle, recordType, recordId, vcxDeleteRecordWalletCB);
        checkResult(result);

        return future;
    }

    private static Callback vcxGetRecordWalletCB = new Callback() {
        public void callback(int command_handle, int err, String wallet_value){
            CompletableFuture<Integer> future = (CompletableFuture<Integer>) removeFuture(command_handle);
            if(!checkCallback(future,err)) return;
            String result = wallet_value;
            future.complete(result);
        }
    };

    public static CompletableFuture<Integer> getRecordWallet(
            String recordType,
            String recordId,
            String recordValue
    ) throws VcxException {
        ParamGuard.notNull(recordType, "recordType");
        ParamGuard.notNull(recordId, "recordId");
        ParamGuard.notNull(recordValue, "recordValue");
        CompletableFuture<Integer> future = new CompletableFuture<Integer>();
        int commandHandle = addFuture(future);
        String recordTag = "{}";

        int result = LibVcx.api.vcx_wallet_get_record( commandHandle, recordType, recordId, recordTag, vcxGetRecordWalletCB);
        checkResult(result);

        return future;
    }

}