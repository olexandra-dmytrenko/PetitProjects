package exceptions;


import java.io.InterruptedIOException;
import java.net.SocketException;

/**
 * Created by Oleksandra_Dmytrenko on 11/11/2016.
 */
public class ExceptionsScope {

    class Parent {
        public void m1() throws Exception {
            throw new Exception();
        }

        public void m2() throws InterruptedIOException, SocketException{
            if (false) {
                if (true)
                    throw new InterruptedIOException();
                throw new SocketException();
            }
        }
    }

    class Child extends Parent {
        /*
        The method can throw less exceptions
         */
        @Override
        public void m1() {
        }

        /*
        The method can't throw more exceptions
         */
        @Override
        public void m2() //throws IOException
        {
//            super.m2();
        }
    }
}

