package abstracts;

import java.io.IOException;

public interface ConsoleInterface {
    String ask(String msg) throws IOException;

    void tell(String msg);

    void close() throws IOException;
}
