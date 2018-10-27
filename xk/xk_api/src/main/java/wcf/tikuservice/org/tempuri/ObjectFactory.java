
package wcf.tikuservice.org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintChapterSectionyHSjzk5H;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk.SimpleTree;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfBookVersion;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfChapterSection;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfChapterSectionKnowledgeMapping;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfCourseMapping;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfExamUsageRuler;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfKnowledgePointQuestionCount;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfPublisher;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestion;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionCategory;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionCategoryModel;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionDisplayType;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionFaultType;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionLabel;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionReportModel;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionSimplifiedFormat;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionSimplifiedFormatCache;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionStatistics;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfSchoolBookVersion;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.BookVersion;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ChapterSectionList;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ClassRoomEvaluationDefaultSelected;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.CourseMapping;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ExamRuler;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ExamUsageRuler;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.IdRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.KnowledgePointList;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.OnlineQuestionSimplifiedFormatKnowledgePointList;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.OnlineQuestionSimplifiedFormatSectionList;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.PreKnowledgePointList;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionCategory;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionDisplayType;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionStatistics;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.SimilarQuestionList;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam.ArrayOfZujuanBasketQuestionCategoryStatisticsView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_exam.AutoZujuanCreationRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ArrayOfBookVersionView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ArrayOfChapterSectionView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ArrayOfKnowledgePointView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ArrayOfQuestionKnowledgePointDistributionView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ArrayOfQuestionSectionDistributionView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ChapterSectionView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.CheckSCPQuestionView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.CourseBookVersionListView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.ExamUsageRulerView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetAllQuestionCategoriesRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetBookVersionsRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetCourseMappingIdBySectionIdRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetExamUsageRulerRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetExamUsageRulerViewRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetOnlineQuestionsForKnowledgePointRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetOnlineQuestionsRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionCategoriesCheckOnlineRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionKnowledgePointDistributionRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionSectionDistributionRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionStatisticsListRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionsFromCourseMappingAllRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetQuestionsFromKnowledgePointsAllRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.KnowledgePointQuestionRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.OneClickTestPaperRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.OneClickTestPaperResultView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.QuestionListCategorieCountView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.QuestionListView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.SCPQuestionDetailView;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.SCPQuestionRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _GetQuestionCategoryByIdResponseGetQuestionCategoryByIdResult_QNAME = new QName("http://tempuri.org/", "GetQuestionCategoryByIdResult");
    private final static QName _GetQuestionCategoriesResponseGetQuestionCategoriesResult_QNAME = new QName("http://tempuri.org/", "GetQuestionCategoriesResult");
    private final static QName _GetQuestionCategoriesCheckOnlineResponseGetQuestionCategoriesCheckOnlineResult_QNAME = new QName("http://tempuri.org/", "GetQuestionCategoriesCheckOnlineResult");
    private final static QName _GetKnowledgePointSimpleTreeResponseGetKnowledgePointSimpleTreeResult_QNAME = new QName("http://tempuri.org/", "GetKnowledgePointSimpleTreeResult");
    private final static QName _GetKnowledgePointsResponseGetKnowledgePointsResult_QNAME = new QName("http://tempuri.org/", "GetKnowledgePointsResult");
    private final static QName _GetChapterSectionSimpleTreeByPageResponseGetChapterSectionSimpleTreeByPageResult_QNAME = new QName("http://tempuri.org/", "GetChapterSectionSimpleTreeByPageResult");
    private final static QName _GetChapterSectionSimpleTreeResponseGetChapterSectionSimpleTreeResult_QNAME = new QName("http://tempuri.org/", "GetChapterSectionSimpleTreeResult");
    private final static QName _GetBookVersionResponseGetBookVersionResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionResult");
    private final static QName _GetBookVersionsByCourseResponseGetBookVersionsByCourseResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionsByCourseResult");
    private final static QName _GetBookVersionInfoResponseGetBookVersionInfoResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionInfoResult");
    private final static QName _GetQuestionByIdResponseGetQuestionByIdResult_QNAME = new QName("http://tempuri.org/", "GetQuestionByIdResult");
    private final static QName _GetQuestionByIdForJavaResponseGetQuestionByIdForJavaResult_QNAME = new QName("http://tempuri.org/", "GetQuestionByIdForJavaResult");
    private final static QName _GetQuestionsForJavaQuestionIds_QNAME = new QName("http://tempuri.org/", "questionIds");
    private final static QName _GetQuestionsForJavaResponseGetQuestionsForJavaResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsForJavaResult");
    private final static QName _GetQuestionsByFilterResponseGetQuestionsByFilterResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsByFilterResult");
    private final static QName _GetQuestionStatisticsResponseGetQuestionStatisticsResult_QNAME = new QName("http://tempuri.org/", "GetQuestionStatisticsResult");
    private final static QName _GetQuestionsFromKnowledgePointsResponseGetQuestionsFromKnowledgePointsResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsFromKnowledgePointsResult");
    private final static QName _SearchQuestionsKeyword_QNAME = new QName("http://tempuri.org/", "keyword");
    private final static QName _SearchQuestionsResponseSearchQuestionsResult_QNAME = new QName("http://tempuri.org/", "SearchQuestionsResult");
    private final static QName _AddQuestionSessionId_QNAME = new QName("http://tempuri.org/", "sessionId");
    private final static QName _AddQuestionResponseAddQuestionResult_QNAME = new QName("http://tempuri.org/", "AddQuestionResult");
    private final static QName _AddMultipleQuestionResponseAddMultipleQuestionResult_QNAME = new QName("http://tempuri.org/", "AddMultipleQuestionResult");
    private final static QName _AddQuestionOnClickQuestion_QNAME = new QName("http://tempuri.org/", "question");
    private final static QName _GetQuestionsFromSectionsResponseGetQuestionsFromSectionsResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsFromSectionsResult");
    private final static QName _GetCourseMappingsResponseGetCourseMappingsResult_QNAME = new QName("http://tempuri.org/", "GetCourseMappingsResult");
    private final static QName _GetCourseMappingResponseGetCourseMappingResult_QNAME = new QName("http://tempuri.org/", "GetCourseMappingResult");
    private final static QName _GetChapterSectionResponseGetChapterSectionResult_QNAME = new QName("http://tempuri.org/", "GetChapterSectionResult");
    private final static QName _GetZujuanBasketStatisticsResponseGetZujuanBasketStatisticsResult_QNAME = new QName("http://tempuri.org/", "GetZujuanBasketStatisticsResult");
    private final static QName _GetQuestionsResponseGetQuestionsResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsResult");
    private final static QName _GetAllBasketQuestionResponseGetAllBasketQuestionResult_QNAME = new QName("http://tempuri.org/", "GetAllBasketQuestionResult");
    private final static QName _GetChapterListResponseGetChapterListResult_QNAME = new QName("http://tempuri.org/", "GetChapterListResult");
    private final static QName _GetCourseMappingIdBySectionIdRequest_QNAME = new QName("http://tempuri.org/", "request");
    private final static QName _GenerateAutoZujuanQuestionsResponseGenerateAutoZujuanQuestionsResult_QNAME = new QName("http://tempuri.org/", "GenerateAutoZujuanQuestionsResult");
    private final static QName _SearchCllectionQuestionsResponseSearchCllectionQuestionsResult_QNAME = new QName("http://tempuri.org/", "SearchCllectionQuestionsResult");
    private final static QName _GetAllCollectionQuestionResponseGetAllCollectionQuestionResult_QNAME = new QName("http://tempuri.org/", "GetAllCollectionQuestionResult");
    private final static QName _GetExamSetQuestionDistributionResponseGetExamSetQuestionDistributionResult_QNAME = new QName("http://tempuri.org/", "GetExamSetQuestionDistributionResult");
    private final static QName _SetPreviewConfigSessionExamConfig_QNAME = new QName("http://tempuri.org/", "examConfig");
    private final static QName _GetPreviewConfigSessionResponseGetPreviewConfigSessionResult_QNAME = new QName("http://tempuri.org/", "GetPreviewConfigSessionResult");
    private final static QName _GetExamSetQuestionSectionResponseGetExamSetQuestionSectionResult_QNAME = new QName("http://tempuri.org/", "GetExamSetQuestionSectionResult");
    private final static QName _GetCourseMappingsByCourseIdResponseGetCourseMappingsByCourseIdResult_QNAME = new QName("http://tempuri.org/", "GetCourseMappingsByCourseIdResult");
    private final static QName _GetBookVersionByCourseResponseGetBookVersionByCourseResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionByCourseResult");
    private final static QName _GetBookVersionByUserIdResponseGetBookVersionByUserIdResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionByUserIdResult");
    private final static QName _GenerateOneClickTestPaperQuestionsOneClickTestPaperRequest_QNAME = new QName("http://tempuri.org/", "oneClickTestPaperRequest");
    private final static QName _GenerateOneClickTestPaperQuestionsResponseGenerateOneClickTestPaperQuestionsResult_QNAME = new QName("http://tempuri.org/", "GenerateOneClickTestPaperQuestionsResult");
    private final static QName _GetCourseQuestionCountResponseGetCourseQuestionCountResult_QNAME = new QName("http://tempuri.org/", "GetCourseQuestionCountResult");
    private final static QName _GetHasQuestionBookVersionIncludeSpecifyBookVersion_QNAME = new QName("http://tempuri.org/", "includeSpecifyBookVersion");
    private final static QName _GetHasQuestionBookVersionResponseGetHasQuestionBookVersionResult_QNAME = new QName("http://tempuri.org/", "GetHasQuestionBookVersionResult");
    private final static QName _GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponseGetFirstLevelChildrenKnowledgePointByQuestionSummaryResult_QNAME = new QName("http://tempuri.org/", "GetFirstLevelChildrenKnowledgePointByQuestionSummaryResult");
    private final static QName _GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2ResponseGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Result_QNAME = new QName("http://tempuri.org/", "GetFirstLevelChildrenKnowledgePointByQuestionSummary_V2Result");
    private final static QName _GetQuestionFaultTypesResponseGetQuestionFaultTypesResult_QNAME = new QName("http://tempuri.org/", "GetQuestionFaultTypesResult");
    private final static QName _GetKnowledgePointQuestionCountResponseGetKnowledgePointQuestionCountResult_QNAME = new QName("http://tempuri.org/", "GetKnowledgePointQuestionCountResult");
    private final static QName _GetAllPublishersResponseGetAllPublishersResult_QNAME = new QName("http://tempuri.org/", "GetAllPublishersResult");
    private final static QName _GetSchoolBookVersionResponseGetSchoolBookVersionResult_QNAME = new QName("http://tempuri.org/", "GetSchoolBookVersionResult");
    private final static QName _GetGetQuestionDisplayTypesResponseGetGetQuestionDisplayTypesResult_QNAME = new QName("http://tempuri.org/", "GetGetQuestionDisplayTypesResult");
    private final static QName _GetExamUsageRulerViewResponseGetExamUsageRulerViewResult_QNAME = new QName("http://tempuri.org/", "GetExamUsageRulerViewResult");
    private final static QName _GetHasQuestionBookVersionViewsByCourseIdResponseGetHasQuestionBookVersionViewsByCourseIdResult_QNAME = new QName("http://tempuri.org/", "GetHasQuestionBookVersionViewsByCourseIdResult");
    private final static QName _GetQuestionReportModelQuestionId_QNAME = new QName("http://tempuri.org/", "questionId");
    private final static QName _GetQuestionReportModelResponseGetQuestionReportModelResult_QNAME = new QName("http://tempuri.org/", "GetQuestionReportModelResult");
    private final static QName _GetExamRulerResponseGetExamRulerResult_QNAME = new QName("http://tempuri.org/", "GetExamRulerResult");
    private final static QName _GetAllExamUsageRulersResponseGetAllExamUsageRulersResult_QNAME = new QName("http://tempuri.org/", "GetAllExamUsageRulersResult");
    private final static QName _GetExamUsageRulerResponseGetExamUsageRulerResult_QNAME = new QName("http://tempuri.org/", "GetExamUsageRulerResult");
    private final static QName _GetQuestionsFromCourseMappingAllResponseGetQuestionsFromCourseMappingAllResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsFromCourseMappingAllResult");
    private final static QName _GetQuestionsFromKnowledgePointsAllResponseGetQuestionsFromKnowledgePointsAllResult_QNAME = new QName("http://tempuri.org/", "GetQuestionsFromKnowledgePointsAllResult");
    private final static QName _GetQuestionStatisticsListResponseGetQuestionStatisticsListResult_QNAME = new QName("http://tempuri.org/", "GetQuestionStatisticsListResult");
    private final static QName _GetQuestionLabelsResponseGetQuestionLabelsResult_QNAME = new QName("http://tempuri.org/", "GetQuestionLabelsResult");
    private final static QName _GetBookVersionsResponseGetBookVersionsResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionsResult");
    private final static QName _GetAllCourseMappingsResponseGetAllCourseMappingsResult_QNAME = new QName("http://tempuri.org/", "GetAllCourseMappingsResult");
    private final static QName _GetChapterSectionsResponseGetChapterSectionsResult_QNAME = new QName("http://tempuri.org/", "GetChapterSectionsResult");
    private final static QName _GetParentChapterSectionsResponseGetParentChapterSectionsResult_QNAME = new QName("http://tempuri.org/", "GetParentChapterSectionsResult");
    private final static QName _GetBookVersionChapterSectionsResponseGetBookVersionChapterSectionsResult_QNAME = new QName("http://tempuri.org/", "GetBookVersionChapterSectionsResult");
    private final static QName _GetAllQuestionCategoriesResponseGetAllQuestionCategoriesResult_QNAME = new QName("http://tempuri.org/", "GetAllQuestionCategoriesResult");
    private final static QName _GetQuestionCategoriesCheckOnlineNewResponseGetQuestionCategoriesCheckOnlineNewResult_QNAME = new QName("http://tempuri.org/", "GetQuestionCategoriesCheckOnlineNewResult");
    private final static QName _GetRootQuestionCategoriesCheckOnlineResponseGetRootQuestionCategoriesCheckOnlineResult_QNAME = new QName("http://tempuri.org/", "GetRootQuestionCategoriesCheckOnlineResult");
    private final static QName _GetQuestionCategoryModelsResponseGetQuestionCategoryModelsResult_QNAME = new QName("http://tempuri.org/", "GetQuestionCategoryModelsResult");
    private final static QName _GetAllBookVersionsResponseGetAllBookVersionsResult_QNAME = new QName("http://tempuri.org/", "GetAllBookVersionsResult");
    private final static QName _GetQuestionDisplayTypeResponseGetQuestionDisplayTypeResult_QNAME = new QName("http://tempuri.org/", "GetQuestionDisplayTypeResult");
    private final static QName _GetCourseAllChapterSectionsResponseGetCourseAllChapterSectionsResult_QNAME = new QName("http://tempuri.org/", "GetCourseAllChapterSectionsResult");
    private final static QName _GetCoursePreKnowledgePointsResponseGetCoursePreKnowledgePointsResult_QNAME = new QName("http://tempuri.org/", "GetCoursePreKnowledgePointsResult");
    private final static QName _GetChapterSectionKnowledgeMappingByCourseIdResponseGetChapterSectionKnowledgeMappingByCourseIdResult_QNAME = new QName("http://tempuri.org/", "GetChapterSectionKnowledgeMappingByCourseIdResult");
    private final static QName _GetOnlineQuestionsResponseGetOnlineQuestionsResult_QNAME = new QName("http://tempuri.org/", "GetOnlineQuestionsResult");
    private final static QName _GetOnlineQuestionsForKnowledgePointResponseGetOnlineQuestionsForKnowledgePointResult_QNAME = new QName("http://tempuri.org/", "GetOnlineQuestionsForKnowledgePointResult");
    private final static QName _GetSimilarQuestionListResponseGetSimilarQuestionListResult_QNAME = new QName("http://tempuri.org/", "GetSimilarQuestionListResult");
    private final static QName _GetClassRoomEvaluationDefaultSelectedResponseGetClassRoomEvaluationDefaultSelectedResult_QNAME = new QName("http://tempuri.org/", "GetClassRoomEvaluationDefaultSelectedResult");
    private final static QName _CheckSCPQuestionResponseCheckSCPQuestionResult_QNAME = new QName("http://tempuri.org/", "CheckSCPQuestionResult");
    private final static QName _GetSCPQuestionDetailsResponseGetSCPQuestionDetailsResult_QNAME = new QName("http://tempuri.org/", "GetSCPQuestionDetailsResult");
    private final static QName _GetQuestionSectionDistributionResponseGetQuestionSectionDistributionResult_QNAME = new QName("http://tempuri.org/", "GetQuestionSectionDistributionResult");
    private final static QName _GetQuestionKnowledgePointDistributionResponseGetQuestionKnowledgePointDistributionResult_QNAME = new QName("http://tempuri.org/", "GetQuestionKnowledgePointDistributionResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetQuestionCategoryById }
     * 
     */
    public GetQuestionCategoryById createGetQuestionCategoryById() {
        return new GetQuestionCategoryById();
    }

    /**
     * Create an instance of {@link GetQuestionCategoryByIdResponse }
     * 
     */
    public GetQuestionCategoryByIdResponse createGetQuestionCategoryByIdResponse() {
        return new GetQuestionCategoryByIdResponse();
    }

    /**
     * Create an instance of {@link GetQuestionCategories }
     * 
     */
    public GetQuestionCategories createGetQuestionCategories() {
        return new GetQuestionCategories();
    }

    /**
     * Create an instance of {@link GetQuestionCategoriesResponse }
     * 
     */
    public GetQuestionCategoriesResponse createGetQuestionCategoriesResponse() {
        return new GetQuestionCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetQuestionCategoriesCheckOnline }
     * 
     */
    public GetQuestionCategoriesCheckOnline createGetQuestionCategoriesCheckOnline() {
        return new GetQuestionCategoriesCheckOnline();
    }

    /**
     * Create an instance of {@link GetQuestionCategoriesCheckOnlineResponse }
     * 
     */
    public GetQuestionCategoriesCheckOnlineResponse createGetQuestionCategoriesCheckOnlineResponse() {
        return new GetQuestionCategoriesCheckOnlineResponse();
    }

    /**
     * Create an instance of {@link GetKnowledgePointSimpleTree }
     * 
     */
    public GetKnowledgePointSimpleTree createGetKnowledgePointSimpleTree() {
        return new GetKnowledgePointSimpleTree();
    }

    /**
     * Create an instance of {@link GetKnowledgePointSimpleTreeResponse }
     * 
     */
    public GetKnowledgePointSimpleTreeResponse createGetKnowledgePointSimpleTreeResponse() {
        return new GetKnowledgePointSimpleTreeResponse();
    }

    /**
     * Create an instance of {@link GetKnowledgePoints }
     * 
     */
    public GetKnowledgePoints createGetKnowledgePoints() {
        return new GetKnowledgePoints();
    }

    /**
     * Create an instance of {@link GetKnowledgePointsResponse }
     * 
     */
    public GetKnowledgePointsResponse createGetKnowledgePointsResponse() {
        return new GetKnowledgePointsResponse();
    }

    /**
     * Create an instance of {@link GetChapterSectionSimpleTreeByPage }
     * 
     */
    public GetChapterSectionSimpleTreeByPage createGetChapterSectionSimpleTreeByPage() {
        return new GetChapterSectionSimpleTreeByPage();
    }

    /**
     * Create an instance of {@link GetChapterSectionSimpleTreeByPageResponse }
     * 
     */
    public GetChapterSectionSimpleTreeByPageResponse createGetChapterSectionSimpleTreeByPageResponse() {
        return new GetChapterSectionSimpleTreeByPageResponse();
    }

    /**
     * Create an instance of {@link GetChapterSectionSimpleTree }
     * 
     */
    public GetChapterSectionSimpleTree createGetChapterSectionSimpleTree() {
        return new GetChapterSectionSimpleTree();
    }

    /**
     * Create an instance of {@link GetChapterSectionSimpleTreeResponse }
     * 
     */
    public GetChapterSectionSimpleTreeResponse createGetChapterSectionSimpleTreeResponse() {
        return new GetChapterSectionSimpleTreeResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionId }
     * 
     */
    public GetBookVersionId createGetBookVersionId() {
        return new GetBookVersionId();
    }

    /**
     * Create an instance of {@link GetBookVersionIdResponse }
     * 
     */
    public GetBookVersionIdResponse createGetBookVersionIdResponse() {
        return new GetBookVersionIdResponse();
    }

    /**
     * Create an instance of {@link GetBookVersion }
     * 
     */
    public GetBookVersion createGetBookVersion() {
        return new GetBookVersion();
    }

    /**
     * Create an instance of {@link GetBookVersionResponse }
     * 
     */
    public GetBookVersionResponse createGetBookVersionResponse() {
        return new GetBookVersionResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionsByCourse }
     * 
     */
    public GetBookVersionsByCourse createGetBookVersionsByCourse() {
        return new GetBookVersionsByCourse();
    }

    /**
     * Create an instance of {@link GetBookVersionsByCourseResponse }
     * 
     */
    public GetBookVersionsByCourseResponse createGetBookVersionsByCourseResponse() {
        return new GetBookVersionsByCourseResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionInfo }
     * 
     */
    public GetBookVersionInfo createGetBookVersionInfo() {
        return new GetBookVersionInfo();
    }

    /**
     * Create an instance of {@link GetBookVersionInfoResponse }
     * 
     */
    public GetBookVersionInfoResponse createGetBookVersionInfoResponse() {
        return new GetBookVersionInfoResponse();
    }

    /**
     * Create an instance of {@link GetQuestionById }
     * 
     */
    public GetQuestionById createGetQuestionById() {
        return new GetQuestionById();
    }

    /**
     * Create an instance of {@link GetQuestionByIdResponse }
     * 
     */
    public GetQuestionByIdResponse createGetQuestionByIdResponse() {
        return new GetQuestionByIdResponse();
    }

    /**
     * Create an instance of {@link GetQuestionByIdForJava }
     * 
     */
    public GetQuestionByIdForJava createGetQuestionByIdForJava() {
        return new GetQuestionByIdForJava();
    }

    /**
     * Create an instance of {@link GetQuestionByIdForJavaResponse }
     * 
     */
    public GetQuestionByIdForJavaResponse createGetQuestionByIdForJavaResponse() {
        return new GetQuestionByIdForJavaResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsForJava }
     * 
     */
    public GetQuestionsForJava createGetQuestionsForJava() {
        return new GetQuestionsForJava();
    }

    /**
     * Create an instance of {@link GetQuestionsForJavaResponse }
     * 
     */
    public GetQuestionsForJavaResponse createGetQuestionsForJavaResponse() {
        return new GetQuestionsForJavaResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsByFilter }
     * 
     */
    public GetQuestionsByFilter createGetQuestionsByFilter() {
        return new GetQuestionsByFilter();
    }

    /**
     * Create an instance of {@link GetQuestionsByFilterResponse }
     * 
     */
    public GetQuestionsByFilterResponse createGetQuestionsByFilterResponse() {
        return new GetQuestionsByFilterResponse();
    }

    /**
     * Create an instance of {@link GetQuestionStatistics }
     * 
     */
    public GetQuestionStatistics createGetQuestionStatistics() {
        return new GetQuestionStatistics();
    }

    /**
     * Create an instance of {@link GetQuestionStatisticsResponse }
     * 
     */
    public GetQuestionStatisticsResponse createGetQuestionStatisticsResponse() {
        return new GetQuestionStatisticsResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsFromKnowledgePoints }
     * 
     */
    public GetQuestionsFromKnowledgePoints createGetQuestionsFromKnowledgePoints() {
        return new GetQuestionsFromKnowledgePoints();
    }

    /**
     * Create an instance of {@link GetQuestionsFromKnowledgePointsResponse }
     * 
     */
    public GetQuestionsFromKnowledgePointsResponse createGetQuestionsFromKnowledgePointsResponse() {
        return new GetQuestionsFromKnowledgePointsResponse();
    }

    /**
     * Create an instance of {@link SearchQuestions }
     * 
     */
    public SearchQuestions createSearchQuestions() {
        return new SearchQuestions();
    }

    /**
     * Create an instance of {@link SearchQuestionsResponse }
     * 
     */
    public SearchQuestionsResponse createSearchQuestionsResponse() {
        return new SearchQuestionsResponse();
    }

    /**
     * Create an instance of {@link AddQuestion }
     * 
     */
    public AddQuestion createAddQuestion() {
        return new AddQuestion();
    }

    /**
     * Create an instance of {@link AddQuestionResponse }
     * 
     */
    public AddQuestionResponse createAddQuestionResponse() {
        return new AddQuestionResponse();
    }

    /**
     * Create an instance of {@link AddMultipleQuestion }
     * 
     */
    public AddMultipleQuestion createAddMultipleQuestion() {
        return new AddMultipleQuestion();
    }

    /**
     * Create an instance of {@link AddMultipleQuestionResponse }
     * 
     */
    public AddMultipleQuestionResponse createAddMultipleQuestionResponse() {
        return new AddMultipleQuestionResponse();
    }

    /**
     * Create an instance of {@link AddQuestionOnClick }
     * 
     */
    public AddQuestionOnClick createAddQuestionOnClick() {
        return new AddQuestionOnClick();
    }

    /**
     * Create an instance of {@link AddQuestionOnClickResponse }
     * 
     */
    public AddQuestionOnClickResponse createAddQuestionOnClickResponse() {
        return new AddQuestionOnClickResponse();
    }

    /**
     * Create an instance of {@link RemoveQuestion }
     * 
     */
    public RemoveQuestion createRemoveQuestion() {
        return new RemoveQuestion();
    }

    /**
     * Create an instance of {@link RemoveQuestionResponse }
     * 
     */
    public RemoveQuestionResponse createRemoveQuestionResponse() {
        return new RemoveQuestionResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsFromSections }
     * 
     */
    public GetQuestionsFromSections createGetQuestionsFromSections() {
        return new GetQuestionsFromSections();
    }

    /**
     * Create an instance of {@link GetQuestionsFromSectionsResponse }
     * 
     */
    public GetQuestionsFromSectionsResponse createGetQuestionsFromSectionsResponse() {
        return new GetQuestionsFromSectionsResponse();
    }

    /**
     * Create an instance of {@link GetCourseMappings }
     * 
     */
    public GetCourseMappings createGetCourseMappings() {
        return new GetCourseMappings();
    }

    /**
     * Create an instance of {@link GetCourseMappingsResponse }
     * 
     */
    public GetCourseMappingsResponse createGetCourseMappingsResponse() {
        return new GetCourseMappingsResponse();
    }

    /**
     * Create an instance of {@link GetCourseMapping }
     * 
     */
    public GetCourseMapping createGetCourseMapping() {
        return new GetCourseMapping();
    }

    /**
     * Create an instance of {@link GetCourseMappingResponse }
     * 
     */
    public GetCourseMappingResponse createGetCourseMappingResponse() {
        return new GetCourseMappingResponse();
    }

    /**
     * Create an instance of {@link GetChapterSection }
     * 
     */
    public GetChapterSection createGetChapterSection() {
        return new GetChapterSection();
    }

    /**
     * Create an instance of {@link GetChapterSectionResponse }
     * 
     */
    public GetChapterSectionResponse createGetChapterSectionResponse() {
        return new GetChapterSectionResponse();
    }

    /**
     * Create an instance of {@link GetZujuanBasketStatistics }
     * 
     */
    public GetZujuanBasketStatistics createGetZujuanBasketStatistics() {
        return new GetZujuanBasketStatistics();
    }

    /**
     * Create an instance of {@link GetZujuanBasketStatisticsResponse }
     * 
     */
    public GetZujuanBasketStatisticsResponse createGetZujuanBasketStatisticsResponse() {
        return new GetZujuanBasketStatisticsResponse();
    }

    /**
     * Create an instance of {@link RemoveQuestions }
     * 
     */
    public RemoveQuestions createRemoveQuestions() {
        return new RemoveQuestions();
    }

    /**
     * Create an instance of {@link RemoveQuestionsResponse }
     * 
     */
    public RemoveQuestionsResponse createRemoveQuestionsResponse() {
        return new RemoveQuestionsResponse();
    }

    /**
     * Create an instance of {@link Empty }
     * 
     */
    public Empty createEmpty() {
        return new Empty();
    }

    /**
     * Create an instance of {@link EmptyResponse }
     * 
     */
    public EmptyResponse createEmptyResponse() {
        return new EmptyResponse();
    }

    /**
     * Create an instance of {@link GetQuestions }
     * 
     */
    public GetQuestions createGetQuestions() {
        return new GetQuestions();
    }

    /**
     * Create an instance of {@link GetQuestionsResponse }
     * 
     */
    public GetQuestionsResponse createGetQuestionsResponse() {
        return new GetQuestionsResponse();
    }

    /**
     * Create an instance of {@link GetAllBasketQuestion }
     * 
     */
    public GetAllBasketQuestion createGetAllBasketQuestion() {
        return new GetAllBasketQuestion();
    }

    /**
     * Create an instance of {@link GetAllBasketQuestionResponse }
     * 
     */
    public GetAllBasketQuestionResponse createGetAllBasketQuestionResponse() {
        return new GetAllBasketQuestionResponse();
    }

    /**
     * Create an instance of {@link GetChapterList }
     * 
     */
    public GetChapterList createGetChapterList() {
        return new GetChapterList();
    }

    /**
     * Create an instance of {@link GetChapterListResponse }
     * 
     */
    public GetChapterListResponse createGetChapterListResponse() {
        return new GetChapterListResponse();
    }

    /**
     * Create an instance of {@link GetCourseMappingIdBySectionId }
     * 
     */
    public GetCourseMappingIdBySectionId createGetCourseMappingIdBySectionId() {
        return new GetCourseMappingIdBySectionId();
    }

    /**
     * Create an instance of {@link GetCourseMappingIdBySectionIdResponse }
     * 
     */
    public GetCourseMappingIdBySectionIdResponse createGetCourseMappingIdBySectionIdResponse() {
        return new GetCourseMappingIdBySectionIdResponse();
    }

    /**
     * Create an instance of {@link GenerateAutoZujuanQuestions }
     * 
     */
    public GenerateAutoZujuanQuestions createGenerateAutoZujuanQuestions() {
        return new GenerateAutoZujuanQuestions();
    }

    /**
     * Create an instance of {@link GenerateAutoZujuanQuestionsResponse }
     * 
     */
    public GenerateAutoZujuanQuestionsResponse createGenerateAutoZujuanQuestionsResponse() {
        return new GenerateAutoZujuanQuestionsResponse();
    }

    /**
     * Create an instance of {@link SearchCllectionQuestions }
     * 
     */
    public SearchCllectionQuestions createSearchCllectionQuestions() {
        return new SearchCllectionQuestions();
    }

    /**
     * Create an instance of {@link SearchCllectionQuestionsResponse }
     * 
     */
    public SearchCllectionQuestionsResponse createSearchCllectionQuestionsResponse() {
        return new SearchCllectionQuestionsResponse();
    }

    /**
     * Create an instance of {@link GetAllCollectionQuestion }
     * 
     */
    public GetAllCollectionQuestion createGetAllCollectionQuestion() {
        return new GetAllCollectionQuestion();
    }

    /**
     * Create an instance of {@link GetAllCollectionQuestionResponse }
     * 
     */
    public GetAllCollectionQuestionResponse createGetAllCollectionQuestionResponse() {
        return new GetAllCollectionQuestionResponse();
    }

    /**
     * Create an instance of {@link GetExamSetQuestionDistribution }
     * 
     */
    public GetExamSetQuestionDistribution createGetExamSetQuestionDistribution() {
        return new GetExamSetQuestionDistribution();
    }

    /**
     * Create an instance of {@link GetExamSetQuestionDistributionResponse }
     * 
     */
    public GetExamSetQuestionDistributionResponse createGetExamSetQuestionDistributionResponse() {
        return new GetExamSetQuestionDistributionResponse();
    }

    /**
     * Create an instance of {@link SetPreviewConfigSession }
     * 
     */
    public SetPreviewConfigSession createSetPreviewConfigSession() {
        return new SetPreviewConfigSession();
    }

    /**
     * Create an instance of {@link SetPreviewConfigSessionResponse }
     * 
     */
    public SetPreviewConfigSessionResponse createSetPreviewConfigSessionResponse() {
        return new SetPreviewConfigSessionResponse();
    }

    /**
     * Create an instance of {@link RemovePreviewConfigSession }
     * 
     */
    public RemovePreviewConfigSession createRemovePreviewConfigSession() {
        return new RemovePreviewConfigSession();
    }

    /**
     * Create an instance of {@link RemovePreviewConfigSessionResponse }
     * 
     */
    public RemovePreviewConfigSessionResponse createRemovePreviewConfigSessionResponse() {
        return new RemovePreviewConfigSessionResponse();
    }

    /**
     * Create an instance of {@link GetPreviewConfigSession }
     * 
     */
    public GetPreviewConfigSession createGetPreviewConfigSession() {
        return new GetPreviewConfigSession();
    }

    /**
     * Create an instance of {@link GetPreviewConfigSessionResponse }
     * 
     */
    public GetPreviewConfigSessionResponse createGetPreviewConfigSessionResponse() {
        return new GetPreviewConfigSessionResponse();
    }

    /**
     * Create an instance of {@link GetExamSetQuestionSection }
     * 
     */
    public GetExamSetQuestionSection createGetExamSetQuestionSection() {
        return new GetExamSetQuestionSection();
    }

    /**
     * Create an instance of {@link GetExamSetQuestionSectionResponse }
     * 
     */
    public GetExamSetQuestionSectionResponse createGetExamSetQuestionSectionResponse() {
        return new GetExamSetQuestionSectionResponse();
    }

    /**
     * Create an instance of {@link GetCourseMappingsByCourseId }
     * 
     */
    public GetCourseMappingsByCourseId createGetCourseMappingsByCourseId() {
        return new GetCourseMappingsByCourseId();
    }

    /**
     * Create an instance of {@link GetCourseMappingsByCourseIdResponse }
     * 
     */
    public GetCourseMappingsByCourseIdResponse createGetCourseMappingsByCourseIdResponse() {
        return new GetCourseMappingsByCourseIdResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionByCourse }
     * 
     */
    public GetBookVersionByCourse createGetBookVersionByCourse() {
        return new GetBookVersionByCourse();
    }

    /**
     * Create an instance of {@link GetBookVersionByCourseResponse }
     * 
     */
    public GetBookVersionByCourseResponse createGetBookVersionByCourseResponse() {
        return new GetBookVersionByCourseResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionByUserId }
     * 
     */
    public GetBookVersionByUserId createGetBookVersionByUserId() {
        return new GetBookVersionByUserId();
    }

    /**
     * Create an instance of {@link GetBookVersionByUserIdResponse }
     * 
     */
    public GetBookVersionByUserIdResponse createGetBookVersionByUserIdResponse() {
        return new GetBookVersionByUserIdResponse();
    }

    /**
     * Create an instance of {@link GenerateOneClickTestPaperQuestions }
     * 
     */
    public GenerateOneClickTestPaperQuestions createGenerateOneClickTestPaperQuestions() {
        return new GenerateOneClickTestPaperQuestions();
    }

    /**
     * Create an instance of {@link GenerateOneClickTestPaperQuestionsResponse }
     * 
     */
    public GenerateOneClickTestPaperQuestionsResponse createGenerateOneClickTestPaperQuestionsResponse() {
        return new GenerateOneClickTestPaperQuestionsResponse();
    }

    /**
     * Create an instance of {@link GetCourseQuestionCount }
     * 
     */
    public GetCourseQuestionCount createGetCourseQuestionCount() {
        return new GetCourseQuestionCount();
    }

    /**
     * Create an instance of {@link GetCourseQuestionCountResponse }
     * 
     */
    public GetCourseQuestionCountResponse createGetCourseQuestionCountResponse() {
        return new GetCourseQuestionCountResponse();
    }

    /**
     * Create an instance of {@link GetHasQuestionBookVersion }
     * 
     */
    public GetHasQuestionBookVersion createGetHasQuestionBookVersion() {
        return new GetHasQuestionBookVersion();
    }

    /**
     * Create an instance of {@link GetHasQuestionBookVersionResponse }
     * 
     */
    public GetHasQuestionBookVersionResponse createGetHasQuestionBookVersionResponse() {
        return new GetHasQuestionBookVersionResponse();
    }

    /**
     * Create an instance of {@link GetFirstLevelChildrenKnowledgePointByQuestionSummary }
     * 
     */
    public GetFirstLevelChildrenKnowledgePointByQuestionSummary createGetFirstLevelChildrenKnowledgePointByQuestionSummary() {
        return new GetFirstLevelChildrenKnowledgePointByQuestionSummary();
    }

    /**
     * Create an instance of {@link GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponse }
     * 
     */
    public GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponse createGetFirstLevelChildrenKnowledgePointByQuestionSummaryResponse() {
        return new GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponse();
    }

    /**
     * Create an instance of {@link GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2 }
     * 
     */
    public GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2 createGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2() {
        return new GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2();
    }

    /**
     * Create an instance of {@link GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Response }
     * 
     */
    public GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Response createGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Response() {
        return new GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Response();
    }

    /**
     * Create an instance of {@link GetQuestionFaultTypes }
     * 
     */
    public GetQuestionFaultTypes createGetQuestionFaultTypes() {
        return new GetQuestionFaultTypes();
    }

    /**
     * Create an instance of {@link GetQuestionFaultTypesResponse }
     * 
     */
    public GetQuestionFaultTypesResponse createGetQuestionFaultTypesResponse() {
        return new GetQuestionFaultTypesResponse();
    }

    /**
     * Create an instance of {@link GetKnowledgePointQuestionCount }
     * 
     */
    public GetKnowledgePointQuestionCount createGetKnowledgePointQuestionCount() {
        return new GetKnowledgePointQuestionCount();
    }

    /**
     * Create an instance of {@link GetKnowledgePointQuestionCountResponse }
     * 
     */
    public GetKnowledgePointQuestionCountResponse createGetKnowledgePointQuestionCountResponse() {
        return new GetKnowledgePointQuestionCountResponse();
    }

    /**
     * Create an instance of {@link GetAllPublishers }
     * 
     */
    public GetAllPublishers createGetAllPublishers() {
        return new GetAllPublishers();
    }

    /**
     * Create an instance of {@link GetAllPublishersResponse }
     * 
     */
    public GetAllPublishersResponse createGetAllPublishersResponse() {
        return new GetAllPublishersResponse();
    }

    /**
     * Create an instance of {@link GetSchoolBookVersion }
     * 
     */
    public GetSchoolBookVersion createGetSchoolBookVersion() {
        return new GetSchoolBookVersion();
    }

    /**
     * Create an instance of {@link GetSchoolBookVersionResponse }
     * 
     */
    public GetSchoolBookVersionResponse createGetSchoolBookVersionResponse() {
        return new GetSchoolBookVersionResponse();
    }

    /**
     * Create an instance of {@link GetGetQuestionDisplayTypes }
     * 
     */
    public GetGetQuestionDisplayTypes createGetGetQuestionDisplayTypes() {
        return new GetGetQuestionDisplayTypes();
    }

    /**
     * Create an instance of {@link GetGetQuestionDisplayTypesResponse }
     * 
     */
    public GetGetQuestionDisplayTypesResponse createGetGetQuestionDisplayTypesResponse() {
        return new GetGetQuestionDisplayTypesResponse();
    }

    /**
     * Create an instance of {@link GetExamUsageRulerView }
     * 
     */
    public GetExamUsageRulerView createGetExamUsageRulerView() {
        return new GetExamUsageRulerView();
    }

    /**
     * Create an instance of {@link GetExamUsageRulerViewResponse }
     * 
     */
    public GetExamUsageRulerViewResponse createGetExamUsageRulerViewResponse() {
        return new GetExamUsageRulerViewResponse();
    }

    /**
     * Create an instance of {@link GetHasQuestionBookVersionViewsByCourseId }
     * 
     */
    public GetHasQuestionBookVersionViewsByCourseId createGetHasQuestionBookVersionViewsByCourseId() {
        return new GetHasQuestionBookVersionViewsByCourseId();
    }

    /**
     * Create an instance of {@link GetHasQuestionBookVersionViewsByCourseIdResponse }
     * 
     */
    public GetHasQuestionBookVersionViewsByCourseIdResponse createGetHasQuestionBookVersionViewsByCourseIdResponse() {
        return new GetHasQuestionBookVersionViewsByCourseIdResponse();
    }

    /**
     * Create an instance of {@link GetQuestionReportModel }
     * 
     */
    public GetQuestionReportModel createGetQuestionReportModel() {
        return new GetQuestionReportModel();
    }

    /**
     * Create an instance of {@link GetQuestionReportModelResponse }
     * 
     */
    public GetQuestionReportModelResponse createGetQuestionReportModelResponse() {
        return new GetQuestionReportModelResponse();
    }

    /**
     * Create an instance of {@link GetExamRuler }
     * 
     */
    public GetExamRuler createGetExamRuler() {
        return new GetExamRuler();
    }

    /**
     * Create an instance of {@link GetExamRulerResponse }
     * 
     */
    public GetExamRulerResponse createGetExamRulerResponse() {
        return new GetExamRulerResponse();
    }

    /**
     * Create an instance of {@link GetAllExamUsageRulers }
     * 
     */
    public GetAllExamUsageRulers createGetAllExamUsageRulers() {
        return new GetAllExamUsageRulers();
    }

    /**
     * Create an instance of {@link GetAllExamUsageRulersResponse }
     * 
     */
    public GetAllExamUsageRulersResponse createGetAllExamUsageRulersResponse() {
        return new GetAllExamUsageRulersResponse();
    }

    /**
     * Create an instance of {@link GetExamUsageRuler }
     * 
     */
    public GetExamUsageRuler createGetExamUsageRuler() {
        return new GetExamUsageRuler();
    }

    /**
     * Create an instance of {@link GetExamUsageRulerResponse }
     * 
     */
    public GetExamUsageRulerResponse createGetExamUsageRulerResponse() {
        return new GetExamUsageRulerResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsFromCourseMappingAll }
     * 
     */
    public GetQuestionsFromCourseMappingAll createGetQuestionsFromCourseMappingAll() {
        return new GetQuestionsFromCourseMappingAll();
    }

    /**
     * Create an instance of {@link GetQuestionsFromCourseMappingAllResponse }
     * 
     */
    public GetQuestionsFromCourseMappingAllResponse createGetQuestionsFromCourseMappingAllResponse() {
        return new GetQuestionsFromCourseMappingAllResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsFromKnowledgePointsAll }
     * 
     */
    public GetQuestionsFromKnowledgePointsAll createGetQuestionsFromKnowledgePointsAll() {
        return new GetQuestionsFromKnowledgePointsAll();
    }

    /**
     * Create an instance of {@link GetQuestionsFromKnowledgePointsAllResponse }
     * 
     */
    public GetQuestionsFromKnowledgePointsAllResponse createGetQuestionsFromKnowledgePointsAllResponse() {
        return new GetQuestionsFromKnowledgePointsAllResponse();
    }

    /**
     * Create an instance of {@link GetQuestionStatisticsList }
     * 
     */
    public GetQuestionStatisticsList createGetQuestionStatisticsList() {
        return new GetQuestionStatisticsList();
    }

    /**
     * Create an instance of {@link GetQuestionStatisticsListResponse }
     * 
     */
    public GetQuestionStatisticsListResponse createGetQuestionStatisticsListResponse() {
        return new GetQuestionStatisticsListResponse();
    }

    /**
     * Create an instance of {@link GetQuestionLabels }
     * 
     */
    public GetQuestionLabels createGetQuestionLabels() {
        return new GetQuestionLabels();
    }

    /**
     * Create an instance of {@link GetQuestionLabelsResponse }
     * 
     */
    public GetQuestionLabelsResponse createGetQuestionLabelsResponse() {
        return new GetQuestionLabelsResponse();
    }

    /**
     * Create an instance of {@link GetBookVersions }
     * 
     */
    public GetBookVersions createGetBookVersions() {
        return new GetBookVersions();
    }

    /**
     * Create an instance of {@link GetBookVersionsResponse }
     * 
     */
    public GetBookVersionsResponse createGetBookVersionsResponse() {
        return new GetBookVersionsResponse();
    }

    /**
     * Create an instance of {@link GetAllCourseMappings }
     * 
     */
    public GetAllCourseMappings createGetAllCourseMappings() {
        return new GetAllCourseMappings();
    }

    /**
     * Create an instance of {@link GetAllCourseMappingsResponse }
     * 
     */
    public GetAllCourseMappingsResponse createGetAllCourseMappingsResponse() {
        return new GetAllCourseMappingsResponse();
    }

    /**
     * Create an instance of {@link GetChapterSections }
     * 
     */
    public GetChapterSections createGetChapterSections() {
        return new GetChapterSections();
    }

    /**
     * Create an instance of {@link GetChapterSectionsResponse }
     * 
     */
    public GetChapterSectionsResponse createGetChapterSectionsResponse() {
        return new GetChapterSectionsResponse();
    }

    /**
     * Create an instance of {@link GetParentChapterSections }
     * 
     */
    public GetParentChapterSections createGetParentChapterSections() {
        return new GetParentChapterSections();
    }

    /**
     * Create an instance of {@link GetParentChapterSectionsResponse }
     * 
     */
    public GetParentChapterSectionsResponse createGetParentChapterSectionsResponse() {
        return new GetParentChapterSectionsResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionChapterSections }
     * 
     */
    public GetBookVersionChapterSections createGetBookVersionChapterSections() {
        return new GetBookVersionChapterSections();
    }

    /**
     * Create an instance of {@link GetBookVersionChapterSectionsResponse }
     * 
     */
    public GetBookVersionChapterSectionsResponse createGetBookVersionChapterSectionsResponse() {
        return new GetBookVersionChapterSectionsResponse();
    }

    /**
     * Create an instance of {@link GetAllQuestionCategories }
     * 
     */
    public GetAllQuestionCategories createGetAllQuestionCategories() {
        return new GetAllQuestionCategories();
    }

    /**
     * Create an instance of {@link GetAllQuestionCategoriesResponse }
     * 
     */
    public GetAllQuestionCategoriesResponse createGetAllQuestionCategoriesResponse() {
        return new GetAllQuestionCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetQuestionCategoriesCheckOnlineNew }
     * 
     */
    public GetQuestionCategoriesCheckOnlineNew createGetQuestionCategoriesCheckOnlineNew() {
        return new GetQuestionCategoriesCheckOnlineNew();
    }

    /**
     * Create an instance of {@link GetQuestionCategoriesCheckOnlineNewResponse }
     * 
     */
    public GetQuestionCategoriesCheckOnlineNewResponse createGetQuestionCategoriesCheckOnlineNewResponse() {
        return new GetQuestionCategoriesCheckOnlineNewResponse();
    }

    /**
     * Create an instance of {@link GetRootQuestionCategoriesCheckOnline }
     * 
     */
    public GetRootQuestionCategoriesCheckOnline createGetRootQuestionCategoriesCheckOnline() {
        return new GetRootQuestionCategoriesCheckOnline();
    }

    /**
     * Create an instance of {@link GetRootQuestionCategoriesCheckOnlineResponse }
     * 
     */
    public GetRootQuestionCategoriesCheckOnlineResponse createGetRootQuestionCategoriesCheckOnlineResponse() {
        return new GetRootQuestionCategoriesCheckOnlineResponse();
    }

    /**
     * Create an instance of {@link GetQuestionCategoryModels }
     * 
     */
    public GetQuestionCategoryModels createGetQuestionCategoryModels() {
        return new GetQuestionCategoryModels();
    }

    /**
     * Create an instance of {@link GetQuestionCategoryModelsResponse }
     * 
     */
    public GetQuestionCategoryModelsResponse createGetQuestionCategoryModelsResponse() {
        return new GetQuestionCategoryModelsResponse();
    }

    /**
     * Create an instance of {@link GetAllBookVersions }
     * 
     */
    public GetAllBookVersions createGetAllBookVersions() {
        return new GetAllBookVersions();
    }

    /**
     * Create an instance of {@link GetAllBookVersionsResponse }
     * 
     */
    public GetAllBookVersionsResponse createGetAllBookVersionsResponse() {
        return new GetAllBookVersionsResponse();
    }

    /**
     * Create an instance of {@link GetQuestionDisplayType }
     * 
     */
    public GetQuestionDisplayType createGetQuestionDisplayType() {
        return new GetQuestionDisplayType();
    }

    /**
     * Create an instance of {@link GetQuestionDisplayTypeResponse }
     * 
     */
    public GetQuestionDisplayTypeResponse createGetQuestionDisplayTypeResponse() {
        return new GetQuestionDisplayTypeResponse();
    }

    /**
     * Create an instance of {@link GetCourseAllChapterSections }
     * 
     */
    public GetCourseAllChapterSections createGetCourseAllChapterSections() {
        return new GetCourseAllChapterSections();
    }

    /**
     * Create an instance of {@link GetCourseAllChapterSectionsResponse }
     * 
     */
    public GetCourseAllChapterSectionsResponse createGetCourseAllChapterSectionsResponse() {
        return new GetCourseAllChapterSectionsResponse();
    }

    /**
     * Create an instance of {@link GetCoursePreKnowledgePoints }
     * 
     */
    public GetCoursePreKnowledgePoints createGetCoursePreKnowledgePoints() {
        return new GetCoursePreKnowledgePoints();
    }

    /**
     * Create an instance of {@link GetCoursePreKnowledgePointsResponse }
     * 
     */
    public GetCoursePreKnowledgePointsResponse createGetCoursePreKnowledgePointsResponse() {
        return new GetCoursePreKnowledgePointsResponse();
    }

    /**
     * Create an instance of {@link GetChapterSectionKnowledgeMappingByCourseId }
     * 
     */
    public GetChapterSectionKnowledgeMappingByCourseId createGetChapterSectionKnowledgeMappingByCourseId() {
        return new GetChapterSectionKnowledgeMappingByCourseId();
    }

    /**
     * Create an instance of {@link GetChapterSectionKnowledgeMappingByCourseIdResponse }
     * 
     */
    public GetChapterSectionKnowledgeMappingByCourseIdResponse createGetChapterSectionKnowledgeMappingByCourseIdResponse() {
        return new GetChapterSectionKnowledgeMappingByCourseIdResponse();
    }

    /**
     * Create an instance of {@link GetOnlineQuestions }
     * 
     */
    public GetOnlineQuestions createGetOnlineQuestions() {
        return new GetOnlineQuestions();
    }

    /**
     * Create an instance of {@link GetOnlineQuestionsResponse }
     * 
     */
    public GetOnlineQuestionsResponse createGetOnlineQuestionsResponse() {
        return new GetOnlineQuestionsResponse();
    }

    /**
     * Create an instance of {@link GetOnlineQuestionsForKnowledgePoint }
     * 
     */
    public GetOnlineQuestionsForKnowledgePoint createGetOnlineQuestionsForKnowledgePoint() {
        return new GetOnlineQuestionsForKnowledgePoint();
    }

    /**
     * Create an instance of {@link GetOnlineQuestionsForKnowledgePointResponse }
     * 
     */
    public GetOnlineQuestionsForKnowledgePointResponse createGetOnlineQuestionsForKnowledgePointResponse() {
        return new GetOnlineQuestionsForKnowledgePointResponse();
    }

    /**
     * Create an instance of {@link GetBookVersionQuestionCount }
     * 
     */
    public GetBookVersionQuestionCount createGetBookVersionQuestionCount() {
        return new GetBookVersionQuestionCount();
    }

    /**
     * Create an instance of {@link GetBookVersionQuestionCountResponse }
     * 
     */
    public GetBookVersionQuestionCountResponse createGetBookVersionQuestionCountResponse() {
        return new GetBookVersionQuestionCountResponse();
    }

    /**
     * Create an instance of {@link GetCourseAllQuestionCount }
     * 
     */
    public GetCourseAllQuestionCount createGetCourseAllQuestionCount() {
        return new GetCourseAllQuestionCount();
    }

    /**
     * Create an instance of {@link GetCourseAllQuestionCountResponse }
     * 
     */
    public GetCourseAllQuestionCountResponse createGetCourseAllQuestionCountResponse() {
        return new GetCourseAllQuestionCountResponse();
    }

    /**
     * Create an instance of {@link GetSimilarQuestionList }
     * 
     */
    public GetSimilarQuestionList createGetSimilarQuestionList() {
        return new GetSimilarQuestionList();
    }

    /**
     * Create an instance of {@link GetSimilarQuestionListResponse }
     * 
     */
    public GetSimilarQuestionListResponse createGetSimilarQuestionListResponse() {
        return new GetSimilarQuestionListResponse();
    }

    /**
     * Create an instance of {@link GetClassRoomEvaluationDefaultSelected }
     * 
     */
    public GetClassRoomEvaluationDefaultSelected createGetClassRoomEvaluationDefaultSelected() {
        return new GetClassRoomEvaluationDefaultSelected();
    }

    /**
     * Create an instance of {@link GetClassRoomEvaluationDefaultSelectedResponse }
     * 
     */
    public GetClassRoomEvaluationDefaultSelectedResponse createGetClassRoomEvaluationDefaultSelectedResponse() {
        return new GetClassRoomEvaluationDefaultSelectedResponse();
    }

    /**
     * Create an instance of {@link CheckSCPQuestion }
     * 
     */
    public CheckSCPQuestion createCheckSCPQuestion() {
        return new CheckSCPQuestion();
    }

    /**
     * Create an instance of {@link CheckSCPQuestionResponse }
     * 
     */
    public CheckSCPQuestionResponse createCheckSCPQuestionResponse() {
        return new CheckSCPQuestionResponse();
    }

    /**
     * Create an instance of {@link GetSCPQuestionDetails }
     * 
     */
    public GetSCPQuestionDetails createGetSCPQuestionDetails() {
        return new GetSCPQuestionDetails();
    }

    /**
     * Create an instance of {@link GetSCPQuestionDetailsResponse }
     * 
     */
    public GetSCPQuestionDetailsResponse createGetSCPQuestionDetailsResponse() {
        return new GetSCPQuestionDetailsResponse();
    }

    /**
     * Create an instance of {@link GetQuestionSectionDistribution }
     * 
     */
    public GetQuestionSectionDistribution createGetQuestionSectionDistribution() {
        return new GetQuestionSectionDistribution();
    }

    /**
     * Create an instance of {@link GetQuestionSectionDistributionResponse }
     * 
     */
    public GetQuestionSectionDistributionResponse createGetQuestionSectionDistributionResponse() {
        return new GetQuestionSectionDistributionResponse();
    }

    /**
     * Create an instance of {@link GetQuestionKnowledgePointDistribution }
     * 
     */
    public GetQuestionKnowledgePointDistribution createGetQuestionKnowledgePointDistribution() {
        return new GetQuestionKnowledgePointDistribution();
    }

    /**
     * Create an instance of {@link GetQuestionKnowledgePointDistributionResponse }
     * 
     */
    public GetQuestionKnowledgePointDistributionResponse createGetQuestionKnowledgePointDistributionResponse() {
        return new GetQuestionKnowledgePointDistributionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionCategoryByIdResult", scope = GetQuestionCategoryByIdResponse.class)
    public JAXBElement<QuestionCategory> createGetQuestionCategoryByIdResponseGetQuestionCategoryByIdResult(QuestionCategory value) {
        return new JAXBElement<QuestionCategory>(_GetQuestionCategoryByIdResponseGetQuestionCategoryByIdResult_QNAME, QuestionCategory.class, GetQuestionCategoryByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionCategoriesResult", scope = GetQuestionCategoriesResponse.class)
    public JAXBElement<ArrayOfQuestionCategory> createGetQuestionCategoriesResponseGetQuestionCategoriesResult(ArrayOfQuestionCategory value) {
        return new JAXBElement<ArrayOfQuestionCategory>(_GetQuestionCategoriesResponseGetQuestionCategoriesResult_QNAME, ArrayOfQuestionCategory.class, GetQuestionCategoriesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionCategoriesCheckOnlineResult", scope = GetQuestionCategoriesCheckOnlineResponse.class)
    public JAXBElement<ArrayOfQuestionCategory> createGetQuestionCategoriesCheckOnlineResponseGetQuestionCategoriesCheckOnlineResult(ArrayOfQuestionCategory value) {
        return new JAXBElement<ArrayOfQuestionCategory>(_GetQuestionCategoriesCheckOnlineResponseGetQuestionCategoriesCheckOnlineResult_QNAME, ArrayOfQuestionCategory.class, GetQuestionCategoriesCheckOnlineResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetKnowledgePointSimpleTreeResult", scope = GetKnowledgePointSimpleTreeResponse.class)
    public JAXBElement<SimpleTree> createGetKnowledgePointSimpleTreeResponseGetKnowledgePointSimpleTreeResult(SimpleTree value) {
        return new JAXBElement<SimpleTree>(_GetKnowledgePointSimpleTreeResponseGetKnowledgePointSimpleTreeResult_QNAME, SimpleTree.class, GetKnowledgePointSimpleTreeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetKnowledgePointsResult", scope = GetKnowledgePointsResponse.class)
    public JAXBElement<KnowledgePointList> createGetKnowledgePointsResponseGetKnowledgePointsResult(KnowledgePointList value) {
        return new JAXBElement<KnowledgePointList>(_GetKnowledgePointsResponseGetKnowledgePointsResult_QNAME, KnowledgePointList.class, GetKnowledgePointsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChapterSectionSimpleTreeByPageResult", scope = GetChapterSectionSimpleTreeByPageResponse.class)
    public JAXBElement<SimpleTree> createGetChapterSectionSimpleTreeByPageResponseGetChapterSectionSimpleTreeByPageResult(SimpleTree value) {
        return new JAXBElement<SimpleTree>(_GetChapterSectionSimpleTreeByPageResponseGetChapterSectionSimpleTreeByPageResult_QNAME, SimpleTree.class, GetChapterSectionSimpleTreeByPageResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChapterSectionSimpleTreeResult", scope = GetChapterSectionSimpleTreeResponse.class)
    public JAXBElement<SimpleTree> createGetChapterSectionSimpleTreeResponseGetChapterSectionSimpleTreeResult(SimpleTree value) {
        return new JAXBElement<SimpleTree>(_GetChapterSectionSimpleTreeResponseGetChapterSectionSimpleTreeResult_QNAME, SimpleTree.class, GetChapterSectionSimpleTreeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionResult", scope = GetBookVersionResponse.class)
    public JAXBElement<ArrayOfBookVersion> createGetBookVersionResponseGetBookVersionResult(ArrayOfBookVersion value) {
        return new JAXBElement<ArrayOfBookVersion>(_GetBookVersionResponseGetBookVersionResult_QNAME, ArrayOfBookVersion.class, GetBookVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionsByCourseResult", scope = GetBookVersionsByCourseResponse.class)
    public JAXBElement<ArrayOfBookVersion> createGetBookVersionsByCourseResponseGetBookVersionsByCourseResult(ArrayOfBookVersion value) {
        return new JAXBElement<ArrayOfBookVersion>(_GetBookVersionsByCourseResponseGetBookVersionsByCourseResult_QNAME, ArrayOfBookVersion.class, GetBookVersionsByCourseResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionInfoResult", scope = GetBookVersionInfoResponse.class)
    public JAXBElement<BookVersion> createGetBookVersionInfoResponseGetBookVersionInfoResult(BookVersion value) {
        return new JAXBElement<BookVersion>(_GetBookVersionInfoResponseGetBookVersionInfoResult_QNAME, BookVersion.class, GetBookVersionInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionByIdResult", scope = GetQuestionByIdResponse.class)
    public JAXBElement<Question> createGetQuestionByIdResponseGetQuestionByIdResult(Question value) {
        return new JAXBElement<Question>(_GetQuestionByIdResponseGetQuestionByIdResult_QNAME, Question.class, GetQuestionByIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionByIdForJavaResult", scope = GetQuestionByIdForJavaResponse.class)
    public JAXBElement<Question> createGetQuestionByIdForJavaResponseGetQuestionByIdForJavaResult(Question value) {
        return new JAXBElement<Question>(_GetQuestionByIdForJavaResponseGetQuestionByIdForJavaResult_QNAME, Question.class, GetQuestionByIdForJavaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "questionIds", scope = GetQuestionsForJava.class)
    public JAXBElement<ArrayOfint> createGetQuestionsForJavaQuestionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionsForJavaQuestionIds_QNAME, ArrayOfint.class, GetQuestionsForJava.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsForJavaResult", scope = GetQuestionsForJavaResponse.class)
    public JAXBElement<ArrayOfQuestion> createGetQuestionsForJavaResponseGetQuestionsForJavaResult(ArrayOfQuestion value) {
        return new JAXBElement<ArrayOfQuestion>(_GetQuestionsForJavaResponseGetQuestionsForJavaResult_QNAME, ArrayOfQuestion.class, GetQuestionsForJavaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "questionIds", scope = GetQuestionsByFilter.class)
    public JAXBElement<ArrayOfint> createGetQuestionsByFilterQuestionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionsForJavaQuestionIds_QNAME, ArrayOfint.class, GetQuestionsByFilter.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsByFilterResult", scope = GetQuestionsByFilterResponse.class)
    public JAXBElement<ArrayOfQuestion> createGetQuestionsByFilterResponseGetQuestionsByFilterResult(ArrayOfQuestion value) {
        return new JAXBElement<ArrayOfQuestion>(_GetQuestionsByFilterResponseGetQuestionsByFilterResult_QNAME, ArrayOfQuestion.class, GetQuestionsByFilterResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionStatistics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionStatisticsResult", scope = GetQuestionStatisticsResponse.class)
    public JAXBElement<QuestionStatistics> createGetQuestionStatisticsResponseGetQuestionStatisticsResult(QuestionStatistics value) {
        return new JAXBElement<QuestionStatistics>(_GetQuestionStatisticsResponseGetQuestionStatisticsResult_QNAME, QuestionStatistics.class, GetQuestionStatisticsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsFromKnowledgePointsResult", scope = GetQuestionsFromKnowledgePointsResponse.class)
    public JAXBElement<QuestionListView> createGetQuestionsFromKnowledgePointsResponseGetQuestionsFromKnowledgePointsResult(QuestionListView value) {
        return new JAXBElement<QuestionListView>(_GetQuestionsFromKnowledgePointsResponseGetQuestionsFromKnowledgePointsResult_QNAME, QuestionListView.class, GetQuestionsFromKnowledgePointsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "keyword", scope = SearchQuestions.class)
    public JAXBElement<String> createSearchQuestionsKeyword(String value) {
        return new JAXBElement<String>(_SearchQuestionsKeyword_QNAME, String.class, SearchQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SearchQuestionsResult", scope = SearchQuestionsResponse.class)
    public JAXBElement<QuestionListView> createSearchQuestionsResponseSearchQuestionsResult(QuestionListView value) {
        return new JAXBElement<QuestionListView>(_SearchQuestionsResponseSearchQuestionsResult_QNAME, QuestionListView.class, SearchQuestionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = AddQuestion.class)
    public JAXBElement<String> createAddQuestionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, AddQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AddQuestionResult", scope = AddQuestionResponse.class)
    public JAXBElement<String> createAddQuestionResponseAddQuestionResult(String value) {
        return new JAXBElement<String>(_AddQuestionResponseAddQuestionResult_QNAME, String.class, AddQuestionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = AddMultipleQuestion.class)
    public JAXBElement<String> createAddMultipleQuestionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, AddMultipleQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "questionIds", scope = AddMultipleQuestion.class)
    public JAXBElement<ArrayOfstring> createAddMultipleQuestionQuestionIds(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetQuestionsForJavaQuestionIds_QNAME, ArrayOfstring.class, AddMultipleQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AddMultipleQuestionResult", scope = AddMultipleQuestionResponse.class)
    public JAXBElement<String> createAddMultipleQuestionResponseAddMultipleQuestionResult(String value) {
        return new JAXBElement<String>(_AddMultipleQuestionResponseAddMultipleQuestionResult_QNAME, String.class, AddMultipleQuestionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = AddQuestionOnClick.class)
    public JAXBElement<String> createAddQuestionOnClickSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, AddQuestionOnClick.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "question", scope = AddQuestionOnClick.class)
    public JAXBElement<ArrayOfQuestionSimplifiedFormat> createAddQuestionOnClickQuestion(ArrayOfQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfQuestionSimplifiedFormat>(_AddQuestionOnClickQuestion_QNAME, ArrayOfQuestionSimplifiedFormat.class, AddQuestionOnClick.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = RemoveQuestion.class)
    public JAXBElement<String> createRemoveQuestionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, RemoveQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsFromSectionsResult", scope = GetQuestionsFromSectionsResponse.class)
    public JAXBElement<QuestionListView> createGetQuestionsFromSectionsResponseGetQuestionsFromSectionsResult(QuestionListView value) {
        return new JAXBElement<QuestionListView>(_GetQuestionsFromSectionsResponseGetQuestionsFromSectionsResult_QNAME, QuestionListView.class, GetQuestionsFromSectionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCourseMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCourseMappingsResult", scope = GetCourseMappingsResponse.class)
    public JAXBElement<ArrayOfCourseMapping> createGetCourseMappingsResponseGetCourseMappingsResult(ArrayOfCourseMapping value) {
        return new JAXBElement<ArrayOfCourseMapping>(_GetCourseMappingsResponseGetCourseMappingsResult_QNAME, ArrayOfCourseMapping.class, GetCourseMappingsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourseMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCourseMappingResult", scope = GetCourseMappingResponse.class)
    public JAXBElement<CourseMapping> createGetCourseMappingResponseGetCourseMappingResult(CourseMapping value) {
        return new JAXBElement<CourseMapping>(_GetCourseMappingResponseGetCourseMappingResult_QNAME, CourseMapping.class, GetCourseMappingResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChapterSectionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChapterSectionResult", scope = GetChapterSectionResponse.class)
    public JAXBElement<ChapterSectionView> createGetChapterSectionResponseGetChapterSectionResult(ChapterSectionView value) {
        return new JAXBElement<ChapterSectionView>(_GetChapterSectionResponseGetChapterSectionResult_QNAME, ChapterSectionView.class, GetChapterSectionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = GetZujuanBasketStatistics.class)
    public JAXBElement<String> createGetZujuanBasketStatisticsSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, GetZujuanBasketStatistics.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfZujuanBasketQuestionCategoryStatisticsView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetZujuanBasketStatisticsResult", scope = GetZujuanBasketStatisticsResponse.class)
    public JAXBElement<ArrayOfZujuanBasketQuestionCategoryStatisticsView> createGetZujuanBasketStatisticsResponseGetZujuanBasketStatisticsResult(ArrayOfZujuanBasketQuestionCategoryStatisticsView value) {
        return new JAXBElement<ArrayOfZujuanBasketQuestionCategoryStatisticsView>(_GetZujuanBasketStatisticsResponseGetZujuanBasketStatisticsResult_QNAME, ArrayOfZujuanBasketQuestionCategoryStatisticsView.class, GetZujuanBasketStatisticsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = RemoveQuestions.class)
    public JAXBElement<String> createRemoveQuestionsSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, RemoveQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = Empty.class)
    public JAXBElement<String> createEmptySessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, Empty.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "questionIds", scope = GetQuestions.class)
    public JAXBElement<ArrayOfint> createGetQuestionsQuestionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionsForJavaQuestionIds_QNAME, ArrayOfint.class, GetQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsResult", scope = GetQuestionsResponse.class)
    public JAXBElement<ArrayOfQuestion> createGetQuestionsResponseGetQuestionsResult(ArrayOfQuestion value) {
        return new JAXBElement<ArrayOfQuestion>(_GetQuestionsResponseGetQuestionsResult_QNAME, ArrayOfQuestion.class, GetQuestionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = GetAllBasketQuestion.class)
    public JAXBElement<String> createGetAllBasketQuestionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, GetAllBasketQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllBasketQuestionResult", scope = GetAllBasketQuestionResponse.class)
    public JAXBElement<ArrayOfint> createGetAllBasketQuestionResponseGetAllBasketQuestionResult(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetAllBasketQuestionResponseGetAllBasketQuestionResult_QNAME, ArrayOfint.class, GetAllBasketQuestionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfChapterSectionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChapterListResult", scope = GetChapterListResponse.class)
    public JAXBElement<ArrayOfChapterSectionView> createGetChapterListResponseGetChapterListResult(ArrayOfChapterSectionView value) {
        return new JAXBElement<ArrayOfChapterSectionView>(_GetChapterListResponseGetChapterListResult_QNAME, ArrayOfChapterSectionView.class, GetChapterListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourseMappingIdBySectionIdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetCourseMappingIdBySectionId.class)
    public JAXBElement<GetCourseMappingIdBySectionIdRequest> createGetCourseMappingIdBySectionIdRequest(GetCourseMappingIdBySectionIdRequest value) {
        return new JAXBElement<GetCourseMappingIdBySectionIdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetCourseMappingIdBySectionIdRequest.class, GetCourseMappingIdBySectionId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutoZujuanCreationRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GenerateAutoZujuanQuestions.class)
    public JAXBElement<AutoZujuanCreationRequest> createGenerateAutoZujuanQuestionsRequest(AutoZujuanCreationRequest value) {
        return new JAXBElement<AutoZujuanCreationRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, AutoZujuanCreationRequest.class, GenerateAutoZujuanQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListCategorieCountView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GenerateAutoZujuanQuestionsResult", scope = GenerateAutoZujuanQuestionsResponse.class)
    public JAXBElement<QuestionListCategorieCountView> createGenerateAutoZujuanQuestionsResponseGenerateAutoZujuanQuestionsResult(QuestionListCategorieCountView value) {
        return new JAXBElement<QuestionListCategorieCountView>(_GenerateAutoZujuanQuestionsResponseGenerateAutoZujuanQuestionsResult_QNAME, QuestionListCategorieCountView.class, GenerateAutoZujuanQuestionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "keyword", scope = SearchCllectionQuestions.class)
    public JAXBElement<String> createSearchCllectionQuestionsKeyword(String value) {
        return new JAXBElement<String>(_SearchQuestionsKeyword_QNAME, String.class, SearchCllectionQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "SearchCllectionQuestionsResult", scope = SearchCllectionQuestionsResponse.class)
    public JAXBElement<QuestionListView> createSearchCllectionQuestionsResponseSearchCllectionQuestionsResult(QuestionListView value) {
        return new JAXBElement<QuestionListView>(_SearchCllectionQuestionsResponseSearchCllectionQuestionsResult_QNAME, QuestionListView.class, SearchCllectionQuestionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllCollectionQuestionResult", scope = GetAllCollectionQuestionResponse.class)
    public JAXBElement<QuestionListView> createGetAllCollectionQuestionResponseGetAllCollectionQuestionResult(QuestionListView value) {
        return new JAXBElement<QuestionListView>(_GetAllCollectionQuestionResponseGetAllCollectionQuestionResult_QNAME, QuestionListView.class, GetAllCollectionQuestionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetExamSetQuestionDistributionResult", scope = GetExamSetQuestionDistributionResponse.class)
    public JAXBElement<SimpleTree> createGetExamSetQuestionDistributionResponseGetExamSetQuestionDistributionResult(SimpleTree value) {
        return new JAXBElement<SimpleTree>(_GetExamSetQuestionDistributionResponseGetExamSetQuestionDistributionResult_QNAME, SimpleTree.class, GetExamSetQuestionDistributionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = SetPreviewConfigSession.class)
    public JAXBElement<String> createSetPreviewConfigSessionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, SetPreviewConfigSession.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "examConfig", scope = SetPreviewConfigSession.class)
    public JAXBElement<String> createSetPreviewConfigSessionExamConfig(String value) {
        return new JAXBElement<String>(_SetPreviewConfigSessionExamConfig_QNAME, String.class, SetPreviewConfigSession.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = RemovePreviewConfigSession.class)
    public JAXBElement<String> createRemovePreviewConfigSessionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, RemovePreviewConfigSession.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = GetPreviewConfigSession.class)
    public JAXBElement<String> createGetPreviewConfigSessionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, GetPreviewConfigSession.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPreviewConfigSessionResult", scope = GetPreviewConfigSessionResponse.class)
    public JAXBElement<String> createGetPreviewConfigSessionResponseGetPreviewConfigSessionResult(String value) {
        return new JAXBElement<String>(_GetPreviewConfigSessionResponseGetPreviewConfigSessionResult_QNAME, String.class, GetPreviewConfigSessionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "sessionId", scope = GetExamSetQuestionSection.class)
    public JAXBElement<String> createGetExamSetQuestionSectionSessionId(String value) {
        return new JAXBElement<String>(_AddQuestionSessionId_QNAME, String.class, GetExamSetQuestionSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetExamSetQuestionSectionResult", scope = GetExamSetQuestionSectionResponse.class)
    public JAXBElement<SimpleTree> createGetExamSetQuestionSectionResponseGetExamSetQuestionSectionResult(SimpleTree value) {
        return new JAXBElement<SimpleTree>(_GetExamSetQuestionSectionResponseGetExamSetQuestionSectionResult_QNAME, SimpleTree.class, GetExamSetQuestionSectionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCourseMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCourseMappingsByCourseIdResult", scope = GetCourseMappingsByCourseIdResponse.class)
    public JAXBElement<ArrayOfCourseMapping> createGetCourseMappingsByCourseIdResponseGetCourseMappingsByCourseIdResult(ArrayOfCourseMapping value) {
        return new JAXBElement<ArrayOfCourseMapping>(_GetCourseMappingsByCourseIdResponseGetCourseMappingsByCourseIdResult_QNAME, ArrayOfCourseMapping.class, GetCourseMappingsByCourseIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionByCourseResult", scope = GetBookVersionByCourseResponse.class)
    public JAXBElement<BookVersion> createGetBookVersionByCourseResponseGetBookVersionByCourseResult(BookVersion value) {
        return new JAXBElement<BookVersion>(_GetBookVersionByCourseResponseGetBookVersionByCourseResult_QNAME, BookVersion.class, GetBookVersionByCourseResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionByUserIdResult", scope = GetBookVersionByUserIdResponse.class)
    public JAXBElement<BookVersion> createGetBookVersionByUserIdResponseGetBookVersionByUserIdResult(BookVersion value) {
        return new JAXBElement<BookVersion>(_GetBookVersionByUserIdResponseGetBookVersionByUserIdResult_QNAME, BookVersion.class, GetBookVersionByUserIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OneClickTestPaperRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "oneClickTestPaperRequest", scope = GenerateOneClickTestPaperQuestions.class)
    public JAXBElement<OneClickTestPaperRequest> createGenerateOneClickTestPaperQuestionsOneClickTestPaperRequest(OneClickTestPaperRequest value) {
        return new JAXBElement<OneClickTestPaperRequest>(_GenerateOneClickTestPaperQuestionsOneClickTestPaperRequest_QNAME, OneClickTestPaperRequest.class, GenerateOneClickTestPaperQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OneClickTestPaperResultView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GenerateOneClickTestPaperQuestionsResult", scope = GenerateOneClickTestPaperQuestionsResponse.class)
    public JAXBElement<OneClickTestPaperResultView> createGenerateOneClickTestPaperQuestionsResponseGenerateOneClickTestPaperQuestionsResult(OneClickTestPaperResultView value) {
        return new JAXBElement<OneClickTestPaperResultView>(_GenerateOneClickTestPaperQuestionsResponseGenerateOneClickTestPaperQuestionsResult_QNAME, OneClickTestPaperResultView.class, GenerateOneClickTestPaperQuestionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourseBookVersionListView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCourseQuestionCountResult", scope = GetCourseQuestionCountResponse.class)
    public JAXBElement<CourseBookVersionListView> createGetCourseQuestionCountResponseGetCourseQuestionCountResult(CourseBookVersionListView value) {
        return new JAXBElement<CourseBookVersionListView>(_GetCourseQuestionCountResponseGetCourseQuestionCountResult_QNAME, CourseBookVersionListView.class, GetCourseQuestionCountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "includeSpecifyBookVersion", scope = GetHasQuestionBookVersion.class)
    public JAXBElement<String> createGetHasQuestionBookVersionIncludeSpecifyBookVersion(String value) {
        return new JAXBElement<String>(_GetHasQuestionBookVersionIncludeSpecifyBookVersion_QNAME, String.class, GetHasQuestionBookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetHasQuestionBookVersionResult", scope = GetHasQuestionBookVersionResponse.class)
    public JAXBElement<ArrayOfBookVersionView> createGetHasQuestionBookVersionResponseGetHasQuestionBookVersionResult(ArrayOfBookVersionView value) {
        return new JAXBElement<ArrayOfBookVersionView>(_GetHasQuestionBookVersionResponseGetHasQuestionBookVersionResult_QNAME, ArrayOfBookVersionView.class, GetHasQuestionBookVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetFirstLevelChildrenKnowledgePointByQuestionSummaryResult", scope = GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponse.class)
    public JAXBElement<ArrayOfKnowledgePointView> createGetFirstLevelChildrenKnowledgePointByQuestionSummaryResponseGetFirstLevelChildrenKnowledgePointByQuestionSummaryResult(ArrayOfKnowledgePointView value) {
        return new JAXBElement<ArrayOfKnowledgePointView>(_GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponseGetFirstLevelChildrenKnowledgePointByQuestionSummaryResult_QNAME, ArrayOfKnowledgePointView.class, GetFirstLevelChildrenKnowledgePointByQuestionSummaryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointQuestionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2 .class)
    public JAXBElement<KnowledgePointQuestionRequest> createGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Request(KnowledgePointQuestionRequest value) {
        return new JAXBElement<KnowledgePointQuestionRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, KnowledgePointQuestionRequest.class, GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetFirstLevelChildrenKnowledgePointByQuestionSummary_V2Result", scope = GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Response.class)
    public JAXBElement<ArrayOfKnowledgePointView> createGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2ResponseGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Result(ArrayOfKnowledgePointView value) {
        return new JAXBElement<ArrayOfKnowledgePointView>(_GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2ResponseGetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Result_QNAME, ArrayOfKnowledgePointView.class, GetFirstLevelChildrenKnowledgePointByQuestionSummaryV2Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionFaultTypesResult", scope = GetQuestionFaultTypesResponse.class)
    public JAXBElement<ArrayOfQuestionFaultType> createGetQuestionFaultTypesResponseGetQuestionFaultTypesResult(ArrayOfQuestionFaultType value) {
        return new JAXBElement<ArrayOfQuestionFaultType>(_GetQuestionFaultTypesResponseGetQuestionFaultTypesResult_QNAME, ArrayOfQuestionFaultType.class, GetQuestionFaultTypesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointQuestionCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetKnowledgePointQuestionCountResult", scope = GetKnowledgePointQuestionCountResponse.class)
    public JAXBElement<ArrayOfKnowledgePointQuestionCount> createGetKnowledgePointQuestionCountResponseGetKnowledgePointQuestionCountResult(ArrayOfKnowledgePointQuestionCount value) {
        return new JAXBElement<ArrayOfKnowledgePointQuestionCount>(_GetKnowledgePointQuestionCountResponseGetKnowledgePointQuestionCountResult_QNAME, ArrayOfKnowledgePointQuestionCount.class, GetKnowledgePointQuestionCountResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPublisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllPublishersResult", scope = GetAllPublishersResponse.class)
    public JAXBElement<ArrayOfPublisher> createGetAllPublishersResponseGetAllPublishersResult(ArrayOfPublisher value) {
        return new JAXBElement<ArrayOfPublisher>(_GetAllPublishersResponseGetAllPublishersResult_QNAME, ArrayOfPublisher.class, GetAllPublishersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSchoolBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSchoolBookVersionResult", scope = GetSchoolBookVersionResponse.class)
    public JAXBElement<ArrayOfSchoolBookVersion> createGetSchoolBookVersionResponseGetSchoolBookVersionResult(ArrayOfSchoolBookVersion value) {
        return new JAXBElement<ArrayOfSchoolBookVersion>(_GetSchoolBookVersionResponseGetSchoolBookVersionResult_QNAME, ArrayOfSchoolBookVersion.class, GetSchoolBookVersionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionDisplayType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetGetQuestionDisplayTypesResult", scope = GetGetQuestionDisplayTypesResponse.class)
    public JAXBElement<ArrayOfQuestionDisplayType> createGetGetQuestionDisplayTypesResponseGetGetQuestionDisplayTypesResult(ArrayOfQuestionDisplayType value) {
        return new JAXBElement<ArrayOfQuestionDisplayType>(_GetGetQuestionDisplayTypesResponseGetGetQuestionDisplayTypesResult_QNAME, ArrayOfQuestionDisplayType.class, GetGetQuestionDisplayTypesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExamUsageRulerViewRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetExamUsageRulerView.class)
    public JAXBElement<GetExamUsageRulerViewRequest> createGetExamUsageRulerViewRequest(GetExamUsageRulerViewRequest value) {
        return new JAXBElement<GetExamUsageRulerViewRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetExamUsageRulerViewRequest.class, GetExamUsageRulerView.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamUsageRulerView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetExamUsageRulerViewResult", scope = GetExamUsageRulerViewResponse.class)
    public JAXBElement<ExamUsageRulerView> createGetExamUsageRulerViewResponseGetExamUsageRulerViewResult(ExamUsageRulerView value) {
        return new JAXBElement<ExamUsageRulerView>(_GetExamUsageRulerViewResponseGetExamUsageRulerViewResult_QNAME, ExamUsageRulerView.class, GetExamUsageRulerViewResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetHasQuestionBookVersionViewsByCourseIdResult", scope = GetHasQuestionBookVersionViewsByCourseIdResponse.class)
    public JAXBElement<ArrayOfBookVersionView> createGetHasQuestionBookVersionViewsByCourseIdResponseGetHasQuestionBookVersionViewsByCourseIdResult(ArrayOfBookVersionView value) {
        return new JAXBElement<ArrayOfBookVersionView>(_GetHasQuestionBookVersionViewsByCourseIdResponseGetHasQuestionBookVersionViewsByCourseIdResult_QNAME, ArrayOfBookVersionView.class, GetHasQuestionBookVersionViewsByCourseIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "questionId", scope = GetQuestionReportModel.class)
    public JAXBElement<ArrayOfint> createGetQuestionReportModelQuestionId(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_GetQuestionReportModelQuestionId_QNAME, ArrayOfint.class, GetQuestionReportModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionReportModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionReportModelResult", scope = GetQuestionReportModelResponse.class)
    public JAXBElement<ArrayOfQuestionReportModel> createGetQuestionReportModelResponseGetQuestionReportModelResult(ArrayOfQuestionReportModel value) {
        return new JAXBElement<ArrayOfQuestionReportModel>(_GetQuestionReportModelResponseGetQuestionReportModelResult_QNAME, ArrayOfQuestionReportModel.class, GetQuestionReportModelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetExamRuler.class)
    public JAXBElement<IdRequest> createGetExamRulerRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetExamRuler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamRuler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetExamRulerResult", scope = GetExamRulerResponse.class)
    public JAXBElement<ExamRuler> createGetExamRulerResponseGetExamRulerResult(ExamRuler value) {
        return new JAXBElement<ExamRuler>(_GetExamRulerResponseGetExamRulerResult_QNAME, ExamRuler.class, GetExamRulerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfExamUsageRuler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllExamUsageRulersResult", scope = GetAllExamUsageRulersResponse.class)
    public JAXBElement<ArrayOfExamUsageRuler> createGetAllExamUsageRulersResponseGetAllExamUsageRulersResult(ArrayOfExamUsageRuler value) {
        return new JAXBElement<ArrayOfExamUsageRuler>(_GetAllExamUsageRulersResponseGetAllExamUsageRulersResult_QNAME, ArrayOfExamUsageRuler.class, GetAllExamUsageRulersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExamUsageRulerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetExamUsageRuler.class)
    public JAXBElement<GetExamUsageRulerRequest> createGetExamUsageRulerRequest(GetExamUsageRulerRequest value) {
        return new JAXBElement<GetExamUsageRulerRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetExamUsageRulerRequest.class, GetExamUsageRuler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamUsageRuler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetExamUsageRulerResult", scope = GetExamUsageRulerResponse.class)
    public JAXBElement<ExamUsageRuler> createGetExamUsageRulerResponseGetExamUsageRulerResult(ExamUsageRuler value) {
        return new JAXBElement<ExamUsageRuler>(_GetExamUsageRulerResponseGetExamUsageRulerResult_QNAME, ExamUsageRuler.class, GetExamUsageRulerResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionsFromCourseMappingAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionsFromCourseMappingAll.class)
    public JAXBElement<GetQuestionsFromCourseMappingAllRequest> createGetQuestionsFromCourseMappingAllRequest(GetQuestionsFromCourseMappingAllRequest value) {
        return new JAXBElement<GetQuestionsFromCourseMappingAllRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionsFromCourseMappingAllRequest.class, GetQuestionsFromCourseMappingAll.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsFromCourseMappingAllResult", scope = GetQuestionsFromCourseMappingAllResponse.class)
    public JAXBElement<ArrayOfQuestionSimplifiedFormat> createGetQuestionsFromCourseMappingAllResponseGetQuestionsFromCourseMappingAllResult(ArrayOfQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfQuestionSimplifiedFormat>(_GetQuestionsFromCourseMappingAllResponseGetQuestionsFromCourseMappingAllResult_QNAME, ArrayOfQuestionSimplifiedFormat.class, GetQuestionsFromCourseMappingAllResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionsFromKnowledgePointsAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionsFromKnowledgePointsAll.class)
    public JAXBElement<GetQuestionsFromKnowledgePointsAllRequest> createGetQuestionsFromKnowledgePointsAllRequest(GetQuestionsFromKnowledgePointsAllRequest value) {
        return new JAXBElement<GetQuestionsFromKnowledgePointsAllRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionsFromKnowledgePointsAllRequest.class, GetQuestionsFromKnowledgePointsAll.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormatCache }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionsFromKnowledgePointsAllResult", scope = GetQuestionsFromKnowledgePointsAllResponse.class)
    public JAXBElement<ArrayOfQuestionSimplifiedFormatCache> createGetQuestionsFromKnowledgePointsAllResponseGetQuestionsFromKnowledgePointsAllResult(ArrayOfQuestionSimplifiedFormatCache value) {
        return new JAXBElement<ArrayOfQuestionSimplifiedFormatCache>(_GetQuestionsFromKnowledgePointsAllResponseGetQuestionsFromKnowledgePointsAllResult_QNAME, ArrayOfQuestionSimplifiedFormatCache.class, GetQuestionsFromKnowledgePointsAllResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionStatisticsListRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionStatisticsList.class)
    public JAXBElement<GetQuestionStatisticsListRequest> createGetQuestionStatisticsListRequest(GetQuestionStatisticsListRequest value) {
        return new JAXBElement<GetQuestionStatisticsListRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionStatisticsListRequest.class, GetQuestionStatisticsList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionStatistics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionStatisticsListResult", scope = GetQuestionStatisticsListResponse.class)
    public JAXBElement<ArrayOfQuestionStatistics> createGetQuestionStatisticsListResponseGetQuestionStatisticsListResult(ArrayOfQuestionStatistics value) {
        return new JAXBElement<ArrayOfQuestionStatistics>(_GetQuestionStatisticsListResponseGetQuestionStatisticsListResult_QNAME, ArrayOfQuestionStatistics.class, GetQuestionStatisticsListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionLabels.class)
    public JAXBElement<IdRequest> createGetQuestionLabelsRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetQuestionLabels.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionLabelsResult", scope = GetQuestionLabelsResponse.class)
    public JAXBElement<ArrayOfQuestionLabel> createGetQuestionLabelsResponseGetQuestionLabelsResult(ArrayOfQuestionLabel value) {
        return new JAXBElement<ArrayOfQuestionLabel>(_GetQuestionLabelsResponseGetQuestionLabelsResult_QNAME, ArrayOfQuestionLabel.class, GetQuestionLabelsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookVersionsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetBookVersions.class)
    public JAXBElement<GetBookVersionsRequest> createGetBookVersionsRequest(GetBookVersionsRequest value) {
        return new JAXBElement<GetBookVersionsRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetBookVersionsRequest.class, GetBookVersions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionsResult", scope = GetBookVersionsResponse.class)
    public JAXBElement<ArrayOfBookVersion> createGetBookVersionsResponseGetBookVersionsResult(ArrayOfBookVersion value) {
        return new JAXBElement<ArrayOfBookVersion>(_GetBookVersionsResponseGetBookVersionsResult_QNAME, ArrayOfBookVersion.class, GetBookVersionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCourseMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllCourseMappingsResult", scope = GetAllCourseMappingsResponse.class)
    public JAXBElement<ArrayOfCourseMapping> createGetAllCourseMappingsResponseGetAllCourseMappingsResult(ArrayOfCourseMapping value) {
        return new JAXBElement<ArrayOfCourseMapping>(_GetAllCourseMappingsResponseGetAllCourseMappingsResult_QNAME, ArrayOfCourseMapping.class, GetAllCourseMappingsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetChapterSections.class)
    public JAXBElement<IdRequest> createGetChapterSectionsRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetChapterSections.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChapterSectionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChapterSectionsResult", scope = GetChapterSectionsResponse.class)
    public JAXBElement<ChapterSectionList> createGetChapterSectionsResponseGetChapterSectionsResult(ChapterSectionList value) {
        return new JAXBElement<ChapterSectionList>(_GetChapterSectionsResponseGetChapterSectionsResult_QNAME, ChapterSectionList.class, GetChapterSectionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetParentChapterSections.class)
    public JAXBElement<IdRequest> createGetParentChapterSectionsRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetParentChapterSections.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfChapterSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetParentChapterSectionsResult", scope = GetParentChapterSectionsResponse.class)
    public JAXBElement<ArrayOfChapterSection> createGetParentChapterSectionsResponseGetParentChapterSectionsResult(ArrayOfChapterSection value) {
        return new JAXBElement<ArrayOfChapterSection>(_GetParentChapterSectionsResponseGetParentChapterSectionsResult_QNAME, ArrayOfChapterSection.class, GetParentChapterSectionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetBookVersionChapterSections.class)
    public JAXBElement<IdRequest> createGetBookVersionChapterSectionsRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetBookVersionChapterSections.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetBookVersionChapterSectionsResult", scope = GetBookVersionChapterSectionsResponse.class)
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> createGetBookVersionChapterSectionsResponseGetBookVersionChapterSectionsResult(ArrayOfKeyValueOfintChapterSectionyHSjzk5H value) {
        return new JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H>(_GetBookVersionChapterSectionsResponseGetBookVersionChapterSectionsResult_QNAME, ArrayOfKeyValueOfintChapterSectionyHSjzk5H.class, GetBookVersionChapterSectionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionCategoriesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetAllQuestionCategories.class)
    public JAXBElement<GetAllQuestionCategoriesRequest> createGetAllQuestionCategoriesRequest(GetAllQuestionCategoriesRequest value) {
        return new JAXBElement<GetAllQuestionCategoriesRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetAllQuestionCategoriesRequest.class, GetAllQuestionCategories.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllQuestionCategoriesResult", scope = GetAllQuestionCategoriesResponse.class)
    public JAXBElement<ArrayOfQuestionCategory> createGetAllQuestionCategoriesResponseGetAllQuestionCategoriesResult(ArrayOfQuestionCategory value) {
        return new JAXBElement<ArrayOfQuestionCategory>(_GetAllQuestionCategoriesResponseGetAllQuestionCategoriesResult_QNAME, ArrayOfQuestionCategory.class, GetAllQuestionCategoriesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionCategoriesCheckOnlineRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionCategoriesCheckOnlineNew.class)
    public JAXBElement<GetQuestionCategoriesCheckOnlineRequest> createGetQuestionCategoriesCheckOnlineNewRequest(GetQuestionCategoriesCheckOnlineRequest value) {
        return new JAXBElement<GetQuestionCategoriesCheckOnlineRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionCategoriesCheckOnlineRequest.class, GetQuestionCategoriesCheckOnlineNew.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionCategoriesCheckOnlineNewResult", scope = GetQuestionCategoriesCheckOnlineNewResponse.class)
    public JAXBElement<ArrayOfQuestionCategory> createGetQuestionCategoriesCheckOnlineNewResponseGetQuestionCategoriesCheckOnlineNewResult(ArrayOfQuestionCategory value) {
        return new JAXBElement<ArrayOfQuestionCategory>(_GetQuestionCategoriesCheckOnlineNewResponseGetQuestionCategoriesCheckOnlineNewResult_QNAME, ArrayOfQuestionCategory.class, GetQuestionCategoriesCheckOnlineNewResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionCategoriesCheckOnlineRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetRootQuestionCategoriesCheckOnline.class)
    public JAXBElement<GetQuestionCategoriesCheckOnlineRequest> createGetRootQuestionCategoriesCheckOnlineRequest(GetQuestionCategoriesCheckOnlineRequest value) {
        return new JAXBElement<GetQuestionCategoriesCheckOnlineRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionCategoriesCheckOnlineRequest.class, GetRootQuestionCategoriesCheckOnline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRootQuestionCategoriesCheckOnlineResult", scope = GetRootQuestionCategoriesCheckOnlineResponse.class)
    public JAXBElement<ArrayOfQuestionCategory> createGetRootQuestionCategoriesCheckOnlineResponseGetRootQuestionCategoriesCheckOnlineResult(ArrayOfQuestionCategory value) {
        return new JAXBElement<ArrayOfQuestionCategory>(_GetRootQuestionCategoriesCheckOnlineResponseGetRootQuestionCategoriesCheckOnlineResult_QNAME, ArrayOfQuestionCategory.class, GetRootQuestionCategoriesCheckOnlineResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategoryModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionCategoryModelsResult", scope = GetQuestionCategoryModelsResponse.class)
    public JAXBElement<ArrayOfQuestionCategoryModel> createGetQuestionCategoryModelsResponseGetQuestionCategoryModelsResult(ArrayOfQuestionCategoryModel value) {
        return new JAXBElement<ArrayOfQuestionCategoryModel>(_GetQuestionCategoryModelsResponseGetQuestionCategoryModelsResult_QNAME, ArrayOfQuestionCategoryModel.class, GetQuestionCategoryModelsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookVersionsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetAllBookVersions.class)
    public JAXBElement<GetBookVersionsRequest> createGetAllBookVersionsRequest(GetBookVersionsRequest value) {
        return new JAXBElement<GetBookVersionsRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetBookVersionsRequest.class, GetAllBookVersions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAllBookVersionsResult", scope = GetAllBookVersionsResponse.class)
    public JAXBElement<ArrayOfBookVersion> createGetAllBookVersionsResponseGetAllBookVersionsResult(ArrayOfBookVersion value) {
        return new JAXBElement<ArrayOfBookVersion>(_GetAllBookVersionsResponseGetAllBookVersionsResult_QNAME, ArrayOfBookVersion.class, GetAllBookVersionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionDisplayType.class)
    public JAXBElement<IdRequest> createGetQuestionDisplayTypeRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetQuestionDisplayType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionDisplayType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionDisplayTypeResult", scope = GetQuestionDisplayTypeResponse.class)
    public JAXBElement<QuestionDisplayType> createGetQuestionDisplayTypeResponseGetQuestionDisplayTypeResult(QuestionDisplayType value) {
        return new JAXBElement<QuestionDisplayType>(_GetQuestionDisplayTypeResponseGetQuestionDisplayTypeResult_QNAME, QuestionDisplayType.class, GetQuestionDisplayTypeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetCourseAllChapterSections.class)
    public JAXBElement<IdRequest> createGetCourseAllChapterSectionsRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetCourseAllChapterSections.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCourseAllChapterSectionsResult", scope = GetCourseAllChapterSectionsResponse.class)
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> createGetCourseAllChapterSectionsResponseGetCourseAllChapterSectionsResult(ArrayOfKeyValueOfintChapterSectionyHSjzk5H value) {
        return new JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H>(_GetCourseAllChapterSectionsResponseGetCourseAllChapterSectionsResult_QNAME, ArrayOfKeyValueOfintChapterSectionyHSjzk5H.class, GetCourseAllChapterSectionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetCoursePreKnowledgePoints.class)
    public JAXBElement<IdRequest> createGetCoursePreKnowledgePointsRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetCoursePreKnowledgePoints.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PreKnowledgePointList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCoursePreKnowledgePointsResult", scope = GetCoursePreKnowledgePointsResponse.class)
    public JAXBElement<PreKnowledgePointList> createGetCoursePreKnowledgePointsResponseGetCoursePreKnowledgePointsResult(PreKnowledgePointList value) {
        return new JAXBElement<PreKnowledgePointList>(_GetCoursePreKnowledgePointsResponseGetCoursePreKnowledgePointsResult_QNAME, PreKnowledgePointList.class, GetCoursePreKnowledgePointsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetChapterSectionKnowledgeMappingByCourseId.class)
    public JAXBElement<IdRequest> createGetChapterSectionKnowledgeMappingByCourseIdRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetChapterSectionKnowledgeMappingByCourseId.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfChapterSectionKnowledgeMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChapterSectionKnowledgeMappingByCourseIdResult", scope = GetChapterSectionKnowledgeMappingByCourseIdResponse.class)
    public JAXBElement<ArrayOfChapterSectionKnowledgeMapping> createGetChapterSectionKnowledgeMappingByCourseIdResponseGetChapterSectionKnowledgeMappingByCourseIdResult(ArrayOfChapterSectionKnowledgeMapping value) {
        return new JAXBElement<ArrayOfChapterSectionKnowledgeMapping>(_GetChapterSectionKnowledgeMappingByCourseIdResponseGetChapterSectionKnowledgeMappingByCourseIdResult_QNAME, ArrayOfChapterSectionKnowledgeMapping.class, GetChapterSectionKnowledgeMappingByCourseIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnlineQuestionsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetOnlineQuestions.class)
    public JAXBElement<GetOnlineQuestionsRequest> createGetOnlineQuestionsRequest(GetOnlineQuestionsRequest value) {
        return new JAXBElement<GetOnlineQuestionsRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetOnlineQuestionsRequest.class, GetOnlineQuestions.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineQuestionSimplifiedFormatSectionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOnlineQuestionsResult", scope = GetOnlineQuestionsResponse.class)
    public JAXBElement<OnlineQuestionSimplifiedFormatSectionList> createGetOnlineQuestionsResponseGetOnlineQuestionsResult(OnlineQuestionSimplifiedFormatSectionList value) {
        return new JAXBElement<OnlineQuestionSimplifiedFormatSectionList>(_GetOnlineQuestionsResponseGetOnlineQuestionsResult_QNAME, OnlineQuestionSimplifiedFormatSectionList.class, GetOnlineQuestionsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnlineQuestionsForKnowledgePointRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetOnlineQuestionsForKnowledgePoint.class)
    public JAXBElement<GetOnlineQuestionsForKnowledgePointRequest> createGetOnlineQuestionsForKnowledgePointRequest(GetOnlineQuestionsForKnowledgePointRequest value) {
        return new JAXBElement<GetOnlineQuestionsForKnowledgePointRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetOnlineQuestionsForKnowledgePointRequest.class, GetOnlineQuestionsForKnowledgePoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineQuestionSimplifiedFormatKnowledgePointList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOnlineQuestionsForKnowledgePointResult", scope = GetOnlineQuestionsForKnowledgePointResponse.class)
    public JAXBElement<OnlineQuestionSimplifiedFormatKnowledgePointList> createGetOnlineQuestionsForKnowledgePointResponseGetOnlineQuestionsForKnowledgePointResult(OnlineQuestionSimplifiedFormatKnowledgePointList value) {
        return new JAXBElement<OnlineQuestionSimplifiedFormatKnowledgePointList>(_GetOnlineQuestionsForKnowledgePointResponseGetOnlineQuestionsForKnowledgePointResult_QNAME, OnlineQuestionSimplifiedFormatKnowledgePointList.class, GetOnlineQuestionsForKnowledgePointResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetBookVersionQuestionCount.class)
    public JAXBElement<IdRequest> createGetBookVersionQuestionCountRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetBookVersionQuestionCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetCourseAllQuestionCount.class)
    public JAXBElement<IdRequest> createGetCourseAllQuestionCountRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetCourseAllQuestionCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetSimilarQuestionList.class)
    public JAXBElement<IdRequest> createGetSimilarQuestionListRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetSimilarQuestionList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimilarQuestionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSimilarQuestionListResult", scope = GetSimilarQuestionListResponse.class)
    public JAXBElement<SimilarQuestionList> createGetSimilarQuestionListResponseGetSimilarQuestionListResult(SimilarQuestionList value) {
        return new JAXBElement<SimilarQuestionList>(_GetSimilarQuestionListResponseGetSimilarQuestionListResult_QNAME, SimilarQuestionList.class, GetSimilarQuestionListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetClassRoomEvaluationDefaultSelected.class)
    public JAXBElement<IdRequest> createGetClassRoomEvaluationDefaultSelectedRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, IdRequest.class, GetClassRoomEvaluationDefaultSelected.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassRoomEvaluationDefaultSelected }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetClassRoomEvaluationDefaultSelectedResult", scope = GetClassRoomEvaluationDefaultSelectedResponse.class)
    public JAXBElement<ClassRoomEvaluationDefaultSelected> createGetClassRoomEvaluationDefaultSelectedResponseGetClassRoomEvaluationDefaultSelectedResult(ClassRoomEvaluationDefaultSelected value) {
        return new JAXBElement<ClassRoomEvaluationDefaultSelected>(_GetClassRoomEvaluationDefaultSelectedResponseGetClassRoomEvaluationDefaultSelectedResult_QNAME, ClassRoomEvaluationDefaultSelected.class, GetClassRoomEvaluationDefaultSelectedResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = CheckSCPQuestion.class)
    public JAXBElement<SCPQuestionRequest> createCheckSCPQuestionRequest(SCPQuestionRequest value) {
        return new JAXBElement<SCPQuestionRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, SCPQuestionRequest.class, CheckSCPQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSCPQuestionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CheckSCPQuestionResult", scope = CheckSCPQuestionResponse.class)
    public JAXBElement<CheckSCPQuestionView> createCheckSCPQuestionResponseCheckSCPQuestionResult(CheckSCPQuestionView value) {
        return new JAXBElement<CheckSCPQuestionView>(_CheckSCPQuestionResponseCheckSCPQuestionResult_QNAME, CheckSCPQuestionView.class, CheckSCPQuestionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetSCPQuestionDetails.class)
    public JAXBElement<SCPQuestionRequest> createGetSCPQuestionDetailsRequest(SCPQuestionRequest value) {
        return new JAXBElement<SCPQuestionRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, SCPQuestionRequest.class, GetSCPQuestionDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SCPQuestionDetailView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSCPQuestionDetailsResult", scope = GetSCPQuestionDetailsResponse.class)
    public JAXBElement<SCPQuestionDetailView> createGetSCPQuestionDetailsResponseGetSCPQuestionDetailsResult(SCPQuestionDetailView value) {
        return new JAXBElement<SCPQuestionDetailView>(_GetSCPQuestionDetailsResponseGetSCPQuestionDetailsResult_QNAME, SCPQuestionDetailView.class, GetSCPQuestionDetailsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionSectionDistributionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionSectionDistribution.class)
    public JAXBElement<GetQuestionSectionDistributionRequest> createGetQuestionSectionDistributionRequest(GetQuestionSectionDistributionRequest value) {
        return new JAXBElement<GetQuestionSectionDistributionRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionSectionDistributionRequest.class, GetQuestionSectionDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSectionDistributionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionSectionDistributionResult", scope = GetQuestionSectionDistributionResponse.class)
    public JAXBElement<ArrayOfQuestionSectionDistributionView> createGetQuestionSectionDistributionResponseGetQuestionSectionDistributionResult(ArrayOfQuestionSectionDistributionView value) {
        return new JAXBElement<ArrayOfQuestionSectionDistributionView>(_GetQuestionSectionDistributionResponseGetQuestionSectionDistributionResult_QNAME, ArrayOfQuestionSectionDistributionView.class, GetQuestionSectionDistributionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionKnowledgePointDistributionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = GetQuestionKnowledgePointDistribution.class)
    public JAXBElement<GetQuestionKnowledgePointDistributionRequest> createGetQuestionKnowledgePointDistributionRequest(GetQuestionKnowledgePointDistributionRequest value) {
        return new JAXBElement<GetQuestionKnowledgePointDistributionRequest>(_GetCourseMappingIdBySectionIdRequest_QNAME, GetQuestionKnowledgePointDistributionRequest.class, GetQuestionKnowledgePointDistribution.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionKnowledgePointDistributionView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetQuestionKnowledgePointDistributionResult", scope = GetQuestionKnowledgePointDistributionResponse.class)
    public JAXBElement<ArrayOfQuestionKnowledgePointDistributionView> createGetQuestionKnowledgePointDistributionResponseGetQuestionKnowledgePointDistributionResult(ArrayOfQuestionKnowledgePointDistributionView value) {
        return new JAXBElement<ArrayOfQuestionKnowledgePointDistributionView>(_GetQuestionKnowledgePointDistributionResponseGetQuestionKnowledgePointDistributionResult_QNAME, ArrayOfQuestionKnowledgePointDistributionView.class, GetQuestionKnowledgePointDistributionResponse.class, value);
    }

}
