package ir.codeprocess.ipc_mother_project;

import ir.codeprocess.ipc_mother_project.IPC_Request_CallBack;

interface IPC_Main_Service {
    void newService();
    void accept(IPC_Request_CallBack request);
}
