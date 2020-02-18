package com.jef.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.jef.constant.BasicConstant;
import com.jef.entity.Foundation;
import com.jef.entity.FoundationEntry;
import com.jef.service.IFoundationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

/**
 * 基金控制器
 * @author Jef
 * @date 2018/9/17 16:21
 */
@Controller
@RequestMapping(value = "/foundation")
public class FoundationController {

    @Autowired
    private IFoundationService foundationService;

    @RequestMapping(value = "/foundation")
    public ModelAndView foundation(ModelAndView mv, Model model) {
        List<Foundation> foundationList = foundationService.getByParams(Maps.newHashMap());
        model.addAttribute("foundationList", foundationList);
        mv.setViewName("foundation/foundation");
        return mv;
    }

    /**
     * 单个添加
     * @param foundation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    public String addInfo(Foundation foundation) {
        foundationService.insert(foundation);
        return BasicConstant.SUCCESS;
    }

    /**
     * 单个添加
     * @param foundationEntry
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addInfoEntry", method = RequestMethod.POST)
    public String addInfoEntry(FoundationEntry foundationEntry) {
        foundationService.insertEntry(foundationEntry);
        return BasicConstant.SUCCESS;
    }


    /**
     * 获取预测信息
     * @param mv
     * @param model
     * @return
     */
    @RequestMapping(value = "/getFoundationDetail")
    public ModelAndView getFuture(@RequestParam(value = "code") String code, ModelAndView mv, Model model) {
        List<FoundationEntry> foundationEntryList = foundationService.getEntryByParams(ImmutableMap.of("code", code));
        Foundation foundation = foundationService.getByCode(code);
        BigDecimal betweenPrice = BigDecimal.ZERO;
        if (foundationEntryList.size() > 0) {
            BigDecimal totalPrice = foundationEntryList.stream().map(FoundationEntry::getUnitPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            betweenPrice = totalPrice.divide(new BigDecimal(foundationEntryList.size()));
        }
        model.addAttribute("foundation", foundation);
        model.addAttribute("foundationEntryList", foundationEntryList);
        model.addAttribute("betweenPrice", betweenPrice);
        mv.setViewName("foundation/foundationDetail");
        return mv;
    }

    /**
     * 批量添加
     * @param mv
     * @param model
     * @return
     */
    @RequestMapping(value = "/batchAdd")
    public ModelAndView batchAdd(ModelAndView mv, Model model, @RequestParam(value = "code") String code) {
        Foundation foundation = foundationService.getByCode(code);
        model.addAttribute("foundation", foundation);
        mv.setViewName("foundation/batchAdd");
        return mv;
    }

}
