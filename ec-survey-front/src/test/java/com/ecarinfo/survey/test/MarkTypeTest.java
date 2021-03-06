package com.ecarinfo.survey.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.SimpleTest;

import org.junit.Assert;

import com.ecarinfo.common.utils.DateUtils;
import com.ecarinfo.persist.service.GenericService;
import com.ecarinfo.survey.po.MarkType;
import com.ecarinfo.survey.service.MarkTypeService;

public class MarkTypeTest extends SimpleTest {

	@Resource
	private MarkTypeService markTypeService;

	@Resource
	private GenericService genericService;

	// 保存
	@org.junit.Test
	public void testSave() {
		MarkType dto = new MarkType();
		genericService.save(dto);
		Assert.assertTrue(dto.getId() > 0);
	}

	// 修改
	@org.junit.Test
	public void testUpdate() {
		MarkType dto = new MarkType();
		genericService.save(dto);
		Date date = DateUtils.stringToDate("1988-01-17 12:12:12", "yyyy-MM-dd hh:mm:ss");
		dto.setCreateTime(date);
		genericService.update(dto);
		Integer id = dto.getId();
		MarkType newDto = this.genericService.findByPK(MarkType.class, id);
		Assert.assertEquals(date.getTime(), newDto.getCreateTime().getTime());
	}

	// 删除
	@org.junit.Test
	public void testDelete() {
		MarkType dto = new MarkType();
		genericService.save(dto);
		genericService.deleteEntity(dto);
		Integer id = dto.getId();
		Assert.assertNull(this.genericService.findByPK(MarkType.class, id));

	}

	// 按Id查询
	@org.junit.Test
	public void testFindByPK() {
		MarkType dto = this.genericService.findByPK(MarkType.class, 1);
		Assert.assertTrue(dto.getId() > 0);
		System.err.println(dto);
	}

	// 获取所有
	@org.junit.Test
	public void testFindAll() {
		List<MarkType> dots = this.genericService.findAll(MarkType.class);
		System.err.println("MarkType size:" + dots.size());
		for (MarkType dto : dots) {
			System.err.println(dto);
		}
	}
}
