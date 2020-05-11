<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
    <script type="text/javascript" src="/mm/js/rem.js"></script>
    <script type="text/javascript" src="/mm/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="/mm/js/swiper.min.js"></script>
    <link rel="stylesheet" href="/mm/css/index.css">
    <link rel="stylesheet" href="/mm/css/swiper.min.css">
</head>
<body>
<div class="container-app content">
    <div class="top">
        <div class="top-ret in-float"><img src="/mm/img/position.png" class="img-float img-1"><div  class="img-float img-font">吉安</div><img src="/mm/img/pull.png" class="img-float img-2"></div>
        <div class="advince">首页</div>
        <div class="dex-float"><img src="/mm/img/around.png" class="img-float img-3"><img src="/mm/img/phone.png" class="img-float img-4"></div>
    </div>
    <div class="in-center">
        <div class="center">

            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="swiper-slide" onclick="goPage(6)"><img src="/mm/img/swiper.png" alt=""></div>
                    <div class="swiper-slide" onclick="goPage(6)"><img src="/mm/img/swiper.png" alt=""></div>
                    <div class="swiper-slide" onclick="goPage(6)"><img src="/mm/img/swiper.png" alt=""></div>
                    <div class="swiper-slide" onclick="goPage(6)"><img src="/mm/img/swiper.png" alt=""></div>
                </div>
                <div class="swiper-pagination"></div>
            </div>

            <div class="flex public">
                <div class="flex-1" onclick="goPage(1)"><div class="inner-pic"><img src="/mm/img/arr9.png" alt=""><p>公众上报</p></div></div>
                <div class="flex-1" onclick="goPage(2)"><div class="inner-pic"><img src="/mm/img/arr10.png" alt=""><p>公众投诉</p></div></div>
                <div class="flex-1" onclick="goPage(3)"><div class="inner-pic"><img src="/mm/img/arr11.png" alt=""><p>公众咨询</p></div></div>
                <div class="flex-1" onclick="goPage(4)"><div class="inner-pic"><img src="/mm/img/arr12.png" alt=""><p>便民服务</p></div></div>
            </div>
        </div>
        <div class="thumbs" >
            <div><img src="/mm/img/mythumbs.png" class="thumbs-img2"></div>
            <div onclick="goDianzan()"><img src="/mm/img/thumbs.png" class="thumbs-img1"></div>
            <div onclick="goDianzan()" class="thumbs-right"><img src="/mm/img/right.png" class="thumbs-img3"></div>
        </div>
        <div class="thumbs">
            <div class="thumbs-tit" onclick="goNewPage()">公众新闻</div>
            <div class="thumbs-right flex flex-c-c"><div class="" onclick="goNewPage()">更多</div><img src="/mm/img/right.png" onclick="goNewPage()" class="thumbs-img3"></div>
        </div>
        <div class="new-list">
            <div class="nlist-item flex " onclick="goNewDetail()">
                <div class="nli-left">
                    <img src="/mm/img/login-top.png" alt="" class="">
                </div>
                <div class="nli-right flex-1">
                    <p class="nli-tit">视频视频视频视频视频视频视频视频</p>
                    <div class="nli-type flex flex-c-c">
                        <div class="nli-sp">视频</div>
                    </div>
                    <p class="nli-time">
                        <span>12.4万人观看</span>
                        <span>8:11</span>
                    </p>
                </div>
            </div>
            <#--<div class="nlist-item flex " onclick="goNewDetail()">-->
                <#--<div class="nli-left">-->
                    <#--<img src="/mm/img/login-top.png" alt="" class="">-->
                <#--</div>-->
                <#--<div class="nli-right flex-1">-->
                    <#--<p class="nli-tit">视频视频视频视频视频视频视频视频</p>-->
                    <#--<div class="nli-type flex flex-c-c">-->
                        <#--<div class="nli-wz">文章</div>-->
                    <#--</div>-->
                    <#--<p class="nli-time">-->
                        <#--<span>12.4万人观看</span>-->
                        <#--<span>8:11</span>-->
                    <#--</p>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="nlist-item flex " onclick="goNewDetail()">-->
                <#--<div class="nli-left">-->
                    <#--<img src="/mm/img/login-top.png" alt="" class="">-->
                <#--</div>-->
                <#--<div class="nli-right flex-1">-->
                    <#--<p class="nli-tit">视频视频视频视频视频视频视频视频</p>-->
                    <#--<div class="nli-type flex flex-c-c">-->
                        <#--<div class="nli-sp">视频</div>-->
                    <#--</div>-->
                    <#--<p class="nli-time">-->
                        <#--<span>12.4万人观看</span>-->
                        <#--<span>8:11</span>-->
                    <#--</p>-->
                <#--</div>-->
            <#--</div>-->
        </div>
    </div>
    <div class="in-bottom flex">
        <div class="flex-1">
            <div class="bot-mess on">
                <div class="bot-img bot-img1"></div>
                <p>首页</p>
            </div>
        </div>
        <div class="flex-1">
            <div class="bot-mess">
                <div class="bot-img bot-img2"></div>
                <p>我的案件</p>
            </div>
        </div>
        <div class="flex-1">
            <div class="bot-mess">
                <div class="bot-img bot-img3"></div>
                <p>地图功能</p>
            </div>
        </div>
        <div class="flex-1">
            <div class="bot-mess">
                <div class="bot-img bot-img4"></div>
                <p>统计管理</p>
            </div>
        </div>
        <div class="flex-1" onclick="goCenter()">
            <div class="bot-mess">
                <div class="bot-img bot-img5"></div>
                <p>个人中心</p>
            </div>
        </div>
    </div>
</div>
<div class="slt-city" style="display: none">
    <div class="mask"></div>
    <div class="alert">
        <div class="this-city">
            <div class="city-place">当前定位城市</div>
            <div class="city-pos city-selected">吉安</div>
        </div>
        <div>
            <div class="city-place">热门城市</div>
            <div class="place-float clearfix">
                <div class="city-pos">北京</div>
                <div class="city-pos city-selected">上海</div>
                <div class="city-pos">北京</div>
                <div class="city-pos">上海</div>
                <div class="city-pos">北京</div>
                <div class="city-pos">上海</div>
                <div class="city-pos">北京</div>
                <div class="city-pos">上海</div>
                <div class="city-pos">上海</div>
                <div class="city-pos">北京</div>
                <div class="city-pos">上海</div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(function(){
        var mySwiper = new Swiper('.swiper-container',{
            direction: 'horizontal',
            loop: true,
            speed:1000,
            autoplay: {
                delay: 3000,
            },
            scrollbar: {
                el: '.swiper-scrollbar',
            },
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
            }
        });
        $(".top-ret").on("click",function(){
            $(".slt-city").toggle()
        })
        $(".place-float .city-pos").on("click",function(){
            var index = $(".place-float .city-pos").index($(this));
            $(".place-float .city-pos").removeClass("city-selected").eq(index).addClass("city-selected");
        })
    })


    function goNewPage(){
        window.location.href='/mm/news/mmNews';
    }
    function goPage(a){
        if(a==1){
            //公众上报
            window.location.href='/mm/news/index';
        }
        if(a==2){
            //公众投诉
            window.location.href='/mm/news/mytousu';
        }
        if(a==3){
            //公众咨询
            window.location.href='/mm/news/advisory';
        }
        if(a==4){
            //便民服务
            window.location.href='/mm/news/conven';
        }
        if(a==6){
            //公众调查
            window.location.href='/mm/news/survey';
        }
    }

    /**
     * 个人中心
     */
    function goCenter(){
        window.location.href='/mm/news/pcenter';
    }
    function goDianzan() {
        window.location.href='/mm/dz/dzlist';
    }

    /**
     * 新闻详情
     */
    function goNewDetail(){
        window.location.href='/mm/news/newsDetail';
    }
</script>
</html>