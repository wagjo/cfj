// Copyright (C) 2014, Jozef Wagner. All rights reserved.

package uppercaser;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import clojure.lang.RT;
import clojure.lang.Var;
import clojure.lang.Symbol;

public class Main {

    // General purpose Interop stuff
    // This can be put into separate class or library

    final static Var REQUIRE = Var.intern(RT.CLOJURE_NS, Symbol.intern("require"));

    public static Var var(String nsName, String fnName) {
        Symbol ns = Symbol.intern(null, nsName);
        Symbol fn = Symbol.intern(null, fnName);
        REQUIRE.invoke(ns);
        return Var.intern(ns, fn);
    }

    public static Object invoke(Var fnVar, Object... args) {
        return fnVar.applyTo(RT.seq(args));
    }

    public static Object call(String nsName, String fnName, Object... args) {
        Symbol ns = Symbol.intern(null, nsName);
        Symbol fn = Symbol.intern(null, fnName);
        REQUIRE.invoke(ns);
        return Var.intern(ns, fn).applyTo(RT.seq(args));
    }

    // uppercaser specific interop

    final static Var uppercaseMapVar = var("cfj.uppercaser", "uppercase-map");

    public static void main(String [] args) {
        Map m = new HashMap();
        m.put("keep me intact", "  make me bigger  ");
        m.put(2, 3);
        
        Map um = (Map) invoke(uppercaseMapVar, m);
        System.out.println(um);

        um = (Map) invoke(uppercaseMapVar, m, true);
        System.out.println(um);

        // another way to call

        um = (Map) call("cfj.uppercaser", "uppercase-map", m);
        System.out.println(um);

    }

}
