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
<link rel="stylesheet" href="${contextPath}/css/ies/trm.page.home.css">

<link rel="stylesheet" href="${contextPath}/js/component/swiper/css/swiper.min.css">
<style type="text/css">
	.examination-ul .error-content{
		margin: 30px auto;
	}
	.swiper-container {
	    width: 1200px;
	    height: 400px;
	}
</style>
</head>
<body>
	<!-- 顶部图片start -->
	<div class="full-container" style="margin-bottom:0;">
<%-- 		<div class="swiper-container">
		    <div class="swiper-wrapper">
		        <div class="swiper-slide" style="background: #ff0000">
		        	<img class="banner-pic" style="max-height: 400px;" src="${contextPath}/images/home-banner.png">
		        </div>
		        <div class="swiper-slide" style="background: #00ff00">slide2</div>
		        <div class="swiper-slide" style="background: #0000ff">slide3</div>
		    </div>
		</div> --%>
		<img class="banner-pic" style="max-height: 400px;" src="${contextPath}/images/home-banner.png">
	</div>
	<!-- 顶部图片end -->
	<!-- section1 start -->
	<div class="full-container" style="background-color:#fff;padding-top:0;">
		<div class="container">
			<div class="layer-wrap equ-news">
				<p class="en-title">NEWS INFOMATION</p>
				<P class="zh-title">新闻资讯</P>	
				
				<ul class="news-ul">
					<li class="active" flagCode="1">政策法规</li>
					<li flagCode="2">要闻动态</li>
					<li flagCode="3">最新推荐</li>
				</ul>
				
				<div class="news-area">
					<div class="news-img pull-left" id="newsImg">
						<!-- <img src="/images/ies-news.png" /> -->
					</div>
					
					<ul class="news-list" id="newsList">
					</ul>
				</div>	
				
				<div class="more-btn" style="background-color:#f8f8f8;">
					<span>更多</span>
					<i class="more-icon"></i>
				</div>
			</div>			
		</div>
	</div>
	<!-- section2 start -->
	<div class="full-container">
		<div class="container">
			<div class="layer-wrap equ-info">
				<p class="en-title">EQUIPMENT FACILITIES</p>
				<P class="zh-title">共享设备设施信息</P>	
				
				<ul id="equipment_list" class="equipment-list">
				</ul>
				
				<div class="more-btn">
					<span>更多</span>
					<i class="more-icon"></i>
				</div>
			</div>

		</div>
	</div>
	<!-- section new add start -->
	<div class="full-container" style="background-color:#fff;padding-top:0;">
		<div class="container">
			<div class="layer-wrap equ-demand">
				<p class="en-title">EQUIPMENT FACILITIES REQUIREMENTS</p>
				<P class="zh-title">军民融合需求</P>	
				
				<ul class="demand-ul" id="demand_ul">
				</ul>
				
				<div class="more-btn" style="background-color:#f8f8f8;">
					<span>更多</span>
					<i class="more-icon"></i>
				</div>
			</div>			
		</div>
	</div>	
	<!-- section3 start -->
	<div class="full-container" style="padding-top:40px;padding-bottom:40px;">
		<div class="container">
			<div class="layer-wrap key-lab">
				<p class="en-title">KEY LABORATORY</p>
				<P class="zh-title">技术服务机构</P>	
				
				<div class="slide-box" id="slideBox">
					<div class="hd">
						<ul>
							<li>1</li>
							<li>2</li>
						</ul>
					</div>
					<div class="bd">
						<ul>
							<li id="slide_li1">
								<div class="slide-ul">
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构</p>
									</div>																																				
								</div>
							</li>
							<li id="slide_li2">
								<div class="slide-ul">
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构2</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构2</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构2</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构2</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构2</p>
									</div>
									<div class="slide-li">
										<img src="/images/ies-lab.png" />
										<p>陕西省生物科技与生化工程技术服务机构2</p>
									</div>																																				
								</div>								
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>	
	
	<!-- section4 start -->
	<div class="full-container" style="background:#fff;padding-top:40px;padding-bottom:40px;">
		<div class="container">
			<div class="layer-wrap agency-info">
				<p class="en-title">TESTING AGENCY</p>
				<P class="zh-title">机构信息</P>	
				
				<div class="agency-wrap">
					<div class="bd">
						<ul id="agency_list" style="position:absolute;top:0;left:0;">
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</div>	
	<!-- section5 start -->
	<div class="full-container" style="padding-top:40px;padding-bottom:40px;">
		<div class="container">
			<div class="layer-wrap my-links">
				<p style="font-size:24px;text-align:left;">友情链接</p>
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
	<script src="${contextPath}/trm_modules/home.js"></script>
</body>
</html>