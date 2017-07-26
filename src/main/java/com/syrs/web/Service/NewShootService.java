package com.syrs.web.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;
import com.syrs.web.DAO.FaceListDao;
import com.syrs.web.DAO.ManhuaListDao;
import com.syrs.web.DAO.YellowListDao;
import com.syrs.web.Model.MainImgShowModel;
import com.syrs.web.Model.SecondImgAryModel;
import com.syrs.web.entity.FaceList;
import com.syrs.web.entity.ManhuaList;
import com.syrs.web.entity.YellowList;

@Service
public class NewShootService {
	
	@Resource
	YellowListDao yellowListDao;
	
	@Resource
	ManhuaListDao manhuaListDao;
	
	@Resource
	FaceListDao faceListDao;
	
	/**
	 * 主页展示列表
	 * @return
	 */
	public List<MainImgShowModel> backMainAllImgList() {
		
		List<YellowList> yellowLists = yellowListDao.getList(0, 8);
		List<ManhuaList> manhuaLists = manhuaListDao.getList(0, 8);
		List<FaceList> faceLists = faceListDao.getList(0, 8);
		
		List<MainImgShowModel> list = yellowList2MainImgShowModel(yellowLists);
		list.addAll(manhuaList2MainImgShowModel(manhuaLists));
		list.addAll(FaceList2MainImgShowModel(faceLists));
		
		return list;
		
	}
	
	
	public List<MainImgShowModel> backMainImgList(String tableName, Integer num, Integer count){
		List<MainImgShowModel> list = new ArrayList<>();
		switch (tableName) {
		case "yellow_list":
			list = yellowList2MainImgShowModel(yellowListDao.getList(num, count));
			break;
		case "manhua_list":
			list = manhuaList2MainImgShowModel(manhuaListDao.getList(num, count));
			break;
		case "face_list":
			list = FaceList2MainImgShowModel(faceListDao.getList(num, count));
			break;
		default:
			break;
		}
		return list;
	}
	
	
	/**
	 * yellowList2MainImgShowModel
	 * @param lists
	 * @return
	 */
	public List<MainImgShowModel> yellowList2MainImgShowModel(List<YellowList> lists){
		List<MainImgShowModel> mainImgShowModels = new ArrayList<>();
		for (YellowList list : lists){
			MainImgShowModel mainImgShowModel = new MainImgShowModel();
			mainImgShowModel.setId(list.getId());
			mainImgShowModel.setPath(list.getPath());
			mainImgShowModel.setTitle(list.getTitle());
			mainImgShowModel.setImgNum(list.getImgNum());
			mainImgShowModel.setImgName(list.getImgName());
			mainImgShowModel.setCreateTime(list.getCreatTime());
			mainImgShowModels.add(mainImgShowModel);			
		}		
		return mainImgShowModels;
	}
	
	/**
	 * manhuaList2MainImgShowModel
	 * @param lists
	 * @return
	 */
	public List<MainImgShowModel> manhuaList2MainImgShowModel(List<ManhuaList> lists){
		List<MainImgShowModel> mainImgShowModels = new ArrayList<>();
		for (ManhuaList list : lists){
			MainImgShowModel mainImgShowModel = new MainImgShowModel();
			mainImgShowModel.setId(list.getId());
			mainImgShowModel.setPath(list.getPath());
			mainImgShowModel.setTitle(list.getTitle());
			mainImgShowModel.setManhuaNum(list.getNum());
			mainImgShowModel.setImgName(list.getImgName());
			mainImgShowModel.setCreateTime(list.getCreatTime());
			mainImgShowModels.add(mainImgShowModel);			
		}		
		return mainImgShowModels;
	}
	
	/**
	 * FaceList2MainImgShowModel
	 * @param lists
	 * @return
	 */
	public List<MainImgShowModel> FaceList2MainImgShowModel(List<FaceList> lists){
		List<MainImgShowModel> mainImgShowModels = new ArrayList<>();
		for (FaceList list : lists){
			MainImgShowModel mainImgShowModel = new MainImgShowModel();
			mainImgShowModel.setId(list.getId());
			mainImgShowModel.setPath(list.getPath());
			mainImgShowModel.setTitle(list.getTitle());
			mainImgShowModel.setImgNum(list.getImgNum());
			mainImgShowModel.setImgName(list.getImgName());
			mainImgShowModel.setCreateTime(list.getCreatTime());
			mainImgShowModels.add(mainImgShowModel);			
		}		
		return mainImgShowModels;
	}

	/**
	 * 手机端数据
	 */
	
	public List<MainImgShowModel> mobileMainData(int begin, int count) {
		List<YellowList> yellowLists = yellowListDao.getList(begin, count);
		List<MainImgShowModel> list = yellowList2MainImgShowModel(yellowLists);
		return list;
	}
	
}
