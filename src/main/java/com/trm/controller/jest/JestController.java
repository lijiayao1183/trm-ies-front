package com.trm.controller.jest;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trm.model.jest.AllJest;
import com.trm.model.jest.AllResponse;
import com.trm.model.jest.JestRequest;
import com.trm.model.jest.JestResponse;
//import com.trm.commons.exception.BaseException;
import com.trm.service.jest.JestService;

//import com.trm.commons.utils.LogUtils;
//import com.trm.commons.utils.ToolUtil;
import io.searchbox.client.JestClient;
import io.searchbox.core.SearchResult;

@Controller
@RequestMapping("/jest")
public class JestController {

    public static Logger logger = LoggerFactory.getLogger(JestController.class);

    @Autowired
    private JestService jestService;

    @RequestMapping(value = "/queryInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object queryInfo(@RequestBody @Valid JestRequest request) throws Exception {
        try {
            JestResponse jestResponse = new JestResponse();
            int pageSize = request.getNum();
            JestClient jestClient = jestService.getJestClient();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(request.getQueryStr(),"_all");
            searchSourceBuilder.query(queryBuilder);
            searchSourceBuilder.size(10);
            searchSourceBuilder.from(0);
            String query = searchSourceBuilder.toString();
            logger.info("es查询条件:"+query);
            SearchResult result = jestService.search(jestClient, request.getIndexName(), "jdbc", query);
            if(result.isSucceeded()){
                int count = result.getTotal();
                int pageTotal = count/pageSize;
                if(count%pageSize != 0){
                    pageTotal += 1;
                }
                if (request.getIndexName().equals("device")){
                    /*List<DeviceInfoJest> jests = new ArrayList<>();
                    List<SearchResult.Hit<DeviceInfoJest, Void>> hits = result.getHits(DeviceInfoJest.class);
                    for (SearchResult.Hit<DeviceInfoJest, Void> hit : hits){
                        DeviceInfoJest infoJest  = hit.source;
                        infoJest.setApplied_range(ToolUtil.RemoveHTMLTags2(infoJest.getApplied_range()));
                        jests.add(infoJest);
                    }
                    jestResponse.setObjList(jests);
                    jestResponse.setTotal(String.valueOf(pageTotal));*/
                }else if(request.getIndexName().equals("expert")){
                    /*List<ExpertInfoJest> jests = new ArrayList<>();
                    List<SearchResult.Hit<ExpertInfoJest, Void>> hits = result.getHits(ExpertInfoJest.class);
                    for (SearchResult.Hit<ExpertInfoJest, Void> hit : hits){
                        ExpertInfoJest infoJest  = hit.source;
                        infoJest.setExpert_domain(ToolUtil.RemoveHTMLTags2(infoJest.getExpert_domain()));
                        jests.add(infoJest);
                    }
                    jestResponse.setObjList(jests);
                    jestResponse.setTotal(String.valueOf(pageTotal));*/
                }else if(request.getIndexName().equals("policy")){
                    /*List<PolicyJest> jests = new ArrayList<>();
                    List<SearchResult.Hit<PolicyJest, Void>> hits = result.getHits(PolicyJest.class);
                    for (SearchResult.Hit<PolicyJest, Void> hit : hits){
                        PolicyJest infoJest  = hit.source;
                        infoJest.setPolicy_content(ToolUtil.RemoveHTMLTags2(infoJest.getPolicy_content()));
                        jests.add(infoJest);
                    }
                    jestResponse.setObjList(jests);
                    jestResponse.setTotal(String.valueOf(pageTotal));*/
                }else if(request.getIndexName().equals("trade")){
                    /*List<TradeJest> jests = new ArrayList<>();
                    List<SearchResult.Hit<TradeJest, Void>> hits = result.getHits(TradeJest.class);
                    for (SearchResult.Hit<TradeJest, Void> hit : hits){
                        TradeJest infoJest  = hit.source;
                        infoJest.setTechnical_route(ToolUtil.RemoveHTMLTags2(infoJest.getTechnical_route()));
                        jests.add(infoJest);
                    }
                    jestResponse.setObjList(jests);
                    jestResponse.setTotal(String.valueOf(pageTotal));*/
                }
            }
            return  jestResponse;
        } catch (Exception e) {
            logger.info("全文检索错误",e);
            throw new Exception("全文检索错误",e);
        }
    }

    @RequestMapping(value = "/queryAllInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object queryAllInfo(@RequestBody @Valid JestRequest request) throws Exception {
        try {
            JestResponse jestResponse = new JestResponse();
            int pageSize = request.getNum();
            JestClient jestClient = jestService.getJestClient();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(request.getQueryStr());
            searchSourceBuilder.query(queryBuilder);
            searchSourceBuilder.size(10);
            searchSourceBuilder.from(0);
            String query = searchSourceBuilder.toString();
            logger.info("es查询条件:"+query);
            SearchResult result = jestService.search(jestClient, "", "", query);
            AllResponse allres = new AllResponse();
            if(result.isSucceeded()) {
                int count = result.getTotal();
                int pageTotal = count / pageSize;
                if (count % pageSize != 0) {
                    pageTotal += 1;
                }
                /*List<Device> devices = new ArrayList<>();
                List<Expert> experts = new ArrayList<>();
                List<Policy> policies = new ArrayList<>();
                List<Trade> trades = new ArrayList<>();*/
                List<SearchResult.Hit<AllJest, Void>> hits = result.getHits(AllJest.class);
                for (SearchResult.Hit<AllJest, Void> hit : hits){
                    AllJest infoJest  = hit.source;

                    if(StringUtils.isNotBlank(infoJest.getType_name())){
                        if(infoJest.getType_name().equals("device")){
                            /*Device device = new Device();
                            device.setId(infoJest.getId());
                            device.setApplied_range(ToolUtil.RemoveHTMLTags2(infoJest.getApplied_range()));
                            device.setDevice_name(infoJest.getDevice_name());
                            device.setType_name(infoJest.getType_name());
                            devices.add(device);*/
                        }


                        if(infoJest.getType_name().equals("expert")){
                            /*Expert expert = new Expert();
                            expert.setId(infoJest.getId());
                            expert.setExpert_domain(ToolUtil.RemoveHTMLTags2(infoJest.getExpert_domain()));
                            expert.setExpert_name(infoJest.getExpert_name());
                            expert.setType_name(infoJest.getType_name());
                            experts.add(expert);*/
                        }

                        if(infoJest.getType_name().equals("policy")){
                            /*Policy policy = new Policy();
                            policy.setId(infoJest.getId());
                            policy.setPolicy_content(ToolUtil.RemoveHTMLTags2(infoJest.getPolicy_content()));
                            policy.setPolicy_title(infoJest.getPolicy_title());
                            policy.setType_name(infoJest.getType_name());
                            policies.add(policy);*/
                        }

                        if(infoJest.getType_name().equals("trade")){
                            /*Trade trade = new Trade();
                            trade.setId(infoJest.getId());
                            trade.setPro_name(infoJest.getPro_name());
                            trade.setTechnical_route(ToolUtil.RemoveHTMLTags2(infoJest.getTechnical_route()));
                            trade.setType_name(infoJest.getType_name());
                            trades.add(trade);*/
                        }
                    }
                }
                /*allres.setDeviceList(devices);
                allres.setExpertList(experts);
                allres.setPolicyList(policies);
                allres.setTradeList(trades);*/
                allres.setTotal(pageTotal);
            }
            return allres;
        }catch (Exception e){
            logger.info("全文检索错误",e);
            throw new Exception("全文检索错误",e);
        }
    }
}
