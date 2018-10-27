
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.motk_model_exam package. 
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

    private final static QName _AutoZujuanCreationRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", "AutoZujuanCreationRequest");
    private final static QName _ArrayOfZujuanBasketQuestionCategoryStatisticsView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "ArrayOfZujuanBasketQuestionCategoryStatisticsView");
    private final static QName _ZujuanBasketQuestionCategoryStatisticsView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "ZujuanBasketQuestionCategoryStatisticsView");
    private final static QName _SelectQuestionScoreView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "SelectQuestionScoreView");
    private final static QName _ArrayOfQuestionCategoryScoreView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "ArrayOfQuestionCategoryScoreView");
    private final static QName _QuestionCategoryScoreView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "QuestionCategoryScoreView");
    private final static QName _QuestionCategoryScoreViewCategoryName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "CategoryName");
    private final static QName _SelectQuestionScoreViewBackPageUrl_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "BackPageUrl");
    private final static QName _SelectQuestionScoreViewQuestionCategoryScores_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "QuestionCategoryScores");
    private final static QName _ZujuanBasketQuestionCategoryStatisticsViewQuestionCategoryName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", "QuestionCategoryName");
    private final static QName _AutoZujuanCreationRequestKnowledgePointIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", "KnowledgePointIds");
    private final static QName _AutoZujuanCreationRequestOrganizationName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", "OrganizationName");
    private final static QName _AutoZujuanCreationRequestQuestionCount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", "QuestionCount");
    private final static QName _AutoZujuanCreationRequestSectionIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", "SectionIds");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.motk_model_exam
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AutoZujuanCreationRequest }
     * 
     */
    public AutoZujuanCreationRequest createAutoZujuanCreationRequest() {
        return new AutoZujuanCreationRequest();
    }

    /**
     * Create an instance of {@link ArrayOfZujuanBasketQuestionCategoryStatisticsView }
     * 
     */
    public ArrayOfZujuanBasketQuestionCategoryStatisticsView createArrayOfZujuanBasketQuestionCategoryStatisticsView() {
        return new ArrayOfZujuanBasketQuestionCategoryStatisticsView();
    }

    /**
     * Create an instance of {@link ZujuanBasketQuestionCategoryStatisticsView }
     * 
     */
    public ZujuanBasketQuestionCategoryStatisticsView createZujuanBasketQuestionCategoryStatisticsView() {
        return new ZujuanBasketQuestionCategoryStatisticsView();
    }

    /**
     * Create an instance of {@link SelectQuestionScoreView }
     * 
     */
    public SelectQuestionScoreView createSelectQuestionScoreView() {
        return new SelectQuestionScoreView();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionCategoryScoreView }
     * 
     */
    public ArrayOfQuestionCategoryScoreView createArrayOfQuestionCategoryScoreView() {
        return new ArrayOfQuestionCategoryScoreView();
    }

    /**
     * Create an instance of {@link QuestionCategoryScoreView }
     * 
     */
    public QuestionCategoryScoreView createQuestionCategoryScoreView() {
        return new QuestionCategoryScoreView();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoZujuanCreationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", name = "AutoZujuanCreationRequest")
    public JAXBElement<AutoZujuanCreationRequest> createAutoZujuanCreationRequest(AutoZujuanCreationRequest value) {
        return new JAXBElement<AutoZujuanCreationRequest>(_AutoZujuanCreationRequest_QNAME, AutoZujuanCreationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfZujuanBasketQuestionCategoryStatisticsView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "ArrayOfZujuanBasketQuestionCategoryStatisticsView")
    public JAXBElement<ArrayOfZujuanBasketQuestionCategoryStatisticsView> createArrayOfZujuanBasketQuestionCategoryStatisticsView(ArrayOfZujuanBasketQuestionCategoryStatisticsView value) {
        return new JAXBElement<ArrayOfZujuanBasketQuestionCategoryStatisticsView>(_ArrayOfZujuanBasketQuestionCategoryStatisticsView_QNAME, ArrayOfZujuanBasketQuestionCategoryStatisticsView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZujuanBasketQuestionCategoryStatisticsView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "ZujuanBasketQuestionCategoryStatisticsView")
    public JAXBElement<ZujuanBasketQuestionCategoryStatisticsView> createZujuanBasketQuestionCategoryStatisticsView(ZujuanBasketQuestionCategoryStatisticsView value) {
        return new JAXBElement<ZujuanBasketQuestionCategoryStatisticsView>(_ZujuanBasketQuestionCategoryStatisticsView_QNAME, ZujuanBasketQuestionCategoryStatisticsView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectQuestionScoreView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "SelectQuestionScoreView")
    public JAXBElement<SelectQuestionScoreView> createSelectQuestionScoreView(SelectQuestionScoreView value) {
        return new JAXBElement<SelectQuestionScoreView>(_SelectQuestionScoreView_QNAME, SelectQuestionScoreView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategoryScoreView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "ArrayOfQuestionCategoryScoreView")
    public JAXBElement<ArrayOfQuestionCategoryScoreView> createArrayOfQuestionCategoryScoreView(ArrayOfQuestionCategoryScoreView value) {
        return new JAXBElement<ArrayOfQuestionCategoryScoreView>(_ArrayOfQuestionCategoryScoreView_QNAME, ArrayOfQuestionCategoryScoreView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionCategoryScoreView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "QuestionCategoryScoreView")
    public JAXBElement<QuestionCategoryScoreView> createQuestionCategoryScoreView(QuestionCategoryScoreView value) {
        return new JAXBElement<QuestionCategoryScoreView>(_QuestionCategoryScoreView_QNAME, QuestionCategoryScoreView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "CategoryName", scope = QuestionCategoryScoreView.class)
    public JAXBElement<String> createQuestionCategoryScoreViewCategoryName(String value) {
        return new JAXBElement<String>(_QuestionCategoryScoreViewCategoryName_QNAME, String.class, QuestionCategoryScoreView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "BackPageUrl", scope = SelectQuestionScoreView.class)
    public JAXBElement<String> createSelectQuestionScoreViewBackPageUrl(String value) {
        return new JAXBElement<String>(_SelectQuestionScoreViewBackPageUrl_QNAME, String.class, SelectQuestionScoreView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategoryScoreView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "QuestionCategoryScores", scope = SelectQuestionScoreView.class)
    public JAXBElement<ArrayOfQuestionCategoryScoreView> createSelectQuestionScoreViewQuestionCategoryScores(ArrayOfQuestionCategoryScoreView value) {
        return new JAXBElement<ArrayOfQuestionCategoryScoreView>(_SelectQuestionScoreViewQuestionCategoryScores_QNAME, ArrayOfQuestionCategoryScoreView.class, SelectQuestionScoreView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.View", name = "QuestionCategoryName", scope = ZujuanBasketQuestionCategoryStatisticsView.class)
    public JAXBElement<String> createZujuanBasketQuestionCategoryStatisticsViewQuestionCategoryName(String value) {
        return new JAXBElement<String>(_ZujuanBasketQuestionCategoryStatisticsViewQuestionCategoryName_QNAME, String.class, ZujuanBasketQuestionCategoryStatisticsView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", name = "KnowledgePointIds", scope = AutoZujuanCreationRequest.class)
    public JAXBElement<ArrayOfint> createAutoZujuanCreationRequestKnowledgePointIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_AutoZujuanCreationRequestKnowledgePointIds_QNAME, ArrayOfint.class, AutoZujuanCreationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", name = "OrganizationName", scope = AutoZujuanCreationRequest.class)
    public JAXBElement<String> createAutoZujuanCreationRequestOrganizationName(String value) {
        return new JAXBElement<String>(_AutoZujuanCreationRequestOrganizationName_QNAME, String.class, AutoZujuanCreationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", name = "QuestionCount", scope = AutoZujuanCreationRequest.class)
    public JAXBElement<ArrayOfKeyValueOfintint> createAutoZujuanCreationRequestQuestionCount(ArrayOfKeyValueOfintint value) {
        return new JAXBElement<ArrayOfKeyValueOfintint>(_AutoZujuanCreationRequestQuestionCount_QNAME, ArrayOfKeyValueOfintint.class, AutoZujuanCreationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Exam.Request", name = "SectionIds", scope = AutoZujuanCreationRequest.class)
    public JAXBElement<ArrayOfstring> createAutoZujuanCreationRequestSectionIds(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_AutoZujuanCreationRequestSectionIds_QNAME, ArrayOfstring.class, AutoZujuanCreationRequest.class, value);
    }

}
