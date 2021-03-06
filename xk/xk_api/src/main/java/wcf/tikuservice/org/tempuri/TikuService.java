package wcf.tikuservice.org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-06-19T19:32:58.808+08:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "TikuService",
                  wsdlLocation = "http://10.0.2.150:40400/Tiku/TikuService.svc?wsdl",
                  targetNamespace = "http://tempuri.org/")
public class TikuService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/", "TikuService");
    public final static QName BasicHttpBindingITikuService = new QName("http://tempuri.org/", "BasicHttpBinding_ITikuService");
    static {
        URL url = null;
        try {
            url = new URL("http://10.0.2.150:40400/Tiku/TikuService.svc?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TikuService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://10.0.2.150:40400/Tiku/TikuService.svc?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TikuService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TikuService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TikuService() {
        super(WSDL_LOCATION, SERVICE);
    }





    /**
     *
     * @return
     *     returns ITikuService
     */
    @WebEndpoint(name = "BasicHttpBinding_ITikuService")
    public ITikuService getBasicHttpBindingITikuService() {
        return super.getPort(BasicHttpBindingITikuService, ITikuService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ITikuService
     */
    @WebEndpoint(name = "BasicHttpBinding_ITikuService")
    public ITikuService getBasicHttpBindingITikuService(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingITikuService, ITikuService.class, features);
    }

}
