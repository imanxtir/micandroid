package cn.mmbook.platform.action.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.util.extjs.ExtJsPageHelper;
import javacommon.util.extjs.ListRange;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import cn.mmbook.platform.model.manage.SiteChannelsPartReal;


import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;
import static javacommon.util.extjs.Struts2JsonHelper.*;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import cn.mmbook.platform.model.manage.*;
import cn.mmbook.platform.dao.manage.*;
import cn.mmbook.platform.service.manage.impl.*;
import cn.mmbook.platform.service.manage.*;

/**
 * <p> SiteChannelsPartRealAction<br> 
 * <p>   <br>
 * @author admin,
 * @version 1.0. 2010-07-08
 *
 */

public class SiteChannelsPartRealAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private SiteChannelsPartRealManager siteChannelsPartRealManager;
	
	private SiteChannelsPartReal siteChannelsPartReal;
	java.lang.Integer id = null;
	private String[] items;
	/**
	 * 自动获取对象
	 * @exception Exception
	 */
	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			siteChannelsPartReal = new SiteChannelsPartReal();
		} else {
			siteChannelsPartReal = (SiteChannelsPartReal)siteChannelsPartRealManager.getById(id);
		}
	}
	
	/**
	 * 对象通过spring自动注入
	 * @param manager SiteChannelsPartRealManager
	 *  
	 */
	public void setSiteChannelsPartRealManager(SiteChannelsPartRealManager manager) {
		this.siteChannelsPartRealManager = manager;
	}
	/**
	 * struts 自动把页面提交数据转换成数据类对象赋值
	 * @return SiteChannelsPartReal siteChannelsPartReal
	 */
	public Object getModel() {
		return siteChannelsPartReal;
	}
	
	public void setId(java.lang.Integer val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}



	/**
	 * 分页显示数据,通过JSON串返回给页面
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void list() throws IOException
	{
		/**自动获取页面数据存在PageRequest对象里*/
		PageRequest<Map> pageRequest = ExtJsPageHelper.createPageRequestForExtJs(getRequest(), DEFAULT_SORT_COLUMNS);
		/**分页查询数据封装在Page对象里*/
		Page pages = siteChannelsPartRealManager.findByPageRequest(pageRequest);
		/**取出 model 数据类 LIST*/
		List<SiteChannelsPartReal> SiteChannelsPartReallist = (List) pages.getResult();
		ListRange<SiteChannelsPartReal> resultList = new ListRange<SiteChannelsPartReal>();
		/**加载LIST数据*/
		resultList.setList(SiteChannelsPartReallist);
		/**加载记录数*/
		resultList.setTotalSize(pages.getTotalCount());
		/**加载页面提示信息*/
		resultList.setMessage("ok");
		/**加载功能状态*/
		resultList.setSuccess(true);
		/**返回页面 JSOM 串 */
		outJson(resultList);
	}
	/**
	 * 返回所有数据
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void findAll() throws IOException
	{
		/**查询所有数据*/
		ArrayList<SiteChannelsPartReal> SiteChannelsPartReallist = (ArrayList)siteChannelsPartRealManager.findAll();
		ListRange<SiteChannelsPartReal> resultList = new ListRange<SiteChannelsPartReal>();
		resultList.setList(SiteChannelsPartReallist);
		/**加载页面提示信息*/
		resultList.setMessage("ok");
		/**加载功能状态*/
		resultList.setSuccess(true);
		/**返回页面 JSOM 串 */
		outJson(resultList);
	}
	

	
	/**
	 * 保存数据
	 * 系统自动把页面提交数据，封装到 SiteChannelsPartReal 对象
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void save() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			/**保存数据*/
			siteChannelsPartRealManager.save(siteChannelsPartReal);
			/**加载操作状态*/
			result.put("success", true);
			/**加载页面提示信息*/
			result.put("msg", "数据添加成功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", "数据添加失败!");
			e.printStackTrace();
		}
		outJson(result);
	}
	
	/**
	 * 修改数据
	 * 系统自动把页面提交数据，封装到 SiteChannelsPartReal 对象
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void update() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		if(null != siteChannelsPartReal){
			try
			{
				/**修改数据*/
				siteChannelsPartRealManager.update(siteChannelsPartReal);
				/**加载操作状态*/
				result.put("success", true);
				/**加载页面提示信息*/
				result.put("msg", "数据修改成功!");
			}
			catch (Exception e)
			{
				result.put("failure", true);
				result.put("msg", "数据修改失败!");
				e.printStackTrace();
			}
		}else{
			result.put("failure", true);
			result.put("msg", "数据不存在!");
		}
		outJson(result);
	}
	
	/**
	 * 删除单条或多条数据
	 * 页面把需要删除的数据的ID存放在　参数 ids 中。
	 * Action 把IDS 分割,得到要删除对象主键ID进行删除
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void delete() throws IOException
	{
		String ids = getRequest().getParameter("ids");
		String[] idarray = ids.split(",");
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			for (int i = 0; i < idarray.length; i++)
			{
				java.lang.Integer id = new java.lang.Integer((String)idarray[i]);
				siteChannelsPartRealManager.removeById(id);
			}
			result.put("success", true);
			result.put("msg", "数据删除成功");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", "数据删除失败!");
			e.printStackTrace();
		}
		outJson(result);
	}

	/**
	 * 下拉框所用
	 * 返回格式: ['1','name1'],['2','name2'],['3','kep']
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void getComboBox() throws IOException
	{
		
		String result =null; 
		List list = siteChannelsPartRealManager.getList(siteChannelsPartReal);
		for (int i = 0; list != null && i < list.size(); i++) {
			siteChannelsPartReal = (SiteChannelsPartReal)list.get(i);
			/**两个都是getId,把后者改成你要取的数*/
			if(i==0){
				result="[['"+siteChannelsPartReal.getId()+"','"+siteChannelsPartReal.getId()+"']";
			}else{
				result+=",['"+siteChannelsPartReal.getId()+"','"+siteChannelsPartReal.getId()+"']";
			}
		}
		if (!"".equals(result)) {
			result+="]";
		}
		outJsonString(result);
	}

	/**
	 * 多表关联查询
	 * 分页显示数据
	 * 列表
     * @author admin,
     * @version 1.0. 2010-07-08
	 * @throws IOException
	 */
	public void listAnyTable() throws IOException
	{
		PageRequest<Map> pr = ExtJsPageHelper.createPageRequestForExtJs(getRequest(), DEFAULT_SORT_COLUMNS);
		Page page = siteChannelsPartRealManager.listPageAnyTable(pr);
		
		List<SiteChannelsPartReal> SiteChannelsPartReallist = (List) page.getResult();
		ListRange<SiteChannelsPartReal> resultList = new ListRange<SiteChannelsPartReal>();
		resultList.setList(SiteChannelsPartReallist);
		resultList.setTotalSize(page.getTotalCount());
		resultList.setMessage("ok");
		resultList.setSuccess(true);
		outJson(resultList);
	}

	/**
	 * 下拉框所用 返回频道与栏目对应数据
     * @author Felix  945166129
     * @version 1.0. 2009-06-08
	 * @throws IOException
	 */
	public void getSiteChannelsPartReal() throws IOException
	{
		String channelsId = getRequest().getParameter("channelsId");
		siteChannelsPartReal.setChannelsId(Integer.parseInt(channelsId));
		String data =""; 
		List list = siteChannelsPartRealManager.getList(siteChannelsPartReal);
		for (int i = 0; list != null && i < list.size(); i++) {
			siteChannelsPartReal = (SiteChannelsPartReal)list.get(i);
			if(null!=siteChannelsPartReal){
				data=data+siteChannelsPartReal.getPartId()+",";
			}
		}
		String xx =  "{success:true,data:'"+data+"'}";//成功
		outJsonString(xx);
	}


}
