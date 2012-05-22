package com.tyland.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tyland.common.CommonService;
import com.tyland.domain.Agent;
import com.tyland.domain.Order;
import com.tyland.domain.OrderItem;
import com.tyland.domain.ProductCategory;
import com.tyland.domain.ProductType;
import com.tyland.domain.User;
import com.tyland.service.OrderService;

public class OrderAction extends ActionSupport implements SessionAware {

	private CommonService commonSer;
	private User user;
	private List resultList;
	private ProductType productType;
	private List typeList;
	private Map<String, Object> session;
	private boolean afterQuery;
	private Set productSet;
	private ProductCategory product;
	private Agent agent;
	private Integer p_count;
	private Order order;
	private String failMsg;
	private String deleteCartFlag;
	private Date start_date;
	private Date end_date;
	private OrderService orderService;
	private List agentList;
	private List productList;
	private List reportList;
	private String message;	
	private List<Order> results;
	
	public String getMessage() {
		return message;
	}

	public List<Order> getResults() {
		return results;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date startDate) {
		start_date = startDate;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date endDate) {
		end_date = endDate;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public String getDeleteCartFlag() {
		return deleteCartFlag;
	}

	public void setDeleteCartFlag(String deleteCartFlag) {
		this.deleteCartFlag = deleteCartFlag;
	}

	public Order getOrder() {
		return order;
	}

	public String getFailMsg() {
		return failMsg;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getP_count() {
		return p_count;
	}

	public void setP_count(Integer pCount) {
		p_count = pCount;
	}

	public ProductCategory getProduct() {
		return product;
	}

	public void setProduct(ProductCategory product) {
		this.product = product;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Set getProductSet() {
		return productSet;
	}

	public User getUser() {
		return user;
	}

	public boolean isAfterQuery() {
		return afterQuery;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List getResultList() {
		return resultList;
	}

	public List getTypeList() {
		return typeList;
	}

	public void setCommonSer(CommonService commonSer) {
		this.commonSer = commonSer;
	}
	
	public void setAgentList(List agentList) {
		this.agentList = agentList;
	}

	public List getAgentList() {
		return agentList;
	}

	public void setProductList(List productList) {
		this.productList = productList;
	}

	public List getProductList() {
		return productList;
	}

	public void setReportList(List reportList) {
		this.reportList = reportList;
	}

	public List getReportList() {
		return reportList;
	}


	/* 订单查询*/
	
	public String prepareQuery(){
		
		return "preparequery";
	}
	
	public String query(){
		User login_user = (User) session.get("sessionUser");
		System.out.println(login_user.getAgent().getId());
		int agentid= login_user.getAgent().getId();
		try{
			resultList = orderService.query(order, start_date, end_date, agentid);
		}catch(Exception e){
			
		}
		afterQuery = true;
		return "preparequery";
	}
	
	public String roderDetail(){
		order = (Order) commonSer.queryById(Order.class, order.getId());
		
		return "order_detail";
	}
	
	
	/*订单删除*/
	public String prepareDelete() {
		results = new ArrayList<Order>() ;
		User login_user = (User) session.get("sessionUser");
		int agentId = login_user.getAgent().getId();
		try {
			resultList = orderService.query(order, start_date, end_date, agentId);
			for(int i=0;i<resultList.size();i++){
				Order ord=(Order)resultList.get(i);
				if(ord.getStatus()==0){
					results.add(ord);
				}
				if (ord.getStatus()==3){
					results.add(ord);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		afterQuery = true;
		return "prepareDelete";
	}
	
	
	public String delete(){

		order = (Order)commonSer.queryById(Order.class,order.getId());
		commonSer.delete(order);
		order = null;
		return  prepareDelete();

	}
	
	/*删除功能中的查询*/
	public String deleteQuery() {
		results = new ArrayList<Order>() ;
		User login_user = (User) session.get("sessionUser");
		int agentId = login_user.getAgent().getId();
		try {
			resultList = orderService.query(order, start_date, end_date, agentId);
			for(int i=0;i<resultList.size();i++){
				Order ord=(Order)resultList.get(i);
				if(ord.getStatus()==0){
					results.add(ord);
				}
				if (ord.getStatus()==3){
					results.add(ord);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		order=null;
		afterQuery = true;
		return "to_delete";
	}
	
/*	Order Create*/
	public String toCreate() {
		if (deleteCartFlag!=null && deleteCartFlag.equals("1")) {
		}else {
			//首先清空购物车
			session.remove("cart");

		}
		typeList = commonSer.queryAll(ProductType.class);
		productType = (ProductType) typeList.get(0);
		getProduct(productType);
		afterQuery = true;
		return "to_create";

	}

	public String queryProductByType() {
		typeList = commonSer.queryAll(ProductType.class);
		productType = (ProductType) commonSer.queryById(ProductType.class,productType.getId());
		getProduct(productType);
		afterQuery = true;
		return "to_create";
	}

	private void getProduct(ProductType type) {
		user = (User) session.get("sessionUser");
		Agent agent = user.getAgent();
		productSet = agent.getPublishProductSet();
		Iterator it = productSet.iterator();
		resultList = new ArrayList();
		while (it.hasNext()) {
			ProductCategory p = (ProductCategory) it.next();
			if (p.getProductType().getId().equals(productType.getId())) {
				resultList.add(p);
				// it.remove();
			}
		}
	}

	public String preBuyProduct() {
		int productId = product.getId();
		product = (ProductCategory) commonSer.queryById(ProductCategory.class, productId);
		return "prepare_buy";
	}

	public String buy() {
		int productId = product.getId();
		product = (ProductCategory) commonSer.queryById(ProductCategory.class, productId);
		Map<Integer, OrderItem> cart = (Map<Integer, OrderItem>) session.get("cart");
		if (null == cart) {
			cart = new HashMap<Integer, OrderItem>();
			session.put("cart", cart);
		}
		
		Set<Integer> keys = cart.keySet();
		Iterator<Integer> it = keys.iterator();
		if (it.hasNext()) {
			Integer key = it.next();
			OrderItem firstItem = cart.get(key);
			if (null != firstItem) {
				int innerProductTypeId = firstItem.getProduct().getProductType().getId().intValue();
				if (innerProductTypeId != product.getProductType().getId().intValue()) {
					failMsg = getText("order.ptype.fail");
					return "buy_fail";
				}
			}
			
		}

		OrderItem item = cart.get(productId);
		if (null == item) {
			item = new OrderItem();
			item.setNumber(p_count);
			item.setProduct(product);
			cart.put(productId, item);
		} else {
			item.setNumber(item.getNumber() + p_count);
		}

		return "buy_success";
	}

	public String listCart() {
		return "list_cart";
	}

	public String deleteOrderProduct() {
		int productId = product.getId();
		Map<Integer, OrderItem> cart = (Map<Integer, OrderItem>) session.get("cart");
		if (null != cart) {
			cart.remove(productId);
		}
		return "list_cart";
	}

	// 到输入收货人地址页面，这里需要保存订单and明细
	public String putinAddress() {
		
		//首先判断购物车是否购买过商品
		Map<Integer, OrderItem> cart = (Map<Integer, OrderItem>) session.get("cart");
		if (null == cart || cart.size() <= 0) {
			this.failMsg = this.getText("order.buy.product.first");
			return "buy_fail";
		}
		
		//判断是订单修改还是创建，修改时order不为空
		if (order.getId() != null && order.getId().intValue() > 0) {
			//update
			order = (Order) commonSer.queryById(Order.class, order.getId());
			order.setStatus(0);
			Set<Integer> keys = cart.keySet();
			Set itemSet = new HashSet();
			for (Integer key : keys) {
				OrderItem item = cart.get(key);
				item.setOrder(order);
				itemSet.add(item);
			}
			order.setItemSet(itemSet);
			commonSer.update(order);
		} else {
			//创建订单
			order = new Order();
			order.setCreateTime(new Date());
			order.setStatus(0);
			User login_user = (User) session.get("sessionUser");
			order.setCreate_user(login_user);

		/** 通过所属企业获得审批者 */
		Agent agent = login_user.getAgent();// 所属企业
		Set<User> managerSet = agent.getManagerSet();
		User approvler = null;// 大客户经理中只有1人具有审批权限
		for (User u : managerSet) {
			if (u.getEnabled_approval().intValue() == 1) {
				approvler = u;
				break;
			}
		}
		order.setApprovl_user(approvler);

		
		Set<Integer> keys = cart.keySet();
		Set itemSet = new HashSet();
		for (Integer key : keys) {
			OrderItem item = cart.get(key);
			item.setOrder(order);
			itemSet.add(item);
		}
		order.setItemSet(itemSet);

		commonSer.add(order);
		session.remove("cart");

		// 再修改订单编码
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		String ymd = date.format(new Date());
		String seq = "";
		if (order.getId() < 10) {
			seq = "00" + order.getId();
		} else if (order.getId() < 100) {
			seq = "0" + order.getId();
		} else if (order.getId() < 1000) {
			seq = "0" + order.getId();
		} 
		String code = agent.getCode() + ymd + order.getId() + seq;
		order.setOrderCode(code);
		commonSer.update(order);
		
		}
		session.remove("cart");

		return "to_putAddress";
	}

	
	// 到预览订单页面，这里需要保存订单收获地址
	public String toView() {
		Order order_db = (Order) commonSer
				.queryById(Order.class, order.getId());
		order_db.setAddress(order.getAddress());
		order_db.setCall(order.getCall());
		order_db.setPostCode(order.getPostCode());
		order_db.setReceivePeopleName(order.getReceivePeopleName());
		commonSer.update(order_db);
		order = order_db;// 到页面展现
		return "view_detail";
	}

	public String submit() {
		order = (Order) commonSer.queryById(Order.class, order.getId());
		order.setStatus(1);
		commonSer.update(order);
		message = "/b2b/order/orderAction_toCreate";
		return "create_success";
	}
	/** ******************订单审批******************************/
	public String prepareApprovl() {
		return "to_approvl";
	}
	public String queryForApprovl () {
		User login_user = (User) session.get("sessionUser");
		int agentId = login_user.getManagement_agent().getId();
		user = login_user;
		try {
			resultList = orderService.query(order, start_date, end_date, agentId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		afterQuery = true;
		return "to_approvl";
	}
	public String detailToApprol() {
		order = (Order) commonSer.queryById(Order.class, order.getId());
		User login_user = (User) session.get("sessionUser");
		user = login_user;
		return "detailToApprovl";
	}
	public String approvlOrder () {
		int status = order.getStatus();
		order = (Order) commonSer.queryById(Order.class, order.getId());
		order.setStatus(status);
		commonSer.update(order);
		return "to_approvl";
	}
/*Order Update*/
	public String edit(){
		
		/*resultList = commonSer.queryAll(Order.class);
		afterQuery = true;*/
		return "to_edit";
	}
	
	public String queryforUpdate(){
		User user = (User) session.get("sessionUser");
		int agentId = user.getAgent().getId();
		try{
			resultList = orderService.query(order, start_date, end_date, agentId);
		}catch (Exception e) {
			
		}
		afterQuery = true;
		return "queryforUpdate";
	}

	public String viewOrder() {
		order = (Order) commonSer.queryById(Order.class, order.getId());
		return "orderDetail";
	}
	public String updateOrder() {
		order = (Order) commonSer.queryById(Order.class, order.getId());
		Set<OrderItem> itemSet = order.getItemSet();
		session.remove("cart");
		HashMap<Integer, OrderItem> cart = new HashMap<Integer, OrderItem>();
		for (OrderItem item : itemSet) {
			cart.put(item.getProduct().getId(), item);
		}
		session.put("cart", cart);
		
		return "updateOrder";
	}
	
/*	Order Report*/
	public String prepareReport(){
		agentList = commonSer.queryAll(Agent.class);
		productList = commonSer.queryAll(ProductType.class);
		return "statisticalReport";
	}
	public String statisticalReport(){
		agentList = commonSer.queryAll(Agent.class);
		productList = commonSer.queryAll(ProductType.class);
		int agentId = 0;
		if (agent != null && agent.getId() != null) {
			agentId = agent.getId();
		}
		int productTypeId = 0;
		if (productType != null && productType.getId()!=null) {
			productTypeId = productType.getId();
		}
		reportList = orderService.statisticalReport(start_date, end_date, agentId, productTypeId);
		afterQuery = true;
		return "statisticalReport";
		
	}
}