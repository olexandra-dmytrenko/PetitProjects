package java8;

import org.testng.annotations.Test;

import java.util.function.Supplier;

/**
 * Created by Oleksandra_Dmytrenko on 4/7/2017.
 */
public class SupplierException {

    @Test(expectedExceptions = NullPointerException.class)
    public void getExceptionTest(){
        Supplier s = NumberFormatException::new;
        final Object ex = s.get();
        if (ex instanceof NumberFormatException){
            NumberFormatException nfe = (NumberFormatException) ex;
            throw nfe;
        }
    }
}