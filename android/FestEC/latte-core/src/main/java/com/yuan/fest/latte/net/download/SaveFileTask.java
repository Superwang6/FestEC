package com.yuan.fest.latte.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.yuan.fest.latte.app.Latte;
import com.yuan.fest.latte.net.callback.IRequest;
import com.yuan.fest.latte.net.callback.ISuccess;
import com.yuan.fest.latte.util.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

public class SaveFileTask extends AsyncTask<Object, Void, File> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest request, ISuccess success) {
        this.REQUEST = request;
        this.SUCCESS = success;
    }

    @Override
    protected File doInBackground(Object... objects) {
        String downloadDir = (String) objects[0];
        String extension = (String) objects[1];
        final ResponseBody body = (ResponseBody) objects[2];
        final InputStream is = body.byteStream();
        final String name = (String) objects[3];
        if(downloadDir == null || downloadDir.equals("")) {
            downloadDir = "down_loads";
        }
        if(extension == null || extension.equals("")) {
            extension = "";
        }
        if(name == null) {
            return FileUtil.writeToDisk(is,downloadDir,extension.toUpperCase(),extension);
        } else {
            return FileUtil.writeToDisk(is,downloadDir,name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if(SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if(REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        autoInstallApk(file);
    }

    /**
     * 自动安装apk
     * @param file
     */
    private void autoInstallApk(File file) {
        if(FileUtil.getExtension(file.getPath()).equals("apk")) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            Latte.getApplication().startActivity(install);

        }
    }
}
