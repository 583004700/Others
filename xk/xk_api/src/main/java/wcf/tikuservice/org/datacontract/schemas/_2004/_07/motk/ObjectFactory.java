
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.motk package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SimpleTree_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "SimpleTree");
    private final static QName _ArrayOfSimpleTreeNode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "ArrayOfSimpleTreeNode");
    private final static QName _SimpleTreeNode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "SimpleTreeNode");
    private final static QName _SimpleTreeNodeChildren_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "Children");
    private final static QName _SimpleTreeNodeEncodeParentPointId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "EncodeParentPointId");
    private final static QName _SimpleTreeNodeEncodePointId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "EncodePointId");
    private final static QName _SimpleTreeNodeNodeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "NodeName");
    private final static QName _SimpleTreeRoots_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model", "Roots");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.motk
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleTree }
     * 
     */
    public SimpleTree createSimpleTree() {
        return new SimpleTree();
    }

    /**
     * Create an instance of {@link ArrayOfSimpleTreeNode }
     * 
     */
    public ArrayOfSimpleTreeNode createArrayOfSimpleTreeNode() {
        return new ArrayOfSimpleTreeNode();
    }

    /**
     * Create an instance of {@link SimpleTreeNode }
     * 
     */
    public SimpleTreeNode createSimpleTreeNode() {
        return new SimpleTreeNode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "SimpleTree")
    public JAXBElement<SimpleTree> createSimpleTree(SimpleTree value) {
        return new JAXBElement<SimpleTree>(_SimpleTree_QNAME, SimpleTree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "ArrayOfSimpleTreeNode")
    public JAXBElement<ArrayOfSimpleTreeNode> createArrayOfSimpleTreeNode(ArrayOfSimpleTreeNode value) {
        return new JAXBElement<ArrayOfSimpleTreeNode>(_ArrayOfSimpleTreeNode_QNAME, ArrayOfSimpleTreeNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTreeNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "SimpleTreeNode")
    public JAXBElement<SimpleTreeNode> createSimpleTreeNode(SimpleTreeNode value) {
        return new JAXBElement<SimpleTreeNode>(_SimpleTreeNode_QNAME, SimpleTreeNode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "Children", scope = SimpleTreeNode.class)
    public JAXBElement<ArrayOfSimpleTreeNode> createSimpleTreeNodeChildren(ArrayOfSimpleTreeNode value) {
        return new JAXBElement<ArrayOfSimpleTreeNode>(_SimpleTreeNodeChildren_QNAME, ArrayOfSimpleTreeNode.class, SimpleTreeNode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "EncodeParentPointId", scope = SimpleTreeNode.class)
    public JAXBElement<String> createSimpleTreeNodeEncodeParentPointId(String value) {
        return new JAXBElement<String>(_SimpleTreeNodeEncodeParentPointId_QNAME, String.class, SimpleTreeNode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "EncodePointId", scope = SimpleTreeNode.class)
    public JAXBElement<String> createSimpleTreeNodeEncodePointId(String value) {
        return new JAXBElement<String>(_SimpleTreeNodeEncodePointId_QNAME, String.class, SimpleTreeNode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "NodeName", scope = SimpleTreeNode.class)
    public JAXBElement<String> createSimpleTreeNodeNodeName(String value) {
        return new JAXBElement<String>(_SimpleTreeNodeNodeName_QNAME, String.class, SimpleTreeNode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSimpleTreeNode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model", name = "Roots", scope = SimpleTree.class)
    public JAXBElement<ArrayOfSimpleTreeNode> createSimpleTreeRoots(ArrayOfSimpleTreeNode value) {
        return new JAXBElement<ArrayOfSimpleTreeNode>(_SimpleTreeRoots_QNAME, ArrayOfSimpleTreeNode.class, SimpleTree.class, value);
    }

}
