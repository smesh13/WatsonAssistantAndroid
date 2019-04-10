package com.example.def.entity;

public class MessageOutputDebug {
    Object[] nodes_visited;

    public Object[] getNodes_visited() {
        return nodes_visited;
    }

    public void setNodes_visited(Object[] nodes_visited) {
        this.nodes_visited = nodes_visited;
    }

    public DialogLogMessage[] getLog_messages() {
        return log_messages;
    }

    public void setLog_messages(DialogLogMessage[] log_messages) {
        this.log_messages = log_messages;
    }

    public boolean isBranch_exited() {
        return branch_exited;
    }

    public void setBranch_exited(boolean branch_exited) {
        this.branch_exited = branch_exited;
    }

    public String getBranch_exited_reason() {
        return branch_exited_reason;
    }

    public void setBranch_exited_reason(String branch_exited_reason) {
        this.branch_exited_reason = branch_exited_reason;
    }

    DialogLogMessage[] log_messages;
    boolean branch_exited;
    String branch_exited_reason;
}
