import model.Pessoa;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.File;

public class BeanReaderExample {
    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("src/main/resources/mapping.xml");

        // use a StreamFactory to create a BeanReader
        BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/pessoa.csv"));
        Pessoa pessoa;
        while ((pessoa = (Pessoa) in.read()) != null) {
            // process the employee...
        }
        in.close();
    }
}