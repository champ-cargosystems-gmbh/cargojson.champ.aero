package aero.champ.cargojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by rscheel on 13.04.2017.
 */
public class TestConvert {

    @Test
    public void test() throws IOException {
        Container c = new Container();
        c.sub.add(new Derived1());
        c.sub.add(new Derived2());
        ObjectMapper om = new ObjectMapper();
        String out = om.writer().writeValueAsString(c);
        System.out.println(out);
        Container d = om.reader().forType(Container.class).readValue(out);
        Assert.assertTrue(d.sub.get(0) instanceof Derived1);
        Assert.assertTrue(d.sub.get(1) instanceof Derived2);
    }
}
