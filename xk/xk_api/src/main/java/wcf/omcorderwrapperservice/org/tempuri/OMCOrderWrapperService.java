package wcf.omcorderwrapperservice.org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-18T10:58:10.105+08:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "OMCOrderWrapperService",
                  wsdlLocation = "http://10.0.3.72:17001/Api/OMCOrderWrapperService.svc?wsdl",
                  targetNamespace = "http://tempuri.org/")
public class OMCOrderWrapperService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/", "OMCOrderWrapperService");
    public final static QName WSHttpBindingIOMCOrderWrapperService = new QName("http://tempuri.org/", "WSHttpBinding_IOMCOrderWrapperService");
    static {
        URL url = null;
        try {
            url = new URL("http://10.0.3.72:17001/Api/OMCOrderWrapperService.svc?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(OMCOrderWrapperService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://10.0.3.72:17001/Api/OMCOrderWrapperService.svc?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public OMCOrderWrapperService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OMCOrderWrapperService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OMCOrderWrapperService() {
        super(WSDL_LOCATION, SERVICE);
    }





    /**
     *
     * @return
     *     returns IOMCOrderWrapperService
     */
    @WebEndpoint(name = "WSHttpBinding_IOMCOrderWrapperService")
    public IOMCOrderWrapperService getWSHttpBindingIOMCOrderWrapperService() {
        return super.getPort(WSHttpBindingIOMCOrderWrapperService, IOMCOrderWrapperService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IOMCOrderWrapperService
     */
    @WebEndpoint(name = "WSHttpBinding_IOMCOrderWrapperService")
    public IOMCOrderWrapperService getWSHttpBindingIOMCOrderWrapperService(WebServiceFeature... features) {
        return super.getPort(WSHttpBindingIOMCOrderWrapperService, IOMCOrderWrapperService.class, features);
    }

}