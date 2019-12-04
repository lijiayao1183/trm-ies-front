<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="陕西军民融合科技创新资源开放共享管理服务平台" content="" />
<title>陕西军民融合科技创新资源开放共享管理服务平台</title>
<!--page css  -->
<link rel="stylesheet" href="${contextPath}/css/ies/trm.page.homeNew.css">

<link rel="stylesheet" href="${contextPath}/js/component/swiper/css/swiper.min.css">
<style type="text/css">
	.examination-ul .error-content{
		margin: 30px auto;
	}
	.swiper-container {
	    width: 1200px;
	    height: 400px;
	}
	.fullSlide .bd li img {
	    width: 100%;
	    height: 410px;
	}
	.headerbg {
	    height: 90px;
	    background: transparent !important;
	    position: absolute;
	    top: 0;
	    left: 0;
	    z-index: 999;
	}
	.slideBox {
	    height: 410px;
	}
	.fullSlide {
	    height: 410px;
	}
	.fullSlide .bd {
	    height: 410px;
	}
	.fullSlide .bd li {
	    height: 410px;
	}
	.fullSlide .bd li a {
	    height: 410px;
	}
	.headerbg .header .header-nav ul li a {
	    font-size: 18px;
	    color: #fff;
	}
</style>
</head>
<body>
	<!-- 顶部图片start -->
<%-- 	<div class="full-container" style="margin-bottom:0;">
<div class="swiper-container">
		    <div class="swiper-wrapper">
		        <div class="swiper-slide" style="background: #ff0000">
		        	<img class="banner-pic" style="max-height: 400px;" src="${contextPath}/images/home-banner.png">
		        </div>
		        <div class="swiper-slide" style="background: #00ff00">slide2</div>
		        <div class="swiper-slide" style="background: #0000ff">slide3</div>
		    </div>
		</div>
		<img class="banner-pic" style="max-height: 400px;" src="${contextPath}/images/home-banner.png">
	</div> --%>
	<div class="full-container" style="margin-bottom:0;">
		<div id="home_banner" class="slideBox">
			<div class="fullSlide">
				<div class="bd">
					<div class="tempWrap" style="position:relative;">
						<!-- 平台介绍 -->
						<!-- <div class="introduction">
							<div class="introduction-center">
								<div>
									<h6 >陕西军民融合科技创新资源开放共享服务平台</h6>
									陕西省国防科工办负责建立的省级政府公共服务平台。主要是打造省政府有关部门、省内军工单位和民口配套企业沟通交流的桥梁和纽带。为了深入推进我省军民融合深度发展，促进军工科研仪器设备设施开放共享和国防科技成果转移转化，推进先进军工技术转民用，引导民口先进技术参与国防科技工业建设提供丰富、便捷的信息服务。
								</div>
							</div>
						</div> -->
						<ul style="position: relative; width: 1835px; height: 410px;">
							<%-- <li>
								<a href="http://www.baidu.com/"><img src="${contextPath}/images/home-banner.png" alt="科工办1" title="科工办1" onerror="imgError(this);"></a>
							</li>
							<li>
								<img src="${contextPath}/images/home-banner2.png" alt="科工办2" title="科工办2" onerror="imgError(this);">
							</li>
							<li>
								<img src="${contextPath}/images/home-banner3.png" alt="科工办3" title="科工办3" onerror="imgError(this);">
							</li> --%>
						</ul>
					</div>
				</div>
				<div class="hd" style="bottom:0;">
					<ul style="margin:0;text-align:center;"></ul>
				</div>
			</div>
		</div>
	
		
	</div>
	<!-- 顶部图片end -->
	
	<!-- 改版新增数据展示栏 -->
	<div class="full-container" style="background-color:#f5f5f5;padding-top:50px;padding-bottom:50px;">
		<div class="container">
			<div class="data-info" >
				<ul>
					<li class="Presources">
						<p class="publish-resources">找共享资源</p>
					</li>
					<li class="Pproduct">
						<p class="publish-product">找技术产品</p>
					</li>
					<li class="Pservice">
						<p class="publish-service">找科技服务</p>
					</li>
					<li class="Ppolicy">
						<p class="publish-policy">找政策法规</p>
					</li>
					
					
					<li class="Pequipment">
						<p class="publish-equipment">发布设备设施</p>
					</li>
					<li class="Pdemand">
						<p class="publish-demand">发布需求信息</p>
					</li>
					<li class="Pinteraction">
						<p class="publish-interaction">互动交流</p>
					</li>
					
				</ul>			
			</div> 
			
			<!-- <div class="data-info distribution">
				<ul>
					
					<li class="Pdemand">
						<p class="publish-demand">发布需求信息</p>
					</li>
					<li class="Pequipment">
						<p class="publish-equipment">发布设备设施</p>
					</li>
					<li class="Pinteraction">
						<p class="publish-interaction">互动交流</p>
					</li>
					
				</ul>			
			</div>  -->
		</div>
		
	</div>
	
	<!-- section1 start -->
	<div class="full-container" style="background-color:#fff;padding-top:0;">
		<div class="container">
			<div class="layer-wrap equ-news" style="margin-bottom:0;">
				<p class="en-title" style="background-image:url('${contextPath}/images/index-title-1.png');background-repeat: no-repeat; "></p>
				
				<ul class="news-list">
					<li id="policy_news-q" >
						<div id="slideBox-small" class="slideBox-small">
							<div class="hd">
								<ul></ul>
							</div>
							<div class="bd">
								<ul></ul>
							</div>
				
						</div>
						
					</li>
					<li id="recommon_news">
						
					</li>
					<li id="dynamic_news"></li>
					
				</ul>
			</div>			
		</div>
	</div>
	<!-- section2 start -->
	<div class="full-container facilityBg">
		<div class="container" style="overflow:hidden;">
			<div class="layer-wrap equ-info">
				<div class="equ-line" style="overflow:hidden;background-image:url('${contextPath}/images/index-title-2.png');background-repeat: no-repeat; ">
					<p class="en-title pull-left font-white" ></p>
					
					<p class="statistics">
						<span>全部(<i id="count"></i>)</span>
						<span>设备(<i id="eqipNum"></i>)</span>
						<span>设施(<i id="faciNum"></i>)</span>
					</p>
					
					<p class="pull-right" style="margin-bottom:0;margin-top:4px;position:relative;">
						<span style="display:inline-block;height:34px;vertical-align:bottom;"><input type="text" id="equ_search" class="equ-search" style="color:#333;" /></span>
						<span><i class="s-icon"></i></span>
					</p>
				</div>
				
				
				<!-- <ul id="equipment_list" class="equipment-list"></ul> -->
				<div class="new-equipment_list" id="new-equipment_list">
					<div class="newAdd_list" id="equipmentNew"></div>
					<ul class="equipment-list" id="equipment_list"></ul>
				</div>
				
				
				<div style="overflow:hidden;margin-top:20px;" class="equ-bottom">
					<div class="pull-right">
						<i class="flip fLeft"></i>
						<i class="flip fRight active"></i>
						<span class="equ-more font-white" style="color: #333 !important;">查看更多>></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- section new add start -->
	<div class="full-container" style="background-color:#fff;padding-top:0;">
		<div class="container">
			<div class="layer-wrap equ-demand" style="overflow:hidden;">
				<div class="equ-line" style="background-image:url('${contextPath}/images/index-title-3.png');background-repeat: no-repeat; ">
					<p class="en-title pull-left"></p>
					
					<p class="statistics">
						<span>全部(<i id="demand_count">0</i>)</span>
						<span>技术(<i id="demand_techNum">0</i>)</span>
						<span>产品(<i id="demand_prodNum">0</i>)</span>
						<span>融资(<i id="demand_moneyNum">0</i>)</span>
					</p>
					
					<p class="pull-right" style="margin-bottom:0;margin-top:3px;position:relative;">
						<span style="display:inline-block;height:34px;vertical-align:bottom;"><input type="text" id="demand_search" class="equ-search" /></span>
						<span><i class="s-icon"></i></span>
					</p>
				</div>
				<div class="new-equipment_list" id="new-equipment_list">
					<div class="newAdd_list" id="demandNew"></div>
					<ul class="demand-ul" id="demand_ul"></ul>
				</div>
				
				
				<div style="overflow:hidden; padding-top:20px;">
					<p class="pull-right equ-more">查看更多>></p>
				</div>
				
			</div>			
		</div>
	</div>	
	<!-- section3 start -->
	<div class="full-container" style="padding-bottom:10px;background:#f5f5f5;">
		<div class="container" style="overflow:hidden;color:#fff;">
			<div class="layer-wrap key-lab" style="overflow:hidden;margin-bottom: 0;">
				<div class="equ-line" style="background-image:url('${contextPath}/images/index-title-4.png');background-repeat: no-repeat; ">
					<p class="en-title pull-left font-white" ></p>
					
					<p class="statistics">
						<!-- <span style="color: #333;">全部(<i id="serviceagency_count"></i>)</span> -->
						<span id="span-orgNum1"><label id="label-orgNum1" style="color: #419ff6;">技术需求对接类(<i id="orgNum1"></i>)</label></span>
						<span id="span-orgNum2"><label id="label-orgNum2">科技评估类(<i id="orgNum2"></i>)</label></span>
						<span id="span-orgNum3"><label id="label-orgNum3">孵化器类(<i id="orgNum3"></i>)</label></span>
						<span id="span-orgNum4"><label id="label-orgNum4">科技投融资类(<i id="orgNum4"></i>)</label></span>
						<span id="span-orgNum5"><label id="label-orgNum5">管理咨询类(<i id="orgNum5"></i>)</label></span>
					</p>
					
				</div>
				
				<div class="mechanism_content">
					<div class="mechanismList">
					<p style="color:#000;">为了落实军民融合发展战略，充分发挥市场机制作用，引导科技服务机构参与军民两用技术转移转化和军民设备设施开放共享，综合考虑工作成效、相应资质、规范管理等情况，遴选若干家服务热情高、社会信誉好、综合实力强的申报机构入编<span style="color: #f9514e;">“陕西军民融合科技服务机构推荐名录”</span>，并发布在陕西军民融合科技创新资源开放共享服务平台，供各方选择参考。推荐名录实行动态管理，定期评估新申报机构和已入编机构工作成效情况，并依据评估结果进行更新。鼓励科技服务机构充分利用陕西军民融合科技创新资源开放共享服务平台等载体上的信息资源，推进军民融合发展。</p>
					<p style="color:#000;">服务机构申报流程：注册用户可在首页下方点击<span style="color: #f9514e;">【申报服务机构】</span>栏目，进入机构资料填报页面。</p>
					</div>
					<ul class="lab-list" id="lab_list1" style="display:block;"></ul>
					<ul class="lab-list" id="lab_list2" style="display:none;"></ul>
					<ul class="lab-list" id="lab_list3" style="display:none;"></ul>
					<ul class="lab-list" id="lab_list4" style="display:none;"></ul>
					<ul class="lab-list" id="lab_list5" style="display:none;"></ul>
				</div>
				
					
				<div style="overflow:hidden; padding-top:20px;">
					<p class="pull-right equ-more font-white" style="color: #333 !important;">查看更多>></p>
				</div>
				
			</div>			
		</div>
	</div>	
	
	
	<!-- <div class="full-container" style="padding-bottom:10px;background:url('/images/lab_bg.png') no-repeat 100% 100%;">
		<div class="container" style="overflow:hidden;color:#fff;">
			<div class="layer-wrap key-lab" >
				<div class="equ-line">
					<p class="en-title pull-left font-white">军民融合技术服务机构</p>
					
					<p class="statistics">
						<span>全部(<i id="demand_count"></i>)</span>
						<span>技术(<i id="demand_techNum"></i>)</span>
						<span>产品(<i id="demand_prodNum"></i>)</span>
						<span>融资(<i id="demand_moneyNum"></i>)</span>
					</p>
					
				</div>
				
				<div class="mechanism_content">
					<div class="mechanismList"></div>
					<ul class="lab-list" id="lab_list"></ul>
				</div>
				
				<div style="overflow:hidden; padding-top:20px;">
					<p class="pull-right equ-more font-white">查看更多>></p>
				</div>
				
				
				<div style="overflow:hidden;margin-top:20px;" class="lab-bottom">
					<div class="pull-right">
						<i class="flip fLeft"></i>
						<i class="flip fRight active"></i>
					</div>
				</div>
				
			</div>
		</div>
	</div>	
	 -->
	 
	 <!-- 工作动态资料下载 -->
	<div class="full-container" style="background:#fff;">
		<div class="container">
			
			<div class="operation">

				<div class="operation_list Ojod">工作动态 </div>
				<div class="operation_list Ofile">资料下载 </div>
				<div class="operation_list" id="relateToQuactor">报送服务成效 </div>
				<div class="operation_list" id="relateToLabtoary">申报服务机构 </div>

			</div>
			
		</div>
	</div>	
	 
	<!-- section4 start -->
	<div class="full-container" style="background:#eef8ff;">
		<div class="container">
			<div class="layer-wrap agency-info">
				<p class="en-title" style="background-image:url('${contextPath}/images/index-title-5.png');background-repeat: no-repeat; "></p>
				
				<div class="agency-wrap">
					<div class="bd" style="position:relative;margin-top:10px;">
						<ul id="agency_list" style="position:absolute;top:0;left:0;">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<!-- section5 start -->
	<div class="full-container" style="background:#fff;">
		<div class="container">
			<div class="layer-wrap my-links">
				<p  class="en-title" style="font-size:20px;text-align:left;overflow:hidden;background-image:url('${contextPath}/images/index-title-6.png');background-repeat: no-repeat; "></p>
				<ul>
					<li><a text="http://jmjh.miit.gov.cn/" title="国家军民融合公共服务平台">国家军民融合公共服务平台</a></li>
					<li><a text="http://www.iptrm.com/" title="中国军民融合平台国家知识产权运营军民融合特色平台">中国军民融合平台国家知识产权运营军民融合特色平台</a></li>
					<li><a text="http://www.sastind.gov.cn/" title="国家国防科技工业局">国家国防科技工业局</a></li>
					<li><a text="http://www.weain.mil.cn/" title="全军武器装备采购信息网">全军武器装备采购信息网</a></li>
					<li><a text="http://www.miit.gov.cn/" title="中华人民共和国工业与信息化部">中华人民共和国工业与信息化部</a></li>
					<li><a text="http://www.jungong.net/" title="陕西省国防工业科技办公室">陕西省国防科技工业办公室</a></li>
					<li><a text="https://www.plap.cn/" title="军队采购网">军队采购网</a></li>
					<li><a text="http://www.xatrm.com/" title="西安科技大市场">西安科技大市场</a></li>
				</ul>
			</div>	
		</div>
	</div>	

	
	<script src="${contextPath}/js/component/swiper/js/swiper.min.js"></script>
	<!--引入 js-->
	<script src="${contextPath}/js/component/SuperSlide.js"></script>
	<script src="${contextPath}/trm_modules/homeNew.js"></script>
</body>
	<!-- <script>
		var _hmt = _hmt || [];
		(function() {
		  var hm = document.createElement("script");
		  hm.src = "https://hm.baidu.com/hm.js?9274554e26710e0825a5b20225ed2470";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		})();
	</script> -->
	<script>
		var _hmt = _hmt || [];
		(function() {
		  var hm = document.createElement("script");
		  hm.src = "https://hm.baidu.com/hm.js?a201123ae9266648cbb169dc49900848";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		})();
	</script>

</html>