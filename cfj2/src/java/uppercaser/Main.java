// Copyright (C) 2014, Jozef Wagner. All rights reserved.

package uppercaser;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import cfj.uppercaser;

public class Main {

    public static void main(String [] args) {
        Map m = new HashMap();
        m.put("keep me intact", "  make me bigger  ");
        m.put(2, 3);
        uppercaser u = new uppercaser(true);
        Map um = u.uppercaseMap(m);
        System.out.println(um);

        u = new uppercaser(false);
        um = u.uppercaseMap(m);
        System.out.println(um);
    }

}
