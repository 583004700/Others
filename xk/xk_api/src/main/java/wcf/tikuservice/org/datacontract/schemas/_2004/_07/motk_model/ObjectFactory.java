
package wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintArrayOfintty7Ep6D1;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintChapterSectionyHSjzk5H;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.motk_model package. 
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

    private final static QName _QuestionCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionCategory");
    private final static QName _ArrayOfQuestionCategory_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionCategory");
    private final static QName _KnowledgePointList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointList");
    private final static QName _ArrayOfKnowledgePoint_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfKnowledgePoint");
    private final static QName _KnowledgePoint_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePoint");
    private final static QName _ArrayOfBookVersion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfBookVersion");
    private final static QName _BookVersion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "BookVersion");
    private final static QName _PublisherBookVersion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherBookVersion");
    private final static QName _Question_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Question");
    private final static QName _ArrayOfQuestionAttachment_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionAttachment");
    private final static QName _QuestionAttachment_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionAttachment");
    private final static QName _ArrayOfQuestionOptionGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionOptionGroup");
    private final static QName _QuestionOptionGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionOptionGroup");
    private final static QName _ArrayOfQuestionOptionGroupAnswer_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionOptionGroupAnswer");
    private final static QName _QuestionOptionGroupAnswer_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionOptionGroupAnswer");
    private final static QName _ArrayOfQuestionOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionOption");
    private final static QName _QuestionOption_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionOption");
    private final static QName _ArrayOfQuestionChapterSectionMapping_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionChapterSectionMapping");
    private final static QName _QuestionChapterSectionMapping_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionChapterSectionMapping");
    private final static QName _ArrayOfQuestion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestion");
    private final static QName _QuestionStatistics_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionStatistics");
    private final static QName _ArrayOfQuestionStatisticsDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionStatisticsDetail");
    private final static QName _QuestionStatisticsDetail_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionStatisticsDetail");
    private final static QName _ArrayOfQuestionSimplifiedFormat_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionSimplifiedFormat");
    private final static QName _QuestionSimplifiedFormat_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionSimplifiedFormat");
    private final static QName _ArrayOfCourseMapping_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfCourseMapping");
    private final static QName _CourseMapping_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "CourseMapping");
    private final static QName _ArrayOfQuestionFaultType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionFaultType");
    private final static QName _QuestionFaultType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionFaultType");
    private final static QName _ArrayOfKnowledgePointQuestionCount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfKnowledgePointQuestionCount");
    private final static QName _KnowledgePointQuestionCount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointQuestionCount");
    private final static QName _ArrayOfPublisher_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfPublisher");
    private final static QName _Publisher_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Publisher");
    private final static QName _ArrayOfSchoolBookVersion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfSchoolBookVersion");
    private final static QName _SchoolBookVersion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "SchoolBookVersion");
    private final static QName _ArrayOfQuestionDisplayType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionDisplayType");
    private final static QName _QuestionDisplayType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionDisplayType");
    private final static QName _ArrayOfQuestionReportModel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionReportModel");
    private final static QName _QuestionReportModel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionReportModel");
    private final static QName _ExamRuler_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ExamRuler");
    private final static QName _ArrayOfKnowledgePointPoint_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfKnowledgePointPoint");
    private final static QName _KnowledgePointPoint_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointPoint");
    private final static QName _ArrayOfKnowledgePointPointQuestion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfKnowledgePointPointQuestion");
    private final static QName _KnowledgePointPointQuestion_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointPointQuestion");
    private final static QName _ArrayOfExamUsageRuler_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfExamUsageRuler");
    private final static QName _ExamUsageRuler_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ExamUsageRuler");
    private final static QName _ArrayOfQuestionSimplifiedFormatCache_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionSimplifiedFormatCache");
    private final static QName _QuestionSimplifiedFormatCache_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionSimplifiedFormatCache");
    private final static QName _ArrayOfQuestionStatistics_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionStatistics");
    private final static QName _ArrayOfQuestionLabel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionLabel");
    private final static QName _QuestionLabel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionLabel");
    private final static QName _ChapterSectionList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ChapterSectionList");
    private final static QName _ChapterSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ChapterSection");
    private final static QName _ArrayOfChapterSection_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfChapterSection");
    private final static QName _ArrayOfQuestionCategoryModel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfQuestionCategoryModel");
    private final static QName _QuestionCategoryModel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionCategoryModel");
    private final static QName _PreKnowledgePointList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PreKnowledgePointList");
    private final static QName _ArrayOfChapterSectionKnowledgeMapping_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfChapterSectionKnowledgeMapping");
    private final static QName _ChapterSectionKnowledgeMapping_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ChapterSectionKnowledgeMapping");
    private final static QName _OnlineQuestionSimplifiedFormatSectionList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "OnlineQuestionSimplifiedFormatSectionList");
    private final static QName _ArrayOfOnlineQuestionSimplifiedFormat_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ArrayOfOnlineQuestionSimplifiedFormat");
    private final static QName _OnlineQuestionSimplifiedFormat_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "OnlineQuestionSimplifiedFormat");
    private final static QName _OnlineQuestionSimplifiedFormatKnowledgePointList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "OnlineQuestionSimplifiedFormatKnowledgePointList");
    private final static QName _SimilarQuestionList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "SimilarQuestionList");
    private final static QName _ClassRoomEvaluationDefaultSelected_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ClassRoomEvaluationDefaultSelected");
    private final static QName _RequestFromTypeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Enum", "RequestFromTypeEnum");
    private final static QName _ExamRulerTypeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Enum", "ExamRulerTypeEnum");
    private final static QName _GradeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Enum", "GradeEnum");
    private final static QName _ExamRulerUsageTypeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Enum", "ExamRulerUsageTypeEnum");
    private final static QName _ResultTypeEnum_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Enum", "ResultTypeEnum");
    private final static QName _RequestBase_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Common", "RequestBase");
    private final static QName _IdRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Common", "IdRequest");
    private final static QName _ResultBase_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Common", "ResultBase");
    private final static QName _ResultBaseMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Common", "Message");
    private final static QName _SimilarQuestionListRelatedQuestions_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "RelatedQuestions");
    private final static QName _OnlineQuestionSimplifiedFormatKnowledgePointListQuestions_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Questions");
    private final static QName _OnlineQuestionSimplifiedFormatCapabilities_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Capabilities");
    private final static QName _OnlineQuestionSimplifiedFormatOtherKnowledgePoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "OtherKnowledgePoints");
    private final static QName _OnlineQuestionSimplifiedFormatSolveMethodLabel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "SolveMethodLabel");
    private final static QName _OnlineQuestionSimplifiedFormatUseRange_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "UseRange");
    private final static QName _ChapterSectionKnowledgeMappingKnowledgePointIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointIds");
    private final static QName _PreKnowledgePointListPreKnowledgePoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PreKnowledgePoints");
    private final static QName _QuestionCategoryModelQuestionCategoryModelName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionCategoryModelName");
    private final static QName _ChapterSectionSectionName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "SectionName");
    private final static QName _ChapterSectionListSections_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Sections");
    private final static QName _QuestionLabelAnnotation_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Annotation");
    private final static QName _QuestionLabelQuestionLabelName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionLabelName");
    private final static QName _QuestionSimplifiedFormatKnowledgePointLabels_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointLabels");
    private final static QName _QuestionSimplifiedFormatMainKnowledgePoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "MainKnowledgePoints");
    private final static QName _QuestionSimplifiedFormatUseRangeIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "UseRangeIds");
    private final static QName _QuestionSimplifiedFormatCacheBookVersionIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "BookVersionIds");
    private final static QName _KnowledgePointPointKnowledgePointName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointName");
    private final static QName _KnowledgePointPointParentKnowledgePointName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ParentKnowledgePointName");
    private final static QName _ExamRulerExamRulerName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ExamRulerName");
    private final static QName _ExamRulerKnowledgePointPoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePointPoints");
    private final static QName _ExamRulerRawData_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "RawData");
    private final static QName _ExamRulerRegionIds_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "RegionIds");
    private final static QName _QuestionReportModelCapabilityAnalysis_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "CapabilityAnalysis");
    private final static QName _QuestionReportModelCategoryName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "CategoryName");
    private final static QName _QuestionReportModelKnowledgeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgeName");
    private final static QName _QuestionDisplayTypeQuestionDisplayTypeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionDisplayTypeName");
    private final static QName _PublisherPublisherLogoPath_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherLogoPath");
    private final static QName _PublisherPublisherLogoShortCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherLogoShortCode");
    private final static QName _PublisherPublisherName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherName");
    private final static QName _QuestionFaultTypeFaultTypeName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "FaultTypeName");
    private final static QName _CourseMappingCourseMappingCoverPath_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "CourseMappingCoverPath");
    private final static QName _CourseMappingCourseMappingName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "CourseMappingName");
    private final static QName _CourseMappingCourseMappingShortCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "CourseMappingShortCode");
    private final static QName _CourseMappingECmid_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ECmid");
    private final static QName _CourseMappingImagePath_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ImagePath");
    private final static QName _QuestionStatisticsDetailQuestionOptionId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionOptionId");
    private final static QName _QuestionStatisticsDetails_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Details");
    private final static QName _QuestionStatisticsQuestionSourceReferences_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionSourceReferences");
    private final static QName _QuestionOptionQuestionOptionText_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionOptionText");
    private final static QName _QuestionOptionGroupAnswerAnswer_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Answer");
    private final static QName _QuestionOptionGroupAnswers_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Answers");
    private final static QName _QuestionOptionGroupOptions_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Options");
    private final static QName _QuestionOptionGroupQuestionText_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionText");
    private final static QName _QuestionAttachmentQuestionAttachmentName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionAttachmentName");
    private final static QName _QuestionAttachmentQuestionAttachmentUrl_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionAttachmentUrl");
    private final static QName _QuestionAttachmentUpdateDateTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "UpdateDateTime");
    private final static QName _QuestionAnalysis_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Analysis");
    private final static QName _QuestionAttachments_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "Attachments");
    private final static QName _QuestionFitUseOrganization_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "FitUseOrganization");
    private final static QName _QuestionOptionGroups_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "OptionGroups");
    private final static QName _QuestionQuestionAudioUrl_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionAudioUrl");
    private final static QName _QuestionQuestionContent_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionContent");
    private final static QName _QuestionQuestionContentForDisplay_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionContentForDisplay");
    private final static QName _QuestionQuestionSource_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionSource");
    private final static QName _QuestionSectionMappings_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "SectionMappings");
    private final static QName _QuestionSemanticLabels_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "SemanticLabels");
    private final static QName _PublisherBookVersionPublisherBookVersionCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherBookVersionCode");
    private final static QName _PublisherBookVersionPublisherBookVersionFullName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherBookVersionFullName");
    private final static QName _PublisherBookVersionPublisherBookVersionName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "PublisherBookVersionName");
    private final static QName _BookVersionBookVersionName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "BookVersionName");
    private final static QName _KnowledgePointEncodeParentPointId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "EncodeParentPointId");
    private final static QName _KnowledgePointEncodePointId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "EncodePointId");
    private final static QName _KnowledgePointListKnowledgePoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "KnowledgePoints");
    private final static QName _QuestionCategoryParentCategoryId_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "ParentCategoryId");
    private final static QName _QuestionCategoryQuestionCategoryName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", "QuestionCategoryName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.motk_model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QuestionCategory }
     * 
     */
    public QuestionCategory createQuestionCategory() {
        return new QuestionCategory();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionCategory }
     * 
     */
    public ArrayOfQuestionCategory createArrayOfQuestionCategory() {
        return new ArrayOfQuestionCategory();
    }

    /**
     * Create an instance of {@link KnowledgePointList }
     * 
     */
    public KnowledgePointList createKnowledgePointList() {
        return new KnowledgePointList();
    }

    /**
     * Create an instance of {@link ArrayOfKnowledgePoint }
     * 
     */
    public ArrayOfKnowledgePoint createArrayOfKnowledgePoint() {
        return new ArrayOfKnowledgePoint();
    }

    /**
     * Create an instance of {@link KnowledgePoint }
     * 
     */
    public KnowledgePoint createKnowledgePoint() {
        return new KnowledgePoint();
    }

    /**
     * Create an instance of {@link ArrayOfBookVersion }
     * 
     */
    public ArrayOfBookVersion createArrayOfBookVersion() {
        return new ArrayOfBookVersion();
    }

    /**
     * Create an instance of {@link BookVersion }
     * 
     */
    public BookVersion createBookVersion() {
        return new BookVersion();
    }

    /**
     * Create an instance of {@link PublisherBookVersion }
     * 
     */
    public PublisherBookVersion createPublisherBookVersion() {
        return new PublisherBookVersion();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionAttachment }
     * 
     */
    public ArrayOfQuestionAttachment createArrayOfQuestionAttachment() {
        return new ArrayOfQuestionAttachment();
    }

    /**
     * Create an instance of {@link QuestionAttachment }
     * 
     */
    public QuestionAttachment createQuestionAttachment() {
        return new QuestionAttachment();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionOptionGroup }
     * 
     */
    public ArrayOfQuestionOptionGroup createArrayOfQuestionOptionGroup() {
        return new ArrayOfQuestionOptionGroup();
    }

    /**
     * Create an instance of {@link QuestionOptionGroup }
     * 
     */
    public QuestionOptionGroup createQuestionOptionGroup() {
        return new QuestionOptionGroup();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionOptionGroupAnswer }
     * 
     */
    public ArrayOfQuestionOptionGroupAnswer createArrayOfQuestionOptionGroupAnswer() {
        return new ArrayOfQuestionOptionGroupAnswer();
    }

    /**
     * Create an instance of {@link QuestionOptionGroupAnswer }
     * 
     */
    public QuestionOptionGroupAnswer createQuestionOptionGroupAnswer() {
        return new QuestionOptionGroupAnswer();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionOption }
     * 
     */
    public ArrayOfQuestionOption createArrayOfQuestionOption() {
        return new ArrayOfQuestionOption();
    }

    /**
     * Create an instance of {@link QuestionOption }
     * 
     */
    public QuestionOption createQuestionOption() {
        return new QuestionOption();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionChapterSectionMapping }
     * 
     */
    public ArrayOfQuestionChapterSectionMapping createArrayOfQuestionChapterSectionMapping() {
        return new ArrayOfQuestionChapterSectionMapping();
    }

    /**
     * Create an instance of {@link QuestionChapterSectionMapping }
     * 
     */
    public QuestionChapterSectionMapping createQuestionChapterSectionMapping() {
        return new QuestionChapterSectionMapping();
    }

    /**
     * Create an instance of {@link ArrayOfQuestion }
     * 
     */
    public ArrayOfQuestion createArrayOfQuestion() {
        return new ArrayOfQuestion();
    }

    /**
     * Create an instance of {@link QuestionStatistics }
     * 
     */
    public QuestionStatistics createQuestionStatistics() {
        return new QuestionStatistics();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionStatisticsDetail }
     * 
     */
    public ArrayOfQuestionStatisticsDetail createArrayOfQuestionStatisticsDetail() {
        return new ArrayOfQuestionStatisticsDetail();
    }

    /**
     * Create an instance of {@link QuestionStatisticsDetail }
     * 
     */
    public QuestionStatisticsDetail createQuestionStatisticsDetail() {
        return new QuestionStatisticsDetail();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionSimplifiedFormat }
     * 
     */
    public ArrayOfQuestionSimplifiedFormat createArrayOfQuestionSimplifiedFormat() {
        return new ArrayOfQuestionSimplifiedFormat();
    }

    /**
     * Create an instance of {@link QuestionSimplifiedFormat }
     * 
     */
    public QuestionSimplifiedFormat createQuestionSimplifiedFormat() {
        return new QuestionSimplifiedFormat();
    }

    /**
     * Create an instance of {@link ArrayOfCourseMapping }
     * 
     */
    public ArrayOfCourseMapping createArrayOfCourseMapping() {
        return new ArrayOfCourseMapping();
    }

    /**
     * Create an instance of {@link CourseMapping }
     * 
     */
    public CourseMapping createCourseMapping() {
        return new CourseMapping();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionFaultType }
     * 
     */
    public ArrayOfQuestionFaultType createArrayOfQuestionFaultType() {
        return new ArrayOfQuestionFaultType();
    }

    /**
     * Create an instance of {@link QuestionFaultType }
     * 
     */
    public QuestionFaultType createQuestionFaultType() {
        return new QuestionFaultType();
    }

    /**
     * Create an instance of {@link ArrayOfKnowledgePointQuestionCount }
     * 
     */
    public ArrayOfKnowledgePointQuestionCount createArrayOfKnowledgePointQuestionCount() {
        return new ArrayOfKnowledgePointQuestionCount();
    }

    /**
     * Create an instance of {@link KnowledgePointQuestionCount }
     * 
     */
    public KnowledgePointQuestionCount createKnowledgePointQuestionCount() {
        return new KnowledgePointQuestionCount();
    }

    /**
     * Create an instance of {@link ArrayOfPublisher }
     * 
     */
    public ArrayOfPublisher createArrayOfPublisher() {
        return new ArrayOfPublisher();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link ArrayOfSchoolBookVersion }
     * 
     */
    public ArrayOfSchoolBookVersion createArrayOfSchoolBookVersion() {
        return new ArrayOfSchoolBookVersion();
    }

    /**
     * Create an instance of {@link SchoolBookVersion }
     * 
     */
    public SchoolBookVersion createSchoolBookVersion() {
        return new SchoolBookVersion();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionDisplayType }
     * 
     */
    public ArrayOfQuestionDisplayType createArrayOfQuestionDisplayType() {
        return new ArrayOfQuestionDisplayType();
    }

    /**
     * Create an instance of {@link QuestionDisplayType }
     * 
     */
    public QuestionDisplayType createQuestionDisplayType() {
        return new QuestionDisplayType();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionReportModel }
     * 
     */
    public ArrayOfQuestionReportModel createArrayOfQuestionReportModel() {
        return new ArrayOfQuestionReportModel();
    }

    /**
     * Create an instance of {@link QuestionReportModel }
     * 
     */
    public QuestionReportModel createQuestionReportModel() {
        return new QuestionReportModel();
    }

    /**
     * Create an instance of {@link ExamRuler }
     * 
     */
    public ExamRuler createExamRuler() {
        return new ExamRuler();
    }

    /**
     * Create an instance of {@link ArrayOfKnowledgePointPoint }
     * 
     */
    public ArrayOfKnowledgePointPoint createArrayOfKnowledgePointPoint() {
        return new ArrayOfKnowledgePointPoint();
    }

    /**
     * Create an instance of {@link KnowledgePointPoint }
     * 
     */
    public KnowledgePointPoint createKnowledgePointPoint() {
        return new KnowledgePointPoint();
    }

    /**
     * Create an instance of {@link ArrayOfKnowledgePointPointQuestion }
     * 
     */
    public ArrayOfKnowledgePointPointQuestion createArrayOfKnowledgePointPointQuestion() {
        return new ArrayOfKnowledgePointPointQuestion();
    }

    /**
     * Create an instance of {@link KnowledgePointPointQuestion }
     * 
     */
    public KnowledgePointPointQuestion createKnowledgePointPointQuestion() {
        return new KnowledgePointPointQuestion();
    }

    /**
     * Create an instance of {@link ArrayOfExamUsageRuler }
     * 
     */
    public ArrayOfExamUsageRuler createArrayOfExamUsageRuler() {
        return new ArrayOfExamUsageRuler();
    }

    /**
     * Create an instance of {@link ExamUsageRuler }
     * 
     */
    public ExamUsageRuler createExamUsageRuler() {
        return new ExamUsageRuler();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionSimplifiedFormatCache }
     * 
     */
    public ArrayOfQuestionSimplifiedFormatCache createArrayOfQuestionSimplifiedFormatCache() {
        return new ArrayOfQuestionSimplifiedFormatCache();
    }

    /**
     * Create an instance of {@link QuestionSimplifiedFormatCache }
     * 
     */
    public QuestionSimplifiedFormatCache createQuestionSimplifiedFormatCache() {
        return new QuestionSimplifiedFormatCache();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionStatistics }
     * 
     */
    public ArrayOfQuestionStatistics createArrayOfQuestionStatistics() {
        return new ArrayOfQuestionStatistics();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionLabel }
     * 
     */
    public ArrayOfQuestionLabel createArrayOfQuestionLabel() {
        return new ArrayOfQuestionLabel();
    }

    /**
     * Create an instance of {@link QuestionLabel }
     * 
     */
    public QuestionLabel createQuestionLabel() {
        return new QuestionLabel();
    }

    /**
     * Create an instance of {@link ChapterSectionList }
     * 
     */
    public ChapterSectionList createChapterSectionList() {
        return new ChapterSectionList();
    }

    /**
     * Create an instance of {@link ChapterSection }
     * 
     */
    public ChapterSection createChapterSection() {
        return new ChapterSection();
    }

    /**
     * Create an instance of {@link ArrayOfChapterSection }
     * 
     */
    public ArrayOfChapterSection createArrayOfChapterSection() {
        return new ArrayOfChapterSection();
    }

    /**
     * Create an instance of {@link ArrayOfQuestionCategoryModel }
     * 
     */
    public ArrayOfQuestionCategoryModel createArrayOfQuestionCategoryModel() {
        return new ArrayOfQuestionCategoryModel();
    }

    /**
     * Create an instance of {@link QuestionCategoryModel }
     * 
     */
    public QuestionCategoryModel createQuestionCategoryModel() {
        return new QuestionCategoryModel();
    }

    /**
     * Create an instance of {@link PreKnowledgePointList }
     * 
     */
    public PreKnowledgePointList createPreKnowledgePointList() {
        return new PreKnowledgePointList();
    }

    /**
     * Create an instance of {@link ArrayOfChapterSectionKnowledgeMapping }
     * 
     */
    public ArrayOfChapterSectionKnowledgeMapping createArrayOfChapterSectionKnowledgeMapping() {
        return new ArrayOfChapterSectionKnowledgeMapping();
    }

    /**
     * Create an instance of {@link ChapterSectionKnowledgeMapping }
     * 
     */
    public ChapterSectionKnowledgeMapping createChapterSectionKnowledgeMapping() {
        return new ChapterSectionKnowledgeMapping();
    }

    /**
     * Create an instance of {@link OnlineQuestionSimplifiedFormatSectionList }
     * 
     */
    public OnlineQuestionSimplifiedFormatSectionList createOnlineQuestionSimplifiedFormatSectionList() {
        return new OnlineQuestionSimplifiedFormatSectionList();
    }

    /**
     * Create an instance of {@link ArrayOfOnlineQuestionSimplifiedFormat }
     * 
     */
    public ArrayOfOnlineQuestionSimplifiedFormat createArrayOfOnlineQuestionSimplifiedFormat() {
        return new ArrayOfOnlineQuestionSimplifiedFormat();
    }

    /**
     * Create an instance of {@link OnlineQuestionSimplifiedFormat }
     * 
     */
    public OnlineQuestionSimplifiedFormat createOnlineQuestionSimplifiedFormat() {
        return new OnlineQuestionSimplifiedFormat();
    }

    /**
     * Create an instance of {@link OnlineQuestionSimplifiedFormatKnowledgePointList }
     * 
     */
    public OnlineQuestionSimplifiedFormatKnowledgePointList createOnlineQuestionSimplifiedFormatKnowledgePointList() {
        return new OnlineQuestionSimplifiedFormatKnowledgePointList();
    }

    /**
     * Create an instance of {@link SimilarQuestionList }
     * 
     */
    public SimilarQuestionList createSimilarQuestionList() {
        return new SimilarQuestionList();
    }

    /**
     * Create an instance of {@link ClassRoomEvaluationDefaultSelected }
     * 
     */
    public ClassRoomEvaluationDefaultSelected createClassRoomEvaluationDefaultSelected() {
        return new ClassRoomEvaluationDefaultSelected();
    }

    /**
     * Create an instance of {@link IdRequest }
     * 
     */
    public IdRequest createIdRequest() {
        return new IdRequest();
    }

    /**
     * Create an instance of {@link RequestBase }
     * 
     */
    public RequestBase createRequestBase() {
        return new RequestBase();
    }

    /**
     * Create an instance of {@link ResultBase }
     * 
     */
    public ResultBase createResultBase() {
        return new ResultBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionCategory")
    public JAXBElement<QuestionCategory> createQuestionCategory(QuestionCategory value) {
        return new JAXBElement<QuestionCategory>(_QuestionCategory_QNAME, QuestionCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionCategory")
    public JAXBElement<ArrayOfQuestionCategory> createArrayOfQuestionCategory(ArrayOfQuestionCategory value) {
        return new JAXBElement<ArrayOfQuestionCategory>(_ArrayOfQuestionCategory_QNAME, ArrayOfQuestionCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointList")
    public JAXBElement<KnowledgePointList> createKnowledgePointList(KnowledgePointList value) {
        return new JAXBElement<KnowledgePointList>(_KnowledgePointList_QNAME, KnowledgePointList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfKnowledgePoint")
    public JAXBElement<ArrayOfKnowledgePoint> createArrayOfKnowledgePoint(ArrayOfKnowledgePoint value) {
        return new JAXBElement<ArrayOfKnowledgePoint>(_ArrayOfKnowledgePoint_QNAME, ArrayOfKnowledgePoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePoint")
    public JAXBElement<KnowledgePoint> createKnowledgePoint(KnowledgePoint value) {
        return new JAXBElement<KnowledgePoint>(_KnowledgePoint_QNAME, KnowledgePoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfBookVersion")
    public JAXBElement<ArrayOfBookVersion> createArrayOfBookVersion(ArrayOfBookVersion value) {
        return new JAXBElement<ArrayOfBookVersion>(_ArrayOfBookVersion_QNAME, ArrayOfBookVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "BookVersion")
    public JAXBElement<BookVersion> createBookVersion(BookVersion value) {
        return new JAXBElement<BookVersion>(_BookVersion_QNAME, BookVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublisherBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherBookVersion")
    public JAXBElement<PublisherBookVersion> createPublisherBookVersion(PublisherBookVersion value) {
        return new JAXBElement<PublisherBookVersion>(_PublisherBookVersion_QNAME, PublisherBookVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Question")
    public JAXBElement<Question> createQuestion(Question value) {
        return new JAXBElement<Question>(_Question_QNAME, Question.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionAttachment")
    public JAXBElement<ArrayOfQuestionAttachment> createArrayOfQuestionAttachment(ArrayOfQuestionAttachment value) {
        return new JAXBElement<ArrayOfQuestionAttachment>(_ArrayOfQuestionAttachment_QNAME, ArrayOfQuestionAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionAttachment")
    public JAXBElement<QuestionAttachment> createQuestionAttachment(QuestionAttachment value) {
        return new JAXBElement<QuestionAttachment>(_QuestionAttachment_QNAME, QuestionAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionOptionGroup")
    public JAXBElement<ArrayOfQuestionOptionGroup> createArrayOfQuestionOptionGroup(ArrayOfQuestionOptionGroup value) {
        return new JAXBElement<ArrayOfQuestionOptionGroup>(_ArrayOfQuestionOptionGroup_QNAME, ArrayOfQuestionOptionGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionOptionGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionOptionGroup")
    public JAXBElement<QuestionOptionGroup> createQuestionOptionGroup(QuestionOptionGroup value) {
        return new JAXBElement<QuestionOptionGroup>(_QuestionOptionGroup_QNAME, QuestionOptionGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroupAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionOptionGroupAnswer")
    public JAXBElement<ArrayOfQuestionOptionGroupAnswer> createArrayOfQuestionOptionGroupAnswer(ArrayOfQuestionOptionGroupAnswer value) {
        return new JAXBElement<ArrayOfQuestionOptionGroupAnswer>(_ArrayOfQuestionOptionGroupAnswer_QNAME, ArrayOfQuestionOptionGroupAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionOptionGroupAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionOptionGroupAnswer")
    public JAXBElement<QuestionOptionGroupAnswer> createQuestionOptionGroupAnswer(QuestionOptionGroupAnswer value) {
        return new JAXBElement<QuestionOptionGroupAnswer>(_QuestionOptionGroupAnswer_QNAME, QuestionOptionGroupAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionOption")
    public JAXBElement<ArrayOfQuestionOption> createArrayOfQuestionOption(ArrayOfQuestionOption value) {
        return new JAXBElement<ArrayOfQuestionOption>(_ArrayOfQuestionOption_QNAME, ArrayOfQuestionOption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionOption")
    public JAXBElement<QuestionOption> createQuestionOption(QuestionOption value) {
        return new JAXBElement<QuestionOption>(_QuestionOption_QNAME, QuestionOption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionChapterSectionMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionChapterSectionMapping")
    public JAXBElement<ArrayOfQuestionChapterSectionMapping> createArrayOfQuestionChapterSectionMapping(ArrayOfQuestionChapterSectionMapping value) {
        return new JAXBElement<ArrayOfQuestionChapterSectionMapping>(_ArrayOfQuestionChapterSectionMapping_QNAME, ArrayOfQuestionChapterSectionMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionChapterSectionMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionChapterSectionMapping")
    public JAXBElement<QuestionChapterSectionMapping> createQuestionChapterSectionMapping(QuestionChapterSectionMapping value) {
        return new JAXBElement<QuestionChapterSectionMapping>(_QuestionChapterSectionMapping_QNAME, QuestionChapterSectionMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestion")
    public JAXBElement<ArrayOfQuestion> createArrayOfQuestion(ArrayOfQuestion value) {
        return new JAXBElement<ArrayOfQuestion>(_ArrayOfQuestion_QNAME, ArrayOfQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionStatistics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionStatistics")
    public JAXBElement<QuestionStatistics> createQuestionStatistics(QuestionStatistics value) {
        return new JAXBElement<QuestionStatistics>(_QuestionStatistics_QNAME, QuestionStatistics.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionStatisticsDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionStatisticsDetail")
    public JAXBElement<ArrayOfQuestionStatisticsDetail> createArrayOfQuestionStatisticsDetail(ArrayOfQuestionStatisticsDetail value) {
        return new JAXBElement<ArrayOfQuestionStatisticsDetail>(_ArrayOfQuestionStatisticsDetail_QNAME, ArrayOfQuestionStatisticsDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionStatisticsDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionStatisticsDetail")
    public JAXBElement<QuestionStatisticsDetail> createQuestionStatisticsDetail(QuestionStatisticsDetail value) {
        return new JAXBElement<QuestionStatisticsDetail>(_QuestionStatisticsDetail_QNAME, QuestionStatisticsDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionSimplifiedFormat")
    public JAXBElement<ArrayOfQuestionSimplifiedFormat> createArrayOfQuestionSimplifiedFormat(ArrayOfQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfQuestionSimplifiedFormat>(_ArrayOfQuestionSimplifiedFormat_QNAME, ArrayOfQuestionSimplifiedFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionSimplifiedFormat")
    public JAXBElement<QuestionSimplifiedFormat> createQuestionSimplifiedFormat(QuestionSimplifiedFormat value) {
        return new JAXBElement<QuestionSimplifiedFormat>(_QuestionSimplifiedFormat_QNAME, QuestionSimplifiedFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCourseMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfCourseMapping")
    public JAXBElement<ArrayOfCourseMapping> createArrayOfCourseMapping(ArrayOfCourseMapping value) {
        return new JAXBElement<ArrayOfCourseMapping>(_ArrayOfCourseMapping_QNAME, ArrayOfCourseMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourseMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CourseMapping")
    public JAXBElement<CourseMapping> createCourseMapping(CourseMapping value) {
        return new JAXBElement<CourseMapping>(_CourseMapping_QNAME, CourseMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionFaultType")
    public JAXBElement<ArrayOfQuestionFaultType> createArrayOfQuestionFaultType(ArrayOfQuestionFaultType value) {
        return new JAXBElement<ArrayOfQuestionFaultType>(_ArrayOfQuestionFaultType_QNAME, ArrayOfQuestionFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionFaultType")
    public JAXBElement<QuestionFaultType> createQuestionFaultType(QuestionFaultType value) {
        return new JAXBElement<QuestionFaultType>(_QuestionFaultType_QNAME, QuestionFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointQuestionCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfKnowledgePointQuestionCount")
    public JAXBElement<ArrayOfKnowledgePointQuestionCount> createArrayOfKnowledgePointQuestionCount(ArrayOfKnowledgePointQuestionCount value) {
        return new JAXBElement<ArrayOfKnowledgePointQuestionCount>(_ArrayOfKnowledgePointQuestionCount_QNAME, ArrayOfKnowledgePointQuestionCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointQuestionCount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointQuestionCount")
    public JAXBElement<KnowledgePointQuestionCount> createKnowledgePointQuestionCount(KnowledgePointQuestionCount value) {
        return new JAXBElement<KnowledgePointQuestionCount>(_KnowledgePointQuestionCount_QNAME, KnowledgePointQuestionCount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPublisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfPublisher")
    public JAXBElement<ArrayOfPublisher> createArrayOfPublisher(ArrayOfPublisher value) {
        return new JAXBElement<ArrayOfPublisher>(_ArrayOfPublisher_QNAME, ArrayOfPublisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Publisher")
    public JAXBElement<Publisher> createPublisher(Publisher value) {
        return new JAXBElement<Publisher>(_Publisher_QNAME, Publisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSchoolBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfSchoolBookVersion")
    public JAXBElement<ArrayOfSchoolBookVersion> createArrayOfSchoolBookVersion(ArrayOfSchoolBookVersion value) {
        return new JAXBElement<ArrayOfSchoolBookVersion>(_ArrayOfSchoolBookVersion_QNAME, ArrayOfSchoolBookVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SchoolBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SchoolBookVersion")
    public JAXBElement<SchoolBookVersion> createSchoolBookVersion(SchoolBookVersion value) {
        return new JAXBElement<SchoolBookVersion>(_SchoolBookVersion_QNAME, SchoolBookVersion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionDisplayType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionDisplayType")
    public JAXBElement<ArrayOfQuestionDisplayType> createArrayOfQuestionDisplayType(ArrayOfQuestionDisplayType value) {
        return new JAXBElement<ArrayOfQuestionDisplayType>(_ArrayOfQuestionDisplayType_QNAME, ArrayOfQuestionDisplayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionDisplayType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionDisplayType")
    public JAXBElement<QuestionDisplayType> createQuestionDisplayType(QuestionDisplayType value) {
        return new JAXBElement<QuestionDisplayType>(_QuestionDisplayType_QNAME, QuestionDisplayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionReportModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionReportModel")
    public JAXBElement<ArrayOfQuestionReportModel> createArrayOfQuestionReportModel(ArrayOfQuestionReportModel value) {
        return new JAXBElement<ArrayOfQuestionReportModel>(_ArrayOfQuestionReportModel_QNAME, ArrayOfQuestionReportModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionReportModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionReportModel")
    public JAXBElement<QuestionReportModel> createQuestionReportModel(QuestionReportModel value) {
        return new JAXBElement<QuestionReportModel>(_QuestionReportModel_QNAME, QuestionReportModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamRuler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ExamRuler")
    public JAXBElement<ExamRuler> createExamRuler(ExamRuler value) {
        return new JAXBElement<ExamRuler>(_ExamRuler_QNAME, ExamRuler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfKnowledgePointPoint")
    public JAXBElement<ArrayOfKnowledgePointPoint> createArrayOfKnowledgePointPoint(ArrayOfKnowledgePointPoint value) {
        return new JAXBElement<ArrayOfKnowledgePointPoint>(_ArrayOfKnowledgePointPoint_QNAME, ArrayOfKnowledgePointPoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointPoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointPoint")
    public JAXBElement<KnowledgePointPoint> createKnowledgePointPoint(KnowledgePointPoint value) {
        return new JAXBElement<KnowledgePointPoint>(_KnowledgePointPoint_QNAME, KnowledgePointPoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPointQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfKnowledgePointPointQuestion")
    public JAXBElement<ArrayOfKnowledgePointPointQuestion> createArrayOfKnowledgePointPointQuestion(ArrayOfKnowledgePointPointQuestion value) {
        return new JAXBElement<ArrayOfKnowledgePointPointQuestion>(_ArrayOfKnowledgePointPointQuestion_QNAME, ArrayOfKnowledgePointPointQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KnowledgePointPointQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointPointQuestion")
    public JAXBElement<KnowledgePointPointQuestion> createKnowledgePointPointQuestion(KnowledgePointPointQuestion value) {
        return new JAXBElement<KnowledgePointPointQuestion>(_KnowledgePointPointQuestion_QNAME, KnowledgePointPointQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfExamUsageRuler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfExamUsageRuler")
    public JAXBElement<ArrayOfExamUsageRuler> createArrayOfExamUsageRuler(ArrayOfExamUsageRuler value) {
        return new JAXBElement<ArrayOfExamUsageRuler>(_ArrayOfExamUsageRuler_QNAME, ArrayOfExamUsageRuler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamUsageRuler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ExamUsageRuler")
    public JAXBElement<ExamUsageRuler> createExamUsageRuler(ExamUsageRuler value) {
        return new JAXBElement<ExamUsageRuler>(_ExamUsageRuler_QNAME, ExamUsageRuler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionSimplifiedFormatCache }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionSimplifiedFormatCache")
    public JAXBElement<ArrayOfQuestionSimplifiedFormatCache> createArrayOfQuestionSimplifiedFormatCache(ArrayOfQuestionSimplifiedFormatCache value) {
        return new JAXBElement<ArrayOfQuestionSimplifiedFormatCache>(_ArrayOfQuestionSimplifiedFormatCache_QNAME, ArrayOfQuestionSimplifiedFormatCache.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionSimplifiedFormatCache }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionSimplifiedFormatCache")
    public JAXBElement<QuestionSimplifiedFormatCache> createQuestionSimplifiedFormatCache(QuestionSimplifiedFormatCache value) {
        return new JAXBElement<QuestionSimplifiedFormatCache>(_QuestionSimplifiedFormatCache_QNAME, QuestionSimplifiedFormatCache.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionStatistics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionStatistics")
    public JAXBElement<ArrayOfQuestionStatistics> createArrayOfQuestionStatistics(ArrayOfQuestionStatistics value) {
        return new JAXBElement<ArrayOfQuestionStatistics>(_ArrayOfQuestionStatistics_QNAME, ArrayOfQuestionStatistics.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionLabel")
    public JAXBElement<ArrayOfQuestionLabel> createArrayOfQuestionLabel(ArrayOfQuestionLabel value) {
        return new JAXBElement<ArrayOfQuestionLabel>(_ArrayOfQuestionLabel_QNAME, ArrayOfQuestionLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionLabel")
    public JAXBElement<QuestionLabel> createQuestionLabel(QuestionLabel value) {
        return new JAXBElement<QuestionLabel>(_QuestionLabel_QNAME, QuestionLabel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChapterSectionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ChapterSectionList")
    public JAXBElement<ChapterSectionList> createChapterSectionList(ChapterSectionList value) {
        return new JAXBElement<ChapterSectionList>(_ChapterSectionList_QNAME, ChapterSectionList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChapterSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ChapterSection")
    public JAXBElement<ChapterSection> createChapterSection(ChapterSection value) {
        return new JAXBElement<ChapterSection>(_ChapterSection_QNAME, ChapterSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfChapterSection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfChapterSection")
    public JAXBElement<ArrayOfChapterSection> createArrayOfChapterSection(ArrayOfChapterSection value) {
        return new JAXBElement<ArrayOfChapterSection>(_ArrayOfChapterSection_QNAME, ArrayOfChapterSection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionCategoryModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfQuestionCategoryModel")
    public JAXBElement<ArrayOfQuestionCategoryModel> createArrayOfQuestionCategoryModel(ArrayOfQuestionCategoryModel value) {
        return new JAXBElement<ArrayOfQuestionCategoryModel>(_ArrayOfQuestionCategoryModel_QNAME, ArrayOfQuestionCategoryModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionCategoryModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionCategoryModel")
    public JAXBElement<QuestionCategoryModel> createQuestionCategoryModel(QuestionCategoryModel value) {
        return new JAXBElement<QuestionCategoryModel>(_QuestionCategoryModel_QNAME, QuestionCategoryModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PreKnowledgePointList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PreKnowledgePointList")
    public JAXBElement<PreKnowledgePointList> createPreKnowledgePointList(PreKnowledgePointList value) {
        return new JAXBElement<PreKnowledgePointList>(_PreKnowledgePointList_QNAME, PreKnowledgePointList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfChapterSectionKnowledgeMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfChapterSectionKnowledgeMapping")
    public JAXBElement<ArrayOfChapterSectionKnowledgeMapping> createArrayOfChapterSectionKnowledgeMapping(ArrayOfChapterSectionKnowledgeMapping value) {
        return new JAXBElement<ArrayOfChapterSectionKnowledgeMapping>(_ArrayOfChapterSectionKnowledgeMapping_QNAME, ArrayOfChapterSectionKnowledgeMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChapterSectionKnowledgeMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ChapterSectionKnowledgeMapping")
    public JAXBElement<ChapterSectionKnowledgeMapping> createChapterSectionKnowledgeMapping(ChapterSectionKnowledgeMapping value) {
        return new JAXBElement<ChapterSectionKnowledgeMapping>(_ChapterSectionKnowledgeMapping_QNAME, ChapterSectionKnowledgeMapping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineQuestionSimplifiedFormatSectionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "OnlineQuestionSimplifiedFormatSectionList")
    public JAXBElement<OnlineQuestionSimplifiedFormatSectionList> createOnlineQuestionSimplifiedFormatSectionList(OnlineQuestionSimplifiedFormatSectionList value) {
        return new JAXBElement<OnlineQuestionSimplifiedFormatSectionList>(_OnlineQuestionSimplifiedFormatSectionList_QNAME, OnlineQuestionSimplifiedFormatSectionList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOnlineQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ArrayOfOnlineQuestionSimplifiedFormat")
    public JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat> createArrayOfOnlineQuestionSimplifiedFormat(ArrayOfOnlineQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat>(_ArrayOfOnlineQuestionSimplifiedFormat_QNAME, ArrayOfOnlineQuestionSimplifiedFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "OnlineQuestionSimplifiedFormat")
    public JAXBElement<OnlineQuestionSimplifiedFormat> createOnlineQuestionSimplifiedFormat(OnlineQuestionSimplifiedFormat value) {
        return new JAXBElement<OnlineQuestionSimplifiedFormat>(_OnlineQuestionSimplifiedFormat_QNAME, OnlineQuestionSimplifiedFormat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnlineQuestionSimplifiedFormatKnowledgePointList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "OnlineQuestionSimplifiedFormatKnowledgePointList")
    public JAXBElement<OnlineQuestionSimplifiedFormatKnowledgePointList> createOnlineQuestionSimplifiedFormatKnowledgePointList(OnlineQuestionSimplifiedFormatKnowledgePointList value) {
        return new JAXBElement<OnlineQuestionSimplifiedFormatKnowledgePointList>(_OnlineQuestionSimplifiedFormatKnowledgePointList_QNAME, OnlineQuestionSimplifiedFormatKnowledgePointList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimilarQuestionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SimilarQuestionList")
    public JAXBElement<SimilarQuestionList> createSimilarQuestionList(SimilarQuestionList value) {
        return new JAXBElement<SimilarQuestionList>(_SimilarQuestionList_QNAME, SimilarQuestionList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassRoomEvaluationDefaultSelected }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ClassRoomEvaluationDefaultSelected")
    public JAXBElement<ClassRoomEvaluationDefaultSelected> createClassRoomEvaluationDefaultSelected(ClassRoomEvaluationDefaultSelected value) {
        return new JAXBElement<ClassRoomEvaluationDefaultSelected>(_ClassRoomEvaluationDefaultSelected_QNAME, ClassRoomEvaluationDefaultSelected.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestFromTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum", name = "RequestFromTypeEnum")
    public JAXBElement<RequestFromTypeEnum> createRequestFromTypeEnum(RequestFromTypeEnum value) {
        return new JAXBElement<RequestFromTypeEnum>(_RequestFromTypeEnum_QNAME, RequestFromTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamRulerTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum", name = "ExamRulerTypeEnum")
    public JAXBElement<ExamRulerTypeEnum> createExamRulerTypeEnum(ExamRulerTypeEnum value) {
        return new JAXBElement<ExamRulerTypeEnum>(_ExamRulerTypeEnum_QNAME, ExamRulerTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GradeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum", name = "GradeEnum")
    public JAXBElement<GradeEnum> createGradeEnum(GradeEnum value) {
        return new JAXBElement<GradeEnum>(_GradeEnum_QNAME, GradeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExamRulerUsageTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum", name = "ExamRulerUsageTypeEnum")
    public JAXBElement<ExamRulerUsageTypeEnum> createExamRulerUsageTypeEnum(ExamRulerUsageTypeEnum value) {
        return new JAXBElement<ExamRulerUsageTypeEnum>(_ExamRulerUsageTypeEnum_QNAME, ExamRulerUsageTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Enum", name = "ResultTypeEnum")
    public JAXBElement<ResultTypeEnum> createResultTypeEnum(ResultTypeEnum value) {
        return new JAXBElement<ResultTypeEnum>(_ResultTypeEnum_QNAME, ResultTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", name = "RequestBase")
    public JAXBElement<RequestBase> createRequestBase(RequestBase value) {
        return new JAXBElement<RequestBase>(_RequestBase_QNAME, RequestBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", name = "IdRequest")
    public JAXBElement<IdRequest> createIdRequest(IdRequest value) {
        return new JAXBElement<IdRequest>(_IdRequest_QNAME, IdRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", name = "ResultBase")
    public JAXBElement<ResultBase> createResultBase(ResultBase value) {
        return new JAXBElement<ResultBase>(_ResultBase_QNAME, ResultBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Common", name = "Message", scope = ResultBase.class)
    public JAXBElement<String> createResultBaseMessage(String value) {
        return new JAXBElement<String>(_ResultBaseMessage_QNAME, String.class, ResultBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintArrayOfintty7Ep6D1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "RelatedQuestions", scope = SimilarQuestionList.class)
    public JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1> createSimilarQuestionListRelatedQuestions(ArrayOfKeyValueOfintArrayOfintty7Ep6D1 value) {
        return new JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1>(_SimilarQuestionListRelatedQuestions_QNAME, ArrayOfKeyValueOfintArrayOfintty7Ep6D1 .class, SimilarQuestionList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOnlineQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Questions", scope = OnlineQuestionSimplifiedFormatKnowledgePointList.class)
    public JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat> createOnlineQuestionSimplifiedFormatKnowledgePointListQuestions(ArrayOfOnlineQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat>(_OnlineQuestionSimplifiedFormatKnowledgePointListQuestions_QNAME, ArrayOfOnlineQuestionSimplifiedFormat.class, OnlineQuestionSimplifiedFormatKnowledgePointList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Capabilities", scope = OnlineQuestionSimplifiedFormat.class)
    public JAXBElement<String> createOnlineQuestionSimplifiedFormatCapabilities(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatCapabilities_QNAME, String.class, OnlineQuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "OtherKnowledgePoints", scope = OnlineQuestionSimplifiedFormat.class)
    public JAXBElement<String> createOnlineQuestionSimplifiedFormatOtherKnowledgePoints(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatOtherKnowledgePoints_QNAME, String.class, OnlineQuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SolveMethodLabel", scope = OnlineQuestionSimplifiedFormat.class)
    public JAXBElement<String> createOnlineQuestionSimplifiedFormatSolveMethodLabel(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatSolveMethodLabel_QNAME, String.class, OnlineQuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "UseRange", scope = OnlineQuestionSimplifiedFormat.class)
    public JAXBElement<String> createOnlineQuestionSimplifiedFormatUseRange(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatUseRange_QNAME, String.class, OnlineQuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfOnlineQuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Questions", scope = OnlineQuestionSimplifiedFormatSectionList.class)
    public JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat> createOnlineQuestionSimplifiedFormatSectionListQuestions(ArrayOfOnlineQuestionSimplifiedFormat value) {
        return new JAXBElement<ArrayOfOnlineQuestionSimplifiedFormat>(_OnlineQuestionSimplifiedFormatKnowledgePointListQuestions_QNAME, ArrayOfOnlineQuestionSimplifiedFormat.class, OnlineQuestionSimplifiedFormatSectionList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointIds", scope = ChapterSectionKnowledgeMapping.class)
    public JAXBElement<String> createChapterSectionKnowledgeMappingKnowledgePointIds(String value) {
        return new JAXBElement<String>(_ChapterSectionKnowledgeMappingKnowledgePointIds_QNAME, String.class, ChapterSectionKnowledgeMapping.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintArrayOfintty7Ep6D1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PreKnowledgePoints", scope = PreKnowledgePointList.class)
    public JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1> createPreKnowledgePointListPreKnowledgePoints(ArrayOfKeyValueOfintArrayOfintty7Ep6D1 value) {
        return new JAXBElement<ArrayOfKeyValueOfintArrayOfintty7Ep6D1>(_PreKnowledgePointListPreKnowledgePoints_QNAME, ArrayOfKeyValueOfintArrayOfintty7Ep6D1 .class, PreKnowledgePointList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionCategoryModelName", scope = QuestionCategoryModel.class)
    public JAXBElement<String> createQuestionCategoryModelQuestionCategoryModelName(String value) {
        return new JAXBElement<String>(_QuestionCategoryModelQuestionCategoryModelName_QNAME, String.class, QuestionCategoryModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SectionName", scope = ChapterSection.class)
    public JAXBElement<String> createChapterSectionSectionName(String value) {
        return new JAXBElement<String>(_ChapterSectionSectionName_QNAME, String.class, ChapterSection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintChapterSectionyHSjzk5H }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Sections", scope = ChapterSectionList.class)
    public JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H> createChapterSectionListSections(ArrayOfKeyValueOfintChapterSectionyHSjzk5H value) {
        return new JAXBElement<ArrayOfKeyValueOfintChapterSectionyHSjzk5H>(_ChapterSectionListSections_QNAME, ArrayOfKeyValueOfintChapterSectionyHSjzk5H.class, ChapterSectionList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Annotation", scope = QuestionLabel.class)
    public JAXBElement<String> createQuestionLabelAnnotation(String value) {
        return new JAXBElement<String>(_QuestionLabelAnnotation_QNAME, String.class, QuestionLabel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionLabelName", scope = QuestionLabel.class)
    public JAXBElement<String> createQuestionLabelQuestionLabelName(String value) {
        return new JAXBElement<String>(_QuestionLabelQuestionLabelName_QNAME, String.class, QuestionLabel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointLabels", scope = QuestionSimplifiedFormat.class)
    public JAXBElement<String> createQuestionSimplifiedFormatKnowledgePointLabels(String value) {
        return new JAXBElement<String>(_QuestionSimplifiedFormatKnowledgePointLabels_QNAME, String.class, QuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "MainKnowledgePoints", scope = QuestionSimplifiedFormat.class)
    public JAXBElement<ArrayOfint> createQuestionSimplifiedFormatMainKnowledgePoints(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_QuestionSimplifiedFormatMainKnowledgePoints_QNAME, ArrayOfint.class, QuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "UseRange", scope = QuestionSimplifiedFormat.class)
    public JAXBElement<String> createQuestionSimplifiedFormatUseRange(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatUseRange_QNAME, String.class, QuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "UseRangeIds", scope = QuestionSimplifiedFormat.class)
    public JAXBElement<ArrayOfint> createQuestionSimplifiedFormatUseRangeIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_QuestionSimplifiedFormatUseRangeIds_QNAME, ArrayOfint.class, QuestionSimplifiedFormat.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "BookVersionIds", scope = QuestionSimplifiedFormatCache.class)
    public JAXBElement<ArrayOfint> createQuestionSimplifiedFormatCacheBookVersionIds(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_QuestionSimplifiedFormatCacheBookVersionIds_QNAME, ArrayOfint.class, QuestionSimplifiedFormatCache.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionSimplifiedFormat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Question", scope = KnowledgePointPointQuestion.class)
    public JAXBElement<QuestionSimplifiedFormat> createKnowledgePointPointQuestionQuestion(QuestionSimplifiedFormat value) {
        return new JAXBElement<QuestionSimplifiedFormat>(_Question_QNAME, QuestionSimplifiedFormat.class, KnowledgePointPointQuestion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointName", scope = KnowledgePointPoint.class)
    public JAXBElement<String> createKnowledgePointPointKnowledgePointName(String value) {
        return new JAXBElement<String>(_KnowledgePointPointKnowledgePointName_QNAME, String.class, KnowledgePointPoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ParentKnowledgePointName", scope = KnowledgePointPoint.class)
    public JAXBElement<String> createKnowledgePointPointParentKnowledgePointName(String value) {
        return new JAXBElement<String>(_KnowledgePointPointParentKnowledgePointName_QNAME, String.class, KnowledgePointPoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPointQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "RelatedQuestions", scope = KnowledgePointPoint.class)
    public JAXBElement<ArrayOfKnowledgePointPointQuestion> createKnowledgePointPointRelatedQuestions(ArrayOfKnowledgePointPointQuestion value) {
        return new JAXBElement<ArrayOfKnowledgePointPointQuestion>(_SimilarQuestionListRelatedQuestions_QNAME, ArrayOfKnowledgePointPointQuestion.class, KnowledgePointPoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ExamRulerName", scope = ExamRuler.class)
    public JAXBElement<String> createExamRulerExamRulerName(String value) {
        return new JAXBElement<String>(_ExamRulerExamRulerName_QNAME, String.class, ExamRuler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePointPoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointPoints", scope = ExamRuler.class)
    public JAXBElement<ArrayOfKnowledgePointPoint> createExamRulerKnowledgePointPoints(ArrayOfKnowledgePointPoint value) {
        return new JAXBElement<ArrayOfKnowledgePointPoint>(_ExamRulerKnowledgePointPoints_QNAME, ArrayOfKnowledgePointPoint.class, ExamRuler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "RawData", scope = ExamRuler.class)
    public JAXBElement<String> createExamRulerRawData(String value) {
        return new JAXBElement<String>(_ExamRulerRawData_QNAME, String.class, ExamRuler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "RegionIds", scope = ExamRuler.class)
    public JAXBElement<String> createExamRulerRegionIds(String value) {
        return new JAXBElement<String>(_ExamRulerRegionIds_QNAME, String.class, ExamRuler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CapabilityAnalysis", scope = QuestionReportModel.class)
    public JAXBElement<ArrayOfstring> createQuestionReportModelCapabilityAnalysis(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_QuestionReportModelCapabilityAnalysis_QNAME, ArrayOfstring.class, QuestionReportModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CategoryName", scope = QuestionReportModel.class)
    public JAXBElement<String> createQuestionReportModelCategoryName(String value) {
        return new JAXBElement<String>(_QuestionReportModelCategoryName_QNAME, String.class, QuestionReportModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgeName", scope = QuestionReportModel.class)
    public JAXBElement<String> createQuestionReportModelKnowledgeName(String value) {
        return new JAXBElement<String>(_QuestionReportModelKnowledgeName_QNAME, String.class, QuestionReportModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SolveMethodLabel", scope = QuestionReportModel.class)
    public JAXBElement<ArrayOfstring> createQuestionReportModelSolveMethodLabel(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_OnlineQuestionSimplifiedFormatSolveMethodLabel_QNAME, ArrayOfstring.class, QuestionReportModel.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionDisplayTypeName", scope = QuestionDisplayType.class)
    public JAXBElement<String> createQuestionDisplayTypeQuestionDisplayTypeName(String value) {
        return new JAXBElement<String>(_QuestionDisplayTypeQuestionDisplayTypeName_QNAME, String.class, QuestionDisplayType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherLogoPath", scope = Publisher.class)
    public JAXBElement<String> createPublisherPublisherLogoPath(String value) {
        return new JAXBElement<String>(_PublisherPublisherLogoPath_QNAME, String.class, Publisher.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherLogoShortCode", scope = Publisher.class)
    public JAXBElement<String> createPublisherPublisherLogoShortCode(String value) {
        return new JAXBElement<String>(_PublisherPublisherLogoShortCode_QNAME, String.class, Publisher.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherName", scope = Publisher.class)
    public JAXBElement<String> createPublisherPublisherName(String value) {
        return new JAXBElement<String>(_PublisherPublisherName_QNAME, String.class, Publisher.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "FaultTypeName", scope = QuestionFaultType.class)
    public JAXBElement<String> createQuestionFaultTypeFaultTypeName(String value) {
        return new JAXBElement<String>(_QuestionFaultTypeFaultTypeName_QNAME, String.class, QuestionFaultType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CourseMappingCoverPath", scope = CourseMapping.class)
    public JAXBElement<String> createCourseMappingCourseMappingCoverPath(String value) {
        return new JAXBElement<String>(_CourseMappingCourseMappingCoverPath_QNAME, String.class, CourseMapping.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CourseMappingName", scope = CourseMapping.class)
    public JAXBElement<String> createCourseMappingCourseMappingName(String value) {
        return new JAXBElement<String>(_CourseMappingCourseMappingName_QNAME, String.class, CourseMapping.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CourseMappingShortCode", scope = CourseMapping.class)
    public JAXBElement<String> createCourseMappingCourseMappingShortCode(String value) {
        return new JAXBElement<String>(_CourseMappingCourseMappingShortCode_QNAME, String.class, CourseMapping.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ECmid", scope = CourseMapping.class)
    public JAXBElement<String> createCourseMappingECmid(String value) {
        return new JAXBElement<String>(_CourseMappingECmid_QNAME, String.class, CourseMapping.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ImagePath", scope = CourseMapping.class)
    public JAXBElement<String> createCourseMappingImagePath(String value) {
        return new JAXBElement<String>(_CourseMappingImagePath_QNAME, String.class, CourseMapping.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionOptionId", scope = QuestionStatisticsDetail.class)
    public JAXBElement<String> createQuestionStatisticsDetailQuestionOptionId(String value) {
        return new JAXBElement<String>(_QuestionStatisticsDetailQuestionOptionId_QNAME, String.class, QuestionStatisticsDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionStatisticsDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Details", scope = QuestionStatistics.class)
    public JAXBElement<ArrayOfQuestionStatisticsDetail> createQuestionStatisticsDetails(ArrayOfQuestionStatisticsDetail value) {
        return new JAXBElement<ArrayOfQuestionStatisticsDetail>(_QuestionStatisticsDetails_QNAME, ArrayOfQuestionStatisticsDetail.class, QuestionStatistics.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionSourceReferences", scope = QuestionStatistics.class)
    public JAXBElement<ArrayOfstring> createQuestionStatisticsQuestionSourceReferences(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_QuestionStatisticsQuestionSourceReferences_QNAME, ArrayOfstring.class, QuestionStatistics.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionOptionId", scope = QuestionOption.class)
    public JAXBElement<String> createQuestionOptionQuestionOptionId(String value) {
        return new JAXBElement<String>(_QuestionStatisticsDetailQuestionOptionId_QNAME, String.class, QuestionOption.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionOptionText", scope = QuestionOption.class)
    public JAXBElement<String> createQuestionOptionQuestionOptionText(String value) {
        return new JAXBElement<String>(_QuestionOptionQuestionOptionText_QNAME, String.class, QuestionOption.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Answer", scope = QuestionOptionGroupAnswer.class)
    public JAXBElement<String> createQuestionOptionGroupAnswerAnswer(String value) {
        return new JAXBElement<String>(_QuestionOptionGroupAnswerAnswer_QNAME, String.class, QuestionOptionGroupAnswer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroupAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Answers", scope = QuestionOptionGroup.class)
    public JAXBElement<ArrayOfQuestionOptionGroupAnswer> createQuestionOptionGroupAnswers(ArrayOfQuestionOptionGroupAnswer value) {
        return new JAXBElement<ArrayOfQuestionOptionGroupAnswer>(_QuestionOptionGroupAnswers_QNAME, ArrayOfQuestionOptionGroupAnswer.class, QuestionOptionGroup.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Options", scope = QuestionOptionGroup.class)
    public JAXBElement<ArrayOfQuestionOption> createQuestionOptionGroupOptions(ArrayOfQuestionOption value) {
        return new JAXBElement<ArrayOfQuestionOption>(_QuestionOptionGroupOptions_QNAME, ArrayOfQuestionOption.class, QuestionOptionGroup.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionText", scope = QuestionOptionGroup.class)
    public JAXBElement<String> createQuestionOptionGroupQuestionText(String value) {
        return new JAXBElement<String>(_QuestionOptionGroupQuestionText_QNAME, String.class, QuestionOptionGroup.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionAttachmentName", scope = QuestionAttachment.class)
    public JAXBElement<String> createQuestionAttachmentQuestionAttachmentName(String value) {
        return new JAXBElement<String>(_QuestionAttachmentQuestionAttachmentName_QNAME, String.class, QuestionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionAttachmentUrl", scope = QuestionAttachment.class)
    public JAXBElement<String> createQuestionAttachmentQuestionAttachmentUrl(String value) {
        return new JAXBElement<String>(_QuestionAttachmentQuestionAttachmentUrl_QNAME, String.class, QuestionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "UpdateDateTime", scope = QuestionAttachment.class)
    public JAXBElement<XMLGregorianCalendar> createQuestionAttachmentUpdateDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_QuestionAttachmentUpdateDateTime_QNAME, XMLGregorianCalendar.class, QuestionAttachment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Analysis", scope = Question.class)
    public JAXBElement<String> createQuestionAnalysis(String value) {
        return new JAXBElement<String>(_QuestionAnalysis_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "Attachments", scope = Question.class)
    public JAXBElement<ArrayOfQuestionAttachment> createQuestionAttachments(ArrayOfQuestionAttachment value) {
        return new JAXBElement<ArrayOfQuestionAttachment>(_QuestionAttachments_QNAME, ArrayOfQuestionAttachment.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "CapabilityAnalysis", scope = Question.class)
    public JAXBElement<String> createQuestionCapabilityAnalysis(String value) {
        return new JAXBElement<String>(_QuestionReportModelCapabilityAnalysis_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "FitUseOrganization", scope = Question.class)
    public JAXBElement<ArrayOfstring> createQuestionFitUseOrganization(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_QuestionFitUseOrganization_QNAME, ArrayOfstring.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointLabels", scope = Question.class)
    public JAXBElement<String> createQuestionKnowledgePointLabels(String value) {
        return new JAXBElement<String>(_QuestionSimplifiedFormatKnowledgePointLabels_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "MainKnowledgePoints", scope = Question.class)
    public JAXBElement<String> createQuestionMainKnowledgePoints(String value) {
        return new JAXBElement<String>(_QuestionSimplifiedFormatMainKnowledgePoints_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionOptionGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "OptionGroups", scope = Question.class)
    public JAXBElement<ArrayOfQuestionOptionGroup> createQuestionOptionGroups(ArrayOfQuestionOptionGroup value) {
        return new JAXBElement<ArrayOfQuestionOptionGroup>(_QuestionOptionGroups_QNAME, ArrayOfQuestionOptionGroup.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionAudioUrl", scope = Question.class)
    public JAXBElement<String> createQuestionQuestionAudioUrl(String value) {
        return new JAXBElement<String>(_QuestionQuestionAudioUrl_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionContent", scope = Question.class)
    public JAXBElement<String> createQuestionQuestionContent(String value) {
        return new JAXBElement<String>(_QuestionQuestionContent_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionContentForDisplay", scope = Question.class)
    public JAXBElement<String> createQuestionQuestionContentForDisplay(String value) {
        return new JAXBElement<String>(_QuestionQuestionContentForDisplay_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionSource", scope = Question.class)
    public JAXBElement<String> createQuestionQuestionSource(String value) {
        return new JAXBElement<String>(_QuestionQuestionSource_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfQuestionChapterSectionMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SectionMappings", scope = Question.class)
    public JAXBElement<ArrayOfQuestionChapterSectionMapping> createQuestionSectionMappings(ArrayOfQuestionChapterSectionMapping value) {
        return new JAXBElement<ArrayOfQuestionChapterSectionMapping>(_QuestionSectionMappings_QNAME, ArrayOfQuestionChapterSectionMapping.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SemanticLabels", scope = Question.class)
    public JAXBElement<String> createQuestionSemanticLabels(String value) {
        return new JAXBElement<String>(_QuestionSemanticLabels_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "SolveMethodLabel", scope = Question.class)
    public JAXBElement<String> createQuestionSolveMethodLabel(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatSolveMethodLabel_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "UseRange", scope = Question.class)
    public JAXBElement<String> createQuestionUseRange(String value) {
        return new JAXBElement<String>(_OnlineQuestionSimplifiedFormatUseRange_QNAME, String.class, Question.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherBookVersionCode", scope = PublisherBookVersion.class)
    public JAXBElement<String> createPublisherBookVersionPublisherBookVersionCode(String value) {
        return new JAXBElement<String>(_PublisherBookVersionPublisherBookVersionCode_QNAME, String.class, PublisherBookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherBookVersionFullName", scope = PublisherBookVersion.class)
    public JAXBElement<String> createPublisherBookVersionPublisherBookVersionFullName(String value) {
        return new JAXBElement<String>(_PublisherBookVersionPublisherBookVersionFullName_QNAME, String.class, PublisherBookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherBookVersionName", scope = PublisherBookVersion.class)
    public JAXBElement<String> createPublisherBookVersionPublisherBookVersionName(String value) {
        return new JAXBElement<String>(_PublisherBookVersionPublisherBookVersionName_QNAME, String.class, PublisherBookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherLogoPath", scope = PublisherBookVersion.class)
    public JAXBElement<String> createPublisherBookVersionPublisherLogoPath(String value) {
        return new JAXBElement<String>(_PublisherPublisherLogoPath_QNAME, String.class, PublisherBookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherLogoShortCode", scope = PublisherBookVersion.class)
    public JAXBElement<String> createPublisherBookVersionPublisherLogoShortCode(String value) {
        return new JAXBElement<String>(_PublisherPublisherLogoShortCode_QNAME, String.class, PublisherBookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "BookVersionName", scope = BookVersion.class)
    public JAXBElement<String> createBookVersionBookVersionName(String value) {
        return new JAXBElement<String>(_BookVersionBookVersionName_QNAME, String.class, BookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublisherBookVersion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "PublisherBookVersion", scope = BookVersion.class)
    public JAXBElement<PublisherBookVersion> createBookVersionPublisherBookVersion(PublisherBookVersion value) {
        return new JAXBElement<PublisherBookVersion>(_PublisherBookVersion_QNAME, PublisherBookVersion.class, BookVersion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "EncodeParentPointId", scope = KnowledgePoint.class)
    public JAXBElement<String> createKnowledgePointEncodeParentPointId(String value) {
        return new JAXBElement<String>(_KnowledgePointEncodeParentPointId_QNAME, String.class, KnowledgePoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "EncodePointId", scope = KnowledgePoint.class)
    public JAXBElement<String> createKnowledgePointEncodePointId(String value) {
        return new JAXBElement<String>(_KnowledgePointEncodePointId_QNAME, String.class, KnowledgePoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePointName", scope = KnowledgePoint.class)
    public JAXBElement<String> createKnowledgePointKnowledgePointName(String value) {
        return new JAXBElement<String>(_KnowledgePointPointKnowledgePointName_QNAME, String.class, KnowledgePoint.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKnowledgePoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "KnowledgePoints", scope = KnowledgePointList.class)
    public JAXBElement<ArrayOfKnowledgePoint> createKnowledgePointListKnowledgePoints(ArrayOfKnowledgePoint value) {
        return new JAXBElement<ArrayOfKnowledgePoint>(_KnowledgePointListKnowledgePoints_QNAME, ArrayOfKnowledgePoint.class, KnowledgePointList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "ParentCategoryId", scope = QuestionCategory.class)
    public JAXBElement<String> createQuestionCategoryParentCategoryId(String value) {
        return new JAXBElement<String>(_QuestionCategoryParentCategoryId_QNAME, String.class, QuestionCategory.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Motk.Model.Tiku", name = "QuestionCategoryName", scope = QuestionCategory.class)
    public JAXBElement<String> createQuestionCategoryQuestionCategoryName(String value) {
        return new JAXBElement<String>(_QuestionCategoryQuestionCategoryName_QNAME, String.class, QuestionCategory.class, value);
    }

}
