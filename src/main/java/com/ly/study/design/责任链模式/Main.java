package com.ly.study.design.责任链模式;

import com.ly.study.design.责任链模式.loglevel.DebugLogger;
import com.ly.study.design.责任链模式.loglevel.ErrorLogger;
import com.ly.study.design.责任链模式.loglevel.InfoLogger;

/**
 * @author yang.liu
 * @date 2020-04-22
 * @describe
 *
 * 责任链模式是一条链，链上有多个节点，每个节点都有各自的责任。
 * 当有输入时，第一个责任节点看自己能否处理该输入，如果可以就处理。
 * 如果不能就交由下一个责任节点处理。
 * 依次类推，直到最后一个责任节点。
 *
 * 举例：
 *
 * 假设现在有个需求来了，首先是实习生拿到这个需求。
 *
 * 如果实习生能够实现，直接实现。如果不行，他把这个需求交给初级工程师。
 *
 * 如果初级工程师能够实现，直接实现。如果不行，交给中级工程师。
 *
 * 如果中级工程师能够实现，直接实现。如果不行，交给高级工程师。
 *
 * 如果高级工程师能够实现，直接实现。如果不行，交给 CTO。
 *
 * 如果 CTO能够实现，直接实现。如果不行，直接跟产品说，需求不做。
 */
public class Main {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        return infoLogger;
    }

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        //loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        // loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
