package com.ly.study.design.命令模式;

public class CommandImpl extends Command{
    private Receiver receiver;
    CommandImpl() {
        receiver = new Receiver();
    }
    public void execute() {
        receiver.action();
    }
}
