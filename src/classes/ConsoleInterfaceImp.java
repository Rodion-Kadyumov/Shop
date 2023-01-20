package classes;

import abstracts.ConsoleInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInterfaceImp implements ConsoleInterface {

    BufferedReader bufferedReader;

    public ConsoleInterfaceImp() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String ask(String msg) throws IOException {
        tell(msg);
        System.out.print(">> ");
        return bufferedReader.readLine();
    }

    @Override
    public void tell(String msg) {
        System.out.println(msg);
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}