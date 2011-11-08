package co.imado.controller;

import java.util.logging.Logger;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.MobyletFactory;
import org.mobylet.core.type.SmartPhoneType;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Override
    public Navigation run() throws Exception {
        return forward("index.jsp");
    }
}
