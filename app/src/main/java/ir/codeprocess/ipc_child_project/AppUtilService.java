package ir.codeprocess.ipc_child_project;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class AppUtilService {

    Context context;
    public AppUtilService(Context context){
        this.context = context;
    }

    public void startIpc(String packageName, final LauncherListener launcherListener){
        Intent intent = new Intent("ir.codeprocess.ipc_mother_project");
        intent.setPackage(packageName);

        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                launcherListener.onSuccess(IPC_Main_Service.Stub.asInterface(iBinder));
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                launcherListener.onError("Errorrrrr");
            }
        };

        context.bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
    }
}
