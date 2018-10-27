package com.ry.cds.user.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.common.CommonConst;
import com.ry.cds.common.CommonUtils;
import com.ry.cds.print.bo.PrintListOutput;
import com.ry.cds.user.bo.ClassRoom;
import com.ry.cds.user.bo.ClassRoomUser;
import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.School;
import com.ry.cds.user.bo.SchoolPriceConfig;
import com.ry.cds.user.bo.SyncUser;
import com.ry.cds.user.bo.SyncUserInput;
import com.ry.cds.user.bo.SyncUserOutput;
import com.ry.cds.user.bo.SyncUserResult;
import com.ry.cds.user.bo.User;
import com.ry.cds.user.bo.UserAccount;
import com.ry.cds.user.bo.UserDocument;
import com.ry.cds.user.dao.IClassRoomDao;
import com.ry.cds.user.dao.IClassRoomUserDao;
import com.ry.cds.user.dao.IDocumentDao;
import com.ry.cds.user.dao.ILocationDao;
import com.ry.cds.user.dao.ISchoolDao;
import com.ry.cds.user.dao.ISchoolPriceConfigDao;
import com.ry.cds.user.dao.IUserAccountDao;
import com.ry.cds.user.dao.IUserDao;
import com.ry.cds.utils.CryptogramHelper;
import com.ry.cds.utils.ListHelper;

@Service
public class UserService implements IUserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	private Dictionary<String, Long> schoolCodeSchoolIDMap = new Hashtable<String, Long>();
	private Dictionary<String, Long> classRoomCodeClassRoomIDMap = new Hashtable<String, Long>();
	@Autowired
	IUserDao userDao;

	@Autowired
	ISchoolDao schoolDao;

	@Autowired
	IClassRoomDao classRoomDao;

	@Autowired
	IDocumentDao documentDao;

	@Autowired
	IClassRoomUserDao classRoomUserDao;

	@Autowired
	ISchoolPriceConfigDao schoolPriceConfigDao;

	@Autowired
	ILocationDao locationDao;

	@Autowired
	IUserAccountDao userAccountDao;

	@Override
	public User get(long userId) throws Exception {
		return userDao.get(userId);
	}

	@Override
	public long insert(User user) throws Exception {
		return userDao.insert(user);
	}

	@Override
	public int update(User user) throws Exception {
		return userDao.update(user);
	}

	@Override
	public User getByUserCode(String userCode) throws Exception {
		return userDao.getByUserCode(userCode);
	}

	@Override
	public User getByCardNo(String cardNo) throws Exception {
		return userDao.getByCardNo(cardNo);
	}

	@Override
	public SyncUserOutput synchronous(SyncUserInput syncUserInput) throws Exception {
		SyncUserOutput outputData = new SyncUserOutput();
		outputData.setFailureCount(0);
		outputData.setSuccessCount(0);
		outputData.setResult(CommonConst.RESULT_Y);
		outputData.setSuccess(true);
		outputData.setList(new ArrayList<SyncUserResult>());
		List<SyncUser> syncUserList = syncUserInput.getData();
		for (SyncUser syncUser : syncUserList) {
			bulkInsertEachProcess(outputData, syncUser);
		}
		return outputData;
	}

	@Override
	public PrintListOutput printList(String cardNo) throws Exception {
		PrintListOutput printListOutput = new PrintListOutput();
		User user = userDao.getByCardNo(cardNo);
		if (null == user) {
			printListOutput.setResult(CommonConst.RESULT_N);
			printListOutput.setSuccess(false);
			printListOutput.setErrorMsg("根据卡号未找到对应用户。");
			return printListOutput;
		}
		UserAccount userAccount = userAccountDao.get(user.getUserID(), 1);
		if (null != userAccount) {
			printListOutput.setBalance(CommonUtils.amountConvertYuan(userAccount.getAmount()));
			printListOutput.setFreezeAmount(CommonUtils.amountConvertYuan(userAccount.getFrezeeAmount()));
		}
		printListOutput.setUserName(user.getUserName());
		List<Document> documentList = documentDao.getByUserID(user.getUserID());
		if (ListHelper.isEmpty(documentList)) {
			printListOutput.setResult(CommonConst.RESULT_Y);
			printListOutput.setSuccess(true);
			return printListOutput;
		}
		SchoolPriceConfig schoolPriceConfig = schoolPriceConfigDao.get(user.getSchoolID());
		printListOutput.setUserDocumentList(new ArrayList<UserDocument>());
		for (Document document : documentList) {
			printListEachProcess(printListOutput, document, schoolPriceConfig);
		}
		printListOutput.setResult(CommonConst.RESULT_Y);
		printListOutput.setSuccess(true);
		return printListOutput;
	}

	/**
	 * 获取用户打印列表循环单条处理
	 * 
	 * @param printListOutput
	 *            返回实体
	 * @param document
	 *            文档对象
	 * @param schoolPriceConfig
	 *            学校机构价格配置数据
	 * @throws Exception
	 */
	private void printListEachProcess(PrintListOutput printListOutput, Document document,
			SchoolPriceConfig schoolPriceConfig) throws Exception {
		UserDocument userDocument = new UserDocument();
		userDocument.setDocumentName(document.getDocumentName());
		userDocument.setDocumentNo(
				CryptogramHelper.encryptThreeDESECB(String.valueOf(document.getDocumentID()), CommonConst.DESKEY));
		userDocument.setDocumentPageCount(document.getPageCount() + "");
		userDocument.setDocumentType(document.getDocumentTypeID() + "");
		userDocument.setPrintStatus(CommonUtils.printStatusMapping(document.getPrintStatus() + ""));
		userDocument.setSubject(document.getCourseID() + "");
		if (1 == schoolPriceConfig.getSaleTypeID()) {
			userDocument.setPrintPrice(
					CommonUtils.amountConvertYuan(schoolPriceConfig.getPrice() * document.getPageCount()));
		} else {
			userDocument.setPrintPrice(CommonUtils.amountConvertYuan(schoolPriceConfig.getPrice()));
		}
		printListOutput.getUserDocumentList().add(userDocument);
	}

	/**
	 * 批量导入用户信息循环单条处理
	 * 
	 * @param outputData
	 * @param syncUser
	 */
	private void bulkInsertEachProcess(SyncUserOutput outputData, SyncUser syncUser) {
		SyncUserResult syncUserResult = new SyncUserResult();
		long userID = 0;
		try {
			checkAndInsertSchool(syncUser);
			checkAndInsertClassRoom(syncUser);
			userID = this.upsetUser(syncUser);
			checkAndInsertClassRoomUser(syncUser, userID);
			syncUserResult.setUserCode(syncUser.getUserCode());
			syncUserResult.setTimestamp(syncUser.getTimestamp());
		} catch (Exception e) {
			log.error(MessageFormat.format("学号为{0}的用户导入异常", syncUser.getUserCode()));
		}
		if (userID > 0) {
			syncUserResult.setSyncStatus(CommonConst.SYNC_STATUS_S);
			outputData.setSuccessCount(outputData.getSuccessCount() + 1);
		} else {
			syncUserResult.setSyncStatus(CommonConst.SYNC_STATUS_F);
			syncUserResult.setErrorMessage("数据插入失败");
			outputData.setFailureCount(outputData.getFailureCount() + 1);
			log.error(MessageFormat.format("学号为{0}的用户导入失败", syncUser.getUserCode()));
		}
		outputData.getList().add(syncUserResult);
	}

	/**
	 * 校验数据库是否存在该学校，不存在则插入
	 * 
	 * @param syncUser
	 * @return
	 * @throws Exception
	 */
	private void checkAndInsertSchool(SyncUser syncUser) throws Exception {

		School school = schoolDao.getBySchoolCode(syncUser.getSchoolCode());
		if (null == school) {
			school = new School();
			school.setSchoolCode(syncUser.getSchoolCode());
			school.setSchoolName(syncUser.getSchoolName());

			school.setStatusFlag(1);
			school.setLocationID(locationDao.getPrimaryByLocationCode(syncUser.getCountyCode()) + "");
			school.setSchoolTypeID(1);
			long schoolID = schoolDao.insert(school);
			if (schoolID > 0) {
				schoolCodeSchoolIDMap.put(school.getSchoolCode(), schoolID);
			}
		} else {
			schoolCodeSchoolIDMap.put(school.getSchoolCode(), school.getSchoolID());
		}
	}

	/**
	 * 校验数据库是否存在该班级，不存在则插入
	 * 
	 * @param syncUser
	 * @return
	 * @throws Exception
	 */
	private void checkAndInsertClassRoom(SyncUser syncUser) throws Exception {
		ClassRoom classRoom = classRoomDao.getByClassRoomCode(syncUser.getClassCode());
		if (null == classRoom) {
			classRoom = new ClassRoom();
			classRoom.setClassRoomCode(syncUser.getClassCode());
			classRoom.setClassRoomName(syncUser.getClassName());
			classRoom.setSchoolID(schoolCodeSchoolIDMap.get(syncUser.getSchoolCode()));
			classRoom.setClassRoomTypeID(1);
			classRoom.setStatusFlag(1);

			long classRoomID = classRoomDao.insert(classRoom);
			if (classRoomID > 0) {
				classRoomCodeClassRoomIDMap.put(classRoom.getClassRoomCode(), classRoomID);
			}
		} else {
			classRoomCodeClassRoomIDMap.put(classRoom.getClassRoomCode(), classRoom.getClassRoomID());
		}
	}

	/**
	 * 校验数据库是否存在该学生班级关系，不存在则插入
	 * 
	 * @param syncUser
	 * @return
	 * @throws Exception
	 */
	private void checkAndInsertClassRoomUser(SyncUser syncUser, long userID) throws Exception {
		long classRoomID = classRoomCodeClassRoomIDMap.get(syncUser.getClassCode());
		boolean isExist = classRoomUserDao.isExist(classRoomID, userID);
		if (!isExist) {
			ClassRoomUser classRoomUser = new ClassRoomUser();
			classRoomUser.setClassRoomID(classRoomID);
			classRoomUser.setUserTypeID(syncUser.getUserType());
			classRoomUser.setUserID(userID);
			classRoomUser.setStatusFlag(1);
			if (syncUser.getUserType() == 1) {
				classRoomUser.setTeacherTypeID(1);
			}
			classRoomUserDao.insert(classRoomUser);
		}
	}

	/**
	 * 校验数据库是否存在该用户，存在则更新，不存在则插入
	 * 
	 * @param syncUser
	 * @return 用户ID
	 * @throws Exception
	 */
	private long upsetUser(SyncUser syncUser) throws Exception {
		User user = new User();
		user.setUserTypeID(syncUser.getUserType());
		user.setSchoolID(schoolCodeSchoolIDMap.get(syncUser.getSchoolCode()));
		user.setSex(syncUser.getSex());
		user.setCourseTypeID(syncUser.getPeriod());
		user.setUserCode(syncUser.getUserCode());
		user.setUserName(syncUser.getUserName());
		user.setBirthday(syncUser.getBirthday());
		user.setAdmissionTime(syncUser.getAdmissionTime());
		user.setPrintFlag(Integer.parseInt(syncUser.getShowFlag()));
		user.setMobile(syncUser.getMobile());
		user.setStatusFlag(1);
		return userDao.upset(user);
	}

}