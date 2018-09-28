package com.java1234.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Blog;
import com.java1234.entity.PageBean;
import com.java1234.service.BlogService;
import com.java1234.util.PageUtil;
import com.java1234.util.StringUtil;

/**��ҳController
 * @author lenovo
 *
 */

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false) String page,@RequestParam(value="typeId",required=false) String typeId,@RequestParam(value="releaseDateStr",required=false) String releaseDateStr,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		if (StringUtil.isEmpty(page)) {
			page = "1";
		} 
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		//��ѯ��������
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		List<Blog> blogList = blogService.find(map);
		for (Blog blog : blogList) {
			List<String> imageList = blog.getImageList();
			String blogInfo = blog.getContent();
			//ʹ��jsoup �������ַ����ı��� �ĵ�
			Document doc = Jsoup.parse(blogInfo);
//			System.out.println(doc.toString());
		     // ��ȡ��׺Ϊjpg��ͼƬ��Ԫ�ؼ���(���ĵ��л�ȡ��ָ����ʽ��ͼƬԪ�ؼ���)
            Elements jpgs = doc.select("img[src$=.jpg]");
            for(int i= 0;i<jpgs.size();i++){
            	Element jpg = jpgs.get(i);
            	String attrSrc = jpg.attr("src");
            	jpg.attr("src", request.getContextPath().concat(attrSrc));
            	imageList.add(jpg.toString());
            	if (i == 2) {
					break;	
				}
            }
		}
		mav.addObject("blogList", blogList);
		StringBuffer param=new StringBuffer();
		if (StringUtil.isNotEmpty(typeId)) {
			param.append("typeId="+typeId+"&");
		}
		if (StringUtil.isNotEmpty(releaseDateStr)) {
			param.append("releaseDateStr"+releaseDateStr+"&");
		}
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
		mav.addObject("pageTitle", "java��Դ����ϵͳ"); 
		mav.addObject("mainPage", "foreground/blog/list.jsp");
		mav.setViewName("/mainTemp");
		return mav;
	}
	
	/**
	 * Դ������
	 * @return
	 */
	@RequestMapping("/download")
	public ModelAndView download(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "��վԴ������_java��Դ����ϵͳ");
		mav.addObject("mainPage", "foreground/system/download.jsp");
		mav.setViewName("/mainTemp");
		return mav;
	}
	
	
}
