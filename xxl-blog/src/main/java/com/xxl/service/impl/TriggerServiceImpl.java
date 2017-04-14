package com.xxl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxl.service.IHtmlGenerateService;
import com.xxl.service.ITriggerService;

/**
 * Trigger Service
 * @author xuxueli
 */
@Service("triggerService")
public class TriggerServiceImpl implements ITriggerService {
	private static transient Logger logger = LoggerFactory.getLogger(TriggerServiceImpl.class);
	
	@Autowired
    private IHtmlGenerateService htmlGenerateService;
	
	/**
	 * 全站静态化
	 */
	public void generateNetHtml() {
		long start = System.currentTimeMillis();
		logger.info("全站静态化... start:{}", start);
		
		htmlGenerateService.generateNetHtml();
		
		long end = System.currentTimeMillis();
		logger.info("全站静态化... end:{}, cost:{}", end, end - start);
	}
	
}
