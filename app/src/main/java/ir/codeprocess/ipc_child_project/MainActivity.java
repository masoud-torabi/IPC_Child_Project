package ir.codeprocess.ipc_child_project;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppUtilService appUtilService = new AppUtilService(getApplicationContext());

        appUtilService.startIpc("ir.codeprocess", new LauncherListener() {
            @Override
            public void onSuccess(IPC_Main_Service stub) {
                try {
                    stub.newService();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {
                String myError = error;
            }
        });
    }
}
