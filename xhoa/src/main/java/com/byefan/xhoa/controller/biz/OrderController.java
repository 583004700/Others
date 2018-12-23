package com.byefan.xhoa.controller.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.byefan.core.ResponseData;
import com.byefan.core.entity.Dict;
import com.byefan.core.serivce.IDictService;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.biz.Order;
import com.byefan.xhoa.entity.crm.Cust;
import com.byefan.xhoa.entity.crm.DockingPeople;
import com.byefan.xhoa.service.biz.IArticleService;
import com.byefan.xhoa.service.biz.IOrderService;
import com.byefan.xhoa.service.crm.ICustService;
import com.byefan.xhoa.service.crm.IDockingPeopleService;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.FloatUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 订单管理
 */
@Slf4j
@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	IOrderService orderService;
	@Autowired
	IArticleService articleService;
	@Autowired
	ICustService custService;
	@Autowired
	IRoleService roleService;
	@Autowired
	IDockingPeopleService dockingPeopleService;
	@Autowired
	IDictService dictService;
	@Autowired
	IUserService userService;

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseData get(@PathVariable("id") Integer id) {
		ResponseData responseData = null;
		try {
			Order order = orderService.get(id);
			order.setArticles(articleService.listByOrderId(id));
			responseData = ResponseData.ok();
			responseData.putDataValue("order", order);
		} catch (Exception e) {
			responseData = ResponseData.customerError(1001, e.getMessage());
		}
		return responseData;
	}

	/**
	 * 根据订单ID查询订单信息
	 *
	 * @param id
	 * @param mv
	 * @return
	 */
	@GetMapping("/getById/{id}")
	public ModelAndView get(@PathVariable("id") Integer id, ModelAndView mv) {
		try {
			Order order = orderService.get(id);
			if (order == null) {
				mv.setViewName("redirect:/media/order");
				return mv;
			}
			mv.addObject("order", order);
			Integer userId = AppUtil.getUser().getId();
			boolean flag = roleService.isRole(userId, IConst.ROLE_TYPE_YW);
			List<Cust> custs = null;
			List<DockingPeople> dockpeoples = null;
			if (flag) {// 如果是业务员下单只查询自己负责的客户的对接人 和客户
				custs = custService.listByWorker(userId);
				dockpeoples = dockingPeopleService.listByWorker(userId);
			} else {// 如果是媒介下单就查询所有客户和客户的对接人
				custs = custService.list();
				dockpeoples = dockingPeopleService.listByWorker(null);
			}

			mv.addObject("order", order);
			mv.addObject("custs", custs);
			mv.addObject("dockpeoples", dockpeoples);
			List<Dict> taxes = dictService.listByTypeCode("tax");
			mv.addObject("taxes", taxes);

			mv.setViewName("/biz/order");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@GetMapping("/getByNo/{no}")
	@ResponseBody
	public ResponseData getByNo(@PathVariable("no") String no) {
		ResponseData responseData = null;
		try {
			Order order = orderService.getByNo(no);
			responseData = ResponseData.ok();
			responseData.putDataValue("order", order);
		} catch (Exception e) {
			responseData = ResponseData.customerError(1001, e.getMessage());
		}
		return responseData;
	}

	@GetMapping("/list")
	@ResponseBody
	public PageInfo<Order> list(Order order, Pageable pageable) {
		ResponseData responseData = null;
		try {
			PageInfo<Order> list = orderService.list(order, pageable);
			responseData = ResponseData.ok();
			responseData.putDataValue("list", list);
			return list;
		} catch (Exception e) {
			responseData = ResponseData.customerError(1001, e.getMessage());
		}
		// return responseData;
		return null;
	}

	/**
	 * 查询订单列表 订单管理
	 *
	 * @param mv
	 * @return
	 */
	@GetMapping
	@ResponseBody
	public ModelAndView orders(ModelAndView mv) {
		try {
			mv.setViewName("biz/orders");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	//
	// @PostMapping
	// public ResponseData save(Order order) {
	// ResponseData responseData = null;
	// try {
	// order.setCreator(AppUtil.getUser().getId());
	// orderService.save(order);
	// responseData = ResponseData.ok();
	// } catch (Exception e) {
	// responseData = ResponseData.customerError(1001, e.getMessage());
	// }
	// return responseData;
	// }

	@PostMapping("/add")
	@ResponseBody
	public ResponseData add(@RequestBody Order order) {
		ResponseData responseData = null;
		try {
			order.setCreator(AppUtil.getUser().getId());
			orderService.save(order);
			responseData = ResponseData.ok();
			// responseData.putDataValue("order", order);
		} catch (Exception e) {
			e.printStackTrace();
			responseData = ResponseData.customerError(1001, e.getMessage());
		}
		return responseData;
	}

	@PostMapping
	@ResponseBody
	public ResponseData save(@RequestParam("param") String param) {
		ResponseData responseData = null;
		try {
			Order order = this.saveOrder(param);
			responseData = ResponseData.ok();
			// responseData.putDataValue("order", order);
			responseData.putDataValue("orderId", order.getId());
		} catch (Exception e) {
			e.printStackTrace();
			responseData = ResponseData.customerError(1001, e.getMessage());
		}
		return responseData;
	}

	/**
	 * 修改订单信息
	 *
	 * @param order
	 * @return
	 */
	@PutMapping("/update")
	@ResponseBody
	public ResponseData update(@RequestBody Order order) {
		ResponseData responseData = null;
		try {
			// Integer userId = order.getUserId();//通过客户对接人ID
			// if (userId != null) {
			// userId = dockingPeopleService.getById(userId).getWorker();//通过客户对接人查询业务员ID
			// User user = userService.getById(userId);//根据业务员查询业务员信息
			// if (user != null) {
			// order.setUserId(userId);//设置业务员id
			// order.setUserName(user.getName());//设置业务员姓名
			// }
			// }
			orderService.update(order);
			responseData = ResponseData.ok();
			// responseData.putDataValue("order", order);
		} catch (Exception e) {
			e.printStackTrace();
			responseData = ResponseData.customerError(1001, e.getMessage());
		}
		return responseData;
	}

	// @PostMapping
	// @ResponseBody
	// public ModelAndView add(@RequestParam("param") String param, ModelAndView mv)
	// {
	// try {
	// Order order = saveOrder(param);
	// mv.addObject("order", order);
	// mv.setViewName("/biz/order");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return mv;
	// }

	private Order saveOrder(@RequestParam("param") String param) {
		Order order = new Order();
		JSONObject json = JSON.parseObject(param);
		Object numObj = json.get("num");
		double totalPrice = 0.0;
		if (numObj instanceof JSONArray) {
			JSONArray nums = json.getJSONArray("num");
			JSONArray mediaIds = json.getJSONArray("mediaId");
			JSONArray mediaNames = json.getJSONArray("mediaName");
			JSONArray supplierIds = json.getJSONArray("supplierId");
			JSONArray supplierNames = json.getJSONArray("supplierName");
			JSONArray mediaUserIds = json.getJSONArray("mediaUserId");
			JSONArray mediaUserNames = json.getJSONArray("mediaUserName");
			JSONArray priceTypes = json.getJSONArray("priceType");// 价格类型
			JSONArray priceColumns = json.getJSONArray("priceColumn");// 价格类型列名
			JSONArray payAmounts = json.getJSONArray("payAmount");// 单个应付价(=成本价*折扣率)
			JSONArray prices = json.getJSONArray("price");// 报价
			for (int i = 0, len = nums.size(); i < len; i++) {
				Article article = new Article();
				Integer mediaId = mediaIds.getInteger(i);
				article.setMediaId(mediaId);// 媒体ID
				String mediaName = mediaNames.getString(i);
				article.setMediaName(mediaName);// 媒体名称
				Double price = prices.getDouble(i);// 销售价，客户报价
				String priceType = priceTypes.getString(i);
				article.setPriceType(priceType);// 价格类型
				String priceColumn = priceColumns.getString(i);
				article.setPriceColumn(priceColumn);// 价格类型列名
				Integer num = nums.getInteger(i);
				article.setNum(num);// 数量
				Double payAmount = payAmounts.getDouble(i);// 应付价(=成本价*数量*折扣率)
				payAmount *= num;
				article.setPayAmount(payAmount);// 应付价
				article.setSaleAmount(price);// 销售价，客户报价，不含税（=成本价*数量*折扣率*利润率）
				Integer supplierId = supplierIds.getInteger(i);
				article.setSupplierId(supplierId);// 供应商ID
				String supplierName = supplierNames.getString(i);
				article.setSupplierName(supplierName);// 供应商NAME
				Integer mediaUserId = mediaUserIds.getInteger(i);
				article.setMediaUserId(mediaUserId);// 媒介人员ID
				String mediaUserName = mediaUserNames.getString(i);
				article.setMediaUserName(mediaUserName);// 媒介人员姓名
				order.getArticles().add(article);
				totalPrice = FloatUtil.add(price, totalPrice);
			}
		} else {// 添加单个
			Article article = new Article();
			Integer mediaId = json.getInteger("mediaId");
			article.setMediaId(mediaId);// 媒体ID
			String mediaName = json.getString("mediaName");
			article.setMediaName(mediaName);// 媒体名称
			Double price = json.getDouble("price");// 销售价，客户报价
			Double payAmount = json.getDouble("payAmount");// 单个应付价
			String priceType = json.getString("priceType");
			article.setPriceType(priceType);// 价格类型
			String priceColumn = json.getString("priceColumn");
			article.setPriceColumn(priceColumn);// 价格类型列名
			Integer num = json.getInteger("num");
			article.setNum(num);// 数量
			payAmount *= num;
			article.setPayAmount(payAmount);// 应付价
			article.setSaleAmount(price);// 销售价，客户报价
			Integer supplierId = json.getInteger("supplierId");
			article.setSupplierId(supplierId);// 供应商ID
			String supplierName = json.getString("supplierName");
			article.setSupplierName(supplierName);// 供应商NAME
			Integer mediaUserId = json.getInteger("mediaUserId");
			article.setMediaUserId(mediaUserId);// 媒介人员ID
			String mediaUserName = json.getString("mediaUserName");
			article.setMediaUserName(mediaUserName);// 媒介人员姓名
			order.getArticles().add(article);
			totalPrice = FloatUtil.add(price, totalPrice);
		}
		order.setAmount((float) totalPrice);
		orderService.save(order);
		return order;
	}

	/**
	 * 删除订单
	 *
	 * @param orderId
	 * @return
	 */
	@GetMapping("del/{orderId}")
	@ResponseBody
	public ResponseData del(@PathVariable("orderId") Integer orderId) {
		orderService.delById(orderId);
		return ResponseData.ok();
	}

}
