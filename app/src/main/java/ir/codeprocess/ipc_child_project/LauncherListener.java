package ir.codeprocess.ipc_child_project;

public interface LauncherListener {

    public void onSuccess(IPC_Main_Service stub);
    public void onError(String error);

}
