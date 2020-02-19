import model.Pessoa;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import java.io.File;
import java.util.Date;

public class BeanWriterExample {
    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("src/main/resources/mapping.xml");

        Pessoa pessoa = new Pessoa();
        pessoa.setFirstName("Jennifer");
        pessoa.setLastName("Jones");
        pessoa.setTitle("Marketing");
        pessoa.setSalary("60000");
        pessoa.setHireDate(new Date());

        // use a StreamFactory to create a BeanWriter
        BeanWriter out = factory.createWriter("employeeFile", new File("src/main/resources/pessoa.csv"));
        // write an pessoa object directly to the BeanWriter
        out.write(pessoa);
        out.flush();
        out.close();
    }
}