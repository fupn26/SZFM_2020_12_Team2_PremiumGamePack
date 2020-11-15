package puckg.controller;

import central.util.guice.PersistenceModule;
import com.gluonhq.ignite.guice.GuiceContext;
import com.google.inject.AbstractModule;

import java.util.List;

public class StartController {

    private GuiceContext context = new GuiceContext(this, () -> List.of(
            new AbstractModule() {}
    ));
}
