
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfBookVersion;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionOptionGroup;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionSimplifiedFormat;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.KnowledgePoint;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.PublisherBookVersion;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam.SelectQuestionScoreView;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.motk_model_tiku package. 
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

    private final static QName _QuestionListView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionListView");
    private final static QName _ArrayOfQuestionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfQuestionView");
    private final static QName _QuestionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionView");
    private final static QName _ChapterSectionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ChapterSectionView");
    private final static QName _ArrayOfChapterSectionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfChapterSectionView");
    private final static QName _QuestionListCategorieCountView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionListCategorieCountView");
    private final static QName _OneClickTestPaperResultView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "OneClickTestPaperResultView");
    private final static QName _CourseBookVersionListView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "CourseBookVersionListView");
    private final static QName _ArrayOfBookVersionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfBookVersionView");
    private final static QName _BookVersionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "BookVersionView");
    private final static QName _ArrayOfKnowledgePointView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfKnowledgePointView");
    private final static QName _KnowledgePointView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "KnowledgePointView");
    private final static QName _ExamUsageRulerView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ExamUsageRulerView");
    private final static QName _CheckSCPQuestionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "CheckSCPQuestionView");
    private final static QName _SCPQuestionDetailView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "SCPQuestionDetailView");
    private final static QName _ArrayOfSCPQuestionDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfSCPQuestionDetail");
    private final static QName _SCPQuestionDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "SCPQuestionDetail");
    private final static QName _ArrayOfSCPQuestionOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfSCPQuestionOption");
    private final static QName _SCPQuestionOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "SCPQuestionOption");
    private final static QName _ArrayOfQuestionSectionDistributionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfQuestionSectionDistributionView");
    private final static QName _QuestionSectionDistributionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionSectionDistributionView");
    private final static QName _ArrayOfQuestionKnowledgePointDistributionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ArrayOfQuestionKnowledgePointDistributionView");
    private final static QName _QuestionKnowledgePointDistributionView_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionKnowledgePointDistributionView");
    private final static QName _GetCourseMappingIdBySectionIdRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetCourseMappingIdBySectionIdRequest");
    private final static QName _OneClickTestPaperRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "OneClickTestPaperRequest");
    private final static QName _KnowledgePointQuestionRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "KnowledgePointQuestionRequest");
    private final static QName _GetExamUsageRulerViewRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetExamUsageRulerViewRequest");
    private final static QName _GetExamUsageRulerRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetExamUsageRulerRequest");
    private final static QName _GetQuestionsFromCourseMappingAllRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetQuestionsFromCourseMappingAllRequest");
    private final static QName _GetQuestionsFromKnowledgePointsAllRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetQuestionsFromKnowledgePointsAllRequest");
    private final static QName _GetQuestionStatisticsListRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetQuestionStatisticsListRequest");
    private final static QName _GetBookVersionsRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetBookVersionsRequest");
    private final static QName _GetAllQuestionCategoriesRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetAllQuestionCategoriesRequest");
    private final static QName _GetQuestionCategoriesCheckOnlineRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetQuestionCategoriesCheckOnlineRequest");
    private final static QName _GetOnlineQuestionsRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetOnlineQuestionsRequest");
    private final static QName _GetOnlineQuestionsForKnowledgePointRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetOnlineQuestionsForKnowledgePointRequest");
    private final static QName _SCPQuestionRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "SCPQuestionRequest");
    private final static QName _GetQuestionSectionDistributionRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetQuestionSectionDistributionRequest");
    private final static QName _GetQuestionKnowledgePointDistributionRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "GetQuestionKnowledgePointDistributionRequest");
    private final static QName _SCPQuestionOptionQuestionOptionId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionOptionId");
    private final static QName _SCPQuestionOptionQuestionOptionText_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionOptionText");
    private final static QName _SCPQuestionDetailAnalysis_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "Analysis");
    private final static QName _SCPQuestionDetailAnswer_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "Answer");
    private final static QName _SCPQuestionDetailKnowledgePointNames_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "KnowledgePointNames");
    private final static QName _SCPQuestionDetailOptions_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "Options");
    private final static QName _SCPQuestionDetailQuestionContent_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionContent");
    private final static QName _KnowledgePointViewKnowledgePoint_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "KnowledgePoint");
    private final static QName _BookVersionViewBookVersionName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "BookVersionName");
    private final static QName _BookVersionViewPublisherBookVersion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "PublisherBookVersion");
    private final static QName _BookVersionViewPublisherLogoPath_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "PublisherLogoPath");
    private final static QName _QuestionViewKnowledgePointLabels_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "KnowledgePointLabels");
    private final static QName _QuestionViewMainKnowledgePointValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "MainKnowledgePointValue");
    private final static QName _QuestionViewOptionGroups_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "OptionGroups");
    private final static QName _QuestionViewQuestionCategoryName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionCategoryName");
    private final static QName _QuestionViewQuestionLevelText_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionLevelText");
    private final static QName _QuestionViewQuestionSource_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionSource");
    private final static QName _GetQuestionKnowledgePointDistributionRequestSectionIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "SectionIds");
    private final static QName _GetQuestionSectionDistributionRequestKnowledgePointIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "KnowledgePointIds");
    private final static QName _SCPQuestionDetailViewQuestions_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "Questions");
    private final static QName _CheckSCPQuestionViewCourseName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "CourseName");
    private final static QName _SCPQuestionRequestQuestionIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", "QuestionIds");
    private final static QName _ExamUsageRulerViewImprovementRulerName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ImprovementRulerName");
    private final static QName _ExamUsageRulerViewPredictionRulerName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "PredictionRulerName");
    private final static QName _CourseBookVersionListViewBookVersions_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "BookVersions");
    private final static QName _OneClickTestPaperResultViewQuestionCategoryScore_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionCategoryScore");
    private final static QName _QuestionListCategorieCountViewCategoriesCount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "CategoriesCount");
    private final static QName _QuestionListCategorieCountViewQuestionList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "QuestionList");
    private final static QName _ChapterSectionViewChapterSectionName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "ChapterSectionName");
    private final static QName _ChapterSectionViewParents_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "Parents");
    private final static QName _ChapterSectionViewSectionName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", "SectionName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.motk_model_tiku
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QuestionListView }
     * 
     */
    public QuestionListView createQuestionListView() {
        return new QuestionListView();
    }

    /**
     * Create an instance of {@link ChapterSectionView }
     * 
     */
    public ChapterSectionView createChapterSectionView() {
        return new ChapterSectionView();
    }

    /**
     * Create an instance of {@link ArrayOfChapterSectionView }
     * 
     */
    public ArrayOfChapterSectionView createArrayOfChapterSectionView() {
        return new ArrayOfChapterSectionView();
    }

    /**
     * Create an instance of {@link GetCourseMappingIdBySectionIdRequest }
     * 
     */
    public GetCourseMappingIdBySectionIdRequest createGetCourseMappingIdBySectionIdRequest() {
        return new GetCourseMappingIdBySectionIdRequest();
    }

    /**
     * Create an instance of {@link QuestionListCategorieCountView }
     * 
     */
    public QuestionListCategorieCountView createQuestionListCategorieCountView() {
        return new QuestionListCategorieCountView();
    }

    /**
     * Create an instance of {@link OneClickTestPaperRequest }
     * 
     */
    public OneClickTestPaperRequest createOneClickTestPaperRequest() {
        return new OneClickTestPaperRequest();
    }

    /**
     * Create an instance of {@link OneClickTestPaperResultView }
     * 
     */
    public OneClickTestPaperResultView createOneClickTestPaperResultView() {
        return new OneClickTestPaperResultView();
    }

    /**
     * Create an instance of {@link CourseBookVersionListView }
     * 
     */
    public CourseBookVersionListView createCourseBookVersionListView() {
        return new CourseBookVersionListView();
    }

    /**
     * Create an instance of {@link ArrayOfBookVersionView }
     * 
     */
    public ArrayOfBookVersionView createArrayOfBookVersionView() {
        return new ArrayOfBookVersionView();
    }

    /**
     * Create an instance of {@link ArrayOfKnowledgePointView }
     * 
     */
    public ArrayOfKnowledgePointView createArrayOfKnowledgePointView() {
        return new ArrayOfKnowledgePointView();
    }

    /**
     * Create an instance of {@link KnowledgePointQuestionRequest }
     * 
     */
    public KnowledgePointQuestionRequest createKnowledgePointQuestionRequest() {
        return new KnowledgePointQuestionRequest();
    }

    /**
     * Create an instance of {@link GetExamUsageRulerViewRequest }
     * 
     */
    public GetExamUsageRulerViewRequest createGetExamUsageRulerViewRequest() {
        return new GetExamUsageRulerViewRequest();
    }

    /**
     * Create an instance of {@link ExamUsageRulerView }
     * 
     */
    public ExamUsageRulerView createExamUsageRulerView() {
        return new ExamUsageRulerView();
    }

    /**
     * Create an instance of {@link GetExamUsageRulerRequest }
     * 
     */
    public GetExamUsageRulerRequest createGetExamUsageRulerRequest() {
        return new GetExamUsageRulerRequest();
    }

    /**
     * Create an instance of {@link GetQuestionsFromCourseMappingAllRequest }
     * 
     */
    public GetQuestionsFromCourseMappingAllRequest createGetQuestionsFromCourseMappingAllRequest() {
        return new GetQuestionsFromCourseMappingAllRequest();
    }

    /**
     * Create an instance of {@link GetQuestionsFromKnowledgePointsAllRequest }
     * 
     */
    public GetQuestionsFromKnowledgePointsAllRequest createGetQuestionsFromKnowledgePointsAllRequest() {
        return new GetQuestionsFromKnowledgePointsAllRequest();
    }

    /**
     * Create an instance of {@link GetQuestionStatisticsListRequest }
     * 
     */
    public GetQuestionStatisticsListRequest createGetQuestionStatisticsListRequest() {
        return new GetQuestionStatisticsListRequest();
    }

    /**
     * Create an instance of {@link GetBookVersionsRequest }
     * 
     */
    public GetBookVersionsRequest createGetBookVersionsRequest() {
        return new GetBookVersionsRequest();
    }

    /**
     * Create an instance of {@link GetAllQuestionCategoriesRequest }
     * 
     */
    public GetAllQuestionCategoriesRequest createGetAllQuestionCategoriesRequest() {
        return new GetAllQuestionCategoriesRequest();
    }

    /**
     * Create an instance of {@link GetQuestionCategoriesCheckOnlineRequest }
     * 
     */
    public GetQuestionCategoriesCheckOnlineRequest createGetQuestionCategoriesCheckOnlineRequest() {
        return new GetQuestionCategoriesCheckOnlineRequest();
    }

    /**
     * Create an instance of {@link GetOnlineQuestionsRequest }
     * 
     */
    public GetOnlineQuestionsRequest createGetOnlineQuestionsRequest() {
        return new GetOnlineQuestionsRequest();
    }

    /**
     * Create an instance of {@link GetOnlineQuestionsForKnowledgePointRequest }
     * 
     */
    public GetOnlineQuestionsForKnowledgePointRequest createGetOnlineQuestionsForKnowledgePointRequest() {
        return new GetOnlineQuestionsForKnowledgePointRequest();
    }

    /**
     * Create an instance of {@link SCPQuestionRequest }
     * 
     */
    public SCPQuestionRequest createSCPQuestionRequest() {
        return new SCPQuestionRequest();
    }

    /**
     * Create an instance of {@link CheckSCPQuestionView }
     * 
     */
    public CheckSCPQuestionView createCheckSCPQuestionView() {
        return new CheckSCPQuestionView();
    }

    /**
     * Create an instance of {@link SCPQuestionDetailView }
     * 
     */
    public SCPQuestionDetailView createSCPQuestionDetailView() {
        return new SCPQuestionDetailView();
    }

    /**
     * Create an instance of {@link GetQuestionSectionDistributionRequest }
     * 
     */
    public GetQuestionSectionDistributionRequest createGetQuestionSectionDistributionRequest() {
        return new GetQuestionSectionDistributionRequest();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionSectionDistributionView }
     * 
     */
    public ArrayOfQuestionSectionDistributionView createArrayOfQuestionSectionDistributionView() {
        return new ArrayOfQuestionSectionDistributionView();
    }

    /**
     * Create an instance of {@link GetQuestionKnowledgePointDistributionRequest }
     * 
     */
    public GetQuestionKnowledgePointDistributionRequest createGetQuestionKnowledgePointDistributionRequest() {
        return new GetQuestionKnowledgePointDistributionRequest();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionKnowledgePointDistributionView }
     * 
     */
    public ArrayOfQuestionKnowledgePointDistributionView createArrayOfQuestionKnowledgePointDistributionView() {
        return new ArrayOfQuestionKnowledgePointDistributionView();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionView }
     * 
     */
    public ArrayOfQuestionView createArrayOfQuestionView() {
        return new ArrayOfQuestionView();
    }

    /**
     * Create an instance of {@link QuestionView }
     * 
     */
    public QuestionView createQuestionView() {
        return new QuestionView();
    }

    /**
     * Create an instance of {@link BookVersionView }
     * 
     */
    public BookVersionView createBookVersionView() {
        return new BookVersionView();
    }

    /**
     * Create an instance of {@link KnowledgePointView }
     * 
     */
    public KnowledgePointView createKnowledgePointView() {
        return new KnowledgePointView();
    }

    /**
     * Create an instance of {@link ArrayOfSCPQuestionDetail }
     * 
     */
    public ArrayOfSCPQuestionDetail createArrayOfSCPQuestionDetail() {
        return new ArrayOfSCPQuestionDetail();
    }

    /**
     * Create an instance of {@link SCPQuestionDetail }
     * 
     */
    public SCPQuestionDetail createSCPQuestionDetail() {
        return new SCPQuestionDetail();
    }

    /**
     * Create an instance of {@link ArrayOfSCPQuestionOption }
     * 
     */
    public ArrayOfSCPQuestionOption createArrayOfSCPQuestionOption() {
        return new ArrayOfSCPQuestionOption();
    }

    /**
     * Create an instance of {@link SCPQuestionOption }
     * 
     */
    public SCPQuestionOption createSCPQuestionOption() {
        return new SCPQuestionOption();
    }

    /**
     * Create an instance of {@link QuestionSectionDistributionView }
     * 
     */
    public QuestionSectionDistributionView createQuestionSectionDistributionView() {
        return new QuestionSectionDistributionView();
    }

    /**
     * Create an instance of {@link QuestionKnowledgePointDistributionView }
     * 
     */
    public QuestionKnowledgePointDistributionView createQuestionKnowledgePointDistributionView() {
        return new QuestionKnowledgePointDistributionView();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionListView")
    public JAXBElement<QuestionListView> createQuestionListView(QuestionListView value) {
        return new JAXBElement<QuestionListView>(_QuestionListView_QNAME, QuestionListView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfQuestionView")
    public JAXBElement<ArrayOfQuestionView> createArrayOfQuestionView(ArrayOfQuestionView value) {
        return new JAXBElement<ArrayOfQuestionView>(_ArrayOfQuestionView_QNAME, ArrayOfQuestionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionView")
    public JAXBElement<QuestionView> createQuestionView(QuestionView value) {
        return new JAXBElement<QuestionView>(_QuestionView_QNAME, QuestionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChapterSectionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ChapterSectionView")
    public JAXBElement<ChapterSectionView> createChapterSectionView(ChapterSectionView value) {
        return new JAXBElement<ChapterSectionView>(_ChapterSectionView_QNAME, ChapterSectionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfChapterSectionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfChapterSectionView")
    public JAXBElement<ArrayOfChapterSectionView> createArrayOfChapterSectionView(ArrayOfChapterSectionView value) {
        return new JAXBElement<ArrayOfChapterSectionView>(_ArrayOfChapterSectionView_QNAME, ArrayOfChapterSectionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListCategorieCountView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionListCategorieCountView")
    public JAXBElement<QuestionListCategorieCountView> createQuestionListCategorieCountView(QuestionListCategorieCountView value) {
        return new JAXBElement<QuestionListCategorieCountView>(_QuestionListCategorieCountView_QNAME, QuestionListCategorieCountView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OneClickTestPaperResultView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "OneClickTestPaperResultView")
    public JAXBElement<OneClickTestPaperResultView> createOneClickTestPaperResultView(OneClickTestPaperResultView value) {
        return new JAXBElement<OneClickTestPaperResultView>(_OneClickTestPaperResultView_QNAME, OneClickTestPaperResultView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourseBookVersionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "CourseBookVersionListView")
    public JAXBElement<CourseBookVersionListView> createCourseBookVersionListView(CourseBookVersionListView value) {
        return new JAXBElement<CourseBookVersionListView>(_CourseBookVersionListView_QNAME, CourseBookVersionListView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfBookVersionView")
    public JAXBElement<ArrayOfBookVersionView> createArrayOfBookVersionView(ArrayOfBookVersionView value) {
        return new JAXBElement<ArrayOfBookVersionView>(_ArrayOfBookVersionView_QNAME, ArrayOfBookVersionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookVersionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "BookVersionView")
    public JAXBElement<BookVersionView> createBookVersionView(BookVersionView value) {
        return new JAXBElement<BookVersionView>(_BookVersionView_QNAME, BookVersionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfKnowledgePointView")
    public JAXBElement<ArrayOfKnowledgePointView> createArrayOfKnowledgePointView(ArrayOfKnowledgePointView value) {
        return new JAXBElement<ArrayOfKnowledgePointView>(_ArrayOfKnowledgePointView_QNAME, ArrayOfKnowledgePointView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "KnowledgePointView")
    public JAXBElement<KnowledgePointView> createKnowledgePointView(KnowledgePointView value) {
        return new JAXBElement<KnowledgePointView>(_KnowledgePointView_QNAME, KnowledgePointView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamUsageRulerView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ExamUsageRulerView")
    public JAXBElement<ExamUsageRulerView> createExamUsageRulerView(ExamUsageRulerView value) {
        return new JAXBElement<ExamUsageRulerView>(_ExamUsageRulerView_QNAME, ExamUsageRulerView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSCPQuestionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "CheckSCPQuestionView")
    public JAXBElement<CheckSCPQuestionView> createCheckSCPQuestionView(CheckSCPQuestionView value) {
        return new JAXBElement<CheckSCPQuestionView>(_CheckSCPQuestionView_QNAME, CheckSCPQuestionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionDetailView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "SCPQuestionDetailView")
    public JAXBElement<SCPQuestionDetailView> createSCPQuestionDetailView(SCPQuestionDetailView value) {
        return new JAXBElement<SCPQuestionDetailView>(_SCPQuestionDetailView_QNAME, SCPQuestionDetailView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSCPQuestionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfSCPQuestionDetail")
    public JAXBElement<ArrayOfSCPQuestionDetail> createArrayOfSCPQuestionDetail(ArrayOfSCPQuestionDetail value) {
        return new JAXBElement<ArrayOfSCPQuestionDetail>(_ArrayOfSCPQuestionDetail_QNAME, ArrayOfSCPQuestionDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "SCPQuestionDetail")
    public JAXBElement<SCPQuestionDetail> createSCPQuestionDetail(SCPQuestionDetail value) {
        return new JAXBElement<SCPQuestionDetail>(_SCPQuestionDetail_QNAME, SCPQuestionDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSCPQuestionOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfSCPQuestionOption")
    public JAXBElement<ArrayOfSCPQuestionOption> createArrayOfSCPQuestionOption(ArrayOfSCPQuestionOption value) {
        return new JAXBElement<ArrayOfSCPQuestionOption>(_ArrayOfSCPQuestionOption_QNAME, ArrayOfSCPQuestionOption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "SCPQuestionOption")
    public JAXBElement<SCPQuestionOption> createSCPQuestionOption(SCPQuestionOption value) {
        return new JAXBElement<SCPQuestionOption>(_SCPQuestionOption_QNAME, SCPQuestionOption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSectionDistributionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfQuestionSectionDistributionView")
    public JAXBElement<ArrayOfQuestionSectionDistributionView> createArrayOfQuestionSectionDistributionView(ArrayOfQuestionSectionDistributionView value) {
        return new JAXBElement<ArrayOfQuestionSectionDistributionView>(_ArrayOfQuestionSectionDistributionView_QNAME, ArrayOfQuestionSectionDistributionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionSectionDistributionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionSectionDistributionView")
    public JAXBElement<QuestionSectionDistributionView> createQuestionSectionDistributionView(QuestionSectionDistributionView value) {
        return new JAXBElement<QuestionSectionDistributionView>(_QuestionSectionDistributionView_QNAME, QuestionSectionDistributionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionKnowledgePointDistributionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ArrayOfQuestionKnowledgePointDistributionView")
    public JAXBElement<ArrayOfQuestionKnowledgePointDistributionView> createArrayOfQuestionKnowledgePointDistributionView(ArrayOfQuestionKnowledgePointDistributionView value) {
        return new JAXBElement<ArrayOfQuestionKnowledgePointDistributionView>(_ArrayOfQuestionKnowledgePointDistributionView_QNAME, ArrayOfQuestionKnowledgePointDistributionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionKnowledgePointDistributionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionKnowledgePointDistributionView")
    public JAXBElement<QuestionKnowledgePointDistributionView> createQuestionKnowledgePointDistributionView(QuestionKnowledgePointDistributionView value) {
        return new JAXBElement<QuestionKnowledgePointDistributionView>(_QuestionKnowledgePointDistributionView_QNAME, QuestionKnowledgePointDistributionView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourseMappingIdBySectionIdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetCourseMappingIdBySectionIdRequest")
    public JAXBElement<GetCourseMappingIdBySectionIdRequest> createGetCourseMappingIdBySectionIdRequest(GetCourseMappingIdBySectionIdRequest value) {
        return new JAXBElement<GetCourseMappingIdBySectionIdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetCourseMappingIdBySectionIdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OneClickTestPaperRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "OneClickTestPaperRequest")
    public JAXBElement<OneClickTestPaperRequest> createOneClickTestPaperRequest(OneClickTestPaperRequest value) {
        return new JAXBElement<OneClickTestPaperRequest>(_OneClickTestPaperRequest_QNAME, OneClickTestPaperRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointQuestionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "KnowledgePointQuestionRequest")
    public JAXBElement<KnowledgePointQuestionRequest> createKnowledgePointQuestionRequest(KnowledgePointQuestionRequest value) {
        return new JAXBElement<KnowledgePointQuestionRequest>(_KnowledgePointQuestionRequest_QNAME, KnowledgePointQuestionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExamUsageRulerViewRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetExamUsageRulerViewRequest")
    public JAXBElement<GetExamUsageRulerViewRequest> createGetExamUsageRulerViewRequest(GetExamUsageRulerViewRequest value) {
        return new JAXBElement<GetExamUsageRulerViewRequest>(_GetExamUsageRulerViewRequest_QNAME, GetExamUsageRulerViewRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExamUsageRulerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetExamUsageRulerRequest")
    public JAXBElement<GetExamUsageRulerRequest> createGetExamUsageRulerRequest(GetExamUsageRulerRequest value) {
        return new JAXBElement<GetExamUsageRulerRequest>(_GetExamUsageRulerRequest_QNAME, GetExamUsageRulerRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionsFromCourseMappingAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetQuestionsFromCourseMappingAllRequest")
    public JAXBElement<GetQuestionsFromCourseMappingAllRequest> createGetQuestionsFromCourseMappingAllRequest(GetQuestionsFromCourseMappingAllRequest value) {
        return new JAXBElement<GetQuestionsFromCourseMappingAllRequest>(_GetQuestionsFromCourseMappingAllRequest_QNAME, GetQuestionsFromCourseMappingAllRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionsFromKnowledgePointsAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetQuestionsFromKnowledgePointsAllRequest")
    public JAXBElement<GetQuestionsFromKnowledgePointsAllRequest> createGetQuestionsFromKnowledgePointsAllRequest(GetQuestionsFromKnowledgePointsAllRequest value) {
        return new JAXBElement<GetQuestionsFromKnowledgePointsAllRequest>(_GetQuestionsFromKnowledgePointsAllRequest_QNAME, GetQuestionsFromKnowledgePointsAllRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionStatisticsListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetQuestionStatisticsListRequest")
    public JAXBElement<GetQuestionStatisticsListRequest> createGetQuestionStatisticsListRequest(GetQuestionStatisticsListRequest value) {
        return new JAXBElement<GetQuestionStatisticsListRequest>(_GetQuestionStatisticsListRequest_QNAME, GetQuestionStatisticsListRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookVersionsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetBookVersionsRequest")
    public JAXBElement<GetBookVersionsRequest> createGetBookVersionsRequest(GetBookVersionsRequest value) {
        return new JAXBElement<GetBookVersionsRequest>(_GetBookVersionsRequest_QNAME, GetBookVersionsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionCategoriesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetAllQuestionCategoriesRequest")
    public JAXBElement<GetAllQuestionCategoriesRequest> createGetAllQuestionCategoriesRequest(GetAllQuestionCategoriesRequest value) {
        return new JAXBElement<GetAllQuestionCategoriesRequest>(_GetAllQuestionCategoriesRequest_QNAME, GetAllQuestionCategoriesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionCategoriesCheckOnlineRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetQuestionCategoriesCheckOnlineRequest")
    public JAXBElement<GetQuestionCategoriesCheckOnlineRequest> createGetQuestionCategoriesCheckOnlineRequest(GetQuestionCategoriesCheckOnlineRequest value) {
        return new JAXBElement<GetQuestionCategoriesCheckOnlineRequest>(_GetQuestionCategoriesCheckOnlineRequest_QNAME, GetQuestionCategoriesCheckOnlineRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnlineQuestionsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetOnlineQuestionsRequest")
    public JAXBElement<GetOnlineQuestionsRequest> createGetOnlineQuestionsRequest(GetOnlineQuestionsRequest value) {
        return new JAXBElement<GetOnlineQuestionsRequest>(_GetOnlineQuestionsRequest_QNAME, GetOnlineQuestionsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnlineQuestionsForKnowledgePointRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetOnlineQuestionsForKnowledgePointRequest")
    public JAXBElement<GetOnlineQuestionsForKnowledgePointRequest> createGetOnlineQuestionsForKnowledgePointRequest(GetOnlineQuestionsForKnowledgePointRequest value) {
        return new JAXBElement<GetOnlineQuestionsForKnowledgePointRequest>(_GetOnlineQuestionsForKnowledgePointRequest_QNAME, GetOnlineQuestionsForKnowledgePointRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "SCPQuestionRequest")
    public JAXBElement<SCPQuestionRequest> createSCPQuestionRequest(SCPQuestionRequest value) {
        return new JAXBElement<SCPQuestionRequest>(_SCPQuestionRequest_QNAME, SCPQuestionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionSectionDistributionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetQuestionSectionDistributionRequest")
    public JAXBElement<GetQuestionSectionDistributionRequest> createGetQuestionSectionDistributionRequest(GetQuestionSectionDistributionRequest value) {
        return new JAXBElement<GetQuestionSectionDistributionRequest>(_GetQuestionSectionDistributionRequest_QNAME, GetQuestionSectionDistributionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionKnowledgePointDistributionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "GetQuestionKnowledgePointDistributionRequest")
    public JAXBElement<GetQuestionKnowledgePointDistributionRequest> createGetQuestionKnowledgePointDistributionRequest(GetQuestionKnowledgePointDistributionRequest value) {
        return new JAXBElement<GetQuestionKnowledgePointDistributionRequest>(_GetQuestionKnowledgePointDistributionRequest_QNAME, GetQuestionKnowledgePointDistributionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionOptionId", scope = SCPQuestionOption.class)
    public JAXBElement<String> createSCPQuestionOptionQuestionOptionId(String value) {
        return new JAXBElement<String>(_SCPQuestionOptionQuestionOptionId_QNAME, String.class, SCPQuestionOption.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionOptionText", scope = SCPQuestionOption.class)
    public JAXBElement<String> createSCPQuestionOptionQuestionOptionText(String value) {
        return new JAXBElement<String>(_SCPQuestionOptionQuestionOptionText_QNAME, String.class, SCPQuestionOption.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Analysis", scope = SCPQuestionDetail.class)
    public JAXBElement<String> createSCPQuestionDetailAnalysis(String value) {
        return new JAXBElement<String>(_SCPQuestionDetailAnalysis_QNAME, String.class, SCPQuestionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Answer", scope = SCPQuestionDetail.class)
    public JAXBElement<String> createSCPQuestionDetailAnswer(String value) {
        return new JAXBElement<String>(_SCPQuestionDetailAnswer_QNAME, String.class, SCPQuestionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "KnowledgePointNames", scope = SCPQuestionDetail.class)
    public JAXBElement<ArrayOfstring> createSCPQuestionDetailKnowledgePointNames(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_SCPQuestionDetailKnowledgePointNames_QNAME, ArrayOfstring.class, SCPQuestionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSCPQuestionOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Options", scope = SCPQuestionDetail.class)
    public JAXBElement<ArrayOfSCPQuestionOption> createSCPQuestionDetailOptions(ArrayOfSCPQuestionOption value) {
        return new JAXBElement<ArrayOfSCPQuestionOption>(_SCPQuestionDetailOptions_QNAME, ArrayOfSCPQuestionOption.class, SCPQuestionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionContent", scope = SCPQuestionDetail.class)
    public JAXBElement<String> createSCPQuestionDetailQuestionContent(String value) {
        return new JAXBElement<String>(_SCPQuestionDetailQuestionContent_QNAME, String.class, SCPQuestionDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "KnowledgePoint", scope = KnowledgePointView.class)
    public JAXBElement<KnowledgePoint> createKnowledgePointViewKnowledgePoint(KnowledgePoint value) {
        return new JAXBElement<KnowledgePoint>(_KnowledgePointViewKnowledgePoint_QNAME, KnowledgePoint.class, KnowledgePointView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "BookVersionName", scope = BookVersionView.class)
    public JAXBElement<String> createBookVersionViewBookVersionName(String value) {
        return new JAXBElement<String>(_BookVersionViewBookVersionName_QNAME, String.class, BookVersionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublisherBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "PublisherBookVersion", scope = BookVersionView.class)
    public JAXBElement<PublisherBookVersion> createBookVersionViewPublisherBookVersion(PublisherBookVersion value) {
        return new JAXBElement<PublisherBookVersion>(_BookVersionViewPublisherBookVersion_QNAME, PublisherBookVersion.class, BookVersionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "PublisherLogoPath", scope = BookVersionView.class)
    public JAXBElement<String> createBookVersionViewPublisherLogoPath(String value) {
        return new JAXBElement<String>(_BookVersionViewPublisherLogoPath_QNAME, String.class, BookVersionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Analysis", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewAnalysis(String value) {
        return new JAXBElement<String>(_SCPQuestionDetailAnalysis_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Answer", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewAnswer(String value) {
        return new JAXBElement<String>(_SCPQuestionDetailAnswer_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "KnowledgePointLabels", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewKnowledgePointLabels(String value) {
        return new JAXBElement<String>(_QuestionViewKnowledgePointLabels_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "MainKnowledgePointValue", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewMainKnowledgePointValue(String value) {
        return new JAXBElement<String>(_QuestionViewMainKnowledgePointValue_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "OptionGroups", scope = QuestionView.class)
    public JAXBElement<ArrayOfQuestionOptionGroup> createQuestionViewOptionGroups(ArrayOfQuestionOptionGroup value) {
        return new JAXBElement<ArrayOfQuestionOptionGroup>(_QuestionViewOptionGroups_QNAME, ArrayOfQuestionOptionGroup.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionCategoryName", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewQuestionCategoryName(String value) {
        return new JAXBElement<String>(_QuestionViewQuestionCategoryName_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionContent", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewQuestionContent(String value) {
        return new JAXBElement<String>(_SCPQuestionDetailQuestionContent_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionLevelText", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewQuestionLevelText(String value) {
        return new JAXBElement<String>(_QuestionViewQuestionLevelText_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionSource", scope = QuestionView.class)
    public JAXBElement<String> createQuestionViewQuestionSource(String value) {
        return new JAXBElement<String>(_QuestionViewQuestionSource_QNAME, String.class, QuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "SectionIds", scope = GetQuestionKnowledgePointDistributionRequest.class)
    public JAXBElement<ArrayOfint> createGetQuestionKnowledgePointDistributionRequestSectionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionKnowledgePointDistributionRequestSectionIds_QNAME, ArrayOfint.class, GetQuestionKnowledgePointDistributionRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "KnowledgePointIds", scope = GetQuestionSectionDistributionRequest.class)
    public JAXBElement<ArrayOfint> createGetQuestionSectionDistributionRequestKnowledgePointIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionSectionDistributionRequestKnowledgePointIds_QNAME, ArrayOfint.class, GetQuestionSectionDistributionRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "SectionIds", scope = GetQuestionSectionDistributionRequest.class)
    public JAXBElement<ArrayOfint> createGetQuestionSectionDistributionRequestSectionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionKnowledgePointDistributionRequestSectionIds_QNAME, ArrayOfint.class, GetQuestionSectionDistributionRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSCPQuestionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Questions", scope = SCPQuestionDetailView.class)
    public JAXBElement<ArrayOfSCPQuestionDetail> createSCPQuestionDetailViewQuestions(ArrayOfSCPQuestionDetail value) {
        return new JAXBElement<ArrayOfSCPQuestionDetail>(_SCPQuestionDetailViewQuestions_QNAME, ArrayOfSCPQuestionDetail.class, SCPQuestionDetailView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "CourseName", scope = CheckSCPQuestionView.class)
    public JAXBElement<String> createCheckSCPQuestionViewCourseName(String value) {
        return new JAXBElement<String>(_CheckSCPQuestionViewCourseName_QNAME, String.class, CheckSCPQuestionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "QuestionIds", scope = SCPQuestionRequest.class)
    public JAXBElement<ArrayOfint> createSCPQuestionRequestQuestionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_SCPQuestionRequestQuestionIds_QNAME, ArrayOfint.class, SCPQuestionRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "QuestionIds", scope = GetQuestionStatisticsListRequest.class)
    public JAXBElement<ArrayOfint> createGetQuestionStatisticsListRequestQuestionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_SCPQuestionRequestQuestionIds_QNAME, ArrayOfint.class, GetQuestionStatisticsListRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ImprovementRulerName", scope = ExamUsageRulerView.class)
    public JAXBElement<String> createExamUsageRulerViewImprovementRulerName(String value) {
        return new JAXBElement<String>(_ExamUsageRulerViewImprovementRulerName_QNAME, String.class, ExamUsageRulerView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "PredictionRulerName", scope = ExamUsageRulerView.class)
    public JAXBElement<String> createExamUsageRulerViewPredictionRulerName(String value) {
        return new JAXBElement<String>(_ExamUsageRulerViewPredictionRulerName_QNAME, String.class, ExamUsageRulerView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "BookVersions", scope = CourseBookVersionListView.class)
    public JAXBElement<ArrayOfBookVersion> createCourseBookVersionListViewBookVersions(ArrayOfBookVersion value) {
        return new JAXBElement<ArrayOfBookVersion>(_CourseBookVersionListViewBookVersions_QNAME, ArrayOfBookVersion.class, CourseBookVersionListView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectQuestionScoreView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionCategoryScore", scope = OneClickTestPaperResultView.class)
    public JAXBElement<SelectQuestionScoreView> createOneClickTestPaperResultViewQuestionCategoryScore(SelectQuestionScoreView value) {
        return new JAXBElement<SelectQuestionScoreView>(_OneClickTestPaperResultViewQuestionCategoryScore_QNAME, SelectQuestionScoreView.class, OneClickTestPaperResultView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Questions", scope = OneClickTestPaperResultView.class)
    public JAXBElement<ArrayOfQuestionSimplifiedFormat> createOneClickTestPaperResultViewQuestions(ArrayOfQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfQuestionSimplifiedFormat>(_SCPQuestionDetailViewQuestions_QNAME, ArrayOfQuestionSimplifiedFormat.class, OneClickTestPaperResultView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "KnowledgePointIds", scope = OneClickTestPaperRequest.class)
    public JAXBElement<ArrayOfint> createOneClickTestPaperRequestKnowledgePointIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionSectionDistributionRequestKnowledgePointIds_QNAME, ArrayOfint.class, OneClickTestPaperRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.Request", name = "SectionIds", scope = OneClickTestPaperRequest.class)
    public JAXBElement<ArrayOfstring> createOneClickTestPaperRequestSectionIds(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetQuestionKnowledgePointDistributionRequestSectionIds_QNAME, ArrayOfstring.class, OneClickTestPaperRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "CategoriesCount", scope = QuestionListCategorieCountView.class)
    public JAXBElement<ArrayOfKeyValueOfstringint> createQuestionListCategorieCountViewCategoriesCount(ArrayOfKeyValueOfstringint value) {
        return new JAXBElement<ArrayOfKeyValueOfstringint>(_QuestionListCategorieCountViewCategoriesCount_QNAME, ArrayOfKeyValueOfstringint.class, QuestionListCategorieCountView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionList", scope = QuestionListCategorieCountView.class)
    public JAXBElement<ArrayOfQuestionView> createQuestionListCategorieCountViewQuestionList(ArrayOfQuestionView value) {
        return new JAXBElement<ArrayOfQuestionView>(_QuestionListCategorieCountViewQuestionList_QNAME, ArrayOfQuestionView.class, QuestionListCategorieCountView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "ChapterSectionName", scope = ChapterSectionView.class)
    public JAXBElement<String> createChapterSectionViewChapterSectionName(String value) {
        return new JAXBElement<String>(_ChapterSectionViewChapterSectionName_QNAME, String.class, ChapterSectionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "Parents", scope = ChapterSectionView.class)
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ> createChapterSectionViewParents(ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ value) {
        return new JAXBElement<ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ>(_ChapterSectionViewParents_QNAME, ArrayOfKeyValueOfintChapterSectionViewGgTWa5IQ.class, ChapterSectionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "SectionName", scope = ChapterSectionView.class)
    public JAXBElement<String> createChapterSectionViewSectionName(String value) {
        return new JAXBElement<String>(_ChapterSectionViewSectionName_QNAME, String.class, ChapterSectionView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku.View", name = "QuestionList", scope = QuestionListView.class)
    public JAXBElement<ArrayOfQuestionView> createQuestionListViewQuestionList(ArrayOfQuestionView value) {
        return new JAXBElement<ArrayOfQuestionView>(_QuestionListCategorieCountViewQuestionList_QNAME, ArrayOfQuestionView.class, QuestionListView.class, value);
    }

}
