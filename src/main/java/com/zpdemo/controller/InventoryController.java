package com.zpdemo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpdemo.entityModel.ImageBo;
import com.zpdemo.entityModel.InventoryDetailsBo;
import com.zpdemo.entityModel.StockBo;
import com.zpdemo.entityModel.WebResponseJsonBo;
import com.zpdemo.serviceImpl.InventoryService;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@PostMapping(value = "/createItems")
	public ResponseEntity<WebResponseJsonBo> createItems(@RequestBody InventoryDetailsBo bo,HttpServletRequest req,HttpServletResponse res)
	{
		WebResponseJsonBo returnBo=new WebResponseJsonBo();
		Map<String,Object> retMap=inventoryService.createItems(bo);
		if(retMap != null && retMap.size()>0)
		{
			String msg=(String)retMap.get("msg");
			returnBo.setMessage(msg);
			returnBo.setStatus("200");
		}
		return ResponseEntity.status(HttpStatus.OK).body(returnBo);
	}
	
	

	
	@PostMapping(value = "/updateStatusItems")
	public ResponseEntity<WebResponseJsonBo> updateStatusItems(@RequestBody InventoryDetailsBo bo,HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		bo.setCategory_id(id);
		WebResponseJsonBo returnBo=new WebResponseJsonBo();
		Map<String,Object> retMap=inventoryService.updateStatusItems(bo);
		if(retMap != null && retMap.size()>0)
		{
			String msg=(String)retMap.get("msg");
			returnBo.setMessage(msg);
			returnBo.setStatus("200");
		}
		return ResponseEntity.status(HttpStatus.OK).body(returnBo);
	}
	
	@GetMapping(value = "/fetchstock")
	public ResponseEntity<List<StockBo>> fetchstock(HttpServletRequest req,HttpServletResponse res)
	{
		WebResponseJsonBo returnBo=new WebResponseJsonBo();
		List<StockBo> listBo=inventoryService.fetchstock();
		
		return ResponseEntity.status(HttpStatus.OK).body(listBo);
	}
	
	@PostMapping(value = "/removeStock")
	public ResponseEntity<WebResponseJsonBo> removeStock(@RequestBody InventoryDetailsBo bo,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		bo.setCategory_id(id);
		WebResponseJsonBo returnBo=new WebResponseJsonBo();
		Map<String,Object> retMap=inventoryService.removeStock(bo);
		if(retMap != null && retMap.size()>0)
		{
			String msg=(String)retMap.get("msg");
			returnBo.setMessage(msg);
			returnBo.setStatus("200");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(returnBo);
	}
	
	@PostMapping(value = "/getStockDetails")
	public ResponseEntity<InventoryDetailsBo> getStockDetails(@RequestBody InventoryDetailsBo bo,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		bo.setCategory_id(id);
		WebResponseJsonBo returnBo=new WebResponseJsonBo();
		InventoryDetailsBo inveBo=inventoryService.getStockDetails(bo);
		return ResponseEntity.status(HttpStatus.OK).body(inveBo);
	}
	
	//image Code
	@PostMapping(value = "/saveImage")
	public ResponseEntity<WebResponseJsonBo> saveImage(@ModelAttribute ImageBo bo,HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		WebResponseJsonBo returnBo=new WebResponseJsonBo();
		Map<String,Object> retMap=inventoryService.saveImage(bo);
		if(retMap != null && retMap.size()>0)
		{
			String msg=(String)retMap.get("msg");
			returnBo.setMessage(msg);
			returnBo.setStatus("200");
		}
		return ResponseEntity.status(HttpStatus.OK).body(returnBo);
	}
}
