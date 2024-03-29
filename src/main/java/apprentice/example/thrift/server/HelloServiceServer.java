package apprentice.example.thrift.server;

import apprentice.example.thrift.api.Hello;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by huangshitao on 2015/6/7.
 */
public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(7911);
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());

            TThreadPoolServer.Args threadPoolServerArgs = new TThreadPoolServer.Args(serverTransport);
            threadPoolServerArgs.processor(processor);
            threadPoolServerArgs.protocolFactory(proFactory);

            TServer server = new TThreadPoolServer(threadPoolServerArgs);
            System.out.println("Start server on port 7911...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
