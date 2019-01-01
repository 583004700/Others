package wcf.wechataccessservice.org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-29T14:43:19.205+08:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "WeChatAccessService",
                  wsdlLocation = "http://tr:6666/WeChatAccessService.svc?wsdl",
                  targetNamespace = "http://tempuri.org/")
public class WeChatAccessService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/", "WeChatAccessService");
    public final static QName BasicHttpBindingIWeChatAccessService = new QName("http://tempuri.org/", "BasicHttpBinding_IWeChatAccessService");
    static {
        URL url = null;
        try {
            url = new URL("http://tr:6666/WeChatAccessService.svc?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WeChatAccessService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://tr:6666/WeChatAccessService.svc?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WeChatAccessService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WeChatAccessService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeChatAccessService() {
        super(WSDL_LOCATION, SERVICE);
    }





    /**
     *
     * @return
     *     returns IWeChatAccessService
     */
    @WebEndpoint(name = "BasicHttpBinding_IWeChatAccessService")
    public IWeChatAccessService getBasicHttpBindingIWeChatAccessService() {
        return super.getPort(BasicHttpBindingIWeChatAccessService, IWeChatAccessService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWeChatAccessService
     */
    @WebEndpoint(name = "BasicHttpBinding_IWeChatAccessService")
    public IWeChatAccessService getBasicHttpBindingIWeChatAccessService(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIWeChatAccessService, IWeChatAccessService.class, features);
    }

}