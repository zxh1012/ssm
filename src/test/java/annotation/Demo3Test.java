package annotation;

import com.zking.ssm.annotation.Demo3;
import com.zking.ssm.service.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Demo3Test extends BaseTest {

    @Autowired
    private Demo3 demo3;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void hello() throws Exception {
        String name = "张大锤";
        demo3.hello(name);
        System.out.println("ok");
    }

}