package aero.champ.cargojson.flightstatus;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CreateCopyCode {


    public static void main(String[] args) {


    }

    public void copyCode(Class<?> clazz) {
        for (Field f : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers()))
                continue;
            System.out.println("ret."+f.getName()+" = this."+f.getName());
        }


    }
}
