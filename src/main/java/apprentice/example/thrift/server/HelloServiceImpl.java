package apprentice.example.thrift.server;

import apprentice.example.thrift.api.Hello;
import org.apache.thrift.TException;

/**
 * Created by huangshitao on 2015/6/7.
 */
public class HelloServiceImpl implements Hello.Iface {
    public String helloString(String para) throws TException {
        return "Hi there! ";
    }

    public int helloInt(int para) throws TException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1000;
    }

    public boolean helloBoolean(boolean para) throws TException {
        return !para;
    }

    public void helloVoid() throws TException {
        System.out.println("Hello void. ");
    }

    public String helloNull() throws TException {
        return null;
    }
}
